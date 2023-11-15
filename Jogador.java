public abstract class Jogador {
    private String nome;
    private double saldo;
    private JogoDados[] jogos = new JogoDados[10];

    public Jogador(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }

    public void jogarDados(){

    }

    public String toString(){
        String str = "";

        return str;
    }

    public void mostraJogadasExecutadas(){
        
    }

    public void atualizaSaldo(double saldo){
        
    }

}
