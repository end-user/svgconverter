package com.endusersoft.svnconverter.model.handlers;

import com.endusersoft.svnconverter.model.drawing.AbstractKhanObject;
import com.endusersoft.svnconverter.model.drawing.Bezier;
import org.apache.batik.parser.ParseException;
import org.apache.batik.parser.PathHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Oblio.Leitch on 3/16/14.
 * http://xmlgraphics.apache.org/batik/javadoc/org/apache/batik/parser/PathHandler.html
 */
public class KhanPathHandler extends AbstractKhanHandler implements PathHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(KhanPathHandler.class);


    public KhanPathHandler(List<AbstractKhanObject> khanObjects) {
        super(khanObjects);
    }

    /**
     * called at beginning of a path
     *
     * @throws ParseException
     */
    @Override
    public void startPath() throws ParseException {
        LOGGER.debug("begin Path");
        getCoordinates().Reset();
    }


    /**
     * called at the end of a path
     *
     * @throws ParseException
     */
    @Override
    public void endPath() throws ParseException {

    }

    /**
     * called with an "m" command
     *
     * @param v
     * @param v2
     * @throws ParseException
     */
    @Override
    public void movetoRel(float v, float v2) throws ParseException {

    }

    /**
     * called with an "M" command
     *
     * @param v
     * @param v2
     * @throws ParseException
     */
    @Override
    public void movetoAbs(float v, float v2) throws ParseException {
        getCoordinates().Set(v, v2);
    }

    /**
     * called with "z" or "Z" commands; should return to the beginning
     *
     * @throws ParseException
     */
    @Override
    public void closePath() throws ParseException {
        LOGGER.debug("closing Path");
    }

    /**
     * creates a line with "l" command
     *
     * @param v
     * @param v2
     * @throws ParseException
     */
    @Override
    public void linetoRel(float v, float v2) throws ParseException {
        LOGGER.debug("create relative Line: %f,%f", v, v2);
    }

    /**
     * creates a line with an "L" command
     *
     * @param v
     * @param v2
     * @throws ParseException
     */
    @Override
    public void linetoAbs(float v, float v2) throws ParseException {
        LOGGER.debug("create absolute Line: %f,%f", v, v2);
    }

    /**
     * creates a horizontal line; "h" command
     *
     * @param v
     * @throws ParseException
     */
    @Override
    public void linetoHorizontalRel(float v) throws ParseException {
        LOGGER.debug("create relative horizontal Line: %f", v);
    }

    /**
     * creates a horizontal line; "H" command
     *
     * @param v
     * @throws ParseException
     */
    @Override
    public void linetoHorizontalAbs(float v) throws ParseException {
        LOGGER.debug("create absolute horizontal Line: %f", v);
    }

    /**
     * creates a vertical line; "v" command
     *
     * @param v
     * @throws ParseException
     */
    @Override
    public void linetoVerticalRel(float v) throws ParseException {
        LOGGER.debug("create relative Line: %f", v);
    }

    /**
     * creates a vertical line; "V" command
     *
     * @param v
     * @throws ParseException
     */
    @Override
    public void linetoVerticalAbs(float v) throws ParseException {
        LOGGER.debug("create absolute vertical Line: %f", v);
    }

    /**
     * intended to create a cubic bezier "c" command
     *
     * @param v
     * @param v2
     * @param v3
     * @param v4
     * @param v5
     * @param v6
     * @throws ParseException
     */
    @Override
    public void curvetoCubicRel(float v, float v2, float v3, float v4, float v5, float v6) throws ParseException {
        LOGGER.debug("create relative Bezier: %f,%f", v, v2);
    }

    /**
     * intended to create a cubic bezier "C" command
     *
     * @param v
     * @param v2
     * @param v3
     * @param v4
     * @param v5
     * @param v6
     * @throws ParseException
     */
    @Override
    public void curvetoCubicAbs(float v, float v2, float v3, float v4, float v5, float v6) throws ParseException {
        LOGGER.debug("create absolute Bezier: %f,%f", v, v2);
        Bezier bezier = new Bezier(
                getCoordinates().getX(),
                getCoordinates().getY(),
                v, v2, v3, v4, v5, v6
        );
        this.getObjectList().add(bezier);
        this.getCoordinates().Set(v5, v6);
    }

    @Override
    public void curvetoCubicSmoothRel(float v, float v2, float v3, float v4) throws ParseException {

    }

    @Override
    public void curvetoCubicSmoothAbs(float v, float v2, float v3, float v4) throws ParseException {

    }

    @Override
    public void curvetoQuadraticRel(float v, float v2, float v3, float v4) throws ParseException {

    }

    @Override
    public void curvetoQuadraticAbs(float v, float v2, float v3, float v4) throws ParseException {

    }

    @Override
    public void curvetoQuadraticSmoothRel(float v, float v2) throws ParseException {

    }

    @Override
    public void curvetoQuadraticSmoothAbs(float v, float v2) throws ParseException {

    }

    @Override
    public void arcRel(float v, float v2, float v3, boolean b, boolean b2, float v4, float v5) throws ParseException {

    }

    @Override
    public void arcAbs(float v, float v2, float v3, boolean b, boolean b2, float v4, float v5) throws ParseException {

    }
}
