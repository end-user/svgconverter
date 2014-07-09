package com.endusersoft.svnconverter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Oblio.Leitch on 2/21/14.
 */
public class TestSvgConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSvgConverter.class);

    @Test
    public void TestParseFile()
            throws IOException, URISyntaxException, XPathExpressionException, ParserConfigurationException, SAXException {
        SvgConverter svgConverter = new SvgConverter();

//        InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream("Papilio_memnon_butterfly.svg");

        URI uri = TestSvgConverter.class.getClassLoader()
                .getResource("Papilio_memnon_butterfly.svg").toURI();
        File file = new File(uri);

        LOGGER.debug("processing '{}'", file.getPath());

        svgConverter.ConsumeFile(file);

    }
}
