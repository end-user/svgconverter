package com.endusersoft.svnconverter.model.drawing;

import java.awt.*;

/**
 * Created by Oblio.Leitch on 3/27/14.
 */
public class Fill extends AbstractKhanObject {

    private Color fill;

    public String getFill() {
        if (null == fill) {
            return "noStroke();";
        }
        return String.format("fill(%s, %s, %s);",
                fill.getRed(),
                fill.getGreen(),
                fill.getBlue()
        );
    }

    void setFill(Color fill) {
        this.fill = fill;
    }

    public Fill(String hex) {
        this.fill = Color.decode(hex);
    }

    @Override
    public String toString() {
        return null;
    }
}
