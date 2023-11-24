import java.util.Scanner;

public class Humano extends Jogador implements JogarComoHumano{
    private String cpf, agencia, conta;
    private int numeroBanco;
    private JogoGeneral jogoG;
    private JogoAzar jogoA;

    public Humano(String nome, double saldo){
        super(nome, saldo);
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
        this.jogoA = new JogoAzar(saldo);
        this.jogoG = new JogoGeneral(getSaldo());
    }
    
    public void jogarDados(){
        int jogoEscolhido = Jogador.escolherJogo();

        System.out.println("JOGADOR(A) DA RODADA: " + this.getNome() + " (H)");

        if(jogoEscolhido == 2){ //jogoGeneral
            jogoG.resetarRodadas();
            escolherJogadas();
            jogoG.pontuarRodada(jogoEscolhido);
        }
        else if(jogoEscolhido == 1){
            jogoA.resultado();
        }
        else{
            System.out.println("Escolha um jogo válido");
        }
    }

    public void escolherJogadas(){
        int value;
        for(int i=0; i<13; i++){//pq o for?   
            Scanner scanner = new Scanner(System.in);

            jogoG.rolarDados();
            System.out.print(jogoG);
            System.out.println("\nEscolha uma jogada:\n 1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S+) 11(S-) 12(G) 13(X)");;
            value = scanner.nextInt();
            // scanner.close();

            while(value<=1 && value >= 13){//value escolha uma opção que não seja uma jogada
                System.out.println("Jogada invalida, escolha um número entre 1 e 13");
                value = scanner.nextInt();
            }

            while (!jogoG.validarRodada(value)){//verificar se a jogada é valida
                System.out.println("Jogada inválida, escolha outro número:");
                value = scanner.nextInt();
            }
            //devemos retornar? return jogoG.pontuarRodada(caso);
        }
    }

}