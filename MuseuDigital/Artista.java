package MuseuDigital;

import java.util.Arrays;
import java.util.Objects;

public class Artista {

    /**
     * Identificação única de um artista.
     */
    private String nome;
    private String bio;
    private String[] expressoesArtisticas;
    private int qntObrasVendidas;

    public Artista(String nome, String bio, String[] expressoesArtisticas) {
        this.nome = nome;
        this.bio = bio;
        this.expressoesArtisticas = expressoesArtisticas;
        this.qntObrasVendidas = 0;
    }


    @Override
    public String toString() {
        return "Artista{" +
                "Nome: '" + this.nome + '\'' +
                ", Bio: '" + this.bio + '\'' +
                ", Expressões artísticas: " + Arrays.toString(this.expressoesArtisticas) +
                "Quantidade de edições de obras vendidas: " + this.qntObrasVendidas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(nome, artista.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getNome(){
        return this.nome;
    }

    public void compraObra(){
        this.qntObrasVendidas ++;
    }

    public int getQntObrasVendidas() {
        return this.qntObrasVendidas;
    }

    public String getBio(){
        return this.bio;
    }
}

