public abstract class JogoDados implements Estatistica{
    private int numDados;
    private String nomeJogo;
    private double saldo;
    Dado[] dados;

    public JogoDados(int numDados, String nomeJogo, double saldo) {
        this.numDados = numDados;
        this.nomeJogo = nomeJogo;
        this.saldo = saldo;
        this.dados = new Dado[numDados];
        for (int i = 0; i < numDados; i++) {
            this.dados[i] = new Dado();
        }
    }

    public void rolarDados(){//joga os dados e obtem o resultado
        for(Dado dado : this.dados){
            dado.roll();
        }
    }

    public String toString(){
  
        String valores = "Os valores obtidos são: ";
        for (int i=0;i<numDados;i++){
             valores += this.dados[i].getSideUp() + " - ";
        } 
        return valores;

    }


}