package EX02;

public class Conta {
	
	private	int id;
	private	int agencia;
	private	String numeroConta;
	private	Cliente cliente;
	
	public Conta() {
		cliente = new Cliente();
	}
	
	
	public String getCliente() {
		return cliente.getCliente();
	}
	public void setCliente(String nome, String cpf, String endereco, String email) {
		cliente.setCliente(nome, cpf, endereco, email);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public String getnumeroConta() {
		return numeroConta;
	}
	public void setnumeroConta(String nConta) {
		this.numeroConta = nConta;
	}

}
