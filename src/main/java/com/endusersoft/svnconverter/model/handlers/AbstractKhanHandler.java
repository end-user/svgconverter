package com.endusersoft.svnconverter.model.handlers;

import com.endusersoft.svnconverter.model.drawing.AbstractKhanObject;
import com.endusersoft.svnconverter.model.drawing.Point;

import java.util.List;

/**
 * Abstract class responsible for compiling a collection of Khan Objects.
 */
public class AbstractKhanHandler {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private List<AbstractKhanObject> khanObjects;

    private Point coordinates;

    Point getCoordinates() {
        return coordinates;
    }

    public List<AbstractKhanObject> getObjectList() {
        return khanObjects;
    }



    /***
     * The constructor needs a String[] to append new object outputs to.  When the constructor is initialized, the starting coordinates are zeroed.
     * @param khanObjects
     */
    public AbstractKhanHandler(List<AbstractKhanObject> khanObjects) {
        this.khanObjects = khanObjects;
        this.coordinates = new Point(0f, 0f);
    }
}
