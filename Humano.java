public class Humano extends Jogador implements JogarComoHumano{
    private String cpf, agencia, conta;
    private int numeroBanco;
    private JogoGeneral jogoG;
    private JogoAzar jogoA;

    public Humano(String nome, double saldo){
        super(nome, saldo);
        this.jogoG = new JogoGeneral(saldo);
        this.jogoA = new JogoAzar(saldo);
     }

    public void jogarDados(){
        int jogoEscolhido = Jogador.escolherJogo();

        if(jogoEscolhido == 1){ //jogoGeneral
            JogarComoHumano.escolherJogadas(jogoG);
        }
        else if(jogoEscolhido == 2){
            //jogoA.rolarDados();
            jogoA.resultado();            
        }
        else{
            System.out.println("Escolha um jogo válido");
        }
    }

}