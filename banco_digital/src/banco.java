import java.util.List;

public class banco {

	private List<cliente> clientes;
	private List<conta> contas;

	

	@Override
	public String toString() {
		return "banco [clientes=" + clientes + ", contas=" + contas + "]";
	}

	public List<conta> getContas() {
		return contas;
	}

	public void setContas(List<conta> contas) {
		this.contas = contas;
	}

	public List<cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
