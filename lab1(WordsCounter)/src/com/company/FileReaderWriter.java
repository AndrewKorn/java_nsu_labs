package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {
    public static List<String> divideString(String line) {
        int beginIdx = 0;
        int wordLen = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < line.length(); ++i) {
            if (Character.isLetterOrDigit(line.charAt(i))) {
                ++wordLen;
            }
            else {
                if (wordLen != 0) {
                    String newWord = line.substring(beginIdx, beginIdx + wordLen);
                    list.add(newWord);
                }
                beginIdx = i + 1;
                wordLen = 0;
            }
        }
        if (wordLen != 0) {
            String newWord = line.substring(beginIdx, beginIdx + wordLen);
            list.add(newWord);
        }
        return list;
    }

    public static List<String> readFile(String inputFile) {
        BufferedReader reader = null;
        List<String> listOfWords = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            while (reader.ready()) {
                String line = reader.readLine();
                listOfWords.addAll(divideString(line));
            }
            return listOfWords;
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
        return listOfWords;
    }

    public static void writeCSVFile(String outputFile, List<WordCountPair> list, int wordsCount) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(outputFile, false);
            for (WordCountPair pair : list) {
                writer.write(
                        pair.getWord() + ';'
                                + pair.getCount() + ';'
                                + (double)pair.getCount() / wordsCount * 100 + '\n'
                );
            }
            writer.flush();
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
