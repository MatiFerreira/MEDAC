
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Tablas extends JPanel {

    public Tablas() throws ParserConfigurationException, SAXException {
        DefaultTableModel tablamodelo = new DefaultTableModel();
        JTable table = new JTable(tablamodelo);
        
         table.setPreferredScrollableViewportSize(new Dimension(900, 600));
         JScrollPane scroll = new JScrollPane(table);
         add(scroll);
           tablamodelo.addColumn("Nombre");
           tablamodelo.addColumn("Apellido");
           tablamodelo.addColumn("Notas");
           tablamodelo.addColumn("ID");
           
        
        try {
            double suma =0;
            double media =0.0;
            String alumno="",id="",apellido="",nota="";
            File file = new File("alumnos.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("alumno"); 
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    id =eElement.getAttribute("id");             
                    alumno = eElement.getElementsByTagName("nombre").item(0).getTextContent();                   
                    apellido = eElement.getElementsByTagName("apellido").item(0).getTextContent();           
                    nota = eElement.getElementsByTagName("nota").item(0).getTextContent();
                    tablamodelo.addRow(new Object[]{alumno,apellido,nota,id});
                     suma +=+ Integer.parseInt(eElement.getElementsByTagName("nota").item(0).getTextContent());
                    
                }
                
                media = suma/nList.getLength();
            }
            tablamodelo.addRow(new Object[]{"MEDIA","DEL CURSO : ",media});

        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
