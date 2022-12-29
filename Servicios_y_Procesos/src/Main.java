public class Main {
    public static void main(String[] args) {
        Carrera carreritaChill = new Carrera();
        carreritaChill.Participante("Mathias");
        carreritaChill.Participante("Rodrigo");
        carreritaChill.Participante("Fernando");
        carreritaChill.Participante("Nathalia");
        carreritaChill.Participante("Zara");
        carreritaChill.iniciarCarrera();
        System.out.println(carreritaChill.getFinalizados());
        System.out.println(carreritaChill.getGanador());
        System.out.println(carreritaChill.getFinalizados());

        Buffer b = new Buffer(10);
        Productor productor = new Productor(b);
        Consumidor consumidor = new Consumidor(b);
        productor.start();
        consumidor.start();
    }

}