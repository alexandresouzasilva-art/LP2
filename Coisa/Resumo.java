package LP2.Coisa;

/**
 * Configuração de um resumo. Todos os resumos possuem um tema e um conteúdo.
 *
 * @author Alexandre Souza Silva
 */
public class Resumo {
    /**
     * Tema do resumo.
     */
    private final String tema;

    /**
     * Conteúdo do resumo.
     */
    private String conteudo;

    /**
     * Construtor de um resumo. Cria um objeto da classe resumo com tema e conteúdo.
     *
     * @param tema tema.
     * @param conteudo conteúdo.
     */
    public Resumo(String tema, String conteudo){
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Construtor de um resumo. Cria um objeto do tipo resumo apenas com tema.
     *
     * @param tema tema.
     */
    public Resumo(String tema){
        this.tema = tema;
    }

    /**
     * Retorna o tema de um resumo.
     *
     * @return tema do resumo.
     */
    public String getTema(){
        return this.tema;
    }

    /**
     * Retorna o conteúdo de um resumo.
     *
     * @return conteúdo do resumo.
     */
    public String getConteudo(){
        return this.conteudo;
    }

    /**
     * Representação de um objeto do tipo resumo contendo tema e conteúdo.
     *
     * @return representação de um resumo.
     */
    @Override
    public String toString(){
        return this.tema + ": " + this.conteudo;
    }
}
