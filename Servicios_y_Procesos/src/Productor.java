public class Productor extends Thread{
    private Buffer buffer;
    private String letras = "abcdefghijklmnopqrstuvwxyz";
    public Productor(Buffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void run(){
        while (true){
            char c = letras.charAt((int) (Math.random()*letras.length())); /*Cogera 1 caracter aleatorio*/
            buffer.producir(c);
            System.out.println("ESTA DEPOSITANDO UNA LETRA XD --> "+c);
            try {
                sleep((long) (Math.random()*4000)); /*Lo que va a tardar en hacerlo*/
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
