package com.company;


import com.company.Operations.AddOperation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException, NoSuchMethodException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");

        Factory factory = new Factory(configuration);
        try {
            if (args.length == 0) {
                factory.getInstance(configuration);
            }
            else {
                factory.getInstance(args[0], configuration);
            }
        }
        catch (CalculatorException calculatorException) {
            calculatorException.printStackTrace();
        }
    }
}