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
            docDocument.normalizeDocument();
            NodeList ndlNodelist = docDocument.getElementsByTagName("equipo");

            for (int i=0;i<ndlNodelist.getLength();i++){
                //Lo convertimos en un elemento el node
                Node nNodes = ndlNodelist.item(i);
                Element eElemet =(Element)nNodes;
                NodeList nlListSoon = eElemet.getChildNodes();
                //FOR QUE RECORREMOS PARA VER LOS ARCHIVOS XML
                    for (int k=0;k<nlListSoon.getLength();k++){
                        Node nNodesoon = nlListSoon.item(k);
                        if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "nombre".equals(nNodesoon.getNodeName())){
                            System.out.println(nNodesoon.getNodeName() +" de la club : "+nNodesoon.getTextContent());
                        }

                        if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "ciudad".equals(nNodesoon.getNodeName())){
                            System.out.println(nNodesoon.getNodeName() +": "+nNodesoon.getTextContent());
                        }
                        if (nNodesoon.getNodeType()== Node.ELEMENT_NODE && "entrenador".equals(nNodesoon.getNodeName())){
                                if(nNodesoon.getTextContent().equals("")){
                                    System.out.println(nNodesoon.getNodeName() +": "+"SIN ENTRENADOR :(");
                            }else {
                                    System.out.println(nNodesoon.getNodeName() +": "+nNodesoon.getTextContent());
                                }

                        }

                        NodeList nodelistjugador = nNodesoon.getChildNodes();
                        for (int m= 0; m<nodelistjugador.getLength();m++){//jugadores
                                Node nodesjugador = nodelistjugador.item(m);
                                NodeList listajugador = nodesjugador.getChildNodes();

                                for (int x=0;x< listajugador.getLength();x++){//jugador
                                    Node jugadorenodes = listajugador.item(x);
                                    Element elementojugador = (Element) listajugador;

                                    if (jugadorenodes.getNodeType()== Node.ELEMENT_NODE && "nombre".equals(jugadorenodes.getNodeName())){
                                        System.out.print("su posicion actual en el campo de futbol es: ");
                                        System.out.println(elementojugador.getAttribute("posicion"));
                                        System.out.println(jugadorenodes.getNodeName() +": "+jugadorenodes.getTextContent());
                                    }
                                    if (jugadorenodes.getNodeType()== Node.ELEMENT_NODE && "nacionalidad".equals(jugadorenodes.getNodeName())){
                                        System.out.println(jugadorenodes.getNodeName() +": "+jugadorenodes.getTextContent());
                                    }
                                }
                        }
                    }
                System.out.println("-----------------------------------");
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
