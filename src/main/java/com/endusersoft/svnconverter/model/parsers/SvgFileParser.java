package com.endusersoft.svnconverter.model.parsers;

import com.endusersoft.svnconverter.model.drawing.AbstractKhanObject;
import org.apache.batik.css.parser.Parser;
import org.apache.batik.svggen.SVGCSSStyler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * This class takes a NodeList and parses each node, generating Khan objects and pushes them onto a stack.
 */
public class SvgFileParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(SvgFileParser.class);
    private final List<AbstractKhanObject> khanObjects = new ArrayList<AbstractKhanObject>();

    public List<AbstractKhanObject> getKhanObjects() {
        return khanObjects;
    }

    /*
    for each element, push a fill(rgb) and strokeWeight()
    */
    protected SvgFileParser() {
    }

    public SvgFileParser(NodeList nodes) {
        handleNodes(nodes);
    }

    private void handleNodes(NodeList nodes) {
        Node node;
        for (int i = 0; i < nodes.getLength(); i++) {
            node = nodes.item(i);

            LOGGER.debug("\tlooking at '{}'", node.getNodeName());
            // in order to create KhanStyles we need to know what to do with css
// todo: I need a css class to deal with the style attribute
//            org.apache.batik.parser.style.StyleAttributeParser;

            Parser parser = new Parser();
            SvgStyleParser styleParser = new SvgStyleParser();
            SvgStyleParser.style(node);

        }
    }


}
