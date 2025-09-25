import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ManipulaDataset {
    
    public void lerDoArquivoCsv(ColecaoDeMusicas colecao){
        String arquivoBruto = "cleaned_dataset.csv";
        
        try(BufferedReader leitor = new BufferedReader(new FileReader(arquivoBruto))){
            leitor.readLine();
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] vetorColunas = linha.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

               try {
                    String artist = vetorColunas[0];
                    String track = vetorColunas[1];
                    double danceability = Double.parseDouble(vetorColunas[4]);
                    double energy = Double.parseDouble(vetorColunas[5]);
                    double durationMin = Double.parseDouble(vetorColunas[13]);
                    long views = (long) Double.parseDouble(vetorColunas[16]);
                    long likes = (long) Double.parseDouble(vetorColunas[17]);

                    Musica musica = new Musica(artist, track, danceability, energy, durationMin, likes, views);
                    colecao.adicionarMusica(musica);

               } catch (NumberFormatException e) {
                    System.err.println("Aviso: Linha ignorada por erro de formato numérico: " + linha);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Aviso: Linha ignorada por falta de colunas: " + linha);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Erro no nome do arquivo: %s.\n", e.getMessage());
        } catch (IOException e) {
            System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public void escreverNoArquivoCsv(ColecaoDeMusicas colecao){
        String arquivoFiltradoFormatado = "filtered_dataset.csv";

        try(PrintWriter escritor = new PrintWriter(new FileWriter(arquivoFiltradoFormatado))){
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
