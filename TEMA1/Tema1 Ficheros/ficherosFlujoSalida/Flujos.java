package tema1Ficheros.ficherosFlujoSalida;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * Flujo. Abstracción de la información independientemente del fichero. Hay que verlo
 * como una secuencia de 1 y 0
 * Los flujos que existen en Java son bytes (Entrada y Salida) caracteres (Entrada y Salida)
 * Flujos de entrada. Sirven para leer de un archivo
 * Flujos de salida. Sirven para escribir en un archivo.
 * Flujos de salida:
 * 1. Abrir el flujo
 * 2. Mientras hay datos. Escribimos
 * 3. Cerrar flujo
 * Utilizaremos la clase OutputStream:
 * OutputStream. Clase abstracta padre del resto.
 * FileOutputStream. Fichero byte a byte
 * BufferedOutputStream. Escribe grupo de bytes (buffer)
 * ByteArrayOutputStream. Permite escribir en memoria y posteriormente obtener información en array
 * Ejemplo: BufferedOutputStream sobre FileOutputStream. Se escribirán una secuencia de bytes sobre un fichero
 * 
 */

public class Flujos {
	/* Flujos de salidas de bytes. Vamos a escribir información en un fichero binario.
	 * Ejemplo de FileOutputStream
	 * Esta estructura es la básica para trabajar con flujos 
	 */
	
	public static void main(String[] args) {
		/* Definimos una variable OutputStream e inicializamos a null */
		OutputStream fout = null;
		//En este caso vamos a escribir un byte sobre un fichero binario (no texto)
		try {
			//Ruta. Lo almacena en la raiz del proyecto. Si no está en raiz se usa \\
			fout = new FileOutputStream("fichero.dat"); 
			for(int i=0; i<10; i++) {
				fout.write(i);
			}
		//Excepciones de la más específica a la genérica
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();	
		}finally {
			if (fout != null)
				try {
					fout.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}	 

	}
	
}
