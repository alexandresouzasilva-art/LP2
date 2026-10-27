package MuseuDigital;

import java.util.*;

public class MuseuDigital {
    private int indiceArtista;
    private int indiceObra;
    private int indiceColecionador;
    private Artista[] artistas;
    private Obra[] obras;
    private Colecionador[] colecionadores;

    public MuseuDigital(int qntArtistas, int qntObras, int qntColecionadores){
        this.artistas = new Artista[qntArtistas];
        this.obras = new Obra[qntObras];
        this.colecionadores = new Colecionador[qntColecionadores];
        this.indiceArtista = 0;
        this.indiceObra = 0;
        this.indiceColecionador = 0;
    }


    public boolean cadastrarArtista(String nome, String bio,String[] tipos){
        Artista artista = new Artista(nome, bio, tipos);

        for(Artista artista0 : this.artistas){
            if(artista0.equals(artista)) return false;
        }

        this.artistas[this.indiceArtista] = artista;
        indiceArtista ++;

        return true;
    }

    public void atualizarBioArtista(String nomeArtista, String novaBio) {
        int indiceA = buscaArtista(nomeArtista);

        this.artistas[indiceA].setBio(novaBio);
    }

    public String[] listarArtistas(){
        String resultado[] = new String[this.artistas.length];

        for(int q = 0;q < this.artistas.length;q++ ){
            if(this.artistas[q] != null) resultado[q] = this.artistas[q].toString();
        }

        return resultado;
    }

    public int cadastrarObra(String titulo, String tipo, String artista, int edicoes, double valor, String[] caracteristicas){
        this.obras[indiceObra] = new Obra(titulo, tipo, artista, edicoes, valor, caracteristicas);

        indiceObra ++;

        return indiceObra - 1;
    }

    public String[] listarObras(){
        String resultado[] = new String[this.obras.length];

        for(int q = 0;q < this.obras.length;q++ ){
            if(this.obras[q] != null) resultado[q] = this.obras[q].getTitulo();
        }

        return resultado;
    }

    private int buscaColecionador(String cpf){
        int indice = -1;

        for(int q = 0;q < this.colecionadores.length;q ++){
            if(this.colecionadores[q] != null && this.colecionadores[q].getCpf().equals(cpf)){
                indice = q;
                break;
            }
        }

        if(indice == -1) throw new IllegalArgumentException("Nome não encontrado");
        return indice;
    }

    public String[] listarObrasCompativeis(String cpf, int afinidade){
        String resultado[] = new String[this.obras.length];

        for(int q = 0;q < this.obras.length;q ++){
            if(this.obras[q] != null && calcularAfinidade(cpf,q) >= afinidade) resultado[q] = this.obras[q].toString();
        }

        return resultado;
    }

    public String exibirDetalhesObra(int indexObra){
        return this.obras[indexObra].toString();
    }

    public boolean cadastrarColecionador(String nome, String cpf, String link, String[] interesses){
        this.colecionadores[this.indiceColecionador] = new Colecionador(nome, cpf, interesses, link);

        return true;
    }

    public boolean cadastrarColecionador(String nome, String cpf, String[] interesses){
        this.colecionadores[this.indiceColecionador] = new Colecionador(nome, cpf, interesses);

        return true;
    }

    public void atualizarLinkPerfil(String cpf, String novoLink){
        int indiceC = buscaColecionador(cpf);

        this.colecionadores[indiceC].setLink(novoLink);
    }

    public String[] listarColecionadores(){
        String[] resultado = new String[this.colecionadores.length];

        for(int q = 0;q < colecionadores.length;q ++){
            if(this.colecionadores[q] != null) resultado[q] = this.colecionadores[q].toString();
        }

        return resultado;
    }
    public int buscaArtista(String nome){
        int indice = -1;

        for(int q = 0;q < this.artistas.length;q ++){
            if(this.artistas[q].getNome().equals(nome)){
                indice = q;
                break;
            }
        }

        if(indice == -1) throw new IllegalArgumentException("Nome não encontrado");

        return indice;
    }


    public String comprarEdicao(String cpf, int indexObra){
        boolean compraEdicaoObra = this.obras[indexObra].compraEdicao(cpf);

        if(!compraEdicaoObra) return "OBRA INDIPONÍVEL";

        int indiceC = buscaColecionador(cpf);
        int indiceA = buscaArtista(this.obras[indexObra].getNomeArtista());
        this.artistas[indiceA].compraObra();

        return this.colecionadores[indiceC].getNome() + " " +
                this.colecionadores[indiceC].getLink() + " " +
                this.obras[indexObra].getTitulo() + " " +
                calcularAfinidade(cpf,indexObra);
    }

    public String[] listarCompradoresObra(int indexObra){
        String[] colecionadoresObra = this.obras[indexObra].getCompradores();
        String[] resultado = new String[colecionadoresObra.length];

        for(int q = 0;q < colecionadoresObra.length; q ++){
            int indice = buscaColecionador(colecionadoresObra[q]);

            resultado[q] = this.colecionadores[indice].getNome() + " " +
                    this.colecionadores[indice].getLink() +
                    calcularAfinidade(this.colecionadores[q].getCpf(),indexObra);
        }

        return resultado;
    }


    public String[] listarCompradoresCompativeis(int indexObra, int afinidade){
        String[] colecionadoresObra = this.obras[indexObra].getCompradores();
        String[] resultado = new String[colecionadoresObra.length];

        for(int q = 0;q < colecionadoresObra.length; q ++){
            int indice = buscaColecionador(colecionadoresObra[q]);
            int afinidadeColecionador = calcularAfinidade(this.colecionadores[q].getCpf(),indexObra);

            if(afinidadeColecionador >= afinidade){
            resultado[q] = this.colecionadores[indice].getNome() + " " +
                    this.colecionadores[indice].getLink() +
                    afinidadeColecionador;
            }
        }

        return resultado;
    }

    public int calcularAfinidade(String cpf, int indexObra){
        int cont = 0;
        String[] interessesArtisticos = this.colecionadores[buscaColecionador(cpf)].getInteressesArtisticos();
        String[] caracteristicas = this.obras[indexObra].getCaracteristicas();

        for(String caracteristica : caracteristicas){
            for(String interesseArtistico : interessesArtisticos){
                if(caracteristica.equals(interesseArtistico)) cont ++;
            }
        }

        if(cont == 1) return 30;
        else if(cont == 2) return 70;
        else if(cont == 3) return 100;

        return 0;
    }
    public String emitirRelatorioMaioresVendas(){
        int artistaMaiorQntVendas = 0;

        for(int q = 0;q < this.artistas.length;q ++){
            if(this.artistas[q].getQntObrasVendidas() > this.artistas[artistaMaiorQntVendas].getQntObrasVendidas()){
                artistaMaiorQntVendas = q;
            }
        }

        return this.artistas[artistaMaiorQntVendas].getNome() + " " +
                this.artistas[artistaMaiorQntVendas].getBio() + " " +
                this.artistas[artistaMaiorQntVendas].getQntObrasVendidas();
    }
}

