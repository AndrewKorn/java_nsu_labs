package com.View;

import com.General.Subscriber;
import com.Model.BlocksField;
import com.Model.ColorEnum;
import com.Model.GameField;

import javax.swing.*;
import java.awt.*;

public class GameFieldPanel extends JPanel implements Subscriber {
    private final JTextArea[][] grids;
    private final GameField gameField;

    public GameFieldPanel(GameField gameField) {
        super();
        grids = new JTextArea[20][10];
        this.gameField = gameField;
        this.gameField.addSubscriber(this);
        this.setLayout(new GridLayout(20, 10, 1, 1));
        init();
    }

    public void init() {
        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 10; ++j) {
                grids[i][j] = new JTextArea(20,20);
                grids[i][j].setBackground(Color.WHITE);
                grids[i][j].setEditable(false);
                this.add(grids[i][j]);
            }
        }
    }

    @Override
    public void reactOnNotify() {
        BlocksField field = gameField.getFieldWithFigure();
        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (field.getField()[i][j] == ColorEnum.Empty && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.WHITE);
                }
                else if (field.getField()[i][j] == ColorEnum.Blue && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.BLUE);
                }
                else if (field.getField()[i][j] == ColorEnum.LightBlue && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.CYAN);
                }
                else if (field.getField()[i][j] == ColorEnum.Orange && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.ORANGE);
                }
                else if (field.getField()[i][j] == ColorEnum.Yellow && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.YELLOW);
                }
                else if (field.getField()[i][j] == ColorEnum.Red && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.RED);
                }
                else if (field.getField()[i][j] == ColorEnum.Green && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.GREEN);
                }
                else if (field.getField()[i][j] == ColorEnum.Purple && grids[i][j] != null) {
                    grids[i][j].setBackground(Color.MAGENTA);
                }
            }
        }
        this.repaint();
    }
}
