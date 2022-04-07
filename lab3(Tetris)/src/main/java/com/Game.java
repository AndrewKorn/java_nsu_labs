package com;

import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private final GameField gameField;
    private final Score score = new Score(0);
    private State state;
    private final TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            if (state.getState() == StateEnum.Run) {
                gameField.fallFigure();
                if (!gameField.isPossibleToSpawn()) {
                    state.setState(StateEnum.End);
                }
                increaseScore();
            }
        }
    };

    public Game(GameField gameField) {
        this.gameField = gameField;
        state = new State(StateEnum.Run);
        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 500);
    }

    public GameField getGameField() {
        return gameField;
    }

    public Score getScore() {
        return score;
    }

    public void increaseScore() {
        int removed = gameField.clearFilledRows();
        switch (removed) {
            case 1 -> score.IncreaseScore(40);
            case 2 -> score.IncreaseScore(100);
            case 3 -> score.IncreaseScore(300);
            case 4 -> score.IncreaseScore(1200);
        }
    }

    public State getState() {
        return state;
    }

    public void restart() {
        gameField.clear();
        score.setScore(0);
        state = new State(StateEnum.Run);
    }
}
