import java.util.GregorianCalendar;
import java.text.DecimalFormat;

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

	public void imprimirFatura(int mes) {
		float custoMensal = 0f;
		float recarMensal = 0f;
		System.out.println("CPF: " + getCpf() + "\n" + toString());
		System.out.println("FATURA CHAMADAS");
		for(int i = 0; i < chamadas.length; i ++) {
			if (chamadas[i] != null) {
				if(chamadas[i].getData().get(GregorianCalendar.MONTH) == (mes - 1)) {
					System.out.println(chamadas[i].toString()+"| Custo: "+chamadas[i].getDuracao()*1.04f);
					//custoMensal += chamadas[i].getCusto();
					custoMensal += (chamadas[i].getDuracao() * 1.45f);
				}
			}
		}
		System.out.println("FATURA RECARGAS:");
		for(int i = 0; i < recargas.length; i ++) {
			if (recargas[i] != null) {
				if(recargas[i].getData().get(GregorianCalendar.MONTH) == (mes - 1)) {
					System.out.println(recargas[i].toString());
					recarMensal += recargas[i].getValor();
				}
			}
		}
		System.out.println("CUSTO DE CHAMADAS MENSAL: " + new DecimalFormat("#.##").format(custoMensal));
		System.out.println("VALOR DE RECARGAS MENSAL: " + recarMensal);
	}
}