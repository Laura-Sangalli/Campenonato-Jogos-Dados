import java.util.Scanner;

public class UsaCampeonato {
    private static Campeonato campeonato;

    public static void main(String[] args) {
        campeonato = new Campeonato();
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n\tMenu");
            System.out.println("1 - Adicionar Jogador.");
            System.out.println("2 - Remover Jogador.");
            System.out.println("3 - Começar o jogo.");
            System.out.println("4 - Mostrar Tabela.");
            System.out.println("5 - Gravar dados.");
            System.out.println("6 - Ler dados.");
            System.out.println("7 - Sair.\n");

            opcao = 0;
            System.out.print("Escolha uma opção:");
            opcao = teclado.nextInt();


            switch (opcao) {
                case 1:
                    campeonato.incluirJogador();
                    break;
                case 2:
                    campeonato.removerJogador();
                    break;
                case 3:
                    campeonato.iniciarCampeonato();
                    break;
                /*case 4:
                    System.out.println(campeonato.mostrarCartela());
                    break;
                case 5:
                    campeonato.gravarEmArquivo();
                    break;
                case 6:
                    campeonato.lerDoArquivo();
                    break;                  
                case 7:
                    System.out.println("Encerrando o programa.");
                    break;*/
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);

        teclado.close();
    }
}
