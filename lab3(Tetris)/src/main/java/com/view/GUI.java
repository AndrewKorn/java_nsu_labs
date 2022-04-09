package com.view;

import com.*;
import com.controller.Command;
import com.controller.ConcreteClient;
import com.general.Subscriber;
import com.model.BlocksField;
import com.model.ColorEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements Subscriber, KeyListener {
    private final JTextArea[][] grids;
    private final Game game;
    JLabel scoreLabel;
    JLabel stateLabel;
    ConcreteClient client;

    public GUI(Game game) {
        this.game = game;
        this.game.getGameField().addSubscriber(this);
        this.game.getScore().addSubscriber(this);
        this.game.getState().addSubscriber(this);
        client = new ConcreteClient(game);
        grids = new JTextArea[20][10];
        scoreLabel = new JLabel("Score: 0");
        stateLabel = new JLabel("Game is running");
        init();
    }

    private void init() {
        JPanel centerPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel scorePanel = new JPanel();
        JPanel statePanel = new JPanel();
        centerPanel.setLayout(new GridLayout(20, 10, 1, 1));
        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 10; ++j) {
                grids[i][j] = new JTextArea(20,20);
                grids[i][j].setBackground(Color.WHITE);
                grids[i][j].addKeyListener(this);
                grids[i][j].setEditable(false);
                centerPanel.add(grids[i][j]);
            }
        }

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        scorePanel.add(scoreLabel);
        statePanel.add(stateLabel);
        stateLabel.setForeground(Color.RED);
        topPanel.add(statePanel);
        topPanel.add(scorePanel);

        JMenu menu = new JMenu("Options");
        JMenuItem about = new JMenuItem("About");
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem highScores = new JMenuItem("High scores");
        JMenuItem exit = new JMenuItem("Exit");
        menu.add(about);
        menu.add(newGame);
        menu.add(highScores);
        menu.add(exit);

        about.addActionListener(e -> {
            game.getState().switchState();
            JFrame aboutFrame = new JFrame("About");

            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.add(new JLabel("Control:"));
            infoPanel.add(new JLabel("W - Rotate"));
            infoPanel.add(new JLabel("A - Left"));
            infoPanel.add(new JLabel("S - Down"));
            infoPanel.add(new JLabel("D - Right"));
            infoPanel.add(new JLabel("SPACE - Drop"));
            infoPanel.add(new JLabel("P - Pause"));

            aboutFrame.setLayout(new BorderLayout());
            aboutFrame.add(infoPanel, BorderLayout.CENTER);
            aboutFrame.setSize(200, 400);
            aboutFrame.setVisible(true);
            aboutFrame.setLocationRelativeTo(null);
            aboutFrame.setResizable(false);
            aboutFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        });
        newGame.addActionListener(e -> game.restart());
        highScores.addActionListener(e -> {
            game.getState().switchState();
            JFrame highScoresFrame = new JFrame("High scores");

            JPanel highScoresPanel = new JPanel();
            highScoresPanel.setLayout(new BoxLayout(highScoresPanel, BoxLayout.Y_AXIS));
            highScoresPanel.add(new JLabel("Leader Board:"));

            for (String name : game.getLeaderBoard().getProperties().stringPropertyNames()) {
                highScoresPanel.add(new JLabel(name +  " : " + game.getLeaderBoard().getProperties().get(name)));
            }

            highScoresFrame.setLayout(new BorderLayout());
            highScoresFrame.add(highScoresPanel, BorderLayout.CENTER);
            highScoresFrame.setSize(200, 400);
            highScoresFrame.setVisible(true);
            highScoresFrame.setLocationRelativeTo(null);
            highScoresFrame.setResizable(false);
            highScoresFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        });
        exit.addActionListener(e -> dispose());

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        this.setJMenuBar(menuBar);
        this.setLayout(new BorderLayout());
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.NORTH);
        this.setSize(400, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case('w') -> client.execute(Command.Rotate);
            case('a') -> client.execute(Command.Left);
            case('s') -> client.execute(Command.Down);
            case('d') -> client.execute(Command.Right);
            case('p') -> client.execute(Command.Pause);
            case(' ') -> client.execute(Command.Drop);
            case('r') -> client.execute(Command.Restart);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void reactOnNotify() {
        BlocksField field = game.getGameField().getFieldWithFigure();
        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (field.getField()[i][j] == ColorEnum.Empty && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.WHITE);
                }
                else if (field.getField()[i][j] == ColorEnum.Blue && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.BLUE);
                }
                else if (field.getField()[i][j] == ColorEnum.LightBlue && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.CYAN);
                }
                else if (field.getField()[i][j] == ColorEnum.Orange && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.ORANGE);
                }
                else if (field.getField()[i][j] == ColorEnum.Yellow && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.YELLOW);
                }
                else if (field.getField()[i][j] == ColorEnum.Red && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.RED);
                }
                else if (field.getField()[i][j] == ColorEnum.Green && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.GREEN);
                }
                else if (field.getField()[i][j] == ColorEnum.Purple && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.MAGENTA);
                }
            }
        }
        scoreLabel.setText("Score: " + game.getScore().getData());

        switch (game.getState().getData()) {
            case Run -> stateLabel.setText("Game is running");
            case Pause -> stateLabel.setText("Game is pausing");
            case End -> stateLabel.setText("Game over");
        }

        this.repaint();
    }
}
