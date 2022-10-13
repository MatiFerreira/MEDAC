package InterfaceGrafica;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.*;


    public class Alea extends JFrame implements ActionListener {

        private int num;
        private JButton bt;
        private JTextField jtfText;

        public Alea() {
            //Boton :)
            setLayout(null);
            bt = new JButton("Finalizar");
            bt.setBounds(10, 200, 100, 30);
            add(bt);
            bt.addActionListener(this);

            //Texto
            jtfText = new JTextField();
            jtfText.setBounds(10, 10, 45, 50);
            add(jtfText);

        }

        public void numero() {
            int x = (int) (Math.random() * 100 + 1);
            num = x;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == bt) {

                String cad = jtfText.getText();
                int x1;
                ArrayList<Integer>repetido = new ArrayList<>();

                //intento pasar a string a numero y si no puedo es porque estaré metiendo caracteres
                    try {
                            x1 = Integer.parseInt(cad);
                            repetido.add(x1);

                            if (x1 < num) {
                                setTitle("Es mayor");
                                JOptionPane.showMessageDialog(null, "El numero es mayor al que acabas de poner");
                            }
                            if(x1>num){
                                setTitle("Es menor");
                                JOptionPane.showMessageDialog(null, "El numero es menor al que acabas de poner");
                            }
                            if (x1 == num) {
                                setTitle("Congratulation");
                                JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
                            }


                    } catch (Exception z) {
                        setTitle("error");
                        JOptionPane.showMessageDialog(null, "Operación realizada Incorrectamente , solo numeros enteros");
                    }
            }

        }


        public static void main(String[] args) {
            Alea b1 = new Alea();
            b1.numero();
            System.out.print(b1.num);
            b1.setBounds(0, 0, 450, 350);
            b1.setVisible(true);
            b1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }


