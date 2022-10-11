package tema2FlujosFicheros;


/*
 * Programa que lee un array de bytes de números como un input stream y muestra por pantalla
 * Posteriormente este array de bytes se escribe en un fichero mifichero.dat
 * 
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Miarraybytes {

	public static void main(String[] args) {
		//Programa 1. ByteArrayInputStream
		//Creamos el array de bytes
		byte[] buf = { 35, 36, 37, 38 };  
	    try {
			// Creamos el input stream para array de bytes buf
		    ByteArrayInputStream byt = new ByteArrayInputStream(buf);  
		    int k = 0;  
		    //Leemos desde el input stream
		    while ((k = byt.read()) != -1) {  
		      System.out.println("El valor leido del input stream es " + k );  
		    } 
		  
		  //Programa 2. ByteArrayOutputStream
		  //array de bytes se escribe en un fichero mifichero.dat
		  
		  FileOutputStream fout = new FileOutputStream("mifichero.dat");    
        
	      ByteArrayOutputStream bout = new ByteArrayOutputStream();    
	      //Escribimos al buffer
	      bout.write(buf);    
	      //Escribimos al fichero (puede ser a más de uno)
	      bout.writeTo(fout);      
	      bout.close();   
	      System.out.println("ByteArray escrito en fichero");    
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			System.out.println("Array de bytes leido/escrito correctamente");
		}
	}
}
