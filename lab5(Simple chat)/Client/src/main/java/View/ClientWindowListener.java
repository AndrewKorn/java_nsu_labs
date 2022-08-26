package View;

import Client.Client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class ClientWindowListener extends WindowAdapter {
    private final Client client;

    public ClientWindowListener(Client client) {
        this.client = client;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        try {
            client.sendMessage(client.getNickname() + " exited the chat");
            client.sendMessage("session end");
            client.getOutputStream().close();
            client.getInputStream().close();
            client.getSocket().close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
