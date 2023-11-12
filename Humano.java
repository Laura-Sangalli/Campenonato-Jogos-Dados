public class Humano implements JogarComoHumano{
    private String cpf, agencia, conta;
    private int numeroBanco;

    public Humano(String cpf, String agencia, String conta, int numeroBanco){
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
    }
}