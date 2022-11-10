package Ahorcado1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author MATI
 */
public class Ahorcado1_0 extends javax.swing.JFrame {

    private JButton[] botonesAZ;
    private String[] valores;
    private ImageIcon[] aImageIcons;
    private String valorcorrectos;
    private int error;
    private String res[];
    private int ran;
    //Inicio del component
    public Ahorcado1_0() {
        initComponents();
        //metemos 6 imagen cada imagen es el cambio de el ahorcado :)
        aImageIcons = new ImageIcon[6];
        botonesAZ = new JButton[27];
        valores = new String[3];
           //Hacemos mayus para evitar errores de mayus y minus
        valores[0] = "abatojar".toUpperCase();
        valores[1] = "abduzcan".toUpperCase();
        valores[2] = "abisales".toUpperCase();

        /*Pondremos en cada array una imagen que sera del array*/
        aImageIcons[0] = new ImageIcon(getClass().getResource("1.jpg"));
        aImageIcons[1] = new ImageIcon(getClass().getResource("2.jpg"));
        aImageIcons[2] = new ImageIcon(getClass().getResource("3.jpg"));
        aImageIcons[3] = new ImageIcon(getClass().getResource("4.jpg"));
        aImageIcons[4] = new ImageIcon(getClass().getResource("5.jpg"));
        aImageIcons[5] = new ImageIcon(getClass().getResource("6.jpg"));
        /*===================================================*/
        // INDICAMOS LOS  BOTONES CORRESPONDIENTES
        botonesAZ[1] = jButton1;
        botonesAZ[2] = jButton2;
        botonesAZ[3] = jButton3;
        botonesAZ[4] = jButton4;
        botonesAZ[5] = jButton5;
        botonesAZ[6] = jButton6;
        botonesAZ[7] = jButton7;
        botonesAZ[8] = jButton8;
        botonesAZ[9] = jButton9;
        botonesAZ[10] = jButton10;
        botonesAZ[11] = jButton11;
        botonesAZ[12] = jButton12;
        botonesAZ[13] = jButton13;
        botonesAZ[14] = jButton14;
        botonesAZ[15] = jButton16;
        botonesAZ[16] = jButton17;
        botonesAZ[17] = jButton18;
        botonesAZ[18] = jButton19;
        botonesAZ[19] = jButton20;
        botonesAZ[20] = jButton21;
        botonesAZ[21] = jButton22;
        botonesAZ[22] = jButton23;
        botonesAZ[23] = jButton24;
        botonesAZ[24] = jButton25;
        botonesAZ[25] = jButton26;
        botonesAZ[26] = jButton27;
        

        for (int i = 1; i < 27; i++) {
            botonesAZ[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                       checarLetra(e);
                }
            });
        }
        iniciar();

    }

    private void iniciar(){
        //ERRORES EN 0
        error = 0;
        jButton28.setIcon(aImageIcons[0]);
        jTextPane1.setText("");
        //ACTIVAMOS TODAS LAS LETRAS PARA EL USO 
        for (int i = 1; i < 27; i++) {
            botonesAZ[i].setEnabled(true);
        }
        //GENERAMOS UN MENGSAME RANDOM CUAL ELIGIRA ALEATORIAMENTE
         ran =(int) 0 + (int)(Math.random() * ((valores.length - 1) + 1));
        //SEPARAMOS EL MENSAJE POR PALABRAS CON SPLIT SI FUESE UNA FRASE
        String pal[] = valores[ran].split(" ");
        res = new String[valores[ran].length()+1];
        int j = 0;
        //VAMOS IMPRIMIENDO EL NUMERO DE CARACTERES DEL MENSAGE CON _
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                jTextPane1.setText(jTextPane1.getText() + "_ ");
                res[j++] = "_";
            }
            jTextPane1.setText(jTextPane1.getText() + "\n");
            res[j++] = " ";
        }
    }
    
        private void checarLetra(ActionEvent e){
        JButton bt = (JButton)e.getSource();
        char c[];
        //BUSCAMOS EL BOTON QUE HEMOS PRECIONADO Y COMPROBAMOS SACANDO LA LETRA FUERA
        for (int i = 1; i < 27; i++) {
            if(bt == botonesAZ[i]){
                //SE SACA LA LETRA PARA LA COMPROBRACION
                c = Character.toChars(64+i);
                //AQUI LO QUE HACEMOS ES COMRPOBRAR SI LA LETRA QUE BUSCAMOS ESTA
                boolean esta = false;
                for (int j = 0; j < valores[ran].length(); j++) {
                    if(c[0] == valores[ran].charAt(j)){
                        res[j] = c[0]+"";
                        esta = true;
                    }
                }
                //SI ESTA SE MOSTRARA EN NUESTRO PANEL DE TEXTO
                if(esta){
                    jTextPane1.setText("");
                    for (String re : res) {
                        if(" ".equals(re))jTextPane1.setText(jTextPane1.getText() + "\n");
                        else jTextPane1.setText(jTextPane1.getText() + re +" ");
                    }
                    //COMPROBAMOS SI TIENE _ SI ES ASI AUN NO HA GANADO LE FALTA LETRAS POR ADIVINAR
                    boolean gano = true;
                    for (String re : res) {
                        if(re.equals("_")){
                            gano = false;
                            break;
                        }
                    }
                    //SI GANAMOS NOS DA UN MENSAJE DE QUE HEMOS GANADO :)
                    if(gano){
                        JOptionPane.showMessageDialog(this, "YOU WIN!");
                        iniciar();
                        return;
                    }
                //Cada vez que falle en el array de imagen cambia al siquiente y cuando llegue al final nos dara que hemos perdido
                }else{
                    jButton28.setIcon(aImageIcons[++error]);
                    //SI LLEGAMOS A LOS 5 ERRORES ENTONCES SE PERDIO EL JUEGO Y SE MANDA EL MENSAGE
                    if(error == 5){
                        JOptionPane.showMessageDialog(this, "Has perdido, LA FRASE ERA:\n"+valores[ran]);
                        iniciar();
                        return;
                    }
                }
                //Aqui desactivamos que pueda darle otra vez al mismo boton
                bt.setEnabled(false);
                break;
            }
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("A");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, -1));

        jButton2.setText("B");
        jButton2.setToolTipText("");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, -1));

        jButton3.setText("C");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, -1, -1));

        jButton4.setText("D");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, -1, -1));

        jButton5.setText("E");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, -1, -1));

        jButton6.setText("F");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, -1, -1));

        jButton7.setText("G");
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, -1, -1));

        jButton8.setText("H");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, -1, -1));

        jButton9.setText("I");
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, -1, -1));

        jButton10.setText("J");
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, -1, -1));

        jButton11.setText("K");
        jButton11.setToolTipText("");
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, -1, -1));

        jButton12.setText("L");
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, -1, -1));

        jButton13.setText("M");
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, -1, -1));

        jButton14.setText("N");
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, -1, -1));

        jButton16.setText("O");
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, -1, -1));

        jButton17.setText("P");
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, -1, -1));

        jButton18.setText("Q");
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, 20));

        jButton19.setText("R");
        jButton19.setToolTipText("");
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));

        jButton20.setText("S");
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, -1, -1));

        jButton21.setText("T");
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, -1, -1));

        jButton22.setText("U");
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, -1, -1));

        jButton23.setText("V");
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, -1, -1));

        jButton24.setText("W");
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, -1, -1));

        jButton25.setText("X");
        getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, -1, -1));

        jButton26.setText("Y");
        getContentPane().add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, -1, -1));

        jButton27.setText("Z");
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, -1, -1));
        getContentPane().add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 280));

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 460, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ahorcado1_0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado1_0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado1_0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado1_0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ahorcado1_0().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}
