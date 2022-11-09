package tema1Ficheros.ficherosFlujoEntrada;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*
 * En este ejemplo vamos a leer un archivo de texto (saludo.txt) 
 * y vamos a mostrar por pantalla su contenido
 */

public class FlujosCaracteres {

	public static void main(String[] args) {
		
		FileReader filer = null;
		
		try {
			filer = new FileReader("saludo.txt"); //Ruta. Lo almacena en la raiz del proyecto.
			int i;
			while((i = filer.read())!=-1) {
				System.out.print((char)i);
			}
		//Excepciones de la más específica a la genérica
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();	
		}finally {
			if (filer != null)
				try {
					filer.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}	 


	}

}
