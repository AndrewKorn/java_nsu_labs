package com.Controller.Commands;

import com.Game;
import com.Model.StateEnum;

public class LeftCommand implements Command {
    private final Game game;

    public LeftCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        if (game.getState().getData() == StateEnum.Run) {
            game.getGameField().shiftFigure(-1, 0);
        }
    }
}
