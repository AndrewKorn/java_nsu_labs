package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException, NoSuchMethodException {
        Factory.getInstance(args[0]);
    }
}
