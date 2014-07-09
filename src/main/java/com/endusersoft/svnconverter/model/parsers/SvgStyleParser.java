package com.endusersoft.svnconverter.model.parsers;

import org.apache.batik.svggen.SVGStylingAttributes;
import org.apache.batik.svggen.SVGSyntax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.Vector;

/**
 * Created by Oblio.Leitch on 4/1/14.
 */
public class SvgStyleParser implements SVGSyntax {
    private static final Logger LOGGER = LoggerFactory.getLogger(SvgStyleParser.class);
    static private String CSS_PROPERTY_VALUE_SEPARATOR = ":";
    static private String CSS_RULE_SEPARATOR = ";";
    static private String SPACE = " ";


    public static void style(Node node) {
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            // Has to be an Element, as it has attributes
            // According to spec.
            Element element = (Element) node;
            StringBuffer styleAttrBuffer = new StringBuffer();
            int nAttr = attributes.getLength();
            Vector toBeRemoved = new Vector();
            for (int i = 0; i < nAttr; i++) {
                Attr attr = (Attr) attributes.item(i);
                if (SVGStylingAttributes.set.contains(attr.getName())) {
                    // System.out.println("Found new style attribute");
                    styleAttrBuffer.append(attr.getName());
                    styleAttrBuffer.append(CSS_PROPERTY_VALUE_SEPARATOR);
                    styleAttrBuffer.append(attr.getValue());
                    styleAttrBuffer.append(CSS_RULE_SEPARATOR);
                    styleAttrBuffer.append(SPACE);
                    toBeRemoved.addElement(attr.getName());
                }
            }

            if (styleAttrBuffer.length() > 0) {
                // System.out.println("Setting style attribute on node: " + styleAttrBuffer.toString().trim());
                // There were some styling attributes
                element.setAttributeNS(null,
                        SVG_STYLE_ATTRIBUTE,
                        styleAttrBuffer.toString().trim());

                int n = toBeRemoved.size();
                for (int i = 0; i < n; i++)
                    element.removeAttribute((String) toBeRemoved.elementAt(i));
            }
            // else
            // System.out.println("NO STYLE PROPERTIES");

        }
    }
}