package tema1Ficheros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CrearFichero {

	public static void main(String[] args) {
		try {
			//Creamos un fichero y creamos un directorio en la carpeta de proyecto de netbeans
                        File f = new File("./","nuevofichero.txt"); //Directorio,nombre_fichero
			f.createNewFile();
			
			//Ficheros temporales. Se crean en la carpeta ..Local\Temp
			File temporal = File.createTempFile("temporal", ".txt");
			System.out.println(temporal.getAbsolutePath());
			
                        //----------- DIRECTORIOS ---------//
                        
                        //Creamos un directorio en la carpeta de proyecto de netbeans
                        //mkdir crea un directorio (si su padre existe)
                        //mkdirs crea tvarios directorios 
			File d = new File("./midirectorio");
			d.mkdir();
                        System.out.println(d.getAbsolutePath());
			
                        //-------Librería java.nio------------------
                        //Utilizamos createDirectory y createDirectories
                        Path filePath = Paths.get("C:\\Files\\");
                        String fileName = "Java Tutorial.doc";
                        if (!Files.exists(filePath)) {
                          System.out.println("El directorio no existe");
	                  //System.out.println("Creamos nuevo directorio  : " + Files.createDirectory(filePath));
                          File file = new File(filePath + "/" + fileName);
                        }
                        
                        //Comprobamos si es un  fichero
			if (f.isFile()) {
				System.out.println("Es un fichero");
			}else {
				System.out.println("No es un fichero");
			}
			
			if (d.isDirectory()) {
				
                            System.out.println("Es un directorio");
			}
		}catch(IOException e) {
			System.out.println(e);
		}

	}

}
