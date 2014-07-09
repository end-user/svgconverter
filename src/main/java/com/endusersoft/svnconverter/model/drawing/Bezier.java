package com.endusersoft.svnconverter.model.drawing;

/**
 * Created by Oblio.Leitch on 2/15/14.
 */
public class Bezier extends AbstractKhanObject {
    private double x1;
    private double y1;
    private double cx1;
    private double cy1;
    private double cx2;
    private double cy2;
    private double x2;
    private double y2;

    public Bezier(double x1, double y1, double cx1, double cy1, double cx2, double cy2, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.cx1 = cx1;
        this.cy1 = cy1;
        this.cx2 = cx2;
        this.cy2 = cy2;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String getX1() {
        return fmt(x1);
    }

    public String getY1() {
        return fmt(y1);
    }

    public String getCx1() {
        return fmt(cx1);
    }

    public String getCy1() {
        return fmt(cy1);
    }

    public String getCx2() {
        return fmt(cx2);
    }

    public String getCy2() {
        return fmt(cy2);
    }

    public String getX2() {
        return fmt(x2);
    }

    public String getY2() {
        return fmt(y2);
    }

    @Override
    public String toString() {
        return String.format("bezier(%s, %s, %s, %s, %s, %s, %s, %s);",
                getX1(), getY1(), getCx1(), getCy1(), getCx2(), getCy2(), getX2(), getY2());
    }



}
