public abstract class JogoDados implements Estatistica{
    private int numDados;
    private String nomeJogo;
    private double saldo;
    Dado[] dados;

    public JogoDados(int numDados, String nomeJogo) {
        this.numDados = numDados;
        this.nomeJogo = nomeJogo;
        this.dados = new Dado[numDados];
        for (int i = 0; i < numDados; i++) {
            this.dados[i] = new Dado();
        }
    }

    public int somarFacesSorteadas(){
        int soma = 0;
        for(Dado dado: dados){
            soma += dado.getSideUp();
        }
        return soma;
    }

    public void rolarDados(){//joga os dados e obtem o resultado
        System.out.println(dados[0]);
        
        for(Dado dado : this.dados){
            dado.roll();
        }
    }

    public String toString(){
  
        String valores = "Os valores obtidos são: ";
        for (int i=0;i<numDados - 1;i++){
             valores += this.dados[i].getSideUp() + " - ";
        } 
        valores += this.dados[numDados - 1].getSideUp();
        return valores;

    }


}