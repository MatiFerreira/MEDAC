import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ejr2 {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbfFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuild = dbfFactory.newDocumentBuilder();
            Document docDocument = dbBuild.parse(new File("empresa.xml"));
            NodeList ndlList = docDocument.getElementsByTagName("trabajador");

            for (int i =0;i<ndlList.getLength();i++){
                Node nNODE = ndlList.item(i);
                Element elElement = (Element) nNODE;
                System.out.println("id : "+elElement.getAttribute("id"));
                NodeList nlistSoon = elElement.getChildNodes();

                for (int j=0;j<nlistSoon.getLength();j++){
                    Node nNodesoon = nlistSoon.item(j);
                    if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "nombre".equals(nNodesoon.getNodeName())){
                        System.out.println(nNodesoon.getNodeName() +": "+nNodesoon.getTextContent());
                    }

                    if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "apellido".equals(nNodesoon.getNodeName())){
                        System.out.println(nNodesoon.getNodeName() +": "+nNodesoon.getTextContent());
                    }

                    if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "edad".equals(nNodesoon.getNodeName())){
                        System.out.println(nNodesoon.getNodeName() +": "+nNodesoon.getTextContent());
                    }

                }
                System.out.println("----------------------------------------");
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
