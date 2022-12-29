import java.util.concurrent.Semaphore;

public class Buffer {
    private char[]buffer;
    private int siguiente;
    private boolean isVacio;
    private boolean isLleno;
    public  Buffer(int tamanio){
        this.buffer = new char[tamanio];
        this.siguiente = 0;
        this.isVacio = true;
        this.isLleno = false;
    }
 /*AL ESTAR SINCRONIZADO AMBAS PARTES COSUMIR Y PRODUCIR NO SE VAN A PISAR*/
    public synchronized char consumir(){
        while (this.isVacio){
            try {
                wait(); /*Si esta vacio tendra que esperar que haya algo para consumir*/
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        siguiente--; /*CONSUME 1 VALOR COMO SI ME COMIESE UNA GALLETA*/
        this.isLleno = false;
        if (siguiente ==0){
            this.isVacio = true;
        }
        notifyAll();
        return this.buffer[this.siguiente];
    }

    public synchronized void producir(char v){
        while (this.isLleno){ /*Si al producir detecta que esta lleno va a esperar*/
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        /*Si no entra en por que no esta lleno mete el valor dentro y luego aumenta 1 posicion e indica que no esta vacio*/
        buffer[siguiente] = v;
        siguiente++;
        this.isVacio = false;
        if (siguiente == this.buffer.length){ /*Si lo anterior detecta que el valor de siguiente es igual al tamaño del array es un indicador de que ya esta lleno y lo indicamos*/
            this.isLleno = true;
        }
        notifyAll(); /*Notifica que todos lo que estan esperando puede seguir continuando*/
    }
}
