package LP2.FilmNow;

import static java.lang.String.format;

public class FilmNow {
    private Filme[] filmes =  new Filme[100];
    private HotList hotList = new HotList();

    public FilmNow(){
    }

    public String adicionaFilme(int indice, String nome, int dataLancamento, String local){
        if(nome.equals("")) return  "FILME INVALIDO";

        Filme filme = new Filme(nome, dataLancamento, local);

        for(int q = 0;q < 100;q ++){
            if(filmes[q] != null && filmes[q].equals(filme)) return "FILME JA ADICIONADO";
        }

        this.filmes[indice] = filme;

        return "FILME ADICIONADO";
    }

    public String listaFilmes(){
        String resposta = "";

        for(int q = 0;q < 100;q ++){
            if(this.filmes[q] != null) resposta = resposta + q + " - " + this.filmes[q].getNome() + "\n";
        }

        return resposta;

    }

    public String detalhaFilme(int indice){
        if(this.filmes[indice] == null) return "SEM RESULTADOS";
        else return this.filmes[indice].getStatus() + this.filmes[indice].toString() + "\n " + this.filmes[indice].getLocal();
    }

    public String adicionaHot(int indiceFilme, int indiceLista){
        return hotList.atribuirHot(this.filmes[indiceFilme], indiceLista);
    }
}
