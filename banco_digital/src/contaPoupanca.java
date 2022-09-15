
public class contaPoupanca extends conta {	
	
	public contaPoupanca(cliente client) {
		super(client);
		
	}
	@Override
	public void imprimirExtrato() {
		System.out.println();
		System.out.println("=== Extrato conta Poupanca ===");
		super.imprimirInfosComuns();
	
	}
		
	}
