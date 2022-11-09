import java.io.*;
import java.util.Scanner;

public class EJ11 {
    static Scanner tc = new Scanner(System.in);
   static String[] strnombre = new String[5];
   static String[] straltura = new String[5];

    static BufferedWriter bfwWriter = null;
    static FileWriter flWriter = null;
    //metodo insertar usuario
    public static void Usuarios(String nombre,String altura,String nombre_archivo) throws IOException {
        flWriter = new FileWriter("./"+nombre_archivo);
            for (int i =0;i<strnombre.length;i++){
                if (strnombre[i] ==null){
                    strnombre[i] = nombre;
                    i = strnombre.length;
                }
            }

            for (int j =0;j<straltura.length;j++){
                if (straltura[j] == null){
                    straltura[j] = altura;
                    j = straltura.length;
                }
            }

            for (int i =0;i<5 ;i++){
                if ((strnombre[i]!=null) && (strnombre[i]!=null)){
                    flWriter.write("["+String.valueOf(strnombre[i]) +","+String.valueOf(straltura[i])+"] ");
                }
            }
            flWriter.close();
        }


    public static void main(String[] args) {
        try {
            Usuarios("Mathias","1.74","Mathias.txt");
            Usuarios("Paco","1.84","Mathias.txt");
            Usuarios("Fer","1.78","Mathias.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}