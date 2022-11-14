public class Barbero extends Thread{
    public boolean ocupado;
    public boolean[] sillas = new boolean[5];

    public Barbero(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public synchronized void ocuparSilla(int pos) {
        System.out.println("Silla ocupada por el cliente numero: " + pos);
    }

    public synchronized void dejarSilla(int pos) {
        while (getOcupado()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("ERROR: " + ex);
            }
        }
        System.out.println("El cliente " + pos + " deja libre una silla");
    }

    public synchronized void inicioCorte(int pos) {
        while (getOcupado()) {
            System.out.println("Barbero ocupado, " + pos + " espera");
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("ERROR: " + ex);
            }
        }
        this.setOcupado(true);
        System.out.println("El barbero empieza a cortar el pelo al cliente " + pos);
    }

    public synchronized void finCorte(int pos) {
        this.setOcupado(false);
        System.out.println("El barbero termina de cortar el pelo al cliente " + pos);
        notify();
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }


}