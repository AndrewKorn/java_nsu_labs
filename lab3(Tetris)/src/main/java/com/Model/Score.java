package com.Model;

import com.General.ConcretePublisher;

public class Score extends ConcretePublisher {
    private int score;

    public Score(int score) {
        this.score = score;
    }

    public int getData() {
        return score;
    }

    public void setData(int score) {
        this.score = score;
        notifySubscriber();
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
