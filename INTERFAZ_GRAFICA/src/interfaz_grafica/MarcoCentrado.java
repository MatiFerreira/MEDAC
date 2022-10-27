package interfaz_grafica;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
public class MarcoCentrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MarcoCentral marco = new MarcoCentral();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoCentral extends JFrame {
        public MarcoCentral(){
            //constructor
            
            Toolkit scream =Toolkit.getDefaultToolkit(); //alamacenamos nuestro sistema nativo de la ventana
            Dimension dimesionScreen = scream.getScreenSize();  //Nos da el tamaño de la pantalla de nuestro ordenadorç
            int altopantalla = dimesionScreen.height; //Nos da el alto de la pantalla nuestra
            int anchopantalla = dimesionScreen.width; // nos da el ancho de nuestra pantalla
            setSize(anchopantalla/2,altopantalla/2);  //Nos da la mitad del tamaño de nuestra pantalla
            setLocation(anchopantalla/4, altopantalla/4); // Con esto centramos nuestra pantalla
            setTitle("VENTANA-CENTRADO");
            Image icono = scream.getImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fes.vecteezy.com%2Farte-vectorial%2F2373248-black-cat-simple-logo-design&psig=AOvVaw2nAor0TXssYauS3m7ld0Jf&ust=1666891407695000&source=images&cd=vfe&ved=0CA0QjRxqFwoTCPCTzMG0_voCFQAAAAAdAAAAABAE"); //Con esto ponemos un icono para el marco
            setIconImage(icono); //Establecemos el icono
        }   
}
