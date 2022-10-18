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

public class ejr3 {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbfFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuild = dbfFactory.newDocumentBuilder();
            Document docDocument = dbBuild.parse(new File("equipo_futbol.xml"));
            NodeList ndlNodelist = docDocument.getElementsByTagName("equipo");

            for (int i=0;i<ndlNodelist.getLength();i++){
                //Lo convertimos en un elemento el node
                Node nNodes = ndlNodelist.item(i);
                Element eElemet =(Element)nNodes;
                NodeList nlListSoon = eElemet.getChildNodes();
                    for (int k=0;k<nlListSoon.getLength();k++){
                        Node nNodesoon = nlListSoon.item(k);
                        if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "nombre".equals(nNodesoon.getNodeName())){
                            System.out.println(nNodesoon.getNodeName() +": "+nNodesoon.getTextContent());
                        }

                        if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "ciudad".equals(nNodesoon.getNodeName())){
                            System.out.println(nNodesoon.getNodeName() +": "+nNodesoon.getTextContent());
                        }

                        if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "entrenador".equals(nNodesoon.getNodeName())){
                            System.out.println(nNodesoon.getNodeName() +": "+nNodesoon.getTextContent());
                        }

                    }

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
