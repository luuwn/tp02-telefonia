public class PrePago extends Assinante{
	private Recarga [] recargas;
	private int numRecargas;
	private float creditos;
	
	public PrePago(long cpf, String nome, int numero){
		super(cpf, nome, numero);
		this.creditos = 0.0f;
		this.numRecargas = 0;
		this.recargas = new Recarga[10];
	}
}