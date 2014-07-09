package com.endusersoft.svnconverter.model.drawing;

/**
 * Created by Oblio.Leitch on 3/17/14.
 */
public class Line extends AbstractKhanObject {

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
    @Override
    public String toString() {
        return String.format("line(%s, %s, %s, %s);",
                getX1(), getY1(), getX2(), getY2());
    }
}
