package tema2FlujosFicheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MiDataStream {

	public static void main(String[] args) {
		//Programa1. DataOutputStream
		FileOutputStream file;
		try {
			file = new FileOutputStream("test.txt");
			DataOutputStream data = new DataOutputStream(file);  
	        data.writeBytes("Esto es un archivo de texto para DataOutputStream");   
	        data.close(); 
	    //Programa2. DataInputStream
	        FileInputStream input = new FileInputStream("test.txt");  
	        DataInputStream inst = new DataInputStream(input);  
	        int count = input.available();  
	        byte[] ary = new byte[count];  
	        inst.read(ary);  
	        for (byte bt : ary) {  
	          char k = (char) bt;  
	          System.out.print(k);  
	        }  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();  
		}finally { 
			System.out.println("\nLectura y escritura correcta"); 
		}
	}

}
