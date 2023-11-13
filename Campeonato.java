import java.util.Scanner;

public class Campeonato {
    private Jogador jogadores[] = new Jogador[10];

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
        System.out.println("Digite o nome do jogador");
        String nome = teclado.next();

        // verifica se o nome do jogador já foi inserido anteriormente. Não podem haver jogadores com nomes iguais
        if(checarNome(nome)==true){
            System.out.println("Nome já inserido");
        }

        // solicita ao usuário o tipo de jogador que está sendo adicionado
        System.out.println("Digite o Tipo do Jogador (H/M)");
        double saldo = teclado.next().charAt(0);

        // verifica se o tipo do jogador informado é válido, ou seja, humano (h ou H) ou máquina (m ou M)

        // verifica a situação do vetor de jogadores 
        for(int i=0;i<10;i++){
            // se a posição for nula, inicializa uma instância da classe Jogador 
            if(jogadores[i] == null){
                jogadores[i] = new Jogador(nome, saldo);
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
                // verifica se o jogador existe antes de removê-lo e comunicao sucesso da operação
                if(jogadores[i] != null && jogadores[i].getNome().equals(nome)){ 
                    jogadores[i] = null;
                    System.out.println("Jogador " + nome + " Removido\n");
                }
            }
        }

        //teclado.close();
    }

    public void iniciarCampeonato(){
        // antes de iniciar o campeonato, reseta-se as jogadas para todos os jogadores existentes. Dessa forma elimina-se o risco de 
        //um jogador, humano ou máquina, continuar com as mesmas jogadas, pontuação e valores dos dados de campeonatos anteriores. Ou 
        //seja, pode-se jogar várias vezes com os mesmos jogadores (instâncias da classe Jogador) definidas
        for(Jogador jogador : jogadores){
            if(jogador != null){
                jogador.getReset();
            }
        }
        if(jogadores[0] == null){//verifica se tem algum jogador
            System.out.println("Adicione um jogador");
        }
        else{
            for(int i=0;i<13;i++){//numero de rodadas
                for(int j=0;j<10;j++){//numero de jogadores
                    if(jogadores[j] != null){
                        // os métodos atríbuidos a "jogador[j]" abaixo estão explicados na classe Jogador
                        System.out.println(jogadores[j].getNome() + " está rolando os dados");
                        jogadores[j].jogarDados();
                        jogadores[j].escolherJogadas();
                        jogadores[j].mostrarJogadasExecutadas();
                        System.out.println("\n\n");
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
