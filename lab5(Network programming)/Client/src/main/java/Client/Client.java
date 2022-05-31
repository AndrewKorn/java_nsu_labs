package Client;

import Common.ConcretePublisher;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends ConcretePublisher implements Runnable {
    private final static int port = 8080;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private String nickname;
    private final List<String> chat = new ArrayList<>();

    public Client() {
        try {
            socket = new Socket("localhost", port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                String message = (String)inputStream.readObject();
                if (Objects.equals(message, "session end")) {
                    getOutputStream().close();
                    getInputStream().close();
                    getSocket().close();
                    notifySubscribers();
                    break;
                }
                else {
                    chat.add(message);
                    notifySubscribers();
                }
            }
            catch (SocketException e) {
                break;
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void sendMessage(String message) {
        try {
            outputStream.writeObject(message);
            outputStream.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getChat() {
        return chat;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public Socket getSocket() {
        return socket;
    }

}
