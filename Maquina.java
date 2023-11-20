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
        
        if(jogoEscolhido == 1){
            JogarComoMaquina.aplicarEstrategia(jogoG);
        }
        else if(jogoEscolhido == 2){
            jogoA.rolarDados();
            jogoA.resultado();
        }
    }
}
