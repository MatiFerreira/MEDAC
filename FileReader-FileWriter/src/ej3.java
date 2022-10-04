import java.io.*;
import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        try {
            File fFile = new File("./archivo.txt");
            Writer wWriter = new FileWriter(fFile);
            wWriter.write("Hola me llamo Mathias Ferreira Ferreira.Esto es Facil."+"\n");
            wWriter.write("Mathias es una persona curiosa"+"\n");
            wWriter.close();
            BufferedReader bfReader = new BufferedReader(new FileReader("./archivo.txt"));
            System.out.print("Dame la palabra que creas que se repite : ");
            String tmp = tc.nextLine(); //Recogemos las palabras a comparar
            int contador =0;
            String palabras;
            //WHILE le metemos la cadena de texto en palabras y no salimos hasta que este vacio :/
            while ((palabras = bfReader.readLine()) !=null){
                //recorro el tamaño del texto y con substring le indico donde empezar y con startwith comparo el texto que le he pasado si coincide
                for (int i=0;i<palabras.length();i++){
                    if (palabras.substring(i).startsWith(tmp)){
                        contador++;
                    }
                }
            }
            System.out.println(contador);
            bfReader.close();
        }catch (Exception z){
            System.out.println(z.getMessage() +";(");
        }
    }
}
