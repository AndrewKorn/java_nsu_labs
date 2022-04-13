package com.View;

import com.Controller.Commands.AboutCommand;
import com.Controller.Commands.ExitCommand;
import com.Controller.Commands.HighScoreCommand;
import com.Controller.Commands.RestartCommand;
import com.Controller.Executor;
import com.Game;

import javax.swing.*;

import java.lang.reflect.InvocationTargetException;

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

        about.addActionListener(e -> {
            try {
                executor.execute(new AboutCommand(game));
            } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
        highScores.addActionListener(e -> {
            try {
                executor.execute(new HighScoreCommand(game));
            } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
        newGame.addActionListener(e -> {
            try {
                executor.execute(new RestartCommand(game));
            } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
        exit.addActionListener(e -> {
            try {
                executor.execute(new ExitCommand());
            } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
    }
}
