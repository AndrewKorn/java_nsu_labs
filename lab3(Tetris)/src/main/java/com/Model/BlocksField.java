package com.Model;

import com.Model.Figures.Figure;

import java.awt.*;

public class BlocksField {
    int width;
    int height;
    private final Color[][] field;

    public BlocksField(int width, int height) {
        this.width = width;
        this.height = height;
        field = new Color[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                field[i][j] = Color.WHITE;
            }
        }
    }

    public boolean isInside(Figure figure) {
        Block[] blocks = figure.getBlocks();
        for (Block block : blocks) {
            if (block.getX() < 0 || block.getX() >= width || block.getY() < 0 || block.getY() >= height) {
                return false;
            }
        }
        return true;
    }

    public void addFigure(Figure figure) {
        Block[] blocks = figure.getBlocks();
        for (Block block : blocks) {
            if (isInside(figure)) {
                field[height - 1 - block.getY()][block.getX()] = figure.getColor();
            }
        }
    }

    public boolean isRowFull(int y) {
        for (int i = 0; i < width; ++i) {
            if (field[height - 1 - y][i] == Color.WHITE) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                field[i][j] = Color.WHITE;
            }
        }
    }

    public void print() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public Color[][] getField() {
        return field;
    }
}
