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
            for(int i=0; i<12; i++){
                JogarComoMaquina.aplicarEstrategia(jogoG);
            }
            if(Estatistica.ganhouJogoGeneral(jogoG) == true){
                System.out.println("O jogador venceu o Jogo General :)\n");
            }
            else{
                System.out.println("O jogador perdeu o Jogo General :(\n");
            }
        }
        else if(jogoEscolhido == 1){
            jogoA.resultado();
        }

        
    }
}
