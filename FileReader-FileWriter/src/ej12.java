import java.io.*;

public class ej12 {
    static BufferedInputStream bfistrImput = null;
    static BufferedOutputStream bfoutstrOUT = null;
    static final int SIZE = 1024*16;
    static int bytesRecorrido = 0;

    public static void main(String[] args) {
        try {
            bfistrImput = new BufferedInputStream(new FileInputStream("./meme.jpg"));
            bfoutstrOUT = new BufferedOutputStream(new FileOutputStream("./meme2.jpg"));
            byte[] buffer = new byte[SIZE];

            while ((bytesRecorrido = bfistrImput.read(buffer,0,SIZE)) !=-1){
                bfoutstrOUT.write(buffer,0,bytesRecorrido);
            }
            bfistrImput.close();
            bfoutstrOUT.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
