package com.Model;

public class Point {
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void shift(float xShift, float yShift) {
        x += xShift;
        y += yShift;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
}
