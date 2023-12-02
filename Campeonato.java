import java.util.Scanner;

public class Campeonato{
    private Jogador jogadores[];
    //private String cpf;
    private double saldo;
    Scanner teclado = new Scanner(System.in);

    public Campeonato(){
        this.jogadores = new Jogador[10];
        this.saldo = 100;
        //this.cpf = ""; 
    }

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
        while(checarNome(nome)==true){
            System.out.println("Nome já inserido, insira outro nome");
            nome = teclado.next();
        }

        //System.out.println("Digite seu cpf:");

        // solicita ao usuário o tipo de jogador que está sendo adicionado
        System.out.println("Digite o Tipo do Jogador (H/M)");
        char tipo = teclado.next().charAt(0);

        if(checarTipo(tipo) == false){
            while(checarTipo(tipo) == false){
                System.out.println("Tipo invalido, digite o Tipo do Jogador (H/M)");
                tipo = teclado.next().charAt(0);
            }
        }
        // verifica se o tipo do jogador informado é válido, ou seja, humano (h ou H) ou máquina (m ou M)

        // verifica a situação do vetor de jogadores 
        for(int i=0;i<10;i++){
            // se a posição for nula, inicializa uma instância da classe Jogador 
            if(jogadores[i] == null){
                if(tipo == 'H' || tipo == 'h'){
                    jogadores[i] = new Humano(nome, saldo, tipo);
                }
                else if(tipo == 'M' || tipo == 'm'){
                    jogadores[i] = new Maquina(nome, saldo, tipo);
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
        if(jogadores[0] == null){//verifica se tem algum jogador
            System.out.println("Adicione um jogador");
        }
        double maiorSaldo = 100;
        double aposta;
        if(maiorSaldo > 0){
            for(int i=0;i<10;i++){
                if(jogadores[i] != null && jogadores[i].getSaldo() > 0 && jogadores[i].getRodadas()<10){
                    if(jogadores[i].getTipo() == 'H' || jogadores[i].getTipo() == 'h'){
                        System.out.println("Digite o valor que deseja apostar");
                        aposta = teclado.nextDouble();

                        while(aposta <= 0 || aposta > jogadores[i].getSaldo()){
                            System.out.println("Aposta invalida digite outra aposta");
                            aposta = teclado.nextDouble();
                        }
                                        
                        jogadores[i].jogarDados(aposta);

                        jogadores[i].setSaldo(jogadores[i].getSaldo());
                        if(jogadores[i].getSaldo() < maiorSaldo){
                            maiorSaldo = jogadores[i].getSaldo();
                        }
                    }
                    else{
                        aposta = (jogadores[i].getSaldo() * 30) / 100;
                        System.out.println("O valor apostado foi: " + String.format("%.2f", aposta));
                                        
                        jogadores[i].jogarDados(aposta);

                        jogadores[i].setSaldo(jogadores[i].getSaldo());
                        if(jogadores[i].getSaldo() < maiorSaldo){
                            maiorSaldo = jogadores[i].getSaldo();
                        }
                    }
                    jogadores[i].setRodadas(jogadores[i].getRodadas() + 1);
                }
            }
            
            for(int i=0; i<10; i++){
                if(jogadores[i] != null)
                    jogadores[i].estatisticaTotalJogador();
            }

            
        }
    }

    public int[] estatisticaCampeonatoJogoAzar(){
        int estatistica[] = new int[6];

        for(Jogador jogador : jogadores){
            for(int i =0; i<6; i++){
                estatistica[i] += jogador.estatisticaTotalJogoAzarPara1Player()[i];
            }
        }

        

        return estatistica;
    }

    public int[] estatisticaCampeonatoJogoGeneral(){
        int estatistica[] = new int[6];

        for(Jogador jogador : jogadores){
            for(int i =0; i<6; i++){
                estatistica[i] += jogador.estatisticaTotalJogoGeneralPara1Player()[i];
            }
        }

        return estatistica;
    }

    public int[] estatisticaCampeonatoDeJogos(){
        int estatistica[] = new int[6];

        for(Jogador jogador : jogadores){
            if(jogador != null){
                for(int i =0; i<6; i++){
                estatistica[i] += jogador.estatisticaTotalJogador()[i];
                }
            }
        }
        
        return estatistica;
    }

    public void imprimirSaldo(){
        int escolha = 0;
        while (escolha != 1 && escolha != 2 && escolha != 3) {
            System.out.println("1 - Saldo de todos os jogadores\n2 - Saldo dos jogadores humanos\n3 - Saldo dos jogadores maquinas");
            escolha = teclado.nextInt();
    
            if(escolha != 1 && escolha != 2 && escolha != 3){
                System.out.println("Valor invalido");
            }
        }

        if(escolha == 1){
            for(int i = 0; i<10;i++){
                if(jogadores[i] != null){
                    System.out.println("Jogador " + i);
                    System.out.println(String.format("%.2f", jogadores[i].getSaldo()) + "\n");
                }
            }
        }

        else if(escolha == 2){
            for(int i = 0; i<10;i++){
                System.out.println("Jogador " + i);
                if(jogadores[i] != null && (jogadores[i].getTipo() == 'h' || jogadores[i].getTipo() == 'H')){
                    System.out.println(String.format("%.2f", jogadores[i].getSaldo()) + "\n");
                }
            }
        }

        else{
            for(int i = 0; i<10;i++){
                System.out.println("Jogador " + i);
                if(jogadores[i] != null && (jogadores[i].getTipo() == 'm' || jogadores[i].getTipo() == 'M')){
                    System.out.println(String.format("%.2f", jogadores[i].getSaldo()) + "\n");
                }
            }
        }
    }

    public void imprimirExtrato(){

    }

    public void imprimirEstatistica(){

    }

    public void gravarEmArquivo(){

    }

    public void lerDoArquivo(){
        
    }


}
