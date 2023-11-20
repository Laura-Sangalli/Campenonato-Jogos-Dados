public abstract class Jogador {
    private String nome;
    private double saldo;
    private JogoDados[] jogos = new JogoDados[10];

    public Jogador(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
     
    }

    public void jogarDados(int jogoEscolhido){
        // jogoEscolhido == 1 : jogoGeneral
        // jogoEscolhido == 2 : jogoAzar
        for(JogoDados jogo : jogos){
            
        }
    }

    public String toString(){
        String str = "";

        return str;
    }

    public void mostraJogadasExecutadas(){
        
    }

    public void atualizaSaldo(double saldo){
        this.saldo = saldo;

    }

    public double getSaldo(){ return this.saldo;}

}
