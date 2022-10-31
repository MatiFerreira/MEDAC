import org.w3c.dom.css.Counter;

public class main {
    public static void main(String[] args) {
        /*Crear una clase “Counter” con un método que muestre los números del 0 a n y otro igual pero sincronizado.
         La clase “Counter” tendrá un atributo “sincronizado” de tipo boolean para indicar a cuál debe llamar.*/
        boolean sincronizar = false;
        counter count = new counter(sincronizar);
        counter count2 = new counter(sincronizar);
        Hilo hilo = new Hilo(12,count,8);
        Hilo hilo2 = new Hilo(13,count,8);
        hilo.start();
        hilo2.start();
    }
}

class counter {
    private boolean sincronizar;
    //creo un counter boolenao si es true sicronizar sera true
    public counter(boolean sincronizado) {
        this.sincronizar = sincronizado;
    }
    //Para obtener la sincronizacion
    //devuelve sincronizar
    public boolean isSincronizar() {
        return sincronizar;
    }

    //esto es sin sincronizar
    public void counternosincronizado(int id,int n) {
        System.out.println("inicio de hilo "+id);
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Fin del hilo "+id);
    }

//Si lo recorre que recorra hasta el número que le indiquemos y nos de un  identificador.
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

    public Hilo(int id,counter counter,int n){//Clase hilo que tendra como parametro un counter un identificador y la cantidad de numero que recorrer
        this.count = counter;
        this.id = id;
        this.n =n;
    }


//AQUI LO UNICO QUE HAGO que si esta sincronizado devuelvo sincronizar si no devuelvo el que no esta sincronizado
    public void run(){
        if (this.count.isSincronizar()){
            //es true llama para sincronizar
            this.count.sincronizado(id,n);
        }else{
            //Lamamos a no sincronizado ........
            this.count.counternosincronizado(id,n);
        }
    }
}



