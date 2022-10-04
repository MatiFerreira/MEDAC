import java.io.*;

public class ej5 {
    public static void main(String[] args) {
        try {
            File fFile = new File("./");
            Writer wWriter = new FileWriter("./sumanumeros.txt");
            for (int i=0;i<10;i++){
                int alea = (int)(Math.random()*10);
                wWriter.write(String.valueOf(alea)+"\n");
            }
            wWriter.close();
            Reader rReader = new FileReader("./sumanumeros.txt");
            int contador =0;
            int suma =0;

            while ((contador =rReader.read()) !=-1){
                System.out.print((char) contador);
                suma += contador;
            }
            System.out.println("La suma de todo el archivo es "+ suma);
            rReader.close();


        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
