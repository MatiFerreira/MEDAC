import java.util.ArrayList;

public class Carrera {
    private final ArrayList<Coche> participantes;
    private final ArrayList<Coche> Finalizados;
    private Coche ganador;

    public Carrera() {
        this.participantes = new ArrayList<>();
        this.Finalizados = new ArrayList<>();
    }

    public void Participante(String Participante){
        participantes.add(new Coche(Participante,this));
    }
    public void iniciarCarrera(){
        for(Coche coche : participantes){
            coche.start();
        }
    }
    public synchronized void setGanador(Coche coche){
          //  System.out.println("Ha finalizado: " + coche);
            if (this.ganador == null) {
                this.ganador = coche;
            }
            Finalizados.add(coche);
        }


    public Coche getGanador() {
        for (Coche coche: participantes){
            try {
                coche.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return ganador;
    }

    public ArrayList<Coche> getFinalizados() {
        for (Coche coche: participantes){
            try {
                   coche.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return Finalizados;
    }
}
