package EX03;

public class Cliente {
	
	private	int Codigo;
	private	String Endereco;
	private	String Telefone;
	
	
	protected void setCodigo(int Codigo) {
		this.Codigo = Codigo;
		System.out.println("Codigo cadastrado: " + this.Codigo);
		
	}
	
	protected void setEndereco(String Endereco) {
		this.Endereco = Endereco;
		System.out.println("Endereço cadastrado: " + this.Endereco);
	}
	
	protected void setTelefone(String Telefone) {
		this.Telefone = Telefone;
		System.out.println("Telefone cadastrado: " + this.Telefone);
	}
}
	
