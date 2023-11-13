public class Jogador {
    private String nome;
    private double saldo;
    private JogoDados[] jogos = new JogoDados[10];
    private char tipoDeJogador;

    public Jogador(String nome, double saldo, char tipo){
        this.nome = nome;
        this.saldo = saldo;
        this.tipoDeJogador = tipo;
    }

    public void jogarDados(){
        jogos[0].rolarDados();
    }

    public String toString(){
        String str = "";

        return str;
    }

    public void mostraJogadasExecutadas(){
        System.out.println("\n 1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S+) 11(S-) 12(G) 13(X)");
        String string = "";
        int pontuacao;

        for(int i=1;i<=13;i++){
            if(jogoG.getRodadas(i) == -1){//se a jogada não foi iniciada
                string += " -";
            }
            else{
                pontuacao = jogoG.getRodadas(i);//se a jogada foi iniciada
                string += " " + pontuacao;
            }
        }
        System.out.println(string);
    }

    public String getNome(){
        return this.nome;
    }

}
