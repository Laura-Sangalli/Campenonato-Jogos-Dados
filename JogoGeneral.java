import java.io.Serializable;

public class JogoGeneral implements Serializable{
    private Dado dados[] = new Dado[5];
    private int rodadas[] = new int[13];

    public JogoGeneral(){//inicia o jodo general com a quantidade de dados e o numero de rodadas
        for(int i=0; i<5; i++){
            this.dados[i] = new Dado();
        }
        for(int i=0; i<13; i++){
            this.rodadas[i] = -1;
        }
    } 

    public int getRodadas(int pos){//retorna a rodada
        return rodadas[pos - 1];
    }

    public void resetarRodadas(){
        for(int i=0;i<13; i++){
            rodadas[i] = -1;
        }
    }

    public void rolarDados(){//joga os dados e obtem o resultado
        for(Dado dado : this.dados){
            dado.roll();
        }
    }

    public String toString(){
        String valores = "Os valores obtidos são: ";
        for (int i=0;i<5;i++){
             valores += this.dados[i].getSideUp() + " - ";
        } 
        return valores;
    }

    public boolean validarRodada(int rodadaAtual){//verifica se a rodada ja foi escolhida anteriormente
        if(rodadas[rodadaAtual - 1] == -1){
            return true;
        }         
        return false;
    }

    
    public void alterarSituacaoDaRodada(int rodadaAtual){//muda a rodada para indicar que a mesma ja foi escolhida
        if (rodadaAtual >= 1 && rodadaAtual <= 13) {
            rodadas[rodadaAtual - 1] = 0;
        }
    }

    public void resetarJogadaDaMaquina(int jogadaEscolhida){
        rodadas[jogadaEscolhida - 1] = -1;   
    }

    public int pontuarRodada(int escolha) {
        int soma = 0, cont;
        boolean deuCerto = true;//variavel para verificar se a função irá funcionar, ou seja, retornar um valor
    
        switch (escolha) {
            case 1://soma dos 1
                soma = 0;
                for (Dado dado : this.dados) {
                    if (dado.getSideUp() == 1)
                        soma += 1;
                }
                break;
            case 2://soma dos 2
                soma = 0;
                for (Dado dado : this.dados) {
                    if (dado.getSideUp() == 2)
                        soma += 2;
                }
                break;
            case 3://soma dos 3
                soma = 0;
                for (Dado dado : this.dados) {
                    if (dado.getSideUp() == 3)
                        soma += 3;
                }
                break;
            case 4://soma dos 4
                soma = 0;
                for (Dado dado : this.dados) {
                    if (dado.getSideUp() == 4)
                        soma += 4;
                }
                break;
            case 5://soma dos 5
                soma = 0;
                for (Dado dado : this.dados) {
                    if (dado.getSideUp() == 5)
                        soma += 5;
                }
                break;
            case 6://soma dos 6
                soma = 0;
                for (Dado dado : this.dados) {
                    if (dado.getSideUp() == 6)
                        soma += 6;
                }
                break;
            case 7://trinca
                soma = 0;
                for (int i = 1; i <= 6; i++) {
                    cont = 0;
                    for (Dado dado : this.dados) {//percorre os dados contando a quantidade de dados iguais
                        if (dado.getSideUp() == i)
                            cont++;
                    }
                    if (cont >= 3) {//se 3 numeros forem iguais retorna a soma dos numeros
                        for (Dado dado : this.dados) {
                            soma += dado.getSideUp();
                        }
                        break;
                    }
                }
                break;
            case 8://quadra
                soma = 0;
                for (int i = 1; i <= 6; i++) {
                    cont = 0;
                    for (Dado dado : this.dados) {
                        if (dado.getSideUp() == i)
                            cont++;
                    }
                    if (cont >= 4) {
                        for (Dado dado : this.dados) {
                            soma += dado.getSideUp();
                        }
                        break;
                    }
                }
                break;
            case 9://fullHouse
                int valor1 = -1, valor2 = -1, cont1=0, cont2=0;
                soma = 0;
                valor1 = dados[0].getSideUp();//como Full House tem apenas dois numeros o primeiro valor recebe o dado do primeiro dado
                for (Dado dado : this.dados) {
                    if (dado.getSideUp() != valor1 && valor2 == -1)//verifica se o valor 2 esta vazio para atualiza-lo
                        valor2 = dado.getSideUp();
                    else if(dado.getSideUp() == valor1){
                        cont1++;
                    }
                    else if(dado.getSideUp() == valor2){
                        cont2++;
                    }
                    if(cont1 == 2 && cont2 == 2){//os cont se igualam a 2 pois o primeiro dado ja é contado quando é atribuido a valor1
                        soma = 25;
                    }
                }
                break;
            case 10: // sequencia alta
                soma = 0;
                deuCerto = true;
                for (Dado dado : dados) {
                    if (dado.getSideUp() == 1){//sequencia alta não possui o numero 1
                        deuCerto = false;
                        soma = 0;
                        break;
                    }
                }
                for (int i = 2; i <= 6; i++) {
                    cont = 0;
                    for (Dado dado : dados) {
                        if (dado.getSideUp() == i)
                            cont++;
                    }
                    if (cont != 1){//se não tiver nenhum número repetido é sequência
                        soma = 0;
                        deuCerto = false;
                        break;
                    }
                }
                if(deuCerto == true)
                    soma = 30;
                break;
            case 11: // sequencia baixa
                soma = 0;
                deuCerto = true;
                for (Dado dado : dados) {
                    if (dado.getSideUp() == 6){
                        soma = 0;
                        deuCerto = false;
                        break;
                    }
                }
                for (int i = 1; i <= 5; i++) {
                    cont = 0;
                    for (Dado dado : dados) {
                        if (dado.getSideUp() == i){
                            cont++;
                        }
                    }
                    if (cont != 1){
                        soma = 0;
                        deuCerto = false;
                    }
                }
                if(deuCerto == true){
                    soma=40;
                }
                break;
            case 12: // general
                soma = 0;
                deuCerto = true;

                for (Dado dado : dados) {
                    if (dado.getSideUp() != dados[0].getSideUp()){//caso um numero seja diferente, não é general
                        soma = 0;
                        deuCerto = false;
                        break;
                    }
                }
                if(deuCerto == true)
                    soma = 50;
                break;
            case 13:
                soma = 0;
                for (Dado dado : this.dados)
                    soma += dado.getSideUp();
                break;
            default:
                System.out.println("jogada inválida!");
                break;
        }

        if (escolha >= 1 && escolha <= 13) {
                rodadas[escolha - 1] = soma;
        }
        return soma;
    }
    
}
