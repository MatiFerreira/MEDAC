import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

public class ej8 {
    public static void main(String[] args) {
        try {
            //Creamos una array de bytes y definimos tamaño 9 para meter 9 numeros

            byte[] bytes = new byte[10];
            for (int i=1;i<bytes.length;i++){
              bytes[i] = (byte) i;
            }
            //Creamos un bytearray y sacamos valor
            ByteArrayInputStream baisByte = new ByteArrayInputStream(bytes);
            //Recorremos con while  siempre , almacenamos el valor en tmp y si es diferente de -1 que siga si no sale
            int tmp = 0;
            while ((tmp = baisByte.read()) != -1){
                System.out.println(tmp);
            }
            baisByte.close();
        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
