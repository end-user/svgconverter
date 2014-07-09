package com.endusersoft.svnconverter.model.drawing;

/**
 * Created by Oblio.Leitch on 2/15/14.
 */
public abstract class AbstractKhanObject {



    public abstract String toString();

    static String fmt(double d) {
        if (d == (int) d)
            return String.format("%d", (int) d);
        else
            return String.format("%s", d);
    }
}
