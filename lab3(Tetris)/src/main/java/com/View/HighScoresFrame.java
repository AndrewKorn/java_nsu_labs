package com.View;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class HighScoresFrame extends JFrame {

    public HighScoresFrame(Properties properties) {
        super("High Scores");

        JPanel highScoresPanel = new JPanel();
        highScoresPanel.setLayout(new BoxLayout(highScoresPanel, BoxLayout.Y_AXIS));
        highScoresPanel.add(new JLabel("Leader Board:"));

        for (String name : properties.stringPropertyNames()) {
            highScoresPanel.add(new JLabel(name +  " : " + properties.get(name)));
        }

        this.setLayout(new BorderLayout());
        this.add(highScoresPanel, BorderLayout.CENTER);
        this.setSize(200, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
