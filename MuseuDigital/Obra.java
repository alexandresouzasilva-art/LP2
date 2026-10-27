package MuseuDigital;

import java.util.Arrays;

public class Obra {
    private String titulo;
    private String tipo;
    private String nomeArtista;
    private int qntMaximaEdicoesDisponiveis;
    private double valorEdicao;
    private String[] caracteristicas;
    private int qntEdicoesVendidas;
    private String[] compradores;

    public Obra(String titulo, String tipo, String nomeArtista, int qntMaximaEdicoesDisponiveis, double valorEdicao, String[] caracteristicas) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.nomeArtista = nomeArtista;
        this.qntMaximaEdicoesDisponiveis = qntMaximaEdicoesDisponiveis;
        this.valorEdicao = valorEdicao;
        this.caracteristicas = caracteristicas;
        this.qntEdicoesVendidas = 0;
        this.compradores = new String[qntMaximaEdicoesDisponiveis];
    }

    public String[] getCompradores(){
        return this.compradores;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "Tituilo: " + this.titulo + '\'' +
                "Tipo: " + this.tipo + '\'' +
                "Nome do Artista: " + this.nomeArtista +
                '}';
    }

    public String[] getCaracteristicas() {
        return caracteristicas;
    }

    public boolean compraEdicao(String cpf){
        if(this.qntEdicoesVendidas == this.qntMaximaEdicoesDisponiveis) return false;

        this.compradores[this.qntEdicoesVendidas] = cpf;
        qntEdicoesVendidas ++;

        return true;
    }

    public String getNomeArtista(){
        return this.nomeArtista;
    }
}

