package tema2FlujosFicheros.ficherosFlujoEntrada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Programa que lee un archivo utilizando las clases BufferedReader y FileReader
 */

public class FlujosCaracteresBuffer {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("saludo.txt");
			BufferedReader br = new BufferedReader(fr);
			//Leemos por lineas 
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			fr.close();
			br.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
