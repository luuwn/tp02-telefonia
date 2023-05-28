public class Assinante{
    private long cpf;
    private String nome;
    private int numero;
    protected Chamadas [] chamadas;
    protected int numChamadas;

    public Assinante(long cpf, String nome, int numero){
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[10];
        this.numChamadas = 0;

    }

}