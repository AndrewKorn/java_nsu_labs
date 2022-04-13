package com.Controller.Commands;

import com.Game;
import com.Model.StateEnum;

public class RotateCommand implements Command {
    private final Game game;

    public RotateCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        if (game.getState().getData() == StateEnum.Run) {
            game.getGameField().rotateFigure();
        }
    }
}
