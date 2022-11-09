package tema2FlujosFicheros.ficherosFlujoSalida;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FlujosCaracteresBuffer {

	public static void main(String[] args) {
		
		/* Definimos una variable del flujo FileWriter e inicializamos a null */
		BufferedWriter bw = null;
		List<String> cadenas =  Arrays.asList(new String[] {"Esto es un ejemplo"," de flujos con BufferedWriter"});
		try {
			File f = new File("otrosaludo.txt");
			FileWriter fr = new FileWriter(f);
			bw = new BufferedWriter(fr); 
			for(String s : cadenas) {
				bw.write(s);
			}
		//Excepciones de la más específica a la genérica
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();	
		}finally {
			if (bw != null)
				try {
					bw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}	 

	}

}
