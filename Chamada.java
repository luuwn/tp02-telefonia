import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Chamada {
	private GregorianCalendar data;
	private int duracao;
	//private double custo;
	
	//public Chamada(GregorianCalendar data, int duracao, double custo) {
	public Chamada(GregorianCalendar data, int duracao) { //método construtor 
		this.data = data;
		this.duracao = duracao;
		//this.custo = custo;
	}
	
	public GregorianCalendar getData() {
		return this.data;
	}
	
	public int getDuracao() {
		return this.duracao;
	}
	
	//public double getCusto() {
	//	return this.custo;
	//}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM");
      	String dataFormatada = formato.format(data.getTime());
      	//return "Data: " + dataFormatada + ", Duração: " + duracao + " minutos, Custo: R$" + custo;
		return "Data: " + dataFormatada + " | Duração: " + duracao + " minutos ";

    }


}