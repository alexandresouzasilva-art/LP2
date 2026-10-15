package LP2.FilmNow;

import java.util.Scanner;

public class Main {
    final static private String string = """
            (A)Adicionar filme
            (M)Mostrar todos
            (D)Detalhar filme
            (E)Exibir HotList
            (H)Atribuir Hot
            (R)Remover Hot
            (S)Sair
            """;

    final static Scanner scanner = new Scanner(System.in);
    final static private FilmNow fimNow = new FilmNow();
    final static private HotList hotList = new HotList();

    public static void main(String[] args){
        char entrada;


        exibirMenu();

        do{
            entrada = scanner.nextLine().charAt(0);

            switch (entrada){
                case 'A':
                    adicionarFilme();
                    break;
                case 'M':
                    mostrarTodos();
                    break;
                case 'D':
                    exibirDetalhes();
                case 'E':
                    exibirHotList();
                case 'H':

            }
        } while (entrada != 'S');
    }

    public static void exibirMenu(){
        System.out.println(string);
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


        System.out.println(fimNow.adicionaFilme(posicao, nome,  dataLancamento, local));
    }

    public static void mostrarTodos(){
        System.out.println(fimNow.listaFilmes());
    }

    public static void exibirDetalhes(){
        String resultado = fimNow.detalhaFilme(scanner.nextInt());

        if(resultado.equals("SEM RESULTADOS")) {
            System.out.println("POSIÇÃO INVÁLIDA!" );
            exibirMenu();
        }
        else{
            System.out.println(resultado);
        }
    }

    public static void exibirHotList(){
        for(String linha : hotList.listarHots()) System.out.println(linha);
    }

    public static void atribuirHot(){

    }
}
