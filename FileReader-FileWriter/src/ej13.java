import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ej13 {
    static Scanner tc = new Scanner(System.in);
    static  String frase;
    static int contador = 0;
    static boolean tusverdades = false;
    public static void main(String[] args) {
        try {
            System.out.print("Dame una frase porfavor y gracias : ");
            frase = tc.nextLine();
            StreamTokenizer strtomTomk = new StreamTokenizer(new StringReader(frase));
            System.out.print("Ahora dime una palabra de la que escribiste anteriormente para buscarlo :) ");
            frase = tc.nextLine();
            //LE digo que salga cuando llegue al final :)
            while (strtomTomk.nextToken() != StreamTokenizer.TT_EOF){
                //nos da el token de palabra -sval contiene el cuerpo de palabra
                if (strtomTomk.sval.equals(frase)) {
                    contador++;
                    tusverdades = true;
                }
            }

            if (tusverdades){
                System.out.println("se repite "+contador);
                System.out.println("Has encontrado la palabra");
            }else{
                System.out.println("No se ha encontrado la palabra :(");
            }
        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
