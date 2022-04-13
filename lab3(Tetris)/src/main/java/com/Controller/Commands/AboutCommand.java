package com.Controller.Commands;

import com.Game;
import com.Model.StateEnum;
import com.View.AboutFrame;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class AboutCommand implements Command {
    private final Game game;

    public AboutCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        if (game.getState().getData() == StateEnum.Run) {
            game.getState().switchState();
        }
        AboutFrame aboutFrame = new AboutFrame();
        aboutFrame.setVisible(true);
        aboutFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
