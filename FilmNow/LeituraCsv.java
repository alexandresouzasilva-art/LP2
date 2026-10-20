package LP2.FilmNow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraCsv {

    public static void lerArquivo(String filmesCSV, FilmNow filmNow) throws IOException {
        try(BufferedReader buffer = new BufferedReader(new FileReader(filmesCSV))){
            String linha;
            int numeroLinha = 0;

            while ((linha = buffer.readLine()) != null) {
                numeroLinha++;

                if (numeroLinha == 1) {
                    continue;
                }

                String[] partes = linha.split(",");

                if (partes.length == 4) {
                    carregaInformacoes(partes, filmNow);
                }
            }
        }
    }

    public static void carregaInformacoes(String[] partes, FilmNow filmNow) {
        try {
            int indice = Integer.parseInt(partes[0].trim());
            int dataLancamento = Integer.parseInt(partes[2].trim());
            String nome = partes[1].trim();
            String local = partes[3].trim();

            filmNow.adicionaFilme(indice, nome, dataLancamento, local);

        } catch (NumberFormatException e) {
            System.out.println(
                    "Erro na linha, posição não é um número válido."
            );
        }
    }
}
