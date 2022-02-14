package com.company;

import java.util.Objects;

public class WordFrequencyPair implements Comparable<WordFrequencyPair> {
    private int frequency;
    private String word;

    public WordFrequencyPair(String word) {
        this.word = word;
        this.frequency = 1;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getWord() {
        return word;
    }

    public void  setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        WordFrequencyPair wordFreq = (WordFrequencyPair) object;
        return ((frequency == wordFreq.frequency) && (Objects.equals(word, wordFreq.word)));
    }

    @Override
    public int hashCode() {
        int result = 0;
        if (word != null) {
            result = word.hashCode();
        }
        return result;
    }

    @Override
    public int compareTo(WordFrequencyPair pair) {
        return pair.getFrequency() - this.getFrequency();
    }
}
