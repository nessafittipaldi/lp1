package EX01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Lista lista = new Lista();

        int opcao = 1;
        int posicao;
        String nome;
        
        
		Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir produto");
            System.out.println("2 - Inserir produto em posição específica");
            System.out.println("3 - Consultar produto (pelo nome)");
            System.out.println("4 - Consultar produto (pela posição)");
            System.out.println("5 - Substituir produto");
            System.out.println("6 - Remover produto (pelo nome)");
            System.out.println("7 - Remover produto (pela posição)");
            System.out.println("0 - Sair");

            try {
            	opcao = Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException e) {
            	System.out.println("Formato inválido!\n");
            	continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    System.out.println(lista.inserirProduto(scanner.nextLine()));
                    break;

                case 2:
                	System.out.println("Digite o nome do produto:");
                    nome = scanner.nextLine();
                    try {
                    	System.out.println("Digite a posição do produto:");
                        posicao = Integer.parseInt(scanner.nextLine());
                        System.out.println(lista.inserirProdutoPosicao(posicao, nome));
                    }catch (InputMismatchException | IndexOutOfBoundsException e) {
                    	System.out.println("Formato inválido ou posição inválida!\n");
                    }                                     
                    break;

                case 3:
                    System.out.println("Digite o nome do produto a ser consultado:");
                    System.out.println(lista.consultarProdutoPeloNome(scanner.nextLine()));
                    break;

                case 4:
                    System.out.println("Digite a posição do produto a ser consultado:");
                    try {
                    	posicao = Integer.parseInt(scanner.nextLine());
                    	System.out.println(lista.consultarProdutoPelaPosicao(Integer.parseInt(scanner.nextLine())));
                    }catch (InputMismatchException | IndexOutOfBoundsException e) {
                        System.out.println("Posição inválida.");
                    }
                        
                    break;

                case 5:
                    System.out.println("Digite o produto a ser substituído:");
                    nome = scanner.nextLine();

                    try {
                        System.out.println("Digite a posição do produto:");
                        posicao = Integer.parseInt(scanner.nextLine());
                        System.out.println(lista.substituirProduto(posicao, nome));
                    } catch (InputMismatchException | IndexOutOfBoundsException e) {
                        System.out.println("Posição inválida.");
                    }
                    break;


                case 6:
                    System.out.println("Digite o nome do produto a ser removido:");
                    nome = scanner.nextLine();
                    System.out.println(lista.removerProdutoPeloNome(scanner.nextLine()));
                    
                    break;

                case 7:
                	try {
                		System.out.println("Digite a posição do produto a ser removido:");
                		System.out.println(lista.removerProdutoPelaPosicao(Integer.parseInt(scanner.nextLine())));
                	} catch (InputMismatchException | IndexOutOfBoundsException e) {
                        System.out.println("Formato inválido ou posição inválida!\n");
                    }
                    
                    
                    break;

                default:
                	if (opcao != 0)
                		System.out.println("Opção inválida!\n");
                	else
                		System.out.println("Programa encerrado!");
                	break;
                }
            } while (opcao != 0);
        
        scanner.close();
    }
}
