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


        if(jogoEscolhido == 1){ //jogoGeneral         
            JogoG.escolherJogadas();
        }
        else if(jogoEscolhido == 2){ //jogo azar
            jogoA.resultado();            
        }
        else{
            System.out.println("Escolha um jogo válido");
        }
    }

}