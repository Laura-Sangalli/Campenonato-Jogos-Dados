public interface Estatistica {
    public static final short numFaces = (short) 6;

    public static int somarFacesSorteadas(Dado dados[]){
        int soma = 0;
        for(Dado dado: dados){
            soma += dado.getSideUp();
        }
        return soma;
    }

    public static boolean ganhouJogoGeneral(JogoGeneral jogoG){
        int soma=0;
        for(int i=1; i<=12; i++){
            soma += jogoG.getRodadas(i);
        }
        if(soma > 2*(jogoG.getRodadas(13))){
            return true;
        }
        return false;
    }
    
}
