package by.bsuir.bonus.xml;

import by.bsuir.bonus.collection.CustomArrayList;
import by.bsuir.bonus.exception.BonusException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomWriter {
    private DocumentBuilder builder;
    private Transformer transformer;

    private static final String ROOT_ELEMENT = "arrayList";
    private static final String STRING_ELEMENT = "str";

    public DomWriter() throws BonusException{
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            throw new BonusException(e);
        }
    }
    public void writeCustomArrayList(CustomArrayList customArrayList, String filePath) throws BonusException {
        Document doc = builder.newDocument();
        Element root = doc.createElement(ROOT_ELEMENT);
        doc.appendChild(root);
        for (String str : customArrayList.getArrayList()) {
            root.appendChild(createStringNode(doc, str));
        }
        DOMSource source = new DOMSource(doc);
        StreamResult file = new StreamResult(new File(filePath));

        try {
            transformer.transform(source, file);
        } catch (TransformerException e) {
            throw new BonusException(e);
        }
    }

    private Node createStringNode(Document doc, String str){
        Element lineElement = doc.createElement(STRING_ELEMENT);
        lineElement.appendChild(doc.createTextNode(str));
        return lineElement;
    }

}
