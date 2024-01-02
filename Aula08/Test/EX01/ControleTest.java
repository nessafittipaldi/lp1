package EX01;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ControleTest {

	@Test
	public void  deveRetornarProdutosComEstoqueInsuficiente() {
		//fail("Estoque Insuficiente");
		Estoque estoque = new Estoque("Pinheiros");
		estoque.armazena(new Produto("caneta", 7, 10, 30));
		estoque.armazena(new Produto("caderno", 10, 5, 20));
        estoque.armazena(new Produto("mochila", 15, 5, 10));
        
		
		Controle controle = new Controle();
		controle.controlaEstoques(estoque);
		
		List<Produto> insuficiente = controle.getProdutosComEstoqueInsuficiente();
		
        assertEquals(1, insuficiente.size());
	}
	
	@Test
	public void deveRetornarProdutosComEstoqueExcedente() {
		//fail("Estoque Excedente");
		Estoque estoque = new Estoque("Pinheiros");
		estoque.armazena(new Produto("caneta", 20, 10, 30));
		estoque.armazena(new Produto("caderno", 10, 5, 20));
        estoque.armazena(new Produto("mochila", 15, 5, 10));
        
		Controle controle = new Controle();
        controle.controlaEstoques(estoque);

        List<Produto> excedente = controle.getProdutosComEstoqueExcedente();
        assertEquals(1, excedente.size());
        
	}
	
	@Test
	public void deveRetornarProdutosComEstoqueZerado() {
		Estoque estoque = new Estoque("Pinheiros");
		estoque.armazena(new Produto("caneta", 20, 10, 30));
		estoque.armazena(new Produto("caderno", 10, 5, 20));
        estoque.armazena(new Produto("mochila", 0, 3, 10));
		
		Controle controle = new Controle();
        controle.controlaEstoques(estoque);

        List<Produto> zerado = controle.getProdutosComEstoqueZerado();
        assertEquals(1, zerado.size());
		
	}
	
	@Test
	public void deveRetornarProdutosComEstoqueAdequado() {
		Estoque estoque = new Estoque("Pinheiros");
		estoque.armazena(new Produto("caneta", 20, 10, 30));
		estoque.armazena(new Produto("caderno", 10, 5, 20));
        estoque.armazena(new Produto("mochila", 10, 5, 15));
        
        Controle controle = new Controle();
        controle.controlaEstoques(estoque);

        List<Produto> adequado = controle.getProdutosComEstoqueAdequado();
        assertEquals(3, adequado.size());
		
	}
	
	@Test
	public void deveRetornarTodasListasVaziasParaEstoqueSemProdutos() {
		Estoque estoque = new Estoque("Jardins");
		
		Controle controle = new Controle();
        controle.controlaEstoques(estoque);
        
        List<Produto> insuficiente = controle.getProdutosComEstoqueInsuficiente();
        List<Produto> excedente = controle.getProdutosComEstoqueExcedente();
        List<Produto> zerado = controle.getProdutosComEstoqueZerado();
        List<Produto> adequado = controle.getProdutosComEstoqueAdequado();

        assertEquals(0, insuficiente.size());
        assertEquals(0, excedente.size());
        assertEquals(0, zerado.size());
        assertEquals(0, adequado.size());
        
       
		
	}
	
	@Test
	public void deveRetornarListaVaziaParaEstoqueQueNaoContemProdutosComEstoqueZerado() {
		Estoque estoque = new Estoque("Pinheiros");
		estoque.armazena(new Produto("caneta", 20, 10, 30));
		estoque.armazena(new Produto("caderno", 10, 5, 20));
        estoque.armazena(new Produto("mochila", 15, 5, 10));
        
        Controle controle = new Controle();
        controle.controlaEstoques(estoque);

        List<Produto> zerado = controle.getProdutosComEstoqueZerado();
        assertEquals(0, zerado.size());
		
	}

}
