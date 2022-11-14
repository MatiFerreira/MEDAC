public class Problema_barbero {


    public static void main(String[] args) {
        Barbero barbero = new Barbero(false);
        for (int i = 0; i < 4; i++) {
            Cliente clientes = new Cliente(i + 1, barbero);
            clientes.start();
        }
    }
}

