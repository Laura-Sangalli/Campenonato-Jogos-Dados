import java.util.Random;

public class Maquina extends Jogador implements JogarComoMaquina{
    private JogoAzar jogoA;
    private JogoGeneral jogoG;
    private double saldo;
    private Random random;

    public Maquina(String nome, double saldo, char tipo){
        super(nome, saldo, tipo);
        this.saldo = saldo;
        jogoA = new JogoAzar();
        jogoG = new JogoGeneral();
        random = new Random();

    }

    public void jogarDados(double aposta){
        int jogoEscolhido = random.nextInt(2) + 1;

        System.out.println("JOGADOR(A) DA RODADA: " + this.getNome() + " (M)");
        if(jogoEscolhido == 2){
            for(int i=0; i<13; i++){
                aplicarEstrategia();
            }
            if(jogoG.ganhouJogoGeneral() == true){
                System.out.println("O jogador venceu o Jogo General :)\n");
                this.saldo += aposta;
            }
            else{
                System.out.println("O jogador perdeu o Jogo General :(\n");
                this.saldo -= aposta;
            }
            setSaldo(this.saldo);
            jogoG.resetarRodadas();
            System.out.println("Saldo: "+ String.format("%.2f", getSaldo()));
        }
        else if(jogoEscolhido == 1){
            if(jogoA.resultado() == true){
                this.saldo += aposta;
            }
            else{
                this.saldo -= aposta;
            }
            setSaldo(this.saldo);

            System.out.println("Saldo: "+ String.format("%.2f", getSaldo()));
        }
    }

    public void aplicarEstrategia(){
        int jogadaDeMaiorPontuacao;
        int maiorPontuacao =-1;

        jogadaDeMaiorPontuacao = 0;
        maiorPontuacao = -1;
        jogoG.rolarDados();
        System.out.println(jogoG);
        for(int i = 1; i<= 12; i++){
            if(jogoG.validarRodada(i)){
                if(jogoG.pontuarRodada(i) > maiorPontuacao){
                        jogadaDeMaiorPontuacao = i;
                        maiorPontuacao = jogoG.pontuarRodada(jogadaDeMaiorPontuacao);
                }
                jogoG.resetarJogadaDaMaquina(i);
            }
        } 
        if(jogadaDeMaiorPontuacao != 0){
            System.out.println("Jogada escolhida pela maquina: " + jogadaDeMaiorPontuacao);
            System.out.println("Pontuação obtida: " + jogoG.pontuarRodada(jogadaDeMaiorPontuacao));
            mostrarJogadasExecutadas(jogoG);
            System.out.println("==================================================================");
            
        }
        else{
            System.out.println("==================================================================");
            System.out.println("Jogada escolhida pela maquina: " + 13);
            System.out.println("Pontuação obtida: " + jogoG.pontuarRodada(13));
            mostrarJogadasExecutadas(jogoG);
            System.out.println("==================================================================");
        }
    }
}
