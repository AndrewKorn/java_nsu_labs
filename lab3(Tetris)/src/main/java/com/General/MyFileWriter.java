package com.General;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    private final String filename;

    public MyFileWriter(String filename) {
        this.filename = filename;
    }

    public void writeFile(String text) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, true);
            writer.write(text);
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                }
                catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
