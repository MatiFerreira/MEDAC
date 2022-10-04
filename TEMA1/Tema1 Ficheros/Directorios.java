package tema1Ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/*
    
*/
public class Directorios {

	public static void main(String[] args) {
            //Directorio raiz del proyecto de netbeans
            File d = new File("./");
            //Lista de ficheros y directorios.
      
            if (d.isDirectory()){
                List<File> listaFicheros = Arrays.asList(d.listFiles());
                for (File l : listaFicheros) {
                    if (l.isFile())
                        System.out.println("fich: "+l.getName());
                    else
                        System.out.println("dir: "+l.getName());
                }
            }else {
                System.out.println("No es un directorio ni un fichero");
            }
           
            
    }
        
}


