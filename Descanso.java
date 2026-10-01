package LB2;

public class Descanso {
    int horasDescanso;
    int numerosSemana;
    String rotina = "cansado";

    public Descanso(){
    }

    public void defineHorasDescanso(int horasDescanso){
        this.horasDescanso = horasDescanso;
    }

    public void defineNumeroSemanas(int numerosSemana){
        this.numerosSemana = numerosSemana;
    }

    public String getStatusGeral(){
        if(this.numerosSemana != 0) {
            if ((this.horasDescanso / this.numerosSemana) < 26) this.rotina = "cansado";
            else this.rotina = "descansado";
        }
        return this.rotina;
    }
}