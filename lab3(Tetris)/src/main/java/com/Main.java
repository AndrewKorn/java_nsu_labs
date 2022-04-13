package com;
import com.Controller.Executor;
import com.Controller.Commands.Command;
import com.View.GUI;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Game game = new Game();
        Executor executor = new Executor(game);
        GUI gui = new GUI(game, executor);
        gui.setVisible(true);
    }
}

