public class JogoAzar extends JogoDados{
    //private Dado[] dados = new Dado[2];
    
    public JogoAzar(){
        super(2, "JogoAzar");
    }

    public boolean resultado(){
        this.rolarDados();
        int res;
        System.out.print(this);
        res = dados[0].getSideUp() + dados[1].getSideUp();
        System.out.println("\n1A soma é:" + res);
        if(res == 7 || res == 11){
            System.out.println("O jogador ganhou :)");
        }
        else if(res == 2 || res == 3 || res == 12){
            System.out.println("O jogador perdeu :(");
        }
        else{
            int res1 = res;
            res = 0;
            while (res != res1 && res !=2 && res != 3 && res != 12) {
                System.out.println("Jogar Dados.\n");
                this.rolarDados();
                res = dados[0].getSideUp() + dados[1].getSideUp();
                System.out.println(this);
                System.out.println("A soma é:" + res);
                if(res == res1){
                    System.out.println("O jogador ganhou :)");
                    return true;
                }
                else if(res == 2 || res == 3 || res == 12){
                    System.out.println("O jogador perdeu :(");
                    return false;
                }
            }
        }
        return false;
    }
}
