package com;

import com.view.GUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        GUI gui = new GUI(game);
        gui.setVisible(true);
    }
}

