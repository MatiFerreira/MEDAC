import java.io.*;
import java.util.Scanner;
public class ej9 {
    static RandomAccessFile rafFile = null;

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int num;
        try {
             rafFile = new RandomAccessFile("./numeros.dat","rw");
            // Introduce un numero
            System.out.print("Escribe un numero: ");
            num = tc.nextInt();
            rafFile.seek(rafFile.length());
            rafFile.writeInt(num);
            mostrafich();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (rafFile != null) {
                    rafFile.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void mostrafich (){
        int num;
        try {
            rafFile.seek(0);
          /*  while (true){
                num = rafFile.readInt();
                System.out.println(num);
            }*/
            while ((num=rafFile.readInt()) != -1){
                System.out.println(num);
            }

        } catch (EOFException e) {
            System.out.println("Esto da el error >> "+e.getMessage()+" SORRY");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
