package com.View;

import com.Model.Score;
import com.Model.State;

import javax.swing.*;

public class TopPanel extends JPanel {
    private final StateLabel stateLabel;
    private final ScoreLabel scoreLabel;

    public TopPanel(State state, Score score) {
        super();
        this.stateLabel = new StateLabel(state);
        this.scoreLabel = new ScoreLabel(score);
        init();
    }

    public void init() {
        JPanel statePanel = new JPanel();
        statePanel.add(stateLabel);

        JPanel scorePanel = new JPanel();
        scorePanel.add(scoreLabel);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(statePanel);
        this.add(scorePanel);
    }
}
