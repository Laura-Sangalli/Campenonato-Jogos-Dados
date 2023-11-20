import java.util.Scanner;

public interface JogarComoHumano {

    public static void escolherJogadas(JogoGeneral jogo){
        int value;
        for(int i=0; i<13; i++){    
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Informe o número correspondente a jogada que voce deseja executar: ");
            value = scanner.nextInt();
            scanner.close();

            if(value >= 1 && value <= 13){
                if(jogo.validarRodada(value)){
                    jogo.pontuarRodada(value);
                    }

            }
        }
    }
     
}