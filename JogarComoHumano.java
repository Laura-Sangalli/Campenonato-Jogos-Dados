import java.util.Scanner;

public interface JogarComoHumano {

    public static int escolherJogo(){
        int value;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe o número correspondente a qual jogo voce deseja apostar: \n1 - Jogo Azar; \n2 - Jogo General.");
        value = scanner.nextInt();
        scanner.close();

        if(value == 1 || value == 2){
            return value;
        }

        return 0;
    }

    public static void escolherJogada(JogoGeneral jogo){
        int value;
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