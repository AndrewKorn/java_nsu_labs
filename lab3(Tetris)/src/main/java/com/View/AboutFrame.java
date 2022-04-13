package com.View;

import javax.swing.*;
import java.awt.*;

public class AboutFrame extends JFrame {
    public AboutFrame() {
        super("About");

        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
        aboutPanel.add(new JLabel("Control:", SwingConstants.CENTER));
        aboutPanel.add(new JLabel("W - Rotate", SwingConstants.CENTER));
        aboutPanel.add(new JLabel("A - Left", SwingConstants.CENTER));
        aboutPanel.add(new JLabel("S - Down", SwingConstants.CENTER));
        aboutPanel.add(new JLabel("D - Right", SwingConstants.CENTER));
        aboutPanel.add(new JLabel("SPACE - Drop", SwingConstants.CENTER));
        aboutPanel.add(new JLabel("P - Pause", SwingConstants.CENTER));

        this.setLayout(new BorderLayout());
        this.add(aboutPanel, BorderLayout.CENTER);
        this.setSize(200, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}
