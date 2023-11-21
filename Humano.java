public class Humano extends Jogador implements JogarComoHumano{
    private String cpf, agencia, conta;
    private int numeroBanco;
    private JogoGeneral jogoG;
    private JogoAzar jogoA;

    public Humano(String nome, double saldo, String cpf, String agencia, String conta, int numeroBanco){
        super(nome, saldo);
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
        this.jogoG = new JogoGeneral(saldo);
        this.jogoA = new JogoAzar(saldo);
     }

    public void jogarDados(){
        int jogoEscolhido = Jogador.escolherJogo();

<<<<<<< HEAD
        while(jogoEscolhido != 1 || jogoEscolhido != 2){
            if(jogoEscolhido == 1){ //jogoGeneral
                JogarComoHumano.escolherJogadas(jogoG);
            }
            else if(jogoEscolhido == 2){
                jogoA.rolarDados();
                jogoA.resultado();
            }
            else{
                System.out.println("Escolha um jogo válido");
            }
=======
        if(jogoEscolhido == 1){ //jogoGeneral
            
            JogarComoHumano.escolherJogadas(jogoG);
        }
        else if(jogoEscolhido == 2){
            jogoA.rolarDados();
            jogoA.resultado();
>>>>>>> 3ccc87848ce8e08b47816a7efc69542446e4cd15
        }
    }

}