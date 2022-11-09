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

public class ejr1 {
    public static void main(String[] args) {
        try {
            //Instanciamos
            DocumentBuilderFactory dbfFactory = DocumentBuilderFactory.newDefaultInstance();
            //Construimos el nuevo documento sobre la instancia
            DocumentBuilder dbBuilder = dbfFactory.newDocumentBuilder();
            //creamos el file e indicamos donde va a apuntar
            //CREAMOS EL TIPO DE ARBOL DOM
            Document docDocument = dbBuilder.parse(new File("ejemplo.xml"));
            //Normalizamos e ignoramos las etiquetas con espacios
            docDocument.normalizeDocument();
            // Ahora buscamos el nodo   por el elemento con su nombre
            NodeList ndlNodelist = docDocument.getElementsByTagName("animal");

            //Ahora vamos a recorrer todos los node list anterior-->
            for (int i=0;i<ndlNodelist.getLength();i++){
                //Obtenemos el node :)
                Node nNode = ndlNodelist.item(i);
                //Comprobamos si es un tipo de elemento
                if (nNode.getNodeType()== Node.ELEMENT_NODE){
                    System.out.println(nNode.getNodeName()+": "+nNode.getTextContent());
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
