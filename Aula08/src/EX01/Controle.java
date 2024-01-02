package EX01;

import java.util.List;
import java.util.ArrayList;

public class Controle {
	private List<Produto> produtosComEstoqueInsuficiente;
	private List<Produto> produtosComEstoqueExcedente;
	private List<Produto> produtosComEstoqueZerado;
	private List<Produto> produtosComEstoqueAdequado;
	
	public Controle() {
		produtosComEstoqueInsuficiente = new ArrayList<Produto>();
		produtosComEstoqueExcedente = new ArrayList<Produto>();
		produtosComEstoqueZerado = new ArrayList<Produto>();
		produtosComEstoqueAdequado = new ArrayList<Produto>();
	}
	
	public void controlaEstoques(Estoque estoque) {
		
		for (Produto produto : estoque.getProduto()) {
			if(produto.getQuantidade()>produto.getEstoqueMaximo()) {
				produtosComEstoqueExcedente.add(produto);
			}else if(produto.getQuantidade()<produto.getEstoqueMinimo()) {
				produtosComEstoqueInsuficiente.add(produto);
			}
			
			if(produto.getQuantidade() >= produto.getEstoqueMinimo() &&
                    produto.getQuantidade() <= produto.getEstoqueMaximo()) {
             produtosComEstoqueAdequado.add(produto);
			}else if (produto.getQuantidade() == 0) {
				produtosComEstoqueZerado.add(produto);
			}
			
		}
		
		
	}
	
	public List<Produto> getProdutosComEstoqueInsuficiente() {
		return produtosComEstoqueInsuficiente;
	}
	public List<Produto> getProdutosComEstoqueExcedente() {
		return produtosComEstoqueExcedente;
	}
	public List<Produto> getProdutosComEstoqueZerado() {
		return produtosComEstoqueZerado;
	}
	public List<Produto> getProdutosComEstoqueAdequado() {
		return produtosComEstoqueAdequado;
	}
	

}
