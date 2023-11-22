import java.util.Scanner;

public class Humano extends Jogador implements JogarComoHumano{
    private String cpf, agencia, conta;
    private int numeroBanco;
    private JogoGeneral jogoG = new JogoGeneral(100, agencia);
    private JogoAzar jogoA;

    public Humano(String nome, double saldo){
        super(nome, saldo);
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
        this.jogoA = new JogoAzar(saldo);
    }
    
    public void jogarDados(){
        int jogoEscolhido = Jogador.escolherJogo();

        if(jogoEscolhido == 1){ //jogoGeneral
            escolherJogadas();
        }
        else if(jogoEscolhido == 2){
            jogoA.rolarDados();
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
            scanner.close();

            if(value >= 1 && value <= 13){
                if(jogoG.validarRodada(value)){
                    jogoG.pontuarRodada(value);
                }

            }
        }
    }

}