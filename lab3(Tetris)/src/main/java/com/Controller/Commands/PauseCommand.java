package com.Controller.Commands;

import com.Game;

public class PauseCommand implements Command {
    private final Game game;

    public PauseCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.getState().switchState();
    }
}
