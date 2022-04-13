package com.Controller.Commands;

import com.Game;
import com.Model.StateEnum;

public class DropCommand implements Command {
    private final Game game;

    public DropCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        if (game.getState().getData() == StateEnum.Run) {
            game.getGameField().dropFigure();
        }
    }
}
