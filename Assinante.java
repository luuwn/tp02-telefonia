public class Assinante{
    private long cpf;
    private String nome;
    private int numero;
    protected Chamada [] chamadas;
    protected int numChamadas;

    public Assinante(long cpf, String nome, int numero){
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[10];
        this.numChamadas = 0;

    }

    public long getCpf(){
        return cpf;
    }

    public String toString(){
        return "Nome: " + nome + "\nNúmero:" + numero;
    }

}
