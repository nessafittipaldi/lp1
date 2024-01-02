package EX01;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o código do produto:");
		int codigo = scanner.nextInt();
		
		System.out.println("Digite a descrição do produto:");
		scanner.nextLine();
		String descricao = scanner.nextLine();
		
		System.out.println("Digite o preço do produto:");
		float preco = scanner.nextFloat();
		
		System.out.println("O produto está ativo? (true/false):");
		boolean ativo = scanner.nextBoolean();
		
	
		Produto p = new Produto(codigo, descricao, preco, ativo);

		
		System.out.println("Código: " + p.getCodigo());
		System.out.println("Descrição: " + p.getDescricao());
		System.out.println("Preço: " + p.getPreco());
		System.out.println("Ativo: " + p.isAtivo());

		
		scanner.close();
		

	}

}
