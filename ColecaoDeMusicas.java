public interface ColecaoDeMusicas {
    public void adicionarMusica(Musica musica);
    public void excluirMusica(String nomeDaMusica);
    public Musica obterMusica(int posicaoDaMusica);
    public int obterTotaldeMusicas();
    public void trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2);
    public void alterarMusica(int posicaoDaMusica, Musica novaMusica);
    public void ordenarMusicas(Ordenador ordenador);
}
