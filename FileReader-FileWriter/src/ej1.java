import java.io.FileWriter;
import java.io.Writer;

public class ej1 {
    public static void main(String[] args) {
        //capturamos datos
        try {
            Writer wWriter = new FileWriter("./pares.txt");

            for (int i =1;i<201;i++){
                String dato = String.valueOf(i);
                if (i%2==0){
                    wWriter.write(dato +"\n");
                }
        }
            System.out.println("Ha terminado correctamente");
            wWriter.close();
        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}