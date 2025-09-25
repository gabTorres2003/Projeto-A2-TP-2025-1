public class VetorDeMusicas implements ColecaoDeMusicas {

    private Musica[] musicas;
    private int totalDeMusicas;

    public VetorDeMusicas(int capacidade) {
        this.musicas = new Musica[capacidade];
        this.totalDeMusicas = 0;
    }

    
    public void adicionarMusica(Musica musica) {
        if (this.totalDeMusicas < this.musicas.length) {
            this.musicas[this.totalDeMusicas] = musica;
            this.totalDeMusicas++;
        } else {
            System.err.println("Erro: A coleção de músicas (vetor) está cheia.");
        }
    }
    
    public void excluirMusica(String nomeDaMusica) {
        int indiceParaExcluir = -1;
        for (int i = 0; i < this.totalDeMusicas; i++) {
            if (this.musicas[i].getFaixa().equalsIgnoreCase(nomeDaMusica)) {
                indiceParaExcluir = i;
                break;
            }
        }
        if (indiceParaExcluir != -1) {
            for (int i = indiceParaExcluir; i < this.totalDeMusicas - 1; i++) {
                this.musicas[i] = this.musicas[i + 1];
            }
            this.musicas[this.totalDeMusicas - 1] = null;
            this.totalDeMusicas--;
        }
    }
    
    public Musica obterMusica(int posicaoDaMusica) {
        return this.musicas[posicaoDaMusica];
    }
    
    public int obterTotaldeMusicas() {
        return this.totalDeMusicas;
    }

    public void verificaPosicaoValida(int posicao) {
        if (posicao < 0 || posicao >= this.totalDeMusicas) {
            return;
        }
    }
    
    public void trocarPosicaoEntreMusicas(int pos1, int pos2) {
        verificaPosicaoValida(pos1);
        verificaPosicaoValida(pos2);
        Musica temp = this.musicas[pos1];
        this.musicas[pos1] = this.musicas[pos2];
        this.musicas[pos2] = temp;
    }

    public void alterarMusica(int posicaoDaMusica, Musica novaMusica) {
        verificaPosicaoValida(posicaoDaMusica);
        this.musicas[posicaoDaMusica] = novaMusica;
    }
    
    public void ordenarMusicas(Ordenador ordenador) {
        ordenador.ordenar(this);
    }
}