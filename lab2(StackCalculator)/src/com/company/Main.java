package com.company;

import Operations.DefineOperation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException, NoSuchMethodException {
        Configuration configuration = new Configuration();
        Map<String, Operation> config = configuration.getConfig("operations.properties");

        if (args.length == 0) {
            Factory.getInstance(config);
        }
        else {
            Factory.getInstance(args[0], config);
        }
    }
}
