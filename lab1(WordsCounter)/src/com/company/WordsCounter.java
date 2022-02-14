package com.company;
import java.io.*;
import java.util.*;

public class WordsCounter {
    private int wordsCount;
    private final String inputFile;
    private final String outputFile;
    private final HashSet<WordFrequencyPair> set;

    public WordsCounter(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.set = new HashSet<>();
    }

    private void addWord(String word) {
        WordFrequencyPair pair = new WordFrequencyPair(word);
        boolean exist = false;
        for (WordFrequencyPair element : set) {
            if (element.getWord().hashCode() == pair.hashCode()) {
                element.setFrequency(element.getFrequency() + 1);
                exist = true;
                break;
            }
        }
        if (!exist) {
            set.add(pair);
        }
        ++wordsCount;
    }

    private void divideString(String line) {
        int beginIdx = 0;
        int wordLen = 0;
        for (int i = 0; i < line.length(); ++i) {
            if (Character.isLetterOrDigit(line.charAt(i))) {
                ++wordLen;
            }
            else {
                if (wordLen != 0) {
                    String newWord = line.substring(beginIdx, beginIdx + wordLen);
                    addWord(newWord);
                }
                beginIdx = i + 1;
                wordLen = 0;
            }
        }
        if (wordLen != 0) {
            String newWord = line.substring(beginIdx, beginIdx + wordLen);
            addWord(newWord);
        }
    }

    public void readFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.inputFile));
            while (reader.ready()) {
                String line = reader.readLine();
                divideString(line);
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
    }

    public void writeFile() {
        List<WordFrequencyPair> list = new ArrayList<>(set);
        Collections.sort(list);
        try {
            FileWriter writer = new FileWriter(this.outputFile, false);
            for (WordFrequencyPair pair : list) {
                writer.write(
                pair.getWord() + ';' +
                    pair.getFrequency() + ';' +
                    (double)pair.getFrequency() / wordsCount * 100 + '\n'
                );
            }
            writer.flush();
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

