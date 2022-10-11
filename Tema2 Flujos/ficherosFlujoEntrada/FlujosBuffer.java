package tema2FlujosFicheros.ficherosFlujoEntrada;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * En este ejemplo vamos a utilizar 2 buffers, uno de entrada y otro de  salida.
 * Uno va a leer un fichero (una imagen) y otro va a escribir un fichero haciendo una copia del anteior.
 * Utilizaremos BufferedInputStream y BufferedOutputStream
 */

public class FlujosBuffer {

	public static void main(String[] args) {
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		final int SIZE = 1024*16; //Tamaño del buffer 16K
		
		try {
			//Buffer que lee una imagen que se encuentra en la raiz del proyecto
			bin = new BufferedInputStream(new FileInputStream("sistemas.jpg"));
			bout = new BufferedOutputStream(new FileOutputStream("copia_imagen.jpg"));
			
			int cantidadBytes = 0; //Esta variable va a guardar numero de bytes reales que ocupa el fichero
			byte[] buffer = new byte[SIZE];
			//read(buffer que se va a ir leyendo/rellenando, comienzo, final)
			while ((cantidadBytes = bin.read(buffer,0,SIZE)) != -1) {
				bout.write(buffer,0,cantidadBytes);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();	
		//Cerramos ambos flujos de ficheros
		}finally {
			if (bin != null)
				try {
					bin.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}	
		if (bout != null)
			try {
				bout.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}	 
			

}


