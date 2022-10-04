package tema1Ficheros.ficherosFlujoSalida;

import java.io.*;
/*
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
*/
/*
 * En este ejemplo vamos a ver como escribir carácter a carácter una linea en un fichero
 * mediante la clase FileWriter
 * 
 * Writer: clase abstracta, padre de la mayoría de los flujos de caracteres.
   FileWriter: flujo que permite escribir en un fichero, caracter a caracter.
   BufferedWriter: flujo que permite escribir líneas de texto.
   StringWriter: flujo que permite escribir en memoria, obteniendo lo escrito en un String
   OutputStreamWriter: flujo que permite transformar un OutputStream en un Writer.
   PrintWriter: flujo que permite escribir tipos básicos Java.
 */

public class FlujosCaracteres {

	public static void main(String[] args) {
		/* Definimos una variable del flujo FileWriter e inicializamos a null */
		FileWriter filew = null;
		String cadena = "Esto es un ejemplo de flujos con FileWriter";
		try {
			filew = new FileWriter("saludo.txt"); //Ruta. Lo almacena en la raiz del proyecto.
			for(char c : cadena.toCharArray()) {
				filew.write(c);
			}
		//Excepciones de la más específica a la genérica
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println(e);	
		}finally {
			if (filew != null)
				try {
					filew.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}	 

	}

}
