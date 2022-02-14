package com.company;

public class Main {
    public static void main(String[] args) {
        WordsCounter wordsCounter = new WordsCounter("in.txt", "out.csv");
        wordsCounter.parseFile();
    }
}
