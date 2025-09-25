import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ManipulaDatasetSpotify {
    public static void main(String[] args) {
        String arquivoBruto = "C:\\Users\\Gabriel Torres\\Meu Drive (gabrielstorres08@gmail.com)\\Gabriel Torres\\IFF\\BSI\\BSI 5 Período\\Técnicas de Programação\\Atividade_28_08\\Projeto-A2-TP-2025-1\\filtered_dataset.csv";
        String arquivoFiltradoFormatado = "C:\\Users\\Gabriel Torres\\Meu Drive (gabrielstorres08@gmail.com)\\Gabriel Torres\\IFF\\BSI\\BSI 5 Período\\Técnicas de Programação\\Atividade_28_08\\Projeto-A2-TP-2025-1\\filtered_dataset.csv";
        FileReader leitor = null;
        BufferedReader leitorOtimizado = null;
        PrintWriter escritor = null;

        try {
            leitor = new FileReader(arquivoBruto);
            leitorOtimizado = new BufferedReader((leitor));
            escritor = new PrintWriter(new FileWriter(arquivoFiltradoFormatado));
            String linhaLidaDoArquivo = null;
            if ((linhaLidaDoArquivo = leitorOtimizado.readLine()) != null) {
                escritor.println("Artist,Track,Danceability,Energy,Duration_min,Views,Likes");
            }
            linhaLidaDoArquivo = leitorOtimizado.readLine();
            while (linhaLidaDoArquivo != null) {
                String[] vetorColunas = linhaLidaDoArquivo.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                linhaLidaDoArquivo = leitorOtimizado.readLine();

                String artist = vetorColunas[0];
                String track = vetorColunas[1];
                String danceability = vetorColunas[4];
                String energy = vetorColunas[5];
                String durationMin = vetorColunas[13];
                String views = vetorColunas[16];
                String likes = vetorColunas[17];

                if (!artist.isEmpty() && !track.isEmpty() && !danceability.isEmpty() && !danceability.equals("0.0")
                        && !energy.isEmpty() && !energy.equals("0.0") && !durationMin.isEmpty() && !durationMin.equals("0.0")
                        && !views.isEmpty() && !views.equals("0.0") && !likes.isEmpty() && !likes.equals("0.0")) {
                    escritor.println(artist + "," + track + "," + danceability + "," + energy + "," + durationMin + "," + views + "," + likes);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.printf("Erro no nome do arquivo: %s.\n", e.getMessage());
        } catch (IOException e) {
            System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public void lerDoArquivoCsv(ColecaoDeMusicas colecao){
        String arquivoBruto = "C:\\\\Users\\\\Gabriel Torres\\\\Meu Drive (gabrielstorres08@gmail.com)\\\\Gabriel Torres\\\\IFF\\\\BSI\\\\BSI 5 Período\\\\Técnicas de Programação\\\\Atividade_28_08\\\\Projeto-A2-TP-2025-1\\\\cleaned_dataset.csv";
        FileReader leitor = null;
        BufferedReader leitorOtimizado = null;
        String linhaLidaDoArquivo = null;

        try{
            leitor = new FileReader(arquivoBruto);
            leitorOtimizado = new BufferedReader((leitor));
            linhaLidaDoArquivo = leitorOtimizado.readLine();
            while (linhaLidaDoArquivo != null) {
                String[] vetorColunas = linhaLidaDoArquivo.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                linhaLidaDoArquivo = leitorOtimizado.readLine();

                String artist = vetorColunas[0];
                String track = vetorColunas[1];
                String danceability = vetorColunas[4];
                String energy = vetorColunas[5];
                String durationMin = vetorColunas[13];
                String views = vetorColunas[16];
                String likes = vetorColunas[17];

                if (!artist.isEmpty() && !track.isEmpty() && !danceability.isEmpty() && !danceability.equals("0.0")
                        && !energy.isEmpty() && !energy.equals("0.0") && !durationMin.isEmpty() && !durationMin.equals("0.0")
                        && !views.isEmpty() && !views.equals("0.0") && !likes.isEmpty() && !likes.equals("0.0")) {
                    
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Erro no nome do arquivo: %s.\n", e.getMessage());
        } catch (IOException e) {
            System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public void escreverNoArquivoCsv(ColecaoDeMusicas colecao){
        PrintWriter escritor = null;
        String arquivoFiltradoFormatado = "C:\\Users\\Gabriel Torres\\Meu Drive (gabrielstorres08@gmail.com)\\Gabriel Torres\\IFF\\BSI\\BSI 5 Período\\Técnicas de Programação\\Atividade_28_08\\Projeto-A2-TP-2025-1\\filtered_dataset.csv";

        try{
            escritor = new PrintWriter(new FileWriter(arquivoFiltradoFormatado));
            escritor.println("Artist,Track,Danceability,Energy,Duration_min,Views,Likes");
            for (int i = 0; i < colecao.obterTotaldeMusicas(); i++) {
                Musica m = colecao.obterMusica(i);
                String linha = String.join(",",
                        m.getArtista(),
                        m.getFaixa(),
                        String.valueOf(m.getDancabilidade()),
                        String.valueOf(m.getEnergia()),
                        String.valueOf(m.getDuracaoMin()),
                        String.valueOf(m.getVisualizacoes()),
                        String.valueOf(m.getCurtidas())
                );
                escritor.println(linha);
            }

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }

    }
}
