import java.util.GregorianCalendar;

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

	public void fazerChamada(GregorianCalendar data, int duracao) {
		if(numChamadas < chamadas.length) {
			float custo = duracao * 1.45f;
			if(creditos > custo){
				Chamada call = new Chamada(data, duracao);
				chamadas[numChamadas] = call;
				numChamadas++;
				creditos -= custo;
				System.out.println("CHAMADA FEITA COM SUCESSO");
			} else {
				System.out.println("NÃO HÁ CRÉDITOS SUFICIENTES");
			  } 
		} else {
			System.out.println("O NÚMERO DE CHAMADAS MÁXIMO FOI ATINGIDO");
		  }
	}

	public void recarregar(GregorianCalendar data, float valor) {
		if(numRecargas < recargas.length){
			Recarga recar = new Recarga(data, valor);
			recargas[numRecargas] = recar;
			numRecargas++;
			creditos += valor;

		} else {
			System.out.println("O NÚMERO DE RECARGAS MÁXIMO FOI ATINGIDO");
		  }
	}
}