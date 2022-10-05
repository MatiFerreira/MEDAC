import java.io.*;
import java.util.Scanner;

public class ej6 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        try {
            String salir ="";
            do {
                Writer wWriter = new FileWriter("./datos-personal.txt");
                wWriter.write("---------------------------------------------------" + "\n");
                System.out.print("\n" + "Escribe su nombre : ");
                String nombre = tc.nextLine() + "\n";
                wWriter.write(nombre);
                System.out.print("Escriba su aficiones : ");
                String aficion = tc.nextLine() + "\n";
                wWriter.write(aficion);
                System.out.print("Dime tu edad: ");
                String edad = tc.nextLine() + "\n";
                wWriter.write(edad);
                wWriter.write("--------------------------------------------------");
                wWriter.close();
                System.out.println("Quiere salir del programa(no/si): ");
                 salir = tc.nextLine();
                BufferedReader bfReader = new BufferedReader(new FileReader("./datos-personal.txt"));
                String texto;
                while ((texto = bfReader.readLine()) != null) {
                    System.out.println(texto);
                }
                bfReader.close();
            }while (salir.equalsIgnoreCase("no"));

        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
