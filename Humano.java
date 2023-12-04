import java.util.Scanner;
import java.io.Serializable;

public class Humano extends Jogador implements JogarComoHumano, Serializable{
    //private String cpf, agencia, conta;
    private double saldo;
    private JogoGeneral jogoG;
    private JogoAzar jogoA;

    public Humano(String nome, double saldo, char tipo){
        super(nome, saldo, tipo);
        this.saldo = saldo;
        this.jogoA = new JogoAzar();
        this.jogoG = new JogoGeneral();
    }
    
    public void jogarDados(double aposta){
        int jogoEscolhido = escolherJogo();

        this.setApostas(aposta);

        System.out.println("JOGADOR(A) DA RODADA: " + this.getNome() + " (H)");

        if(jogoEscolhido == 2){ //jogoGeneral
            jogoG.resetarRodadas();
            for(int i=0; i<13; i++){
                jogoG.pontuarRodada(escolherJogadas());
                System.out.println(mostrarJogadasExecutadas(jogoG));
                System.out.println("==================================================================");
            }
            jogoG.resultado();
            if(jogoG.getResultadoFinal() == true){
                System.out.println("O jogador venceu o Jogo General :)\n");
                this.saldo += aposta;
            }
            else{
                System.out.println("O jogador perdeu o Jogo General :(\n");
                this.saldo -= aposta;
            }
            
            System.out.println("====== ESTATISTICAS DO JOGO ======");
            jogoG.analiseDeJogo();
            
            setJogo(jogoG);
            setSaldo(this.saldo); 
            System.out.println("\nSaldo: "+ getSaldo());
        }
        else if(jogoEscolhido == 1){
            
            jogoA.resultado();
            if(jogoA.getResultadoFinal() == true){
                this.saldo += aposta;
            }
            else{
                this.saldo -= aposta;
            }
            
            System.out.println("====== ESTATISTICAS DO JOGO ======");
            jogoA.analiseDeJogo();
            
            setJogo(jogoA);
            setSaldo(this.saldo);
            System.out.println("Saldo: "+ getSaldo());
        }
        else if(jogoEscolhido == 3){
            System.out.println("Saindo do jogo ...");
            return;
        }
        else{
            System.out.println("Escolha um jogo válido");
        }
        
    }

    public int escolherJogadas(){
        int value = 0;
        Scanner scanner = new Scanner(System.in);

        jogoG.rolarDados();
        System.out.print(jogoG);
        System.out.println("\nEscolha uma jogada:\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S+) 11(S-) 12(G) 13(X)");
        value = scanner.nextInt();
        // scanner.close();
        
        while(value<1 || value > 13){//value escolha uma opção que não seja uma jogada
            System.out.println("Jogada invalida, escolha um número entre 1 e 13");
            value = scanner.nextInt();
        }
        while ((value<1 || value > 13) || !jogoG.validarRodada(value)){//verificar se a jogada é valida
            System.out.println("Jogada inválida, escolha outro número:");
            value = scanner.nextInt();
        }

        return value;
    }
}