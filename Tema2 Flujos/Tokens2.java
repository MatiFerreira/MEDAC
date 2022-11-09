package tema2FlujosFicheros;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Tokens2 {

	public static void main(String[] args) {
		StreamTokenizer st = new StreamTokenizer(new StringReader("Modulo Acceso a Datos 2"));
		//Mientras el token que leemos no sea final de fichero TT_EOF
		try {
			while(st.nextToken() != StreamTokenizer.TT_EOF) {
				//Si es una palabra (caracteres)
				if (st.ttype == StreamTokenizer.TT_WORD) {
					System.out.println(st.sval);
				//Si son números
				}else if (st.ttype == StreamTokenizer.TT_NUMBER) {
					System.out.println(st.nval);
				//Si finaliza el fichero
				}else if (st.ttype == StreamTokenizer.TT_EOL) {
					System.out.println();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
