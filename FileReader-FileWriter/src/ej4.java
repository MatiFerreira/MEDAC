import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        File fFile = new File("./");
        String teclado;
        do {
            System.out.print("Fichero escriba f|Directorio escriba d |Salir escriba exit -->  ");
            teclado = tc.nextLine().toLowerCase();
            //Comprobamos si es un directorio o no
            if (fFile.isDirectory()) {
                //Creamos una lista de array de aslist que que devuelve valores dentro de fFile
                List<File> listarchivos = Arrays.asList(fFile.listFiles());
                //for each de las listaarchivos
                for (File ffiles : listarchivos) {
                    //si es una fichero entrara si no un directorio u otra cosa
                    if (teclado.equals("f")) {
                        if (ffiles.isFile()) {
                            System.out.println("Fichero :" + ffiles.getName());
                        }
                    }
                    //Si toca la d y no es un file es un directorio
                    if (teclado.equals("d")) {
                        if (!ffiles.isFile()) {
                            System.out.println("directorio :" + ffiles.getName());
                        }
                    }
                }
                //Si no es un directorio entonces no hay nada
            } else {
                System.out.println("No hay nada");
            }
        }while (!teclado.equals("exit"));
    }
}
