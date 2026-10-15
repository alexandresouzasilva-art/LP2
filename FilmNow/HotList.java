package LP2.FilmNow;

import static java.lang.String.format;

public class HotList {
    private Filme[] filmes = new Filme[10];

    public HotList(){}

    public String atribuirHot(Filme filme, int indiceLista){
        filmes[indiceLista] = filme;

        return format("ADICIONANDO À HOTLIST NA POSIÇÃO %d", indiceLista);
    }


    public String[] listarHots(){
        String[] resultado = new String[10];

        for(int q = 0;q < 10;q ++) {
            if(filmes[q] != null) {
                resultado[q] = format("%d - %s", (q + 1), filmes[q].toString());
            }
        }
        return resultado;
    }

    public void removerHot(int indiceFilme){
        this.filmes[indiceFilme] = null;
    }
}

