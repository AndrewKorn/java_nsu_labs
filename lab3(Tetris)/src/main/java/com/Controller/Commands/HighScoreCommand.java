package com.Controller.Commands;

import com.Game;
import com.Model.StateEnum;
import com.View.HighScoresFrame;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class HighScoreCommand implements Command {
    private final Game game;

    public HighScoreCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        if (game.getState().getData() == StateEnum.Run) {
            game.getState().switchState();
        }
        HighScoresFrame highScoresFrame= new HighScoresFrame(game.getLeaderBoard().getProperties());
        highScoresFrame.setVisible(true);
        highScoresFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
