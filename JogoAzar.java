public class JogoAzar extends JogoDados{
    private Dado[] dados = new Dado[2];

    public JogoAzar(double saldo){
        super(2, "JogoAzar", saldo);
        for(int i=0; i<2; i++){
            this.dados[i] = new Dado();
        }
    }

    public String toString(){
        return super.toString();
    }

    public void resultado(){
        rolarDados();
        int res = dados[0].getSideUp() + dados[1].getSideUp();
        System.out.println("A soma é:" + res);
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
                rolarDados();
                res = dados[0].getSideUp() + dados[1].getSideUp();
                System.out.println(toString());
                System.out.println("A soma é:" + res);
                if(res == res1){
                    System.out.println("O jogador ganhou :)");
                    break;
                }
                else if(res == 2 || res == 3 || res == 12){
                    System.out.println("O jogador perdeu :(");
                    break;
                }
            }
        }
    }
}
