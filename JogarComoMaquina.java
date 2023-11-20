public interface JogarComoMaquina {
    public static void aplicarEstrategia(JogoGeneral jogo){
        int jogadaDeMaiorPontuacao = 0;
        int maiorPontuacao = -1;
        for(int i = 1; i<= 12; i++){
            if(jogo.validarRodada(i) && (jogo.pontuarRodada(i) > maiorPontuacao)){
                    jogadaDeMaiorPontuacao = i;
                    jogo.resetarJogadaDaMaquina(i);
            }
        }
        
        if(jogadaDeMaiorPontuacao == 0){
            jogo.pontuarRodada(13);
        }
        else{
            jogo.pontuarRodada(jogadaDeMaiorPontuacao);
        }

    }
}
