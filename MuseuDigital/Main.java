package MuseuDigital;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static MuseuDigital museu;

    public static void main(String[] args) {
        inicializarSistema();
        executarMenu();
        scanner.close();
    }

    private static void inicializarSistema() {
        int qntArtistas = 100;
        int qntObras = 500;
        int qntColecionadores = 200;

        museu = new MuseuDigital(
                qntArtistas,
                qntObras,
                qntColecionadores
        );
    }

    private static void executarMenu() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            try {
                processarOpcao(opcao);
            } catch (IllegalArgumentException e) {
                exibirMensagem("Erro: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                exibirMensagem("Índice inválido.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        exibirMensagem("\n===== MUSEU DIGITAL =====");
        exibirMensagem("1. Cadastrar artista");
        exibirMensagem("2. Listar artistas");
        exibirMensagem("3. Atualizar bio de artista");
        exibirMensagem("4. Cadastrar obra");
        exibirMensagem("5. Listar obras");
        exibirMensagem("6. Exibir detalhes de obra");
        exibirMensagem("7. Cadastrar colecionador");
        exibirMensagem("8. Listar colecionadores");
        exibirMensagem("9. Atualizar link do perfil");
        exibirMensagem("10. Calcular afinidade");
        exibirMensagem("11. Listar obras compatíveis");
        exibirMensagem("12. Comprar edição");
        exibirMensagem("13. Listar compradores");
        exibirMensagem("14. Listar compradores compatíveis");
        exibirMensagem("15. Relatório de maiores vendas");
        exibirMensagem("0. Sair");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarArtista();
                break;
            case 2:
                listarArtistas();
                break;
            case 3:
                atualizarBioArtista();
                break;
            case 4:
                cadastrarObra();
                break;
            case 5:
                listarObras();
                break;
            case 6:
                exibirDetalhesObra();
                break;
            case 7:
                cadastrarColecionador();
                break;
            case 8:
                listarColecionadores();
                break;
            case 9:
                atualizarLinkPerfil();
                break;
            case 10:
                calcularAfinidade();
                break;
            case 11:
                listarObrasCompativeis();
                break;
            case 12:
                comprarEdicao();
                break;
            case 13:
                listarCompradoresObra();
                break;
            case 14:
                listarCompradoresCompativeis();
                break;
            case 15:
                emitirRelatorioMaioresVendas();
                break;
            case 0:
                exibirMensagem("Encerrando o Museu Digital...");
                break;
            default:
                exibirMensagem("Opção inválida.");
        }
    }

    private static void cadastrarArtista() {
        String nome = lerTexto("Nome do artista: ");
        String bio = lerTexto("Bio: ");

        exibirMensagem("Tipos de expressão artística (até 3):");
        String[] tipos = lerLista(3);

        boolean cadastrado = museu.cadastrarArtista(nome, bio, tipos);

        exibirMensagem(cadastrado
                ? "Artista cadastrado com sucesso!"
                : "Não foi possível cadastrar o artista.");
    }

    private static void listarArtistas() {
        exibirLista(museu.listarArtistas());
    }

    private static void atualizarBioArtista() {
        String nome = lerTexto("Nome do artista: ");
        String bio = lerTexto("Nova bio: ");

        museu.atualizarBioArtista(nome, bio);
        exibirMensagem("Bio atualizada.");
    }

    private static void cadastrarObra() {
        String titulo = lerTexto("Título da obra: ");
        String tipo = lerTexto("Tipo da obra: ");
        String artista = lerTexto("Nome do artista responsável: ");
        int edicoes = lerInteiro("Quantidade máxima de edições: ");
        double valor = lerDouble("Valor de cada edição: ");

        exibirMensagem("Características da obra (até 3):");
        String[] caracteristicas = lerLista(3);

        int indice = museu.cadastrarObra(
                titulo, tipo, artista, edicoes, valor, caracteristicas
        );

        exibirMensagem(indice >= 0
                ? "Obra cadastrada. Índice: " + indice
                : "Cadastro da obra não realizado.");
    }

    private static void listarObras() {
        exibirLista(museu.listarObras());
    }

    private static void exibirDetalhesObra() {
        int indice = lerInteiro("Índice da obra: ");
        exibirMensagem(museu.exibirDetalhesObra(indice));
    }

    private static void cadastrarColecionador() {
        String nome = lerTexto("Nome do colecionador: ");
        String cpf = lerTexto("CPF: ");

        String link = lerTexto(
                "Link do perfil (pressione Enter para deixar vazio): "
        );

        exibirMensagem("Informe os três interesses artísticos:");
        String[] interesses = lerLista(3);

        if (interesses.length != 3) {
            exibirMensagem(
                    "É necessário informar exatamente três interesses."
            );
            return;
        }

        boolean cadastrado;

        if (link.isEmpty()) {
            cadastrado = museu.cadastrarColecionador(
                    nome, cpf, interesses
            );
        } else {
            cadastrado = museu.cadastrarColecionador(
                    nome, cpf, link, interesses
            );
        }

        exibirMensagem(cadastrado
                ? "Colecionador cadastrado com sucesso!"
                : "Não foi possível cadastrar o colecionador.");
    }

    private static void listarColecionadores() {
        exibirLista(museu.listarColecionadores());
    }

    private static void atualizarLinkPerfil() {
        String cpf = lerTexto("CPF do colecionador: ");
        String link = lerTexto("Novo link: ");

        museu.atualizarLinkPerfil(cpf, link);
        exibirMensagem("Link atualizado.");
    }

    private static void calcularAfinidade() {
        String cpf = lerTexto("CPF do colecionador: ");
        int indice = lerInteiro("Índice da obra: ");

        int afinidade = museu.calcularAfinidade(cpf, indice);

        exibirMensagem("Afinidade artística: " + afinidade + "%");
    }

    private static void listarObrasCompativeis() {
        String cpf = lerTexto("CPF do colecionador: ");
        int afinidade = lerInteiro("Afinidade mínima (%): ");

        exibirLista(
                museu.listarObrasCompativeis(cpf, afinidade)
        );
    }

    private static void comprarEdicao() {
        String cpf = lerTexto("CPF do colecionador: ");
        int indice = lerInteiro("Índice da obra: ");

        exibirMensagem(museu.comprarEdicao(cpf, indice));
    }

    private static void listarCompradoresObra() {
        int indice = lerInteiro("Índice da obra: ");

        exibirLista(museu.listarCompradoresObra(indice));
    }

    private static void listarCompradoresCompativeis() {
        int indice = lerInteiro("Índice da obra: ");
        int afinidade = lerInteiro("Afinidade mínima (%): ");

        exibirLista(
                museu.listarCompradoresCompativeis(indice, afinidade)
        );
    }

    private static void emitirRelatorioMaioresVendas() {
        exibirMensagem(museu.emitirRelatorioMaioresVendas());
    }

    private static String[] lerLista(int maximo) {
        int quantidade = lerInteiro(
                "Quantidade de itens (0 a " + maximo + "): "
        );

        if (quantidade < 0 || quantidade > maximo) {
            throw new IllegalArgumentException(
                    "Informe uma quantidade entre 0 e " + maximo + "."
            );
        }

        String[] itens = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            itens[i] = lerTexto("Item " + (i + 1) + ": ");
        }

        return itens;
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        return Integer.parseInt(lerTexto(mensagem));
    }

    private static double lerDouble(String mensagem) {
        return Double.parseDouble(lerTexto(mensagem));
    }

    private static void exibirLista(String[] itens) {
        if (itens == null || itens.length == 0) {
            exibirMensagem("Nenhum registro encontrado.");
            return;
        }

        boolean encontrou = false;

        for (String item : itens) {
            if (item != null) {
                exibirMensagem(item);
                encontrou = true;
            }
        }

        if (!encontrou) {
            exibirMensagem("Nenhum registro encontrado.");
        }
    }

    private static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
