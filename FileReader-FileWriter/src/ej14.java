import java.io.StreamTokenizer;
import java.io.StringReader;

public class ej14 {
    static StreamTokenizer strtomTomk = null;

    public static void main(String[] args) {
        try{
        strtomTomk = new StreamTokenizer(new StringReader("Hola me llamo mathias Ferreira Ferreia tengo 21 años y soy estudiante a tiempo completo"));
        while (strtomTomk.nextToken() != StreamTokenizer.TT_EOF) {
                if (strtomTomk.ttype == StreamTokenizer.TT_WORD){
                }
                if (strtomTomk.ttype==StreamTokenizer.TT_NUMBER){

                }
            }
        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
