public class OrdenarPorNomeComBubbleSort implements Ordenador {

    public void ordenar(ColecaoDeMusicas colecao) {
        int totalDeMusicas = colecao.obterTotaldeMusicas();
        if (totalDeMusicas < 2) return;

        for (int i = 0; i < totalDeMusicas - 1; i++) {
            for (int j = 0; j < totalDeMusicas - i - 1; j++) {
                Musica musica1 = colecao.obterMusica(j);
                Musica musica2 = colecao.obterMusica(j + 1);

                if (musica1.getFaixa().compareToIgnoreCase(musica2.getFaixa()) > 0) {
                    colecao.trocarPosicaoEntreMusicas(j, j + 1);
                }
            }
        }
    }
}
