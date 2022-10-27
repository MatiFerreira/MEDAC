import org.w3c.dom.css.Counter;

public class main {
    public static void main(String[] args) {
        /*Crear una clase “Counter” con un método que muestre los números del 0 a n y otro igual pero sincronizado.
         La clase “Counter” tendrá un atributo “sincronizado” de tipo boolean para indicar a cuál debe llamar.*/
        boolean sincronizar = true;
        counter count = new counter(sincronizar);
        counter count2 = new counter(sincronizar);
        Hilo hilo = new Hilo(12,count,8);
        Hilo hilo2 = new Hilo(12,count,8);
        hilo.start();
        hilo2.start();
    }
}

class counter {
    private boolean sincronizar;
    public counter(boolean sincronizado) {
        this.sincronizar = sincronizado;
    }
    //Para obtener la sincronizacion
    public boolean isSincronizar() {
        return sincronizar;
    }

    public void counternosincronizado(int id,int n) {
        System.out.println("inicio de hilo "+id);
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Fin del hilo "+id);
    }

    public synchronized void sincronizado(int id,int n) {
        System.out.println("inicio de hilo "+id);
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Fin del hilo "+id);
    }
}

class Hilo extends Thread{
    private int id;
    private counter count;
    private int n;

    public Hilo(int id,counter counter,int n){
        this.count = counter;
        this.id = id;
        this.n =n;
    }

    public void run(){
        if (this.count.isSincronizar()){
            this.count.sincronizado(id,n);
        }else{
            this.count.counternosincronizado(id,n);
        }
    }
}



