package LP2.FilmNow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 */
public class Main {
    final static private String string = "(A)Adicionar filme\n" +
            "(M)Mostrar todos\n" +
            "(D)Detalhar filme\n" +
            "(E)Exibir HotList\n" +
            "(H)Atribuir Hot\n" +
            "(R)Remover Hot\n" +
            "(S)Sair\n" +
            "Opção> ";


    final static Scanner scanner = new Scanner(System.in);
    final static private FilmNow filmNow = new FilmNow();
    final static private HotList hotList = new HotList();

    public static void main(String[] args){
        char entrada;

        LeituraCsv leituraCsv = new LeituraCsv();

        try {
            LeituraCsv.lerArquivo("filmes_inicial.csv", filmNow);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro lendo arquivo: " + e.getMessage());
        }

        while(true){
            entrada = exibirMenu();
            opcoes(entrada);
        }
    }

    public static char exibirMenu(){
        System.out.print(string);

        return scanner.next().toUpperCase().charAt(0);
    }

    public static void opcoes(char entrada){
        switch (entrada){
            case 'A':
                adicionarFilme();
                break;
            case 'M':
                mostrarTodos();
                break;
            case 'D':
                exibirDetalhes();
                break;
            case 'E':
                exibirHotList();
                break;
            case 'H':
                atribuirHot();
                break;
            case'R':
                removerHot();
                break;
            case 'S':
                sair();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }

    }

    public static void adicionarFilme(){
        String nome, local;
        int posicao, dataLancamento;

        System.out.print("Posição> ");
        posicao = scanner.nextInt();
        scanner.nextLine();

        if(posicao > 100){
            System.out.println("POSIÇÃO INVÁLIDA");
            exibirMenu();
        }

        System.out.print("Nome> " );
        nome = scanner.nextLine();

        System.out.print("Ano> ");
        dataLancamento = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Local> ");
        local = scanner.nextLine();


        System.out.println(filmNow.adicionaFilme(posicao, nome,  dataLancamento, local));
    }

    public static void mostrarTodos(){
        System.out.print(filmNow.listaFilmes());
    }

    public static void exibirDetalhes(){
        System.out.print("Posição> ");
        int indice = scanner.nextInt();

        String resultado = filmNow.detalhaFilme(indice);

        if(resultado.equals("SEM RESULTADOS")) {
            System.out.println("POSIÇÃO INVÁLIDA!" );
        }
        else{
            System.out.println(resultado);
        }
    }

    public static void exibirHotList(){
        for(int indice : hotList.listarHots()) {
            if(indice != 0) {
                System.out.println(filmNow.detalhaFilme(indice));
            }
        }
    }

    public static void atribuirHot(){
        System.out.print("Filme> ");
        int filme = scanner.nextInt(); scanner.nextLine();
        System.out.print("Posição> ");
        int posicao = scanner.nextInt(); scanner.nextLine();

        filmNow.alteraStatusFilme(filme);
        hotList.atribuirHot(filme, posicao);
    }

    public static void removerHot(){
        System.out.print("Posição> ");
        int posicao = scanner.nextInt(); scanner.nextLine();

        hotList.removerHot(posicao);
    }

    public static void sair(){System.exit(0);}
}
