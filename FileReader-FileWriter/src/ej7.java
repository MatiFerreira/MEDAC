import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class ej7 {
    public static void main(String[] args) {
        try {
            FileOutputStream fosAccess = new FileOutputStream("./numeros.txt");
            for (int i=1;i<101;i++){
                String test = i+"\n";
                fosAccess.write(test.getBytes());
            }
            fosAccess.close();
        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
