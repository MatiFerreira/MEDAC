import java.io.*;
import java.util.Scanner;

public class ej6 {
    static Writer wWriter = null;
    static  BufferedReader bfReader = null;
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        try {
            String seleccion ="";
             wWriter = new FileWriter("./datos-personal.txt");
             bfReader = new BufferedReader(new FileReader("./datos-personal.txt"));
            do {
                System.out.println("QUE QUIERES HACER: ");
                System.out.println("A -> Crear Fichero ");
                System.out.println("B -> Mostrar fichero");
                System.out.println("SALIR -> si / no");
                System.out.print("Escriba aqui su opcion > ");
                 seleccion = tc.nextLine().toLowerCase();

                 if (seleccion.equals("a")){
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
                 }

                 if (seleccion.equals("b")){
                     String texto;
                     System.out.println(bfReader.readLine());
                     while ((texto = bfReader.readLine()) != null) {
                         System.out.println(texto);
                     }
                 }

            }while (seleccion.equalsIgnoreCase("no")||seleccion.equals("a")||seleccion.equals("b"));

        }catch (Exception z){
            System.out.println(z.getMessage());
        }finally {
            if (bfReader != null){
                try {
                    bfReader.close();
                } catch (IOException e) {
                    System.out.println(" Bye");
                }
            }
            if (wWriter !=null){
                try {
                    wWriter.close();
                } catch (IOException e) {
                    System.out.println(" Bye");
                }
            }
        }
    }
}
