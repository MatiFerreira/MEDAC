import java.io.*;
import java.util.Scanner;

public class ej6 {
    //lo saco fuera por si tengo que poner un finally usando alguna libreria de aqui que haga algo :/
    static Writer wWriter = null;
    static  BufferedReader bfReader = null;
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        try {
            String seleccion;
             wWriter = new FileWriter("./datos-personal.txt");
             bfReader = new BufferedReader(new FileReader("./datos-personal.txt"));
            // Do-while que se cierre hasta nuevo aviso :)
            do {
                System.out.println("============================================================");
                System.out.println("QUE QUIERES HACER: ");
                System.out.println("A -> Crear Fichero ");
                System.out.println("B -> Mostrar fichero");
                System.out.println("SALIR -> si / no");
                System.out.print("Escriba aqui su opcion > ");
                 seleccion = tc.nextLine().toLowerCase();
                // si elijo a obviamente  hare eso facil de enteder :)
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
                     wWriter.flush();// Es como el close pero limpia el flujo de salida para que se pueda meter datos y lo guarda
                 }
/*Este if lo que hace es leer el archivo y una vez leido todo vuelve a abrir el reader por si es necesario leer de nuevo */
                 if (seleccion.equals("b")){
                     String texto;
                     System.out.println(bfReader.readLine());
                     while ((texto = bfReader.readLine()) != null) {
                         System.out.println(texto);
                     }
                     bfReader = new BufferedReader(new FileReader("./datos-personal.txt"));
                 }

            }while (seleccion.equalsIgnoreCase("no")||seleccion.equals("a")||seleccion.equals("b"));

        }catch (Exception z){
            System.out.println(z.getMessage());
            // al finaliza que lo cierre y se guarda los datos y no ocupa memoria  con finally
        }finally {

            try {
                bfReader.close();
                wWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage()+ "Otro error mas en la oficina");
            }
        }
    }
}
