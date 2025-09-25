import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaMusicas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColecaoDeMusicas colecao = new ListaDeMusicas();

        ManipulaDataset manipulador = new ManipulaDataset();

        int opcao = -1;

        while (opcao != 9) {
            System.out.print("Menu Spotify:\n" +
                 "1. Ler músicas do arquivo CSV\n" +
                 "2. Adicionar nova música\n" +
                 "3. Excluir música\n" +
                 "4. Listar músicas\n" +
                 "5. Alterar dados de uma música\n" +
                 "6. Ordenar músicas por nome (Bubble Sort)\n" +
                 "7. Ordenar músicas por duração (Quick Sort)\n" +
                 "8. Salvar músicas em arquivo CSV\n" +
                 "9. Sair\n" +
                 "Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        manipulador.lerDoArquivoCsv(colecao);
                        System.out.println(colecao.obterTotaldeMusicas() + " músicas carregadas do arquivo.");
                        break;
                    case 2:
                        adicionarNovaMusica(scanner, colecao);
                        break;
                    case 3:
                        System.out.print("Digite o nome da música para excluir: ");
                        String faixaExcluir = scanner.nextLine();
                        colecao.excluirMusica(faixaExcluir);
                        System.out.println("Música removida.");
                        break;
                    case 4:
                        listar(colecao);
                        break;
                    case 5:
                        alterarMusicaExistente(scanner, colecao);
                        break;
                    case 6:
                        System.out.println("Ordenando por nome (Bubble Sort)...");
                        colecao.ordenarMusicas(new OrdenarPorNomeComBubbleSort());
                        listar(colecao);
                        break;
                    case 7:
                        System.out.println("Ordenando por duração (Quick Sort)...");
                        colecao.ordenarMusicas(new OrdenarPorTempoDeDuracaoComQuickSort());
                        listar(colecao);
                        break;
                    case 8:
                        manipulador.escreverNoArquivoCsv(colecao);
                        System.out.println("Músicas salvas no arquivo 'musicas.csv'.");
                        break;
                    case 9:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Diigite outro número.");
                scanner.nextLine();
                opcao = -1;
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void listar(ColecaoDeMusicas colecao) {
        if (colecao.obterTotaldeMusicas() == 0) {
            System.out.println("Nenhuma música na coleção.");
            return;
        }
        for (int i = 0; i < colecao.obterTotaldeMusicas(); i++) {
            System.out.println("[" + i + "] " + colecao.obterMusica(i));
        }
    }

    private static void adicionarNovaMusica(Scanner sc, ColecaoDeMusicas colecao) {
        try {
            System.out.print("Artista: ");
            String artista = sc.nextLine();
            System.out.print("Faixa: ");
            String faixa = sc.nextLine();
            System.out.print("Dançabilidade: ");
            double dancabilidade = sc.nextDouble();
            System.out.print("Energia: ");
            double energia = sc.nextDouble();
            System.out.print("Duração (min): ");
            double duracao = sc.nextDouble();
            System.out.print("Visualizações: ");
            long views = sc.nextLong();
            System.out.print("Curtidas: ");
            long likes = sc.nextLong();
            sc.nextLine(); 
            Musica nova = new Musica(artista, faixa, dancabilidade, energia, duracao, views, likes);
            colecao.adicionarMusica(nova);
            System.out.println("Música adicionada!");
        } catch (InputMismatchException e) {
            System.err.println("Erro de entrada. A música não foi adicionada. Tente novamente.");
            sc.nextLine();
        }
    }

    private static void alterarMusicaExistente(Scanner sc, ColecaoDeMusicas colecao) {
        try {
            System.out.print("Digite a posição da música a ser alterada: ");
            int pos = sc.nextInt();
            sc.nextLine();

            if (pos < 0 || pos >= colecao.obterTotaldeMusicas()) {
                System.out.println("Posição inválida!");
                return;
            }

            System.out.println("Digite os novos dados para a música na posição " + pos);
            System.out.print("Artista: ");
            String artista = sc.nextLine();
            System.out.print("Faixa: ");
            String faixa = sc.nextLine();
            System.out.print("Dançabilidade: ");
            double dancabilidade = sc.nextDouble();
            System.out.print("Energia: ");
            double energia = sc.nextDouble();
            System.out.print("Duração (min): ");
            double duracao = sc.nextDouble();
            System.out.print("Visualizações: ");
            long views = sc.nextLong();
            System.out.print("Curtidas: ");
            long likes = sc.nextLong();
            sc.nextLine(); 
            Musica alterada = new Musica(artista, faixa, dancabilidade, energia, duracao, views, likes);
            colecao.alterarMusica(pos, alterada);
            System.out.println("Música alterada com sucesso!");
        } catch (InputMismatchException e) {
            System.err.println("Erro de entrada. A operação foi cancelada.");
            sc.nextLine();
        }
    }
}
