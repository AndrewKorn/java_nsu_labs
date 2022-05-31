import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public class Client implements Runnable {
    private final Server server;
    private ObjectInputStream clientInStream;
    private ObjectOutputStream clientOutStream;
    private String name;
    private final boolean log;

    public Client(Socket socket, Server server) {
        this.server = server;
        this.log = server.getConfiguration().isLog();

        try {
            clientInStream = new ObjectInputStream(socket.getInputStream());
            clientOutStream = new ObjectOutputStream(socket.getOutputStream());
            socket.setSoTimeout(1000);
        }
        catch (IOException e) {
            logException(e);
        }
    }

    @Override
    public void run() {
        try {
            sendChatHistory();

            server.sendMessageToAll("New client connected ");
            server.sendMessageToAll("Now connected " + server.getClientList().size() + " clients");
            getClientName();

            long start = System.currentTimeMillis();
            while (true) {
                String message;
                try {
                    message = (String)clientInStream.readObject();
                }
                catch (SocketException | SocketTimeoutException e) {
                    message = null;
                }

                if (Objects.equals(message, "session end")) {
                    break;
                }
                if (Objects.equals(message, "get clients list")) {
                    sendClientsList();
                    continue;
                }
                if (message != null) {
                    server.getChat().add(message);
                    start = System.currentTimeMillis();
                    server.sendMessageToAll(message);
                }

                long timeout = server.getConfiguration().getTimeout() * 1000L;
                if (System.currentTimeMillis() - start > timeout) {
                    server.sendMessageToAll(name + " was disconnected for inactivity");
                    sendMessage("session end");
                    break;
                }
            }
            server.removeClient(this);
        }
        catch (IOException | ClassNotFoundException e) {
            logException(e);
        }
    }

    public void sendMessage(String message) {
        try {
            clientOutStream.writeObject(message);
            clientOutStream.flush();
        }
        catch (IOException e) {
            logException(e);
        }
    }

    public void sendChatHistory() {
        int size = server.getChat().size();
        List<String> chat = server.getChat();
        int chatHistoryCount = server.getConfiguration().getChatHistoryCount();

        if (size < chatHistoryCount) {
            for (String message : chat) {
                sendMessage(message);
            }
        }
        else {
            for (String message : chat.subList(size - chatHistoryCount, size)) {
                sendMessage(message);
            }
        }
    }

    public void getClientName() {
        String name = null;
        while (name == null) {
            try {
                name = (String) clientInStream.readObject();
            } catch (IOException | ClassNotFoundException ignored) {}
            this.name = name;
        }
    }

    public void sendClientsList() {
        sendMessage("\n");
        sendMessage("Clients list");
        sendMessage("-----------------");
        for (Client client : server.getClientList()) {
            sendMessage(client.name);
        }
        sendMessage("-----------------");
        sendMessage("\n");
    }

    public void logException(Exception e) {
        if (log) {
            server.getServerLogger().getExceptionMessage(Level.WARNING, e);
        }
    }
}
