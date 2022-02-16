package com.company;
import java.io.*;
import java.util.*;

public class WordsCounter {
    private static HashSet<WordCountPair> createSetOfWords(List<String> list) {
        HashSet<WordCountPair> set = new HashSet<>();

        for (String word : list) {
            WordCountPair pair = new WordCountPair(word);
            if (set.contains(pair)) {
                for (WordCountPair element : set) {
                    if (element.getWord().equals(pair.getWord())) {
                        element.setCount(element.getCount() + 1);
                        break;
                    }
                }
            }
            else {
                set.add(pair);
            }
        }
        return set;
    }

    private static void divideString(String line, List<String> list) {
        int beginIdx = 0;
        int wordLen = 0;
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
    }

    private static List<String> readFile(String inputFile) {
        BufferedReader reader = null;
        List<String> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            while (reader.ready()) {
                String line = reader.readLine();
                divideString(line, list);
            }
            return list;
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
        return list;
    }

    private static void writeFile(String outputFile, List<WordCountPair> list, int wordsCount) {
        try {
            FileWriter writer = new FileWriter(outputFile, false);
            for (WordCountPair pair : list) {
                writer.write(
                pair.getWord() + ';' +
                    pair.getCount() + ';' +
                    (double)pair.getCount() / wordsCount * 100 + '\n'
                );
            }
            writer.flush();
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void collectAndDisplayStatistics(String inputFile, String outputFile) {
        List<String> list = readFile(inputFile);
        HashSet<WordCountPair> set = createSetOfWords(list);
        List<WordCountPair> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        writeFile(outputFile, sortedList, list.size());
    }
}

