package com.Controller.Commands;

import java.lang.reflect.InvocationTargetException;

public interface Command {
    void execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
