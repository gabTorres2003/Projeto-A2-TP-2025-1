public class TesteListaEncadeada {

    public static void main(String[] args) {
        ColecaoDeMusicas lista = new ListaDeMusicas();

        Musica m1 = new Musica("Zeca Padoginho", "Deixa a vida me levar", 0.99, 0.9, 5.90, 2000000, 15000000);
        Musica m2 = new Musica("Gilberto Gil", "Luz do Tieta", 0.99, 0.9, 5.90, 2000000, 15000000);

        lista.adicionarMusica(m1);
        lista.adicionarMusica(m2);

        System.out.println(lista.obterTotaldeMusicas());
        System.out.println(lista.obterMusica(0));
        System.out.println(lista.obterMusica(1));
        
        lista.excluirMusica("Deixa a vida me levar");
        System.out.println(lista.obterTotaldeMusicas());
        System.out.println(lista.obterMusica(0));
        
    }

}
