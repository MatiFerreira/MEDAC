import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ej9 {
    public static String MostraFichero(){
        File fFile = new File("./numeros.dat");
            if (fFile.getName().equals("numeros.dat")){
                return fFile.getName()+" y su ubicacion esta en "+fFile.getAbsolutePath()+fFile;
            }

            return "No se encontro el  archivo";
    }
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        try {
            RandomAccessFile rafFile = new RandomAccessFile("./numeros.dat","rw");
            System.out.print("Dame un numero: ");
            int valor = tc.nextInt();
            rafFile.writeInt(valor);
            //mostrar fichero
            System.out.println(MostraFichero());
            rafFile.close();
        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
