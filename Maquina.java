public class Maquina extends Jogador implements JogarComoMaquina{
    private JogoAzar jogoA;
    private JogoGeneral jogoG;

    public Maquina(String nome, double saldo){
        super(nome, saldo);
        jogoA = new JogoAzar(saldo);
        jogoG = new JogoGeneral(saldo);

    }

    public void jogarDados(){
        int jogoEscolhido = Jogador.escolherJogo();

        System.out.println("JOGADOR(A) DA RODADA: " + this.getNome() + " (M)");
        if(jogoEscolhido == 2){
            for(int i=0; i<13; i++){
                aplicarEstrategia();
            }
            if(jogoG.ganhouJogoGeneral() == true){
                System.out.println("O jogador venceu o Jogo General :)\n");
            }
            else{
                System.out.println("O jogador perdeu o Jogo General :(\n");
            }
                jogoG.resetarRodadas();
        }
        else if(jogoEscolhido == 1){
            jogoA.resultado();
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
            
        }
        else{
            System.out.println("Jogada escolhida pela maquina: " + 13);
            System.out.println("Pontuação obtida: " + jogoG.pontuarRodada(13));
        }
    }
}
