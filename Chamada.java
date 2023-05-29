import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Chamada {
	private GregorianCalendar data;
	private int duracao;
	
	
	public Chamada(GregorianCalendar data, int duracao) {  
		this.data = data;
		this.duracao = duracao;
		
	}
	
	public GregorianCalendar getData() {
		return this.data;
	}
	
	public int getDuracao() {
		return this.duracao;
	}
	
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM");
      	String dataFormatada = formato.format(data.getTime());
		return "Data: " + dataFormatada + " | Duração: " + duracao + " minutos ";

    }


}