package View;

import Client.Client;

import javax.swing.*;

public class Menu extends JMenu {
    public Menu(Client client) {
        super("Options");
        JMenuItem getClientsList = new JMenuItem("Get clients list");
        this.add(getClientsList);
        getClientsList.addActionListener(e -> client.sendMessage("get clients list"));

    }
}
