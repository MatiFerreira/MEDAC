import java.io.*;

public class ej15 {
    static LineNumberReader lnrReader = null;
    static LineNumberReader lnrReader2 = null;
    static BufferedWriter bwWrite = null;
    static BufferedWriter bwWrite2 = null;
    static String valorcopia;
    public static void main(String[] args) {
        try {
            File fFile2 = new File("./copia.txt");
            File fFile = new File("./ejr15.txt");
            bwWrite = new BufferedWriter(new FileWriter(fFile));
            bwWrite.write("Y en este titubeo de aliento y agonía, cargo lleno de penas lo que apenas soporto. ¿No oyes caer las gotas de mi melancolía?" +
                    ""+"\n"+"MATHIAS FERREIRA FERRREIA");
            bwWrite.close();
            lnrReader = new LineNumberReader(new FileReader(fFile));
            //copia
            bwWrite2 = new BufferedWriter(new FileWriter(fFile2));
            lnrReader2 = new LineNumberReader(new FileReader(fFile2));
            String datos;
            //esto siver para ver lo escrito y ver las lineas y ademas copiar
            while ((datos = lnrReader.readLine()) !=null){
                bwWrite2.write(datos+"\n");
                System.out.println(datos);

            }
            bwWrite2.close();
            //mensaje de las lineas
            System.out.println("El numero de lineas son "+lnrReader.getLineNumber());
            System.out.println("=====================================================");
            // MOSTRAR COPIA
            System.out.println("El texto copia contiene :");
            String datoscopia;

            while ((datoscopia = lnrReader2.readLine()) != null){
                System.out.println(datoscopia);
            }

            lnrReader.close();
            lnrReader2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
