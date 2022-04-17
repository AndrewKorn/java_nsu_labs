package com.Controller.Commands;

import com.Game;

public class RestartCommand implements Command {
    private final Game game;

    public RestartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.restart();
    }
}
