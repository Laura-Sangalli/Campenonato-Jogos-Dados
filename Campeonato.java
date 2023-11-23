import java.util.Scanner;

public class Campeonato{
    private Jogador jogadores[] = new Jogador[10];
    private String cpf, conta, agencia;
    private int numeroBanco;
    private double saldo = 100;

    private static Scanner teclado = new Scanner(System.in);

    // verifica se o nome do jogador está presente na lista
    public boolean checarNome(String nome){
        for(int i = 0;i <10;i++){
            if(jogadores[i] != null && jogadores[i].getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    // verifica se o tipo de jogador informado é válido
    public boolean checarTipo(char hm){
        if(hm == 'H' || hm == 'h' || hm == 'm' || hm == 'M'){
            return true;
        }
        return false;
    }

    // adiciona um jogador à lista de jogadores 
    public void incluirJogador(){

        // escaneia o nome para o jogador fornecido pelo usuário 
        System.out.println("Digite o nome do jogador:");
        String nome = teclado.next();

        // verifica se o nome do jogador já foi inserido anteriormente. Não podem haver jogadores com nomes iguais
        if(checarNome(nome)==true){
            System.out.println("Nome já inserido");
        }

        // System.out.println("Digite o seu saldo:");
        // double saldo = teclado.nextDouble();

        /*System.out.println("Digite seu cpf:");

        System.out.println("Digite ");*/

        // solicita ao usuário o tipo de jogador que está sendo adicionado
        System.out.println("Digite o Tipo do Jogador (H/M)");
        char tipo = teclado.next().charAt(0);

        if(checarTipo(tipo) == false){
            System.out.println("Tipo invalido");
        }
        // verifica se o tipo do jogador informado é válido, ou seja, humano (h ou H) ou máquina (m ou M)

        // verifica a situação do vetor de jogadores 
        for(int i=0;i<10;i++){
            // se a posição for nula, inicializa uma instância da classe Jogador 
            if(jogadores[i] == null){
                if(tipo == 'H' || tipo == 'h'){
                    jogadores[i] = new Humano(nome, saldo);
                }
                else if(tipo == 'M' || tipo == 'm'){
                    jogadores[i] = new Maquina(nome, saldo);
                }
                System.out.println("Jogador inserido com sucesso");
                return;
            }

            // caso o vetor esteja completo (número limite de 10 jogadores atingido), é emitido um aviso ao usuário de que não é
            // possível adicionar mais jogadores
            if(i == 9 && jogadores[i]!=null){
                System.out.println("número maximo de jogadores já atingido");
                return;
            }
        }

    }

    // utilizada para remover um jogador quando assim for solicitado pelo usuário
    public void removerJogador(){

        // pede ao usuário o nome do jogador que deseja remover
        System.out.println("Digite o nome do jogador que você quer remover");
        String nome = teclado.next();

        // verifica se o nome do jogador informado pelo usuário está, de fato, listado. Caso não esteja, emite um aviso
        if(checarNome(nome) == false){
            System.out.println("Não há jogadores com esse nome");
        }

        // ... porém, se estiver, remove o jogador da lista
        else{
            for(int i=0;i<10;i++){
                // verifica se o jogador existe antes de removê-lo e comunicar sucesso da operação
                if(jogadores[i] != null && jogadores[i].getNome().equals(nome)){ 
                    jogadores[i] = null;
                    System.out.println("Jogador " + nome + " Removido\n");
                }
            }
        }

        //teclado.close();
    }

    public void iniciarCampeonato(){
        // antes de in
        double maiorSaldo = 0;
        while(maiorSaldo >= 0){
            for(int i=0;i<10;i++){
                if(jogadores[i] != null){
                    // if(jogadores[i] instanceof Humano){
                    // jogadores[i].jogarDados();
                    // } 
                    // else{
                    //     jogadores[i]
                    // }
                    jogadores[i].jogarDados();

                    if(jogadores[i].getSaldo() > maiorSaldo){
                        maiorSaldo = jogadores[i].getSaldo();
                    }
                }
            }
        }
        
    }

    public void mostrarCartela(){

    }

    public void gravarEmArquivo(){

    }

    public void lerDoArquivo(){
        
    }
}
