package com.View;
import com.Controller.Commands.*;
import com.Controller.Executor;
import com.Game;
import javax.swing.*;

public class Menu extends JMenu {
    private final Executor executor;

    public Menu(Game game, Executor executor) {
        super("Options");
        this.executor = executor;
        createMenuItem("About", new AboutCommand(game));
        createMenuItem("New game", new RestartCommand(game));
        createMenuItem("High scores", new HighScoreCommand(game));
        createMenuItem("Exit", new ExitCommand());
    }

    public void createMenuItem(String itemName, Command command) {
        JMenuItem item = new JMenuItem(itemName);
        this.add(item);
        item.addActionListener(e -> executor.execute(command));
    }
}
