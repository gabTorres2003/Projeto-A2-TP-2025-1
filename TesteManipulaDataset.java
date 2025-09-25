public class TesteManipulaDataset {
    public static void main(String[] args) {
        ManipulaDataset manipulador = new ManipulaDataset();
        ColecaoDeMusicas colecao = new ListaDeMusicas();

        manipulador.lerDoArquivoCsv(colecao);
        int totalDeMusicas = colecao.obterTotaldeMusicas();
        System.out.println("Quantidade de músicas lida: " + totalDeMusicas);

        manipulador.escreverNoArquivoCsv(colecao);
    }
}
