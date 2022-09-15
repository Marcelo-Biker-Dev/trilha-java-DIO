
public class contaCorrente extends conta {

	public contaCorrente(cliente client) {
		super(client);
		
	}
	@Override
	public void imprimirExtrato() {
		System.out.println();
		System.out.println("=== Extrato conta corrente ===");
		super.imprimirInfosComuns();

	}
	
	}
	

