package com.View;

import com.General.Subscriber;
import com.Model.Score;

import javax.swing.*;

public class ScoreLabel extends JLabel implements Subscriber {
    private final Score score;

    public ScoreLabel(Score score) {
        super("Score: 0");
        this.score = score;
        this.score.addSubscriber(this);
    }

    @Override
    public void reactOnNotify() {
        this.setText("Score: " + score.getData());
    }
}
