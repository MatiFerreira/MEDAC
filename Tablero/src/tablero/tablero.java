package tablero;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class tablero extends JFrame implements ActionListener {

    private JButton botones[][] = new JButton[8][8];
    int x = (int) (Math.random() * 7);
    int y = (int) (Math.random() * 7);
    //private JButton b;
    int i, j;

    public tablero() {

        setLayout(null);

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                botones[i][j] = new JButton();

                botones[i][j].setBounds(1 + i * 30, 1 + j * 30, 30, 30);
                add(botones[i][j]);

                botones[i][j].addActionListener(this);

            }

        }

        //    b=new JButton("hola");
        //    b.setBounds(300,300,40,40);
        //    add(b);
    }
public void actionPerformed(ActionEvent e) {
        JButton mio = (JButton) e.getSource();
        for (int m = 0; m < 8; m++) {
            for (int r = 0; r < 8; r++) {
                if(botones[m][r].equals(mio)){
                    if(botones[m][r].equals(botones[x][y])){
                        botones[m][r].setBackground(Color.red);
                        for (int fila=0;fila<8;fila++){
                            for (int column=0;column<8;column++){
                                botones[fila][column].setEnabled(false);
                            }
                        }
                        //COMPRUEBO AQUI LA CERCANIA QUE TIENE CON RESPECTO AL COLOR
                    } else if ((m-x==1||m-x==0||m-x==-1) && (r-y==1||r-y==0||r-y==-1)){
                        botones[m][r].setBackground(Color.orange);
                        //COMPRUEBO LA LEJANIA QUE HAY ENTRE LA BOMBA
                    } else if((m-x==2||m-x==1||m-x==0||m-x==-1||m-x==-2)&&(r-y==2||r-y==1||r-y==0||r-y==-1||r-y==-2)){
                        botones[m][r].setBackground(Color.blue);
                        //SI NO SE ENCUENTRA EN EL RANGO NO ESRTA
                    } else {
                        botones[m][r].setBackground(Color.green);
                    }
                    mio.setEnabled(false);
                }
            }
        }
    }

    public static void main(String[] args) {

        tablero tabla = new tablero();

        tabla.setBounds(0, 0, 500, 500);
        tabla.setVisible(true);
        tabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
