public abstract class JogoDados implements Estatistica{
    private int numDados;
    private String nomeJogo;
    private double saldo;
    private int estatistica[];
    Dado[] dados;

    public JogoDados(int numDados, String nomeJogo) {
        this.numDados = numDados;
        this.nomeJogo = nomeJogo;
        this.dados = new Dado[numDados];
        this.estatistica = new int[6];
        for (int i = 0; i < numDados; i++) {
            this.dados[i] = new Dado();
        }

        for(int i=0; i<6; i++){
            estatistica[i] = 0;
        }
    }

    public void analiseDeJogo(){
        for(int i=0; i<6; i++){
            System.out.println("DADO DE NUMERO " + (i + 1) + ": " + estatistica[i]);
        }
    }

    public void somarFacesSorteadas(int estatistica[]){
        for(Dado dado : dados){
            estatistica[dado.getSideUp() - 1] += 1;
        }
    }

    public void rolarDados(){//joga os dados e obtem o resultado
        System.out.println(dados[0]);
        
        for(Dado dado : this.dados){
            dado.roll();
        }
        this.somarFacesSorteadas(this.estatistica);
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