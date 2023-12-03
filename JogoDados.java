// Classe abstrata que representa um jogo de dados genérico
public abstract class JogoDados implements Estatistica{
    private int numDados;
    Dado[] dados;
    private int estatistica[];

    // Construtor que inicializa o jogo de dados com um número específico de dados e um nome
    public JogoDados(int numDados, String nomeJogo){
        this.numDados = numDados;
        this.dados = new Dado[numDados];
        this.estatistica = new int[6];

        // Inicializa os dados e a estatística
        for (int i = 0; i < numDados; i++){
            this.dados[i] = new Dado();
        }

        for (int i = 0; i < 6; i++){
            estatistica[i] = 0;
        }
    }

    // Método para realizar a análise do jogo e imprimir a estatística
    public void analiseDeJogo(){
        for (int i = 0; i < 6; i++) {
            System.out.println("DADO DE NUMERO " + (i + 1) + ": " + estatistica[i]);
        }
    }

    // Método para somar as faces sorteadas nos dados à estatística
    public void somarFacesSorteadas(int estatistica[]){
        for (Dado dado : dados) {
            estatistica[dado.getSideUp() - 1] += 1;
        }
    }

    // Método para rolar os dados e obter o resultado
    public void rolarDados(){
        System.out.println(dados[0]);

        // Rola cada dado
        for (Dado dado : this.dados){
            dado.roll();
        }

        // Atualiza a estatística com as faces sorteadas
        this.somarFacesSorteadas(this.estatistica);
    }

    // Método para representação de string do objeto
    public String toString(){
        String valores = "Os valores obtidos são: ";
        for (int i = 0; i < numDados - 1; i++) {
            valores += this.dados[i].getSideUp() + " - ";
        }
        valores += this.dados[numDados - 1].getSideUp();
        return valores;
    }

    // Método para obter a estatística do jogo
    public int[] getEStatistica() {
        return estatistica;
    }
}
