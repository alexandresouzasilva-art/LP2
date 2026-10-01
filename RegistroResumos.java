package LB2;

import java.util.ArrayList;
import java.util.Arrays;

public class RegistroResumos {
    private int numeroDeResumos;
    private ArrayList<Resumo> resumos = new ArrayList<>();


    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
    }

    public int conta() {
        return this.resumos.size();
    }

    private static boolean verificaTemas(ArrayList<Resumo> resumos, String tema) {
        for (int q = 0; q < resumos.size(); q++) {
            if (resumos.get(q).getTema().equals(tema)) return true;
        }

        return false;
    }

    public void adiciona(String tema, String conteudo) {
        if(!verificaTemas(this.resumos,tema) && this.resumos.size() < numeroDeResumos) {
            Resumo resumo = new Resumo(tema, conteudo);
            this.resumos.add(resumo);
        }else{
            System.out.println("Tema já utilizado por outro resumo");
        }

        }
    public String[] pegaResumos(){
        String[] resultado = new String[this.resumos.size()];

        for (int q = 0; q < this.resumos.size(); q++) {
            resultado[q] = this.resumos.get(q).toString();
        }

        return resultado;
    }

    public String imprimeResumos(){
      String resultado = "- " + this.resumos.size() + " resumo(s) cadastrado(s)" +
              "\n" + "- ";

        for (int q = 0; q < this.resumos.size(); q++) {
            if(q != this.resumos.size() - 1) resultado += this.resumos.get(q).getTema() + " | ";
            else resultado += this.resumos.get(q).getTema();
        }

        return resultado;
    }

    public boolean temResumo(String tema){
        return verificaTemas(this.resumos,tema);
    }

}
