package com.company;

import java.util.Objects;

public class WordCountPair implements Comparable<WordCountPair> {
    private int count;
    private final String word;

    public WordCountPair(String word) {
        this.word = word;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public void  setCount(int frequency) {
        this.count = frequency;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        WordCountPair pair = (WordCountPair) object;
        return (Objects.equals(word, pair.getWord()));
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
    public int compareTo(WordCountPair pair) {
        if (pair == null) {
            throw new NullPointerException("no acceptable null value");
        }
        if (word.equals(pair.getWord())) {
            return pair.getCount() - this.getCount();
        }
        else {
            return 0;
        }
    }
}
