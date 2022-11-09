package tema2FlujosFicheros.ficherosFlujoSalida;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * En este ejemplo vamos a escribir un buffer de bytes (32K de información) 
 * sobre un fichero mibuffer.dat. Para ver la información necesitamos un visor hexadecimal
 * Un buffer nos permite leer un archivo grande poco a poco. Ejemplo: buffer 32K y archivo 512K
 */
public class FlujosBuffer {

	public static void main(String[] args) {
		//Creamos un array de bytes de 32K
		byte[] buffer = new byte[1024*32];
		//Rellenamos el array buffer con el valor 1
		Arrays.fill(buffer, Byte.parseByte("1"));
		//Inicializamos el Buffer Output Stream
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream("mibuffer.dat")); //Ruta. Lo almacena en la raiz del proyecto.
			bos.write(buffer);
		//Excepciones de la más específica a la genérica
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();	
		}finally {
			if (bos != null)
				try {
					bos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}	 

	}

}
