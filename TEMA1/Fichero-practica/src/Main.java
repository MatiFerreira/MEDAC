import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Al intentar crear el archivo se lanza excepcion por si no es posible crearlo.
        try {
            // indicamos el paramatro zona mas el tipo de datos que queremos tipo txt ejemplo
            File fFichero = new File("./texto.txt");
            // Esto crea el archivo
            fFichero.createNewFile();
            // podemos ver la ruta de abosoluta del fichero
            System.out.println(fFichero.getAbsolutePath()+" ruta absoluta :)");
            //Aqui lo que hago es comprobar si existe el fichero
            if (fFichero.exists()){
                //Eliminamos el fichero por que existe :(
                fFichero.delete();
                //Volvemos a crear el fichero con otro nuevo nombre :)
                fFichero = new File("./nuevo.txt");
                fFichero.createNewFile();
            }
        }catch (Exception z){
            System.out.println("Se ha producido la excepcion : "+z);
        }
    }
}