
package interfaz_grafica;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author MATI
 */
public class MARCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            MIMARCO marco1 = new MIMARCO();
            marco1.setVisible(true);//PARA QUE SE VEA EL MARCO
            marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ESTO CUANDO SE CIERRE EL PROGRAMA ACABA EL PROGRAMA SI NO CIERRA CONSUME RECURSO
            
            
            
       }
    
}
class MIMARCO extends JFrame{
    
    public MIMARCO(){
           // setSize(500,300);//Damos el tamaño del marco
          //  setLocation(700,300); //ESTABLECE LA UBICACION DEL FRAME (x,y)
            setBounds(500,300,500,300); //NOS DA EL TAMAÑO DEL MARCO Y ESTABLECE UNA UBICACION DEL FRAME
            //setResizable(false);// para evitar que puedan aumentar o disminuir el marco
            //setExtendedState(Frame.MAXIMIZED_BOTH); //SIRVE PARA QUE EL MARCO SE ESTIRE AL MAXIMO DE NUESTRA PANTALLA 
            setTitle("VENTANA"); //PONE EL TITULO DEL MARCO
        }
}
