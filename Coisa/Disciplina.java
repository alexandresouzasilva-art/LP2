package LB2.Coisa;

import java.util.Arrays;

/**
 * Representação de um disciplina. Toda a disciplina possui nome e uma quantidade em horas de estudo associados a ela.
 * A classe também possui as notas associadas a um aluno.
 *
 * @author Alexandre Souza Silva
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Horas de estudo na disciplina.
     */
    private int horasEstudo;

    /**
     * Pesos associados as notas
     */
    private double[] pesos;

    /**
     * Notas do aluno na disciplina.
     */
    private double[] notas;

    /**
     * Construtor de uma disciplina. Inicializa o nome da disciplina e a quantidade de notas.
     *
     * @param nomeDisciplina Nome da disciplina.
     */
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
    }

    /**
     * Construtor de uma disciplina. Inicializa o nome da disciplina e a quantidade de notas.
     *
     * @param nomeDisciplina Nome da disciplina.
     * @param numeroDeNotas Numero de notas.
     */
    public Disciplina(String nomeDisciplina, int numeroDeNotas){
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numeroDeNotas];
    }

    /**
     * Construtor de uma disciplina. Inicializa o nome da disciplina, a quantidade de notas e os pesos
     * utilizados para poderar a média.
     *
     * @param nomeDisciplina Nome da disciplina.
     * @param numeroDeNotas Número de notas.
     * @param pesos pesos.
     */
    public Disciplina(String nomeDisciplina, int numeroDeNotas, double[] pesos){
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numeroDeNotas];
        this.pesos = new double[numeroDeNotas];
    }

    /**
     * Adiciona as horas de estudo consumidas em uma disciplina, de modo a somar com as horas já empregadas.
     *
     * @param horasEstudo Horas de estudo
     */
    public void cadastraHoras(int horasEstudo){
        this.horasEstudo = horasEstudo;
    }

    /**
     * Adiciona o valor de uma nota específica.
     *
     * @param nota identificação da nota.
     * @param valorNota Valor da nota.
     */
    public void cadastraNota(int nota, double valorNota){
        if(nota <= this.notas.length && valorNota <= 10) {
            this.notas[nota - 1] = valorNota;

        }
    }

    /**
     * Retorna a média das notas associadas a disciplina. A média pode ser ponderada, caso existam pesos paras as notas.
     *
     * @param notas Notas.
     * @param pesos Pesos das notas
     * @return media das notas.
     */
    private static double getMedia(double notas[], double[] pesos){
        double somapesos = 0;
        double media = 0;

        if(notas != null) {
            if (pesos == null) {
                for (double nota : notas) {
                    media += nota;
                }

                media = media / notas.length;
            } else {
                for (int q = 0; q < notas.length; q++) {
                    media += (notas[q] * pesos[q]);
                    somapesos += pesos[q];
                }
                media = media / somapesos;
            }
        }
        return media;
    }

    /**
     * Retorna o estado de um aluno na disciplina.
     *
     * @return verdadeiro caso a média seja suficiente, senão, retorna falso.
     */
    public boolean aprovado( ){
        return getMedia(this.notas,this.pesos) >= 7;
    }

    /**
     * Representação de uma disciplina contendo nome, horas de estudo, média e notas.
     *
     * @return representação de uma disciplina.
     */
    @Override
    public String toString(){
        return "%s %d %s %s".formatted(this.nomeDisciplina, this.horasEstudo, getMedia(this.notas, this.pesos), Arrays.toString(this.notas));
    }

}
