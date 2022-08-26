package View;

import Client.Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class GUI extends JFrame {

    public GUI(Client client) {
        super();

        String nickname = JOptionPane.showInputDialog("Enter your nickname");
        client.setNickname(nickname);
        this.setTitle(nickname);
        client.sendMessage(nickname);

        ChatArea chatArea = new ChatArea(this, client);
        client.addSubscriber(chatArea);
        BottomPanel bottomPanel = new BottomPanel(client);

        Menu menu = new Menu(client);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
        add(bottomPanel, BorderLayout.SOUTH);
        addWindowListener(new ClientWindowListener(client));
        this.setFocusable(true);
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
