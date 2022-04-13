package com;

import com.Controller.Executor;
import com.Model.*;
import com.View.LeaderBoardAdder;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private final GameField gameField;
    private final Score score;
    private final State state;
    private final LeaderBoard leaderBoard;
    Timer timer = new Timer();

    public Game() throws IOException {
        gameField = new GameField();
        score = new Score(0);
        leaderBoard = new LeaderBoard();
        state = new State(StateEnum.Run);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (state.getData() == StateEnum.Run) {
                    gameField.fallFigure();
                    if (!gameField.isPossibleToSpawn()) {
                        state.setData(StateEnum.End);
                        LeaderBoardAdder leaderBoardAdder = new LeaderBoardAdder();
                        leaderBoardAdder.addToLeaderBoard(leaderBoard, score);
                    }
                    increaseScore();
                }
            }
        };
        timer.schedule(timerTask, 0L, 500);
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

    public LeaderBoard getLeaderBoard() {
        return leaderBoard;
    }

    public State getState() {
        return state;
    }

    public void restart() {
        gameField.clear();
        score.setData(0);
        state.setData(StateEnum.Run);
    }
}
