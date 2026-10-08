package LB2;

public class Resumo {
    private String tema;
    private String conteudo;

    public Resumo(String tema, String conteudo){
        this.tema = tema;
        this.conteudo = conteudo;
    }

    public Resumo(String tema){
        this.tema = tema;
    }

    public String getTema(){
        return this.tema;
    }

    public String getConteudo(){
        return this.conteudo;
    }

    public String toString(){
        return this.tema + ": " + this.conteudo;
    }
}
