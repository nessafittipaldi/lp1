package EX01;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private String loja;
	private List<Produto> produtos;
	
	public Estoque(String loja) {
		this.loja = loja;
		this.produtos = new ArrayList <Produto>();
	}
	
	public void armazena(Produto produto) {
		if (produto != null) {	
			produtos.add(produto);
		}
	}
	public List<Produto> getProduto() {
		return produtos;
	}

	public String getLoja() {
		return loja;
	}
	

}
