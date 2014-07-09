package com.endusersoft.svnconverter.model.drawing;

/**
 * Class that represents a pair of coordinates
 */
public final class Point {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Point() {
        Reset();
    }

    public Point(float x, float y) {
        Set(x, y);
    }

    public void Set(float x, float y) {
        setX(x);
        setY(y);
    }

    public void Reset() {
        this.x = 0f;
        this.y = 0f;
    }
}
