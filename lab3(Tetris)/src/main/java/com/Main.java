package com;
import com.Controller.Executor;
import com.Model.Figures.FiguresLetter;
import com.View.GUI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Game game = new Game();
        Executor executor = new Executor(game);
        GUI gui = new GUI(game, executor);
        gui.setVisible(true);
    }
}

