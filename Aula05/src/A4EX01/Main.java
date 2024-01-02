package A4EX01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			int opcao;
			
			Pesquisa pesquisa = new Pesquisa();
			
			Scanner scanner = new Scanner(System.in);
			
			
			try {
				
				do {
					System.out.println("OPÇÕES:");
					System.out.println("1) Informar Texto");
					System.out.println("2) Bucar String");
					System.out.println("3) Buscar String no inicio");
					System.out.println("4) Buscar String no final");
					System.out.print("Digite uma opção (0 para sair): ");
					opcao = Integer.parseInt(scanner.nextLine());
					
				
				switch (opcao) {
					case 1:
						System.out.print("Informe o texto: ");
							String texto = scanner.nextLine();
		                    pesquisa.setTexto(texto);
		                    System.out.println("Texto informado.");
		                break;
						
					case 2:
						System.out.print("Informe a cadeia de caracteres: ");
							String cadeiaBusca = scanner.nextLine();
							String resultadoBusca = pesquisa.buscarString(cadeiaBusca);
							System.out.println(resultadoBusca);
					
						break;
					
					case 3:
						System.out.print("Busca no inicio: ");
							String cadeia = scanner.nextLine();
		                    PesquisaInicio pesquisaInicio = new PesquisaInicio();
		                    pesquisaInicio.setTexto(pesquisa.texto);
		                    System.out.println(pesquisaInicio.buscarString(cadeia));
                    break;
			
					
					case 4:
						System.out.print("Busca no fim: ");
							cadeia = scanner.nextLine();
		                    PesquisaFim pesquisaFim = new PesquisaFim();
		                    pesquisaFim.setTexto(pesquisa.texto);
		                    System.out.println(pesquisaFim.buscarString(cadeia));   
					break;
					
					case 0:
						System.out.println("Programa encerrado.");
						break;
						
					default:
                        throw new NumberFormatException("Opção inválida.");
                }
						System.out.println();
					} while (opcao != 0);
				
				}catch(NumberFormatException e){
					System.out.println("Ops... Opção inválida. Digite um número");
				}
						scanner.close();
				}

	

}
