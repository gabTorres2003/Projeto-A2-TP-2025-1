public class OrdenarPorTempoDeDuracaoComQuickSort implements Ordenador {

    public void ordenar(ColecaoDeMusicas colecao) {
        quickSort(colecao, 0, colecao.obterTotaldeMusicas() - 1);
    }

    private void quickSort(ColecaoDeMusicas colecao, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(colecao, inicio, fim);
            quickSort(colecao, inicio, pivo - 1);
            quickSort(colecao, pivo + 1, fim);
        }
    }

    private int particionar(ColecaoDeMusicas colecao, int inicio, int fim) {
        Musica pivo = colecao.obterMusica(fim);
        double duracaoPivo = pivo.getDuracaoMin();
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (colecao.obterMusica(j).getDuracaoMin() <= duracaoPivo) {
                i++;
                colecao.trocarPosicaoEntreMusicas(i, j);
            }
        }
        colecao.trocarPosicaoEntreMusicas(i + 1, fim);
        return i + 1;
    }
}
