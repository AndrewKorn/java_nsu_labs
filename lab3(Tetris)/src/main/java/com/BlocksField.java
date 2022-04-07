package com;

import com.Figures.Figure;

public class BlocksField {
    int width;
    int height;
    private final ColorEnum[][] field;

    public BlocksField(int width, int height) {
        this.width = width;
        this.height = height;
        field = new ColorEnum[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                field[i][j] = ColorEnum.Empty;
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
            if (field[height - 1 - y][i] == ColorEnum.Empty) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                field[i][j] = ColorEnum.Empty;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ColorEnum[][] getField() {
        return field;
    }
}
