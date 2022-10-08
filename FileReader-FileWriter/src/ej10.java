import java.io.*;

public class ej10 {

    public static void main(String[] args) {
        try {
            BufferedWriter bfwWriter = new BufferedWriter (new FileWriter("./mezcla.txt"));
            BufferedWriter bfwWriter2 = new BufferedWriter (new FileWriter("./texto1.txt"));
            BufferedWriter bfwWriter3 = new BufferedWriter (new FileWriter("./texto2.txt"));
            //BufferedReader bfrReader = new BufferedReader(new FileReader("./mezcla.txt"));
            BufferedReader bfrReader2 = new BufferedReader(new FileReader("./texto1.txt"));
            BufferedReader bfrReader3 = new BufferedReader(new FileReader("./texto2.txt"));
            //Añadimos texto a cada archivo
            bfwWriter2.write("Hola");
            bfwWriter3.write("Me llamo mathias");
            bfwWriter3.close();
            bfwWriter2.close();
            String textos = bfrReader2.readLine();
            String textos2 = bfrReader3.readLine();
            int posicion = 1;
            while (posicion != 5){
                if (posicion%2==0){
                    bfwWriter.write(textos2+"\n");
                }else {
                    bfwWriter.write(textos+"\n");
                }
                bfwWriter.flush();// un limpiador de buffer para poder escribir nuevamente :)
                posicion++;
            }


            bfwWriter.close();
            bfrReader3.close();
            bfrReader2.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
