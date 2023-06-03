import java.util.GregorianCalendar;
import java.text.DecimalFormat;
 
public class PosPago extends Assinante {
 
	private float assinatura;
	 
	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	 
	}

	public void fazerChamada(GregorianCalendar data, int duracao) {
		if (numChamadas < chamadas.length) {
			Chamada call = new Chamada(data, duracao); 
			chamadas[numChamadas] = call; 
			numChamadas++;
    		System.out.println("CHAMADA FEITA COM SUCESSO");
		} else {
			System.out.println("DESCULPE, O NÚMERO MÁXIMO DE CHAMADAS FOI ATINGIDO");
		}
	}

	public void imprimirFatura(int mes) {
		double custoMensal = assinatura;
		System.out.println("CPF: " + getCpf() + "\n" + toString());
		for(int i = 0; i < chamadas.length; i ++) {
			if (chamadas[i] != null) {
				if(chamadas[i].getData().get(GregorianCalendar.MONTH) == (mes - 1)) {
					System.out.println(chamadas[i].toString()+"| Custo: "+chamadas[i].getDuracao()*1.04f);
					//custoMensal += chamadas[i].getCusto();
					custoMensal += (chamadas[i].getDuracao() * 1.04f);
				 
				}
			}
		}
		System.out.println("CUSTO DE CHAMADAS MENSAL: " + new DecimalFormat("#.##").format(custoMensal));
	}
 
}
