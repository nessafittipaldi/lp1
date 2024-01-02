package A3EX03;

public class PessoaFisica extends Cliente{
	
	private String nome;
	private	String cpf;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
		System.out.println("Nome cadastrado: " + this.nome);
	}

	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
		System.out.println("CPF cadastrado: " + this.cpf);
	}

}
