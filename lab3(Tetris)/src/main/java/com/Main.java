package com;

public class Main {
    public static void main(String[] args) {
        GameField gameField = new GameField();
        Game game = new Game(gameField);
        GUI gui = new GUI(game);
    }
}

