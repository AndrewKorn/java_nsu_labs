package com;
import com.Controller.Executor;
import com.View.GUI;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Executor executor = new Executor(game);
        GUI gui = new GUI(game, executor);
        gui.setVisible(true);
    }
}

