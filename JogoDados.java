public abstract class JogoDados{
    int numDados;
    String nomeJogo;
    double saldo;
    Dado[] dados;

    public JogoDados(int numDados, String nomeJogo, double saldo) {
        this.numDados = numDados;
        this.nomeJogo = nomeJogo;
        this.saldo = saldo;
        this.dados = new Dado[numDados];
    }

    public void rolarDados(){//joga os dados e obtem o resultado
        for(Dado dado : this.dados){
            dado.roll();
        }
    }

    public abstract String toString();


}