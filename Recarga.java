import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Recarga {
    private GregorianCalendar data;
    private float valor;
    
    public Recarga(GregorianCalendar data, float valor) {
        this.data = data;
        this.valor = valor;
    }
    
    public GregorianCalendar getData() {
        return data;
    }
    
    public float getValor() {
        return valor;
    }
    
    public String toString() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM");
        return "Data: " + formatoData.format(data.getTime()) + " | Valor: R$ " + valor;
    }
}