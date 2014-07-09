package com.endusersoft.svnconverter.model.drawing;


import java.awt.*;

/**
 * Created by Oblio.Leitch on 3/27/14.
 */
public class Stroke extends AbstractKhanObject {

    private Color stroke;
    // must be greater than zero, otherwise use noStroke
    private float strokeWeight;

    public String getStroke() {
        if (null==stroke){
            return "noStroke();";
        }
        return String.format("stroke(%s, %s, %s);",
                stroke.getRed(),
                stroke.getGreen(),
                stroke.getBlue()
        );
    }

    void setStroke(Color stroke) {
        this.stroke = stroke;
    }

    public String getStrokeWeight() {
        if (strokeWeight == 0) {
            return "noStroke();";
        } else {
            return String.format("strokeWeight(%f);", strokeWeight);
        }
    }

    void setStrokeWeight(float strokeWeight) {
        this.strokeWeight = strokeWeight;
    }

    void setNoStroke() {
        this.strokeWeight = 0f;
    }

    public Stroke(String hex) {
        this.stroke = Color.decode(hex);
    }

    @Override
    public String toString() {
        return null;
    }
}
