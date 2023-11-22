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
        this.jogoG = new JogoGeneral(saldo, nome);
    }
    
    public void jogarDados(){
        int jogoEscolhido = Jogador.escolherJogo();


<<<<<<< HEAD
        if(jogoEscolhido == 1){ //jogoGeneral         
            JogoG.escolherJogadas();
        }
        else if(jogoEscolhido == 2){ //jogo azar
            jogoA.resultado();            
=======
        if(jogoEscolhido == 1){ //jogoGeneral
            escolherJogadas();
        }
        else if(jogoEscolhido == 2){
            jogoA.rolarDados();
            jogoA.resultado();
>>>>>>> 5d3265b9fb0eea02e0b84579cfd695371b0a0035
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