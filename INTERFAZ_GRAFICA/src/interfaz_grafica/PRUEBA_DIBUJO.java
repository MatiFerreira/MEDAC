
package interfaz_grafica;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author MATI
 */
public class PRUEBA_DIBUJO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MarcoCondibujos dibujo = new MarcoCondibujos();
        dibujo.setVisible(true);
        dibujo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class MarcoCondibujos extends JFrame{

    public MarcoCondibujos(){
          setTitle("PRUEBA DIBUJO");
          setSize(400,400);
          LaminaFigura figura = new LaminaFigura();
          add(figura);
      
        }

}

class LaminaFigura extends JPanel{
      
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(80, 50, 200, 200); //dibuja un cuadrado 
        g.drawLine(100, 100, 200, 200); //dibuja una linea del punto que le indiquemos
        g.drawArc(70, 80, 100, 100, 120, 100); //dibuja un arco
       }


    }