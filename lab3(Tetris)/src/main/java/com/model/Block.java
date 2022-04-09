package com.model;

import com.model.Point;

public class Block {
    private int x;
    private int y;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void shift(int xShift, int yShift) {
        x += xShift;
        y += yShift;
    }

    public void rotateClockwise(Point centre) {
        int xPrev = x;
        int yPrev = y;
        x = (int)(centre.getX() - centre.getY() + yPrev);
        y = (int)(centre.getY() + centre.getX() - xPrev);
    }

    public void rotateCounterclockwise(Point centre) {
        int xPrev = x;
        int yPrev = y;
        x = (int)(centre.getX() + centre.getY() - yPrev);
        y = (int)(centre.getY() - centre.getX() + xPrev);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
