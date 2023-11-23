public interface JogarComoMaquina {
    public static void aplicarEstrategia(JogoGeneral jogo){
        int jogadaDeMaiorPontuacao;
        int maiorPontuacao = -1;

        jogadaDeMaiorPontuacao = 0;
        for(int i = 1; i<= 12; i++){
            if(jogo.validarRodada(i) == true && (jogo.pontuarRodada(i) > maiorPontuacao)){
                    jogadaDeMaiorPontuacao = i;
                    jogo.resetarJogadaDaMaquina(i);
            }
        } 
        if(jogadaDeMaiorPontuacao != 0){
            jogo.pontuarRodada(jogadaDeMaiorPontuacao);
        }
        else{
            jogo.pontuarRodada(13);
        }

    }
}
