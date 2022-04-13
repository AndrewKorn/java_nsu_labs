package com.View;

import com.Controller.Commands.AboutCommand;
import com.Controller.Commands.ExitCommand;
import com.Controller.Commands.HighScoreCommand;
import com.Controller.Commands.RestartCommand;
import com.Controller.Executor;
import com.Game;

import javax.swing.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Menu extends JMenu {

    public Menu(Game game, Executor executor) {
        super("Options");
        JMenuItem about = new JMenuItem("About");
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem highScores = new JMenuItem("High scores");
        JMenuItem exit = new JMenuItem("Exit");

        this.add(about);
        this.add(newGame);
        this.add(highScores);
        this.add(exit);

        about.addActionListener(e -> executor.execute(new AboutCommand(game)));
        highScores.addActionListener(e -> executor.execute(new HighScoreCommand(game)));
        newGame.addActionListener(e -> executor.execute(new RestartCommand(game)));
        exit.addActionListener(e -> executor.execute(new ExitCommand()));
    }
}
