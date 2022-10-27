

package interfaz_grafica;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author MATI
 */
public class Escribir_Marco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        MarcoConTexto mimarco = new MarcoConTexto(); //instancia
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar
        
        
    }
    
}

class MarcoConTexto extends JFrame{
        public MarcoConTexto(){
            setVisible(true);
            setSize(600,450);
            setLocation(400, 200);
            setTitle("PRIMER TEXTO");
            Lamina milamina = new Lamina();
            add(milamina);
            
            
        }

}

//jPANEL seria como un cristal transparente donde vamos poniendolo en el jframe donde se pinta el ella y se puede poner varios jpanel como si fueran transparentes
class Lamina extends JPanel{
        //dibuja un componente 
    public void paintComponent(Graphics g){ //proviene de grafics 
            super.paintComponent(g);
            g.drawString("ESTAMOS Aprendiendo  Swing", 100, 100);
        }
    
    }