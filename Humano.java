public class Humano extends Jogador implements JogarComoHumano{
    private String cpf, agencia, conta;
    private int numeroBanco;
    private JogoGeneral jogoG;
    private JogoAzar jogoA;

    public Humano(String nome, double saldo){
        super(nome, saldo);
<<<<<<< HEAD
        this.jogoG = new JogoGeneral(saldo);
=======
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
>>>>>>> 480bdc56f7ceabc02026e3258fa97414bfab7579
        this.jogoA = new JogoAzar(saldo);
    }
    
    public void jogarDados(){
        int jogoEscolhido = Jogador.escolherJogo();


        if(jogoEscolhido == 1){ //jogoGeneral
            
            JogarComoHumano.escolherJogadas(jogoG);
        }
        else if(jogoEscolhido == 2){
<<<<<<< HEAD
            //jogoA.rolarDados();
            jogoA.resultado();            
=======
            jogoA.rolarDados();
            jogoA.resultado();
>>>>>>> 480bdc56f7ceabc02026e3258fa97414bfab7579
        }
        else{
            System.out.println("Escolha um jogo válido");
        }
    }

}