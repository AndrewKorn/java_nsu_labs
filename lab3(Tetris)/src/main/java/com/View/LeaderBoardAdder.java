package com.View;

import com.General.MyFileWriter;
import com.Model.LeaderBoard;
import com.Model.Score;

import javax.swing.*;

public class LeaderBoardAdder {
    public void addToLeaderBoard(LeaderBoard leaderBoard, Score score) {
        String name = JOptionPane.showInputDialog("Enter your name");
        String newRecord = name + "=" + score.getData() + "\n";
        new MyFileWriter("src/main/resources/leaderboard.properties").writeFile(newRecord);
        leaderBoard.getProperties().setProperty(name, score.toString());
    }
}
