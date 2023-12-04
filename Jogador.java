import java.io.Serializable;
import java.util.Scanner;

// Classe abstrata que representa um jogador genérico
public abstract class Jogador implements Serializable{
    private String nome;
    private double saldo;
    private JogoDados jogos[];
    private double apostas[];
    private char tipo;
    private int rodadas;

    // Construtor que inicializa os atributos básicos do jogador
    public Jogador(String nome, double saldo, char tipo){
        this.nome = nome;
        this.saldo = saldo;    
        this.tipo = tipo; 
        this.apostas = new double[10];
        jogos = new JogoDados[10];
        rodadas = 0; 
    }

    // Método para permitir ao jogador escolher um jogo (JogoAzar, JogoGeneral, ou sair)
    public int escolherJogo(){
        int value = 0; 
        Scanner scanner = new Scanner(System.in);
            
        while (value != 1 && value != 2){   
            System.out.println("Informe o número correspondente a qual jogo você deseja apostar: \n1 - Jogo Azar; \n2 - Jogo General; \n3 - Sair do campeonato.");
            value = scanner.nextInt();
            
            if (value != 1 && value != 2){
                System.out.println("O valor informado é inválido!");
            } 
        }

        return value;   
    }

    // Método abstrato que deve ser implementado nas subclasses para simular os jogos de dados
    public abstract void jogarDados(double aposta);

    // Método para mostrar as jogadas executadas no JogoGeneral
    public String mostrarJogadasExecutadas(JogoGeneral jogoG){

        String string = new String();
        string += "\n 1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S+) 11(S-) 12(G) 13(X)\n";

        int pontuacao;
        for (int i = 1; i <= 13; i++){
            if (jogoG.getRodadas(i) == -1){
                string += " -";
            } else {
                pontuacao = jogoG.getRodadas(i);
                string += " " + pontuacao;
            }
        }
        //System.out.println(string);

        return string;
    }

    // Método para calcular estatísticas totais do jogador
    public int[] estatisticaTotalJogador(){
        int estatistica[] = new int[6];
        
        for(int i=0; i<6; i++){
            estatistica[i] = 0;
        }
        
        System.out.println("== ESTATISTICA TOTAL JOGADOR ==");
        
        for(JogoDados jogo : jogos){
            if(jogo != null){
                for(int i=0; i<6; i++){
                    estatistica[i] += jogo.getEStatistica()[i];
                }
            }
        }
        
        for(int i=0; i<6; i++){
            
            System.out.println(estatistica[i]);
        }

        return estatistica;

    }

    // Método para calcular estatísticas totais do JogoGeneral para o jogador
    public int[] estatisticaTotalJogoGeneralPara1Player(){
        int estatistica[] = new int[6];

        for(int i=0; i<6; i++){
            estatistica[i]=0;
        }

        for(JogoDados jogo : jogos){
            if(jogo != null && jogo instanceof JogoGeneral){
                for(int i=0; i<6; i++){
                    estatistica[i] += jogo.getEStatistica()[i];
                }
            }
        }

        return estatistica;
    }

    // Método para calcular estatísticas totais do JogoAzar para o jogador
    public int[] estatisticaTotalJogoAzarPara1Player(){
        int estatistica[] = new int[6];

        for(int i=0; i<6; i++){
            estatistica[i]=0;
        }

        for(JogoDados jogo : jogos){

            if(jogo != null && jogo instanceof JogoAzar){
                for(int i=0; i<6; i++){
                    estatistica[i] += jogo.getEStatistica()[i];
                }
            }
        }

        return estatistica;
    }

    // Método para atualizar o saldo do jogador
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    // Método para obter o saldo do jogador
    public double getSaldo(){ 
        return this.saldo;
    }

    // Método para obter o nome do jogador
    public String getNome(){
        return nome;
    }

    // Método para obter o tipo de jogador (H ou M)
    public char getTipo(){
        return tipo;
    }
    
    // Método para obter o número de rodadas jogadas
    public int getRodadas(){
        return rodadas;
    }

    // Método para definir o número de rodadas jogadas
    public void setRodadas(int rodadas){
        this.rodadas = rodadas;
    }

    public double getApostas(int pos) {
        return apostas[pos - 1];
    }

    public void setApostas(double valor){
        for(int i=0; i<10; i++){
            if(apostas[i] == 0.0){
                apostas[i] = valor;
                return;
            }
        }
    }

    // Método para definir o jogo atual do jogador
    public void setJogo(JogoDados jogo){
        for (int i = 0; i < 10; i++){
            if (jogos[i] == null){
                jogos[i] = jogo;
                return;
            }            
        }
    }

    public void extratoIndividual(int dadosExtrato){
        String extrato = new String();
        JogoGeneral jogo;
        switch (dadosExtrato) {
            case 1:{ // extrato de todos os jogos 
                for(int i=0; i<10; i++){
                    if(jogos[i] != null){
                        if(jogos[i] instanceof JogoGeneral){
                            jogo = (JogoGeneral) jogos[i];
                            extrato += "\nJOGO GENERAL: ";
                            extrato += mostrarJogadasExecutadas(jogo) + "\n" ;
                        }
                        else{
                            extrato += "\nJOGO AZAR: \t";
                        }
                        
                        extrato += "Valor apostado: " + apostas[i] + "\t\t";

                        if(jogos[i].getResultadoFinal() == true){
                            extrato += "Situação do jogo: ganhou\n";
                        }
                        else if(jogos[i].getResultadoFinal() == false){
                            extrato += "Situação do jogo: perdeu\n";
                        }
                        else{
                            System.out.println("O jogador não jogou nenhum jogo");
                        }
                    }
                }
                break;
            }
            case 2:{ // extrato jogo azar
                for(int i=0; i<10; i++){
                    if(jogos[i] != null && jogos[i] instanceof JogoAzar){
                        extrato += "\nJOGO AZAR: \t";
                        extrato += "Valor apostado: " + apostas[i] + "\t\t";
                        
                        
                        if(jogos[i].getResultadoFinal() == true){
                            extrato += "Situação do jogo: ganhou\n";
                        }
                        else if(jogos[i].getResultadoFinal() == false){
                            extrato += "Situação do jogo: perdeu\n";
                        }
                        else{
                            System.out.println("O jogador não jogou o jogo Azar");
                        }
                    }
                }
                break;
            }
            case 3:{ // extrato jogo general
                for(int i=0; i<10; i++){
                    if(jogos[i] != null && jogos[i] instanceof JogoGeneral){
                        jogo = (JogoGeneral) jogos[i];
                        extrato += "\nJOGO GENERAL: ";
                        extrato += mostrarJogadasExecutadas(jogo);
                        
                        extrato += "\n" + "Valor apostado: " + apostas[i] + "\t\t";
                        
                        if(jogos[i].getResultadoFinal() == true){
                            extrato += "\nSituação do jogo: ganhou\n";
                        }
                        else if (jogos[i].getResultadoFinal() == false){
                            extrato += "\n Situação do jogo: perdeu\n";
                        }
                        else{
                            System.out.println("O jogador não jogou o jogo General");
                        }
                    }
                }
                break;
            }
            default:
            System.out.println("Valor invalido");
                break;
        }

        System.out.println(extrato);

    }
}