import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class TestApp {
    private Document document;


    @Before
    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Здесь можно указывать любой файл в classpath и не только.
        document = builder.parse(new File("C:/Sitaris/cinema.xml"));
    }


    @After
    public void tearDown() {
        document = null;
    }


    @Test
    public void testDocument() {
        int sum=0;
        // Запрашиваем элементы data из XML документа.
        NodeList nodeList =document.getElementsByTagName("c:film");
        for (int j=0;j<nodeList.getLength();j++){
        Element film = (Element) nodeList.item(j);
        NodeList props = film.getElementsByTagName("c:cost");

        for (int i=0;i<props.getLength();i++){
            sum+=Integer.parseInt (props.item(i).getTextContent());
        }}
        Assert.assertEquals(16,sum);
    }
}