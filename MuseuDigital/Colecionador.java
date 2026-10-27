package MuseuDigital;

import java.util.Arrays;
import java.util.Objects;

public class Colecionador {
    private String nome;
    private String cpf;
    private String[] interessesArtisticos;
    private String link;
    private Afinidade[] afinidade;

    public Colecionador(String nome, String cpf, String[] interessesArtisticos, String link) {
        this.nome = nome;
        this.cpf = cpf;
        this.interessesArtisticos = interessesArtisticos;
        this.link = link;
    }

    public Colecionador(String nome, String cpf, String[] interessesArtisticos) {
        this.interessesArtisticos = interessesArtisticos;
        this.nome = nome;
        this.cpf = cpf;
        this.link = "";
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Colecionador{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", interessesArtisticos=" + Arrays.toString(interessesArtisticos) +
                ", link='" + link + '\'' +
                '}';
    }

    public String getCpf(){
        return this.cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Colecionador that = (Colecionador) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    public String[] getInteressesArtisticos(){
        return  this.interessesArtisticos;
    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
    }

}
