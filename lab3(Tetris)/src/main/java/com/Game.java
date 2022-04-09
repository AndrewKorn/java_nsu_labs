package com;

import com.general.MyFileWriter;
import com.model.*;

import javax.swing.*;
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
                        String name = JOptionPane.showInputDialog("Enter your name");
                        String newRecord = name + "=" + score.getData() + "\n";
                        new MyFileWriter("src/main/resources/leaderboard.properties").writeFile(newRecord);
                        leaderBoard.getProperties().setProperty(name, score.toString());
                    }
                    increaseScore();
                }
            }
        };
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
