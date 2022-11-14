
public class Cliente extends Thread{
    private Barbero barbero;
    private int pos;

    public Cliente(int pos, Barbero barbero) {
        this.pos = pos;
        this.barbero = barbero;
    }

    @Override
    public void run() {
        try {
            barbero.inicioCorte(pos);
            sleep(800);
            barbero.finCorte(pos);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}