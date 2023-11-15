public class Humano extends Jogador implements JogarComoHumano{
    private String cpf, agencia, conta;
    private int numeroBanco;

    public Humano(String nome, double saldo, String cpf, String agencia, String conta, int numeroBanco){
        super(nome, saldo);
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
    }
}