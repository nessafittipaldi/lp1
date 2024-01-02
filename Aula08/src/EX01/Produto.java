package EX01;

public class Produto {
	private String nome;
	private Double quantidade;
	private Double estoqueMinimo;
	private Double estoqueMaximo;
	
	
	public Produto(String nome, double quantidade, double estoqueMinimo, double estoqueMaximo) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.estoqueMaximo = estoqueMaximo;
		this.estoqueMinimo = estoqueMinimo;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public String getNome() {
		return nome;
	}

	public Double getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public Double getEstoqueMaximo() {
		return estoqueMaximo;
	}

}
