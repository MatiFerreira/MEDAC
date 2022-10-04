import java.io.*;
import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        try {
            File fFile = new File("./archivo.txt");
            fFile.createNewFile();
            Writer wWriter = new FileWriter(fFile);
            wWriter.write("Hola me llamo mathias Ferreira Ferreira"+"\n");
            wWriter.close();
            Reader rReader = new FileReader("./archivo.txt");
            System.out.println("Dame la palabra que creas que se repite :( ");
            String tmp = tc.nextLine();
                for (int i=0;i<tmp.length();i++){
                    char cValor =(char)i;
                    char[]valores = {cValor};
                }
            rReader.close();

        }catch (Exception z){
            System.out.println(z.getMessage() +";(");
        }
    }
}
