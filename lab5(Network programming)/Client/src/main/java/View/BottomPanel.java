package View;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BottomPanel extends JPanel {
    public BottomPanel(Client client) {
        super(new BorderLayout());
        JButton sendButton = new JButton("Send");
        this.add(sendButton, BorderLayout.EAST);
        JTextField messageTextField = new JTextField("Enter your message");
        this.add(messageTextField, BorderLayout.CENTER);

        messageTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                messageTextField.setText("");
            }
        });

        sendButton.addActionListener(e -> {
            if (!messageTextField.getText().trim().isEmpty()) {
                String message = client.getNickname() + ": " + messageTextField.getText();
                client.sendMessage(message);
                messageTextField.setText("");
                messageTextField.grabFocus();
            }
        });

        messageTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    if (!messageTextField.getText().trim().isEmpty()) {
                        String message = client.getNickname() + ": " + messageTextField.getText();
                        client.sendMessage(message);
                        messageTextField.setText("");
                        messageTextField.grabFocus();
                    }
                }
            }
        });
    }
}
