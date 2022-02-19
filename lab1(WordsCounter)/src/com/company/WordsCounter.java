package com.company;
import java.util.*;

public class WordsCounter {
    private static HashSet<WordCountPair> countWords(List<String> listOfWords) {
        HashSet<WordCountPair> set = new HashSet<>();
        for (String word : listOfWords) {
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

    public static void collectAndDisplayStatistics(String inputFile, String outputFile) {
        List<String> listOfWords = FileReaderWriter.readFile(inputFile);
        HashSet<WordCountPair> setOfWords  = countWords(listOfWords);
        List<WordCountPair> sortedList = new ArrayList<>(setOfWords);
        Collections.sort(sortedList);
        FileReaderWriter.writeCSVFile(outputFile, sortedList, listOfWords.size());
    }
}

