
public class Main {

	//@SuppressWarnings("null")
	public static void main(String[] args) {
	
		cliente venilton = new cliente();
		venilton.setNome("venilton");
		
		
		conta cc = new contaCorrente(venilton);
		contaPoupanca poupanca = new contaPoupanca(venilton);
		

		cc.depositar(100);
		cc.transferir(50, poupanca);
		
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();		

		banco banco = new banco();
		System.out.println(banco.toString());
		
	}

}
