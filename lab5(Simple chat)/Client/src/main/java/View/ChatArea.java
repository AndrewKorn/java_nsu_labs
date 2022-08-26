package View;

import Client.Client;
import Common.Subscriber;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class ChatArea extends JTextPane implements Subscriber {
    private final Client client;
    private final JFrame mainFrame;
    private final StyledDocument doc;
    private final SimpleAttributeSet left;
    private final SimpleAttributeSet center;
    private final SimpleAttributeSet right;

    public ChatArea(JFrame mainFrame, Client client) {
        super();
        this.mainFrame = mainFrame;
        this.client = client;
        setEditable(false);

        doc = this.getStyledDocument();

        left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(left, Color.BLACK);
        StyleConstants.setFontSize(left, 13);

        center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        StyleConstants.setForeground(center, Color.BLACK);
        StyleConstants.setFontSize(center, 13);

        right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setForeground(right, Color.BLACK);
        StyleConstants.setFontSize(right, 13);

        JScrollPane scrollPane = new JScrollPane(this);
        mainFrame.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void reactOnNotify() {
        if (client.getSocket().isClosed()) {
            mainFrame.dispose();
        }
        else {
            String message = client.getChat().get(client.getChat().size() - 1) + "\n";
            String nickname = client.getNickname() + ": ";
            try {
                if (!message.contains(":")) {
                    doc.setParagraphAttributes(doc.getLength(), 1, center, false);
                    doc.insertString(doc.getLength(), message, center);
                }
                else {
                    if (message.contains(nickname)) {
                        message = message.replace(nickname, "");
                        doc.setParagraphAttributes(doc.getLength(), 1, right, false);
                        doc.insertString(doc.getLength(), message, right);

                    } else {
                        doc.setParagraphAttributes(doc.getLength(), 1, left, false);
                        doc.insertString(doc.getLength(), message, left);
                    }
                }
            }
            catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
}
