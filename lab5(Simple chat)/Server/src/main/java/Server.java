import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Server implements Runnable {
    private final static int port = 8080;
    private final List<Client> clientList = new ArrayList<>();
    private ServerSocket serverSocket;
    private final List<String> chat = new ArrayList<>();
    private final Configuration configuration;
    private final ServerLogger serverLogger;
    private final boolean log;

    public Server(Configuration configuration, ServerLogger serverLogger) {
        this.configuration = configuration;
        this.serverLogger = serverLogger;
        this.log = configuration.isLog();

        try {
            serverSocket = new ServerSocket(port);
            if (log) {
                serverLogger.getInfoMessage("Server started");
            }
        }
        catch (IOException e) {
            logException(e);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket;
                socket = serverSocket.accept();
                Client client = new Client(socket, this);
                clientList.add(client);
                new Thread(client).start();
            }
        }
        catch (IOException e) {
            logException(e);
        }
        finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                logException(e);
            }
            if (log) {
                serverLogger.getInfoMessage("Server closed");
            }
    }
}

    public void removeClient(Client client) {
        clientList.remove(client);
    }

    public void sendMessageToAll(String message) {
        if (log) {
            serverLogger.getInfoMessage(message);
        }

        for (Client client : clientList) {
            client.sendMessage(message);
        }
    }

    public void logException(Exception e) {
        if (log) {
            serverLogger.getExceptionMessage(Level.WARNING, e);
        }
    }


    public List<Client> getClientList() {
        return clientList;
    }

    public List<String> getChat() {
        return chat;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public ServerLogger getServerLogger() {
        return serverLogger;
    }
}
