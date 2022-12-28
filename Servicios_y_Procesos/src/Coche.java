import java.util.Random;

public class Coche extends Thread{
    private Random random = new Random(); /*--> clase random donde nos dara valores aleatorios*/
    String name;
    private final Carrera carrera;
    public Coche(String  nombre,Carrera carrera) {
        this.name = nombre;
        this.carrera = carrera;
    }


    @Override
    public void run(){

        for (int i =0 ;i<7; i++){
            try {
                sleep(random.nextInt(3)*1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        carrera.setGanador(this);
    }

    @Override
    public String toString() {
        return "name='" + name ;
    }
}
