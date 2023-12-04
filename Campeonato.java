import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Campeonato{
    private Jogador jogadores[];
    private double saldo;
    //private String cpf;
    Scanner teclado = new Scanner(System.in);

    // método construtor
    public Campeonato(){
        this.jogadores = new Jogador[10];
        this.saldo = 100;

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

    }


    public void iniciarCampeonato(){
        // antes de iniciar o campeonato é fundamental adicionar ao menos um jogador
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

    // apresenta a estatística para todos os jogadores
    public int[] estatisticaCampeonatoJogadores(int escolha){
        int estatistica[] = new int[6];

        for(Jogador jogador : jogadores){
            if(jogador != null){
                if(escolha == 1){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogador()[i];
                    }
                }
                else if(escolha == 2){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogoAzarPara1Player()[i];
                    }   
                }
                else if (escolha == 3){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogoGeneralPara1Player()[i];
                    }
                }
            }
            
        }

        return estatistica;
    }

    // apresenta a estatística dos jogos dos humanos
    public int[] estatisticaCampeonatoHumanos(int escolha){
        int estatistica[] = new int[6];

        for(Jogador jogador : jogadores){
            if(jogador != null && jogador instanceof Humano){
                if(escolha == 1){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogador()[i];
                    }   
                }
                else if(escolha == 2){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogoAzarPara1Player()[i];
                    }   
                }
                else if (escolha == 3){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogoGeneralPara1Player()[i];
                    }
                }
            }
            
        }

        return estatistica;
    }

    // apresenta a estatística dos jogos dos humanos
    public int[] estatisticaCampeonatoMaquinas(int escolha){
        int estatistica[] = new int[6];

        for(Jogador jogador : jogadores){
            if(jogador != null && jogador instanceof Maquina){
                if(escolha == 1){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogador()[i];
                    }   
                }
                else if(escolha == 2){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogoAzarPara1Player()[i];
                    }   
                }
                else if (escolha == 3){
                    for(int i =0; i<6; i++){
                        estatistica[i] += jogador.estatisticaTotalJogoGeneralPara1Player()[i];
                    }
                }
            }
        }
        
        return estatistica;
    }

    // imprime o saldo, com a opção de escolher para qual tipo de jogador e tipo de jogo deseja fazê-lo
    public void imprimirSaldo(){
        int escolha = 0;

        // opção de escolher para quais jogadores quer imprimir o saldo 
        while (escolha != 1 && escolha != 2 && escolha != 3) {
            System.out.println("1 - Saldo de todos os jogadores\n2 - Saldo dos jogadores humanos\n3 - Saldo dos jogadores maquinas");
            escolha = teclado.nextInt();
    
            // verificação da escolha
            if(escolha != 1 && escolha != 2 && escolha != 3){
                System.out.println("Valor invalido");
            }
        }

        // busca-se realizar a opção escolhida
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
                if(jogadores[i] != null && (jogadores[i].getTipo() == 'h' || jogadores[i].getTipo() == 'H')){
                    System.out.println("Jogador " + i);
                    System.out.println(String.format("%.2f", jogadores[i].getSaldo()) + "\n");
                }
            }
        }

        else{
            for(int i = 0; i<10;i++){
                if(jogadores[i] != null && (jogadores[i].getTipo() == 'm' || jogadores[i].getTipo() == 'M')){
                    System.out.println("Jogador " + i);
                    System.out.println(String.format("%.2f", jogadores[i].getSaldo()) + "\n");
                }
            }
        }
    }

    // imprime o extrato de acordo com as características que o jogador deseja, para tipo de jogo e jogador
    public void imprimirExtrato(){
        int escolha = 0;
        int dadosExtrato = 0;
        // solicita-se para quais jogadores o usuário deseja visualizar o extrato e faz uma verificação da opção dada 
        while (escolha != 1 && escolha != 2 && escolha != 3) {
            System.out.println("1 - Extrato de todos os jogadores\n2 - Extrato dos jogadores humanos\n3 - Extrato dos jogadores maquinas");
            escolha = teclado.nextInt();
    
            if(escolha != 1 && escolha != 2 && escolha != 3){
                System.out.println("Valor invalido");
            }
        }

        // solicita-se para quais jogos o usuário deseja visualizar o extrato e faz uma verificação da opção dada 
        while (dadosExtrato != 1 && dadosExtrato != 2 && dadosExtrato != 3) {
            System.out.println("1 - Extrato de todos os jogos\n2 - Extrato do Jogo Azar \n3 - Extrato do Jogo General");
            dadosExtrato = teclado.nextInt();
    
            if(dadosExtrato!= 1 && dadosExtrato != 2 && dadosExtrato!= 3){
                System.out.println("Valor invalido");
            }
        }

        // switch case para efetuar a operação escolhida pelo usuário
        switch (escolha) {
            case 1: // extrato de todos os jogadores 
            {
                for(Jogador jogador : jogadores){
                    if(jogador != null){
                        System.out.println("JOGADOR " + jogador.getNome() +":   ");
                        jogador.extratoIndividual(dadosExtrato);
                    }
                }
                break;
            }
            case 2: { // extrato dos jogadores humanos 
                for(Jogador jogador : jogadores){
                    if(jogador != null && jogador instanceof Humano){
                        System.out.println("JOGADOR " + jogador.getNome() +":   ");
                        jogador.extratoIndividual(dadosExtrato);
                    }
                }
                break;
            }
            case 3: { // extrato das maquinas
                for(Jogador jogador : jogadores){
                    if(jogador != null && jogador instanceof Maquina){
                        System.out.println("JOGADOR " + jogador.getNome() +":   ");
                        jogador.extratoIndividual(dadosExtrato);
                    }
                }
                break;
            }
        
            default:
                break;
        }

    }

    // imprime a estatística do jogo, com opções para o usuário escolher quais estatísticas deseja visualizar
    public void imprimirEstatistica(){
        int estatistica[] = new int[6];
        int valor = 0;
        int tipo=0;
       while (tipo != 1 && tipo != 2 && tipo != 3) {
           System.out.println("Escolha para quais tipos de jogadores você deseja obter as estatísticas:\n1 - Todos;\n2 - Humanos;\n3 - Máquinas.");
           tipo = teclado.nextInt();

           if(tipo != 1 && tipo != 2 && tipo != 3){
               System.out.println("Valor inválido informado.");
           }
       }
       
       while(valor != 1 && valor != 2 && valor != 3 ){
           
           System.out.println("Escolha quais estatisticas deseja obter: \n1 - Estatística total campeonato;\n2 - Estatísitca total Jogo Azar\n3 - Estatística total Jogo General;");
           valor = teclado.nextInt();
           switch (tipo) {
               case 1:
                   estatistica = estatisticaCampeonatoJogadores(valor);
                   break;
               case 2:
                   estatistica = estatisticaCampeonatoHumanos(valor);
                   break;
               case 3: 
                   estatistica = estatisticaCampeonatoMaquinas(valor);
                   break;
               default:
                   System.out.println("Valor inválido informado.");
                   break;
           }
       }

       System.out.println("==================================================================");
       if(valor == 1){
            System.out.println("ESTATISTICAS TOTAIS DO CAMEPONATO");
       }
       else if(valor == 2){
            System.out.println("ESTATISTICAS TOTAIS JOGO AZAR");
       }
       else if(valor == 3){
            System.out.println("ESTATISTICAS TOTAIS JOGO GENERAL");
       }
       for(int i=0; i<6; i++){
            System.out.println("Dado de numero " + (i + 1) + ": " + estatistica[i]);
       }
    }

    public void gravarEmArquivo() {
        File arquivo = new File("cartela.dat");

        try {
            // o arquivo é criado
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            // grava o vetor de jogadores no arquivo
            oos.writeObject(jogadores);
            oos.flush();
            oos.close();
            fout.close();
        } 
        catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }
    }

    // método ler do arquivo
    public void lerDoArquivo() {
        File arquivo = new File("cartela.dat");

        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);
            // os objetos do arquivo são lidos
            // Corrigindo o casting e atribuindo ao vetor de jogadores
            jogadores = (Jogador[]) oin.readObject();
            oin.close();
            fin.close();

            // o vetor de jogadores é percorrido
            for (Jogador j : jogadores) {
                if (j != null) {
                    // Aqui você pode fazer algo com os jogadores lidos, por exemplo, imprimi-los
                    System.out.println("Nome: " + j.getNome() + ", Tipo: " + j.getTipo());
                }
            }
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }
    }
}
