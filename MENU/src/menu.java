package Paquete;

import javax.swing.*;
import java.awt.event.*;

public class menu extends JFrame implements ItemListener {

    private JComboBox<String> combo1;

    public menu() {

        setLayout(null);
        combo1 = new JComboBox<String>();
        combo1.setBounds(10,10,80,20);
        add(combo1);
        combo1.addItem("rojo");
        combo1.addItem("verde");
        combo1.addItem("azul");
        combo1.addItem("amarillo");
        combo1.addItem("negro");
        combo1.addItemListener(this);

    }

    public void itemStateChanged(ItemEvent e) {

        if(e.getSource() == combo1) {

            String seleccionado = (String)combo1.getSelectedItem();
            setTitle(seleccionado);


        }

    }

    public static void main(String[] args) {

        menu menu1 = new menu();
        menu1.setBounds(0,0,200,250);
        menu1.setVisible(true);
        menu1.setVisible(true);
        menu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}