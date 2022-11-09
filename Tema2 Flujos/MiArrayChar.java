package tema2FlujosFicheros;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * En este programa vamos a estudiar las clases CharArrayWriter y CharArrayReader
 * Programa1. Escribimos un array de caracteres (String) en 2 ficheros
 */

public class MiArrayChar {

	public static void main(String[] args) {
		 //Programa1. CharArrayWriter
		 CharArrayWriter fout=new CharArrayWriter();    
         try {
			fout.write("Programa de uso de CharArrayWriter");
			
			FileWriter f1=new FileWriter("fich1.txt");    
	        FileWriter f2=new FileWriter("fich2.txt");    
	            
	        fout.writeTo(f1);    
	        fout.writeTo(f2); 
	        
	        f1.close();    
			f2.close();
			
			//Programa2. CharArrayReader. Leemos un array de caracteres como stream 
			//y lo mostramos por pantalla
			char[] ary = { 'a', 'c', 'c', 'e', 's', 'o', 'd', 'a', 't', 'o','s' };  
		    CharArrayReader reader = new CharArrayReader(ary);  
		    int n = 0;  
		    // Lee hasta el final del fichero
		    while ((n = reader.read()) != -1) {  
		      System.out.print((char) n);  
		    }  
	          
		} catch (IOException e) {
			e.printStackTrace();
		}finally {    
			System.out.println("\nLectura y escritura de arrays de caractres correcta");  
		}
         
            

	}

}
