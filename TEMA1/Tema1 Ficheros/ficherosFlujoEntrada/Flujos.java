package tema1Ficheros.ficherosFlujoEntrada;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * Es similar a flujos de salida pero cambiando la palabra output por input
 * Flujos de entrada de bytes
	Algunas de las clases que podemos usar son:

	InputStream: clase abstracta, padre de la mayoría de los flujos de bytes.
	FileInputStream: flujo que permite leer de un fichero, byte a byte.
	BufferedInputStream: flujo que permite leer grupos (buffers) de bytes.
	ByteArrayInputStream: flujo que permite leer de memoria (de un array de bytes).
	
   Flujos de entrada de caracteres
	Algunas de las clases que podemos usar son:

	Reader: clase abstracta, padre de la mayoría de los flujos de caracteres.
	FileReader: flujo que permite leer de un fichero, caracter a caracter.
	BufferedReader: flujo que permite leer líneas de texto.
	StringReader: flujo que permite leer desde la memoria.
	InputStreamReader: flujo que permite transformar un InputStream en un Reader.
 */

public class Flujos {

	public static void main(String[] args) {
		
		//Ejemplo FileOutputStream
		/* Definimos una variable FileInputStream e inicializamos a null */
		FileInputStream fin = null;
		//En este caso vamos a leer del fichero binario donde guardamos los 10 numeros (no texto)
		try {
			fin = new FileInputStream("fichero.dat"); //Ruta. Lo almacena en la raiz del proyecto.
			//Ejemplo ruta completa "C:\\Users\\Usuario\\Documents\\saludo.txt"
			int valor;
			//Si f.read() retorna -1 termina
                        while ((valor = fin.read()) != -1) {
				System.out.println(valor);
			}
		//Excepciones de la más específica a la genérica
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();	
		}finally {
			if (fin != null)
				try {
					fin.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}	 
		

	}

}
