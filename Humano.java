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
        for(int i=0; i<13; i++){    
            Scanner scanner = new Scanner(System.in);

            jogoG.toString();
            System.out.println("Informe o número correspondente a jogada que voce deseja executar: ");
            value = scanner.nextInt();
            // scanner.close();

            if(value >= 1 && value <= 13){
                if(jogoG.validarRodada(value)){
                    jogoG.pontuarRodada(value);
                }

            }
        }
    }

}