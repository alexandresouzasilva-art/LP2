package LB2;

import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] Notas = {0, 0, 0, 0};

    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }

    public void cadastraHoras(int horasEstudo){
        this.horasEstudo = horasEstudo;
    }

    public void cadastraNota(int nota, double valorNota){
        if(nota <= 4 && valorNota <= 10) {
            this.Notas[nota - 1] = valorNota;

        }
    }

    private static double getMedia(double Notas[]){
        double media = 0;

        for(double nota : Notas){
            media += nota;
        }

        return media / 4;
    }

    public boolean aprovado( ){
        return (getMedia(this.Notas) >= 7) ? true : false;
        }

    public String toString(){
        return "%s %d %s %s".formatted(this.nomeDisciplina, this.horasEstudo, getMedia(this.Notas), Arrays.toString(this.Notas));
    }

}
