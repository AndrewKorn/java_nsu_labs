package com;

public class ConcreteClient implements Client {
    Game game;

    ConcreteClient(Game game) {
        this.game = game;
    }
    @Override
    public void execute(Command command) {
        switch (command) {
            case Left -> game.getGameField().shiftFigure(-1, 0);
            case Right -> game.getGameField().shiftFigure(1, 0);
            case Down -> game.getGameField().shiftFigure(0, -1);
            case Rotate -> game.getGameField().rotateFigure();
            case Pause -> game.getState().switchState();
            case Drop -> game.getGameField().dropFigure();
            case Restart -> game.restart();
        }
    }
}
