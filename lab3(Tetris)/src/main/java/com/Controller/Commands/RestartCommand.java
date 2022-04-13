package com.Controller.Commands;

import com.Game;

import java.lang.reflect.InvocationTargetException;

public class RestartCommand implements Command {
    private final Game game;

    public RestartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        game.restart();
    }
}
