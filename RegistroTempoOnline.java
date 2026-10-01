package LB2;

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineEsperado = 120;
    private int tempoOnlineUsado = 0;

    public RegistroTempoOnline (String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }

    public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempoOnlineUsado){
        this.tempoOnlineUsado += tempoOnlineUsado;
    }

    public boolean atingiuMetaTempoOnline(){
        return (this.tempoOnlineUsado >= this.tempoOnlineEsperado) ? true : false;
    }

    public String toString(){
        return this.nomeDisciplina + " " + this.tempoOnlineUsado + "/" + this.tempoOnlineEsperado;
    }
}
