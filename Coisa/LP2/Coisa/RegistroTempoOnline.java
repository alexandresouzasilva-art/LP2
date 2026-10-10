package LP2.Coisa;

/**
 * Representação do registro de tempo online de um aluno dedicado a uma disciplina, de forma remota. Por padrão,
 * espera-se que o estudante empregue 120 horas online, ou o dobro de tempo que constitui a disciplina.
 *
 * @author Alexandre Souza Silva
 */
public class RegistroTempoOnline {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Tempo online esperado. Por padrão, igual a 120.
     */
    private int tempoOnlineEsperado = 120;

    /**
     * Tempo online usado.
     */
    private int tempoOnlineUsado = 0;

    /**
     * Construtor da classe. Inicializa o Registro de tempo online com o nome da disciplina.
     *
     * @param nomeDisciplina Nome associado à disciplina.
     */
    public RegistroTempoOnline (String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Construtor da classe. Inicializa o Registro de tempo online com o nome da disciplina e com tempo
     * online esperado.
     *
     * @param nomeDisciplina Nome da disciplina.
     * @param tempoOnlineEsperado Tempo online esperado.
     */
    public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Adiciona o tempo em que o aluno passou online dedicando-se à disciplina
     *
     * @param tempoOnlineUsado tempo online usado.
     */
    public void adicionaTempoOnline(int tempoOnlineUsado){
        this.tempoOnlineUsado += tempoOnlineUsado;
    }

    /**
     * Verifica se o aluno conseguiu atingir a meta de tempo online para a disciplina
     *
     * @return verdadeiro caso tenha atingido a meta e falso, caso não
     */
    public boolean atingiuMetaTempoOnline(){
        return this.tempoOnlineUsado >= this.tempoOnlineEsperado;
    }

    /**
     * Retorna uma representação do registro de tempo online contendo o nome da disciplina, o tempo online alcançado e
     * o tempo online esperado
     *
     * @return representação do registro de tempo online
     */
    @Override
    public String toString(){
        return this.nomeDisciplina + " " + this.tempoOnlineUsado + "/" + this.tempoOnlineEsperado;
    }
}
