package com.View;

import com.*;
import com.Controller.Executor;

import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    private final GameFieldPanel gameFieldPanel;
    private final TopPanel topPanel;
    private final Menu menu;

    public GUI(Game game, Executor executor) {
        gameFieldPanel = new GameFieldPanel(game.getGameField());
        topPanel = new TopPanel(game.getState(), game.getScore());
        menu = new Menu(game, executor);
        this.addKeyListener(new KeyboardListener(executor));
        init();
    }

    private void init() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        this.setFocusable(true);
        this.setJMenuBar(menuBar);
        this.setLayout(new BorderLayout());
        this.add(gameFieldPanel, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.NORTH);
        this.setSize(400, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
