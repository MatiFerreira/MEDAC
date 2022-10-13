
package InterfaceGrafica;

import javax.swing.*;
import java.awt.Color;

import java.awt.event.*;

public class dialogo extends JFrame implements ActionListener {

    private JPanel panel;

    private JButton boton;

    private JLabel label1;

    private JTextField texto1;

    private JDialog dia1, dia2, dia3;

    public dialogo() {


        setLayout(null);

        panel = new JPanel();
        panel.setBackground(Color.cyan);   // creacion de panel
        panel.setBounds(0, 0, 400, 400);
        panel.setLayout(null);


        boton = new JButton("letra");
        boton.setBounds(100, 100, 60, 30);
        panel.add(boton);                      //creacion boton en el panel
        boton.addActionListener(this);

        label1 = new JLabel("introduzca un valor: ");
        label1.setBounds(50, 50, 120, 30);               // creacion de etiqueta
        panel.add(label1);


        texto1 = new JTextField();
        texto1.setBounds(170, 50, 50, 30);                //creacion del campo de texto
        panel.add(texto1);


        add(panel);                 //se añade el panel a la frame


    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton) {


            String cadena = texto1.getText();

            if (cadena.length() == 0)             // si no has metido ningun dato
            {

                dia1 = new JDialog(this, "Sin Datos", true);

                dia1.setLayout(null);

                JButton b = new JButton("OK");

                JLabel lab = new JLabel("No ha introducido ningún dato");

                b.addActionListener(

                        new ActionListener() {

                            public void actionPerformed(ActionEvent eve) {
                                dia1.dispose();


                            }


                        }

                );

                b.setBounds(100, 100, 100, 50);
                dia1.add(lab);
                dia1.add(b);

                lab.setBounds(10, 10, 170, 50);
                dia1.setBounds(30, 10, 300, 200);
                dia1.setVisible(true);


            }

            if (cadena.length() > 1) {


                dia2 = new JDialog(this, "Demasiado largo", true);

                dia2.setLayout(null);

                JButton b = new JButton("OK");

                JLabel lab = new JLabel("Debes meter solo una letra");

                b.addActionListener(

                        new ActionListener() {

                            public void actionPerformed(ActionEvent eve) {
                                dia2.dispose();


                            }


                        }


                );

                b.setBounds(100, 100, 100, 50);
                dia2.add(lab);
                dia2.add(b);

                lab.setBounds(10, 10, 170, 50);
                dia2.setBounds(30, 10, 300, 200);
                dia2.setVisible(true);


            }

            if (cadena.length() == 1) {
                int contador =0;
                String [] palabrasReserva = new String[contador];


                if ((cadena.matches("[A-Z].*")) || (cadena.matches("[a-z].*"))) {


                    // correcto


                } else {


                    dia3 = new JDialog(this, "No es una letra", true);

                    dia3.setLayout(null);

                    JButton b = new JButton("OK");

                    JLabel lab = new JLabel("Debes meter una letra");

                    b.addActionListener(

                            new ActionListener() {

                                public void actionPerformed(ActionEvent eve) {
                                    dia3.dispose();


                                }


                            }


                    );

                    b.setBounds(100, 100, 100, 50);
                    dia3.add(lab);
                    dia3.add(b);

                    lab.setBounds(10, 10, 170, 50);
                    dia3.setBounds(30, 10, 300, 200);
                    dia3.setVisible(true);


                }


            }


        }


    }


    public static void main(String args[]) {


        dialogo d = new dialogo();

        d.setBounds(0, 0, 500, 500);
        d.setVisible(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
