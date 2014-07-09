package com.endusersoft.svnconverter;

import com.endusersoft.svnconverter.model.drawing.AbstractKhanObject;
import com.endusersoft.svnconverter.model.handlers.KhanPathHandler;
import com.endusersoft.svnconverter.model.parsers.SvgFileParser;
import org.apache.batik.parser.PathHandler;
import org.apache.batik.parser.PathParser;
import org.apache.batik.svggen.SVGConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
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
 * Class responsible for parsing a file into a nodelist, then processing those nodes with a path parser.
 */
public class SvgConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SvgConverter.class);

    public static void main(String[] args) {

        System.out.print("Hello, World.");
    }

    void ConsumeFile(File file)
            throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

        SVGConverterFileSource fileSource = new SvgConverter();
        StringBuilder builder = new StringBuilder();

        // this will do the actual parsing
        // this will contain the results
        List<AbstractKhanObject> khanObjects = new ArrayList<AbstractKhanObject>();
        // this performs the conversion
        PathHandler pathHandler = new KhanPathHandler(khanObjects);
        SvgFileParser svgFileParser = new SvgFileParser(parseSVGFile(file));

        /*LOGGER.debug("found {} nodes", nodeList.getLength());

        for (int i = 0; i < nodeList.getLength(); i++) {
            LOGGER.debug("\tlooking at '{}'", nodeList.item(i).getNodeName());
            switch (nodeList.item(i).getNodeName()) {
                case "path":
                    PathParser pathParser = new PathParser();


                    pathParser.setPathHandler(pathHandler);
                    pathParser.parse(nodeList.item(i)
                            .getAttributes().getNamedItem("d")
                            .getNodeValue());
                    break;
                case "line":
                    // pathParser = new lineParser();
            }*/

        SVGConverter
                XMLInputHandler inputHandler

        }

//        processResults(builder, khanObjects);
//        System.out.printf(builder.toString());



    private void processResults(StringBuilder sb, List<AbstractKhanObject> objects) {
        for (AbstractKhanObject khanObject : objects) {
            sb.append(khanObject.toString() + "\n");
        }
    }

    private NodeList  parseSVGFile(File file)
            throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        String xpathExpression = "//path[@d]";

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile(xpathExpression);

        return (NodeList) expression.evaluate(document, XPathConstants.NODESET);
    }

}













