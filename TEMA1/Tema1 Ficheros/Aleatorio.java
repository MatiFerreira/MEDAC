package tema1Ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * En este ejemplo vamos leer de un fichero de forma aleatoria
 */

public class Aleatorio {

	public static void main(String[] args) {
		try {
			RandomAccessFile f = new RandomAccessFile("saludo.txt","r");
			f.seek(0); //Posicionamos el puntero en el byte 0 (al principio, puede ser otro valor)
			//f.seek(f.length()); Nos  posiciona al final del fichero
                        long filePointer = f.getFilePointer(); //Posición del puntero
			//Leemos el byte de la posición 0
			int unByte = f.read();
			System.out.println((char)unByte);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
