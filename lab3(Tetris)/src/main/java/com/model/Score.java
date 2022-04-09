package com.model;

import com.general.ConcretePublisher;

public class Score extends ConcretePublisher {
    private int score;

    public Score(int score) {
        this.score = score;
    }

    public Score() {
        this.score = 0;
    }

    public int getData() {
        return score;
    }

    public void setData(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }

    public void IncreaseScore(int increase) {
        score += increase;
        notifySubscriber();
    }
}
