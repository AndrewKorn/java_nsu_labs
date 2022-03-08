package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private final String file;

    public FileParser(String file) {
        this.file = file;
    }

    public List<String> parse() {
        BufferedReader reader = null;
        List<String> listOfLines = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                String line = reader.readLine();
                listOfLines.add(line);
            }
        }
        catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return listOfLines;
    }
}