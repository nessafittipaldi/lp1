package A3EX03;

public class PessoaJuridica extends Cliente{
	
	private	String razaoSocial;
	private	String cnpj;
	
	
	public String getCnpj() {
		return cnpj;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		System.out.println("Razao Social cadastrado: " + this.razaoSocial);
	}
	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
		System.out.println("CNPJ cadastrado: " + this.cnpj);
	}

}
	

	