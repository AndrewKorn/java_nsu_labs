package com.Controller.Commands;

import com.Game;
import com.Model.StateEnum;

public class RightCommand implements Command {
    private final Game game;

    public RightCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        if (game.getState().getData() == StateEnum.Run) {
            game.getGameField().shiftFigure(1, 0);
        }
    }
}
