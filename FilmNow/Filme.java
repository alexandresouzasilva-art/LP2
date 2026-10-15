package LP2.FilmNow;

import java.util.Objects;

public class Filme {
    private String nome;
    private int dataLancamento;
    private String local;
    private String status;

    public Filme(String nome, int dataLancamento, String local){
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.local = local;
    }

    public String getNome(){return this.nome;}

    public int getDataLancamento(){return this.dataLancamento;}

    public String getLocal(){return this.local;}

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status){this.status = status;}

    @Override
    public String toString() {
        return this.nome + ", " + this.dataLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return dataLancamento == filme.dataLancamento && Objects.equals(nome, filme.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataLancamento);
    }
}
