public class Telefonia{
    private PrePgo [] prePagos;
    private PosPago [] posPagos;
    private int numPrePagos;
    private int numPosPagos;

    public Telefonia(){
        this.prePagos = new PrePago[10];
        this.posPagos = new PosPago[10];
        this.numPrePagos = 0;
        this.numPosPagos = 0;
    }

    public void cadastrarAssinante(){
        System.out.println("QUAL O TIPO DE ASSINANTE: \n1 - PRE-PAGO \n2 - POS-PAGO");
		int cad = scan.nextInt();
		if(cad == 1){
			if(numPrePagos<prePagos.length) {
				System.out.println("CPF:");
				long cpf = scan.nextLong();
				System.out.println("NOME:");
				String nome = scan.next();
				System.out.println("NÚMERO:");
				int numero = scan.nextInt();

				PrePago nante = new PrePago(cpf,nome,numero);
				
				prePagos[numPrePagos] = nante;
				
				numPrePagos ++;
			} else {
				System.out.println("NÃO HÁ MAIS ESPAÇO NO PRÉ-PAGOS");
			}
		}else if(cad == 2) {
			if(numPosPagos<posPagos.length){
				System.out.println("CPF:");
				long cpf = scan.nextLong();
				System.out.println("NOME:");
				String nome = scan.next();
				System.out.println("NÚMERO:");
				int numero = scan.nextInt();
				System.out.println("ASSINATURA:");
				float assinatura = scan.nextFloat();

				PosPago nante = new PosPago(cpf,nome,numero, assinatura);
				
				posPagos[numPosPagos] = nante;
				
				numPosPagos ++;
			} else {
				System.out.println("NÃO HÁ MAIS ESPAÇO NO POS-PAGOS");
			}
			
		}else {
			System.out.println("DIGITE UMA OPÇÃO VÁLIDA!");
		}
    }

   	public void listarAssinantes() {
		System.out.println("ASSINANTES PRÉ-PAGOS:");
		for(int i = 0; i < numPrePagos; i ++) {
			System.out.println(prePagos[i].toString());
		}
		System.out.println("ASSINANTES POS-PAGOS:");
		for(int i = 0; i < numPosPagos; i ++) {
			System.out.println(posPagos[i].toString());
		}
	}

	public void fazerChamada() {
		System.out.println("Tipo de assinante (1 - pré-pago, 2 - pós-pago): ");
        int tipoAssinante = scan.nextInt();
        if(tipoAssinante == 1 || tipoAssinante == 2) {
	        System.out.println("CPF do assinante: ");
	        long cpf = scan.nextLong();
	
	        if (tipoAssinante == 1) {
	            PrePago prePago = localizarPrePago(cpf);
	            if (prePago == null) {
	                System.out.println("Assinante pré-pago não encontrado.");
	                return;
	            }
	            System.out.println("Duração da chamada (em minutos): ");
	            int duracao = scan.nextInt();
	            System.out.println("Data da chamada (dd/MM): ");
	            String d1 = scan.next();
	            SimpleDateFormat d2 = new SimpleDateFormat("dd/MM");
	            Date d3;
				try {
					d3 = d2.parse(d1);
					GregorianCalendar data = new GregorianCalendar();
		            data.setTime(d3);
		            prePago.fazerChamada(data, duracao);
		    		//System.out.println("CHAMADA FEITA COM SUCESSO");
				} catch (ParseException e) {
	                System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM.");
				}
	            
	            
	            //REMOVER O CUSTO DE TODAS AS CLASSES
	            //TENTAR GERAR O CUSTO NO MOMENTO DA CHAMADA E SEMPRE QUE FOR CHAMADO
	        } else if (tipoAssinante == 2){
	        	PosPago posPago = localizarPosPago(cpf);
	            if (posPago == null) {
	                System.out.println("Assinante pos-pago não encontrado.");
	                return;
	            }
	            System.out.println("Duração da chamada (em minutos): ");
	            int duracao = scan.nextInt();
	            System.out.println("Data da chamada (dd/MM): ");
	            String d1 = scan.next();
	            SimpleDateFormat d2 = new SimpleDateFormat("dd/MM");
	            Date d3;
				try {
					d3 = d2.parse(d1);
					GregorianCalendar data = new GregorianCalendar();
		            data.setTime(d3);
		            posPago.fazerChamada(data, duracao);
		    		//System.out.println("CHAMADA FEITA COM SUCESSO"); ISSO É MELHOR NA CLASSE PREPAGO E POSPAGO
				} catch (ParseException e) {
	                System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM.");
					}
	        	}		 
    	} else {
        	System.out.println("DIGITE UMA OPÇÃO VÁLIDA!!!");
        }
    }

    private PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos;i++) {
        	if (prePagos[i].getCpf() == cpf) {
        		return prePagos[i];
        		}
        	}
        		return null;
    }
	
	private PosPago localizarPosPago(long cpf) {
        for (int i = 0; i < numPosPagos; i++) {
            if (posPagos[i].getCpf() == cpf) {
                return posPagos[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {}

}