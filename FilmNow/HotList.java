package LP2.FilmNow;

import static java.lang.String.format;

public class HotList {
    private int[] filmes;

    public HotList(){
        this.filmes = new int[10];
    }

    public String atribuirHot(int filme, int indiceLista){
        this.filmes[indiceLista - 1] = filme;

        return format("ADICIONANDO À HOTLIST NA POSIÇÃO %d", indiceLista);
    }


    public int[] listarHots(){
        return this.filmes;
    }

    public void removerHot(int indiceFilme){
        this.filmes[indiceFilme - 1] = 0;
    }
}

