public class Musica {
    public String artista, faixa;
    public double dancabilidade, energia, duracaoMin;
    public double curtidas, visualizacoes;

    public Musica(String artista, String faixa, double dancabilidade, double energia, double duracaoMin,
            double curtidas,
            double visualizacoes) {
        this.artista = artista;
        this.curtidas = curtidas;
        this.dancabilidade = dancabilidade;
        this.duracaoMin = duracaoMin;
        this.energia = energia;
        this.faixa = faixa;
        this.visualizacoes = visualizacoes;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public double getDancabilidade() {
        return dancabilidade;
    }

    public void setDancabilidade(double dancabilidade) {
        this.dancabilidade = dancabilidade;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public double getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(double duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    public double getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(long curtidas) {
        this.curtidas = curtidas;
    }

    public double getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(long visualizacoes) {
        this.visualizacoes = visualizacoes;
    }

    public String toString() {
        return "Musica {" + "artista: " + artista + " / " + "faixa: " + faixa + " / " + "dancabilidade: "
                + dancabilidade + " / " + "energia: " + energia + " / " + "duracaoMin: " + duracaoMin + " / "
                + "curtidas: " + curtidas + " / " + "visualizações: " + visualizacoes + "}";
    }
}
