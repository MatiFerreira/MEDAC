import java.io.StreamTokenizer;
import java.io.StringReader;

public class ej14 {
    static StreamTokenizer strtomTomk = null;
    static boolean palabras =false;
    static int contwords = 0;
    static boolean numbers = false;
    static int contnumbers =0;
    public static void main(String[] args) {
        try{
        strtomTomk = new StreamTokenizer(new StringReader("Hola me llamo mathias Ferreira Ferreia tengo 21 años y soy estudiante a tiempo completo y estamos a 11 de octubre de 2022"));
        while (strtomTomk.nextToken() != StreamTokenizer.TT_EOF) {
                if (strtomTomk.ttype == StreamTokenizer.TT_WORD){
                    palabras = true;
                    contwords++;
                }

                if (strtomTomk.ttype==StreamTokenizer.TT_NUMBER){
                        numbers = true;
                        contnumbers++;
                }

            }
            System.out.println("El numero de palabras son: "+contwords);
            System.out.println("La cantidad de numeros son : "+contnumbers);
        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
