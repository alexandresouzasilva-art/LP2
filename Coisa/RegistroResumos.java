package LB2.Coisa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Registro de resumos dos estudos realizados ao longo do período por um aluno.
 * Existe um limite máximo de resumos que podem ser armazenados.
 * Não podem ser registrados resumos que já possuem tema associado a outro resumo
 *
 * @author Alexandre Souza Silva
 */
public class RegistroResumos {

    /**
     * Quantidade máxima de resumos que podem ser registrados
     */
    private int numeroDeResumos;

    /**
     * Lista contendo todos os resumos registrados
     */
    private ArrayList<Resumo> resumos = new ArrayList<>();

    /**
     * Construtor de um registro de resumos. Permite inicializar a quantidade máxima de resumos que podem ser registrados
     *
     * @param numeroDeResumos  quantidade máxima de resumos
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
    }

    /**
     * Retorna quantos resumos foram armazenados até o uso do método.
     *
     * @return quantidade de resumos armazenados
     */
    public int conta() {
        return this.resumos.size();
    }

    /**
     * Método paralelo à função principal da classe, que permite verificar se um tema já está associado a um resumo
     *
     * @param resumos lista de resumos.
     * @param tema tema a ser verificado.
     *
     * @return verdadeiro se o tema já está em algum resumo, e falso caso não.
     */
    private static boolean verificaTemas(ArrayList<Resumo> resumos, String tema) {
        for (int q = 0; q < resumos.size(); q++) {
            if (resumos.get(q).getTema().equals(tema)) return true;
        }

        return false;
    }

    /**
     * Adiciona um novo resumo ao registro.
     *
     * @param tema tema.
     * @param conteudo conteúdo.
     */
    public void adiciona(String tema, String conteudo) {
        if(!verificaTemas(this.resumos,tema) && this.resumos.size() < numeroDeResumos) {
            Resumo resumo = new Resumo(tema, conteudo);
            this.resumos.add(resumo);
        }
    }

    /**
     * Retorna um array contento representações de resumos registrados.
     *
     * @return array com representações de resumos.
     */
    public String[] pegaResumos(){
        String[] resultado = new String[this.resumos.size()];

        for (int q = 0; q < this.resumos.size(); q++) {
            resultado[q] = this.resumos.get(q).toString();
        }

        return resultado;
    }

    /**
     * Retorna uma representação da quantidade de resumos registrados, assim como de seus temas
     *
     * @return representação da quantidade de resumos e dos temas.
     */
    public String imprimeResumos(){
      String resultado = "- " + this.resumos.size() + " resumo(s) cadastrado(s)" +
              "\n" + "- ";

        for (int q = 0; q < this.resumos.size(); q++) {
            if(q != this.resumos.size() - 1) resultado += this.resumos.get(q).getTema() + " | ";
            else resultado += this.resumos.get(q).getTema();
        }

        return resultado;
    }

    /**
     * Verifica a existência de um resumo com tema específico
     *
     * @param tema tema a ser buscado
     * @return verdadeiro para caso o tema esteja registrado e falso caso não
     */
    public boolean temResumo(String tema){
        return verificaTemas(this.resumos,tema);
    }

    /**
     * Método pertencente a classe que modulariza o método de busca. Compara a chave de busca com o conteúdo
     * de um resumo
     *
     * @param conteudo conteúdo.
     * @param chaveDebusca chade de busca.
     * @return vardadeiro, caso a chave de busca esteja no conteúdo, senão falso
     */
    private static boolean buscaChaveConteudo(String conteudo, String chaveDebusca){
        conteudo = conteudo.toLowerCase();
        chaveDebusca = chaveDebusca.toLowerCase();
        String[] conteudoSplit = conteudo.split(" ");

        for(String palavra : conteudoSplit){
            if(chaveDebusca.equals(palavra)) return true;
        }

        return false;
    }

    /**
     * Busca uma parte de um conteúdo que não se sabe o tema. Retorna todos os temas que possuem aquela chave de busca
     * em seu conteúdo
     *
     * @param chaveDebusca palavra a ser buscada
     * @return Array de temas que contenham a chave de busca
     */
    public String[] busca(String chaveDebusca){
        int cont = 0;
        String[] resultados = new String[this.resumos.size()];

        for(Resumo resumo : this.resumos){
            if(buscaChaveConteudo(resumo.getConteudo(),chaveDebusca)){
                resultados[cont] = resumo.getTema();
                cont ++;
            }
        }
        Arrays.stream(resultados).sorted();
        return resultados;
    }
}
