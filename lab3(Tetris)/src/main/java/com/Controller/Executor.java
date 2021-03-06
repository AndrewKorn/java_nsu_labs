package com.Controller;

import com.Controller.Commands.Command;
import com.Game;
import com.Main;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public class Executor {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public Executor(Game game) {

        try {
            InputStream is = Main.class.getClassLoader().getResourceAsStream("commands.properties");
            Properties properties = new Properties();
            properties.load(is);

            for (String key : properties.stringPropertyNames()) {
                String commandName = properties.getProperty(key);
                Command operation = (Command) Class.forName(commandName).getDeclaredConstructor(Game.class).newInstance(game);
                commandMap.put(key, operation);
            }
        }
        catch (
                IOException |
                ClassNotFoundException |
                NoSuchMethodException |
                InvocationTargetException |
                InstantiationException |
                IllegalAccessException e
        ) {e.printStackTrace();}
    }

    public void execute(String commandName) {
        Command command = commandMap.get(commandName);
        if (command != null) {
            command.execute();
        }
    }

    public void execute(Command command) {
        command.execute();
    }
}
