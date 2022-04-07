package com;

public class Score extends ConcretePublisher {
    private int score;

    public Score(int score) {
        this.score = score;
    }

    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void IncreaseScore(int increase) {
        score += increase;
        notifySubscriber();
    }
}
