public class ListaDeMusicas implements ColecaoDeMusicas {

    private class No {
        Musica musica;
        No proximo;
        No(Musica musica) {
            this.musica = musica;
            this.proximo = null;
        }
    }

    private No primeiro;
    private int totalDeMusicas;

    public ListaDeMusicas(){
        this.primeiro = null;
        this.totalDeMusicas = 0;
    }

    private No obterNo(int posicao){
        No atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

    public void adicionarMusica(Musica musica) {
        No novaMusica = new No(musica);
        if (this.primeiro == null){
            this.primeiro = novaMusica;
        }else{
            No atual = this.primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novaMusica;
        }
        this.totalDeMusicas++;
    }

    public void excluirMusica(String nomeDaMusica) {
        if (this.primeiro == null) return;
        if(this.primeiro.musica.getFaixa().equalsIgnoreCase(nomeDaMusica)){
            this.primeiro = this.primeiro.proximo;
            this.totalDeMusicas--;
            return;
        }
        No anterior = this.primeiro;
        No atual = primeiro.proximo;
        while (atual != null && !atual.musica.getFaixa().equalsIgnoreCase(nomeDaMusica)) {
            anterior = atual;
            atual = atual.proximo;
        }

        if(atual != null){
            anterior.proximo = atual.proximo;
            this.totalDeMusicas--;
        }
    }

    public Musica obterMusica(int posicaoDaMusica) {
        return obterNo(posicaoDaMusica).musica;
    }

    public int obterTotaldeMusicas() {
        return totalDeMusicas;
    }

    public void trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2) {
        No musica1 = obterNo(posicaoDaMusica1);
        No musica2 = obterNo(posicaoDaMusica2);
        Musica temp = musica1.musica;
        musica1.musica = musica2.musica;
        musica2.musica = temp;
    }

    public void alterarMusica(int posicaoDaMusica, Musica novaMusica) {
        No musicaOriginal = obterNo(posicaoDaMusica);
        musicaOriginal.musica = novaMusica;
    }

    public void ordenarMusicas(Ordenador ordenador) {
        ordenador.ordenar(this);
    }
}
