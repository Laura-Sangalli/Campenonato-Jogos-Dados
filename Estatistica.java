public interface Estatistica {
    public static final short numFaces = (short) 6;

    public static int somarFacesSorteadas(Dado dados[]){
        int soma = 0;
        for(Dado dado: dados){
            soma += dado.getSideUp();
        }
        return soma;
    }
    
}
