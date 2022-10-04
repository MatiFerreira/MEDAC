import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ej4 {
    public static void main(String[] args) {
        File fFile = new File("./");
        //Comprobamos si es un directorio o no
        if (fFile.isDirectory()) {
            //Creamos una lista de array de aslist que que devuelve valores dentro de fFile
            List<File> listarchivos = Arrays.asList(fFile.listFiles());
            //for each de las listaarchivos
            for (File ffiles : listarchivos) {
                //si es una fichero entrara si no un directorio u otra cosa
            if (ffiles.isFile()) {
                System.out.println("Fichero :" + ffiles.getName());
            } else {
                System.out.println("Directorio: " + ffiles.getName());
                    }
             }
            //Si no es un directorio entonces no hay nada
        }else {
            System.out.println("No hay nada");
        }
    }

}
