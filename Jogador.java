import java.util.Scanner;

public abstract class Jogador {
    private String nome;
    private double saldo;
    private JogoDados[] jogos = new JogoDados[10];

    public Jogador(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
     
    }

    public static int escolherJogo(){
        int value=0;
        Scanner scanner = new Scanner(System.in);
            
        while(value != 1 || value != 2){   
            System.out.println("Informe o número correspondente a qual jogo voce deseja apostar: \n1 - Jogo Azar; \n2 - Jogo General.");
            value = scanner.nextInt();
            scanner.close();

            if(value != 1 || value != 2){
                System.out.println("O valor innformado eh invalido!");
            }
        }

        return value;
        
    }

    public abstract void jogarDados();

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
