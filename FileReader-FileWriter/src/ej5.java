import java.io.*;

public class ej5 {
    public static void main(String[] args) {
        try {
            File fFile = new File("./");
            Writer wWriter = new FileWriter("./sumanumeros.txt");
            for (int i=0;i<10;i++){
                int alea = (int)(Math.random()*10);
                //pasamos a Tipo int -> String
                wWriter.write(String.valueOf(alea)+"\n");
            }
            //cerramos
            wWriter.close();
            BufferedReader bfReader = new BufferedReader(new FileReader("./sumanumeros.txt"));
            int sumar =0;
            String tmp;
            while ((tmp = bfReader.readLine()) !=null){
                System.out.println(tmp);
                int valorstr = Integer.parseInt(tmp);
                sumar += valorstr;
            }
            System.out.println(sumar);
            bfReader.close();


        }catch (Exception z){
            System.out.println(z.getMessage());
        }
    }
}
