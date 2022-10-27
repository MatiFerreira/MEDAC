
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



public class MARCO extends JFrame{


    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        MARCO MARCO = new MARCO();
    }
    
    public MARCO() throws ParserConfigurationException, SAXException{
  
        setVisible(true);
        setResizable(true);
       add(new Tablas());
         Toolkit scream =Toolkit.getDefaultToolkit(); //alamacenamos nuestro sistema nativo de la ventana
            Dimension dimesionScreen = scream.getScreenSize();  //Nos da el tamaño de la pantalla de nuestro ordenadorç
            int altopantalla = dimesionScreen.height; //Nos da el alto de la pantalla nuestra
            int anchopantalla = dimesionScreen.width; // nos da el ancho de nuestra pantalla
            setSize(anchopantalla/2,altopantalla/2);  //Nos da la mitad del tamaño de nuestra pantalla
            setLocation(anchopantalla/4, altopantalla/4); // Con esto centramos nuestra pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
