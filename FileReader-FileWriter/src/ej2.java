import java.io.*;

public class ej2 {
    public static void main(String[] args) {
        try {
            Writer wWriter = new FileWriter("./frase.txt");
                        wWriter.write("Tres tristes tigres comen trigo en un trigal :("+"\n");
                        wWriter.write("La rosas son rojas y tus labios son mi coca <3"+"\n");
                        wWriter.close();
            /*Ahora nos pondremos a leer los archivos que nos pide :)*/
        /*  BufferedReader lector = new BufferedReader(new FileReader("./frase.txt"));
                            String tmp;
                            while ((tmp = lector.readLine()) !=null){
                                System.out.println(tmp);
                            }
                            lector.close();*/

            //2 forma de hacer los deberes :)
            Reader rReader = new FileReader("./frase.txt");
            int contador =0;
            while ((contador =rReader.read()) !=-1){
                System.out.print((char)contador);
            }

        }catch (Exception z){

        }
    }
}
