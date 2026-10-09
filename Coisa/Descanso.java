package LB2.Coisa;


/**
 * Representação do estado de descanso do estudante, todo aluno precisa descansar, no mínimo, 26 horas por semana.
 *
 * @author Alexandre Souza Silva
 * */
public class Descanso {

    /**
     * Quantidade em horas que o aluno descansou.
     */
    int horasDescanso;

    /**
     * Quantidade em semanas que se transcorreram na rotina.
     */
    int numerosSemana;

    /**
     * Representação do estado da rotina do aluno.
     * Caso esteja cansado ou descançado.
     */
    String rotina = "cansado";

    /**
     * Define a quantidade em horas que o aluno empregou para descanso.
     *
     * @param horasDescanso quantidade de horas de descanso.
     * */
    public void defineHorasDescanso(int horasDescanso){
        this.horasDescanso = horasDescanso;
    }

    /**
     * Define a quantidade em semanas que o aluno empregou na sua rotina.
     *
     * @param numerosSemana Número de semanas.
     * */
    public void defineNumeroSemanas(int numerosSemana){
        this.numerosSemana = numerosSemana;
    }

    /**
     * Retorna o status da rotina: caso o aluno tenha descansado almenos 26 horas por semana, então o aluno está descansado
     * caso contrário, o aluno está cansado.
     *
     * @return o estado da rotina do aluno
     */
    public String getStatusGeral(){
        if(this.numerosSemana != 0) {
            if ((this.horasDescanso / this.numerosSemana) < 26) this.rotina = "cansado";
            else this.rotina = "descansado";
        }
        return this.rotina;
    }
}
