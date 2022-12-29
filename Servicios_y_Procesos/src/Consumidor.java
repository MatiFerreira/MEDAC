public class Consumidor extends  Thread {
    Buffer buffer;
    public Consumidor(Buffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void run(){
        while (true){
            char valor = this.buffer.consumir();
            System.out.println("ACABA DE CONSUMIR UN CARACTER --> "+valor); /*MOSTRARA EL VALOR QUE HA CONSUMIDO*/
            try {
                sleep((long) (Math.random()*5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
