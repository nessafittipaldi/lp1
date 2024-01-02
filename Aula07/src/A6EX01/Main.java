package A6EX01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Localizacao localizacao = new Localizacao();
		Lista lista = new Lista(localizacao);
		
		
		Scanner r = new Scanner(System.in);
	    System.out.println("Escolha o idioma (pt/en):");
	    String idioma = r.nextLine().toLowerCase();
	    localizacao.selecionarIdioma(idioma);

        int opcao = 1;
        int posicao;
        String nome;
        
        
		Scanner scanner = new Scanner(System.in);
	    
		
        
        do {
        	System.out.println(localizacao.getTexto("menu"));
            System.out.println(localizacao.getTexto("opcao1"));
            System.out.println(localizacao.getTexto("opcao2"));
            System.out.println(localizacao.getTexto("opcao3"));
            System.out.println(localizacao.getTexto("opcao4"));
            System.out.println(localizacao.getTexto("opcao5"));
            System.out.println(localizacao.getTexto("opcao6"));
            System.out.println(localizacao.getTexto("opcao7"));
            System.out.println(localizacao.getTexto("opcao0"));

            try {
            	opcao = Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException e) {
            	System.out.println("Formato inválido!\n");
            	continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println(localizacao.getTexto("mensagemNomeProduto"));
                    System.out.println(lista.inserirProduto(scanner.nextLine()));
                    
                    RegistroLog.registrar("O usuário solicitou a inserção de produto.");
                    break;

                case 2:
                	System.out.println(localizacao.getTexto("mensagemNomeProduto"));
                    nome = scanner.nextLine();
                    try {
                    	System.out.println(localizacao.getTexto("mensagemPosicaoProduto"));
                        posicao = Integer.parseInt(scanner.nextLine());
                        System.out.println(lista.inserirProdutoPosicao(posicao, nome));
                    }catch (InputMismatchException | IndexOutOfBoundsException e) {
                    	System.out.println(localizacao.getTexto("mensagemNomePosicaoInvalida"));
                    }     
                    
                    RegistroLog.registrar("O usuário solicitou a inserção de produto em posição específica.\n");
                    break;

                case 3:
                	System.out.println(localizacao.getTexto("mensagemNomeConsulta"));
                    System.out.println(lista.consultarProdutoPeloNome(scanner.nextLine()));
                    
                    RegistroLog.registrar("O usuário consultou um produto pelo nome\n");
                    break;

                case 4:
                	System.out.println(localizacao.getTexto("mensagemPosicaoConsulta"));
                    try {
                    	posicao = Integer.parseInt(scanner.nextLine());
                    	System.out.println(lista.consultarProdutoPelaPosicao(Integer.parseInt(scanner.nextLine())));
                    }catch (InputMismatchException | IndexOutOfBoundsException e) {
                    	System.out.println(localizacao.getTexto("mensagemNomePosicaoInvalida"));
                    }
                        
                    RegistroLog.registrar("O usuário consultou um produto pela posição\n");
                    break;

                case 5:
                	System.out.println(localizacao.getTexto("mensagemPosicaoSubstituir"));
                    nome = scanner.nextLine();

                    try {
                    	System.out.println(localizacao.getTexto("mensagemPosicaoSubstituir"));
                        posicao = Integer.parseInt(scanner.nextLine());
                        System.out.println(lista.substituirProduto(posicao, nome));
                    } catch (InputMismatchException | IndexOutOfBoundsException e) {
                        System.out.println(localizacao.getTexto("mensagemNomePosicaoInvalidaSubstituir"));
                    }
                    
                    RegistroLog.registrar("O usuário substituiu um produto\n");
                    break;


                case 6:
                	System.out.println(localizacao.getTexto("mensagemNomeRemover"));
                    nome = scanner.nextLine();
                    System.out.println(lista.removerProdutoPeloNome(scanner.nextLine()));
                    
                    RegistroLog.registrar("O usuário removeu um produto pelo nome\n");
                    break;

                case 7:
                	try {
                		System.out.println(localizacao.getTexto("mensagemPosicaoRemover"));
                		System.out.println(lista.removerProdutoPelaPosicao(Integer.parseInt(scanner.nextLine())));
                	} catch (InputMismatchException | IndexOutOfBoundsException e) {
                        System.out.println(localizacao.getTexto("mensagemPosicaoInvalidaRemover"));
                    }
                    
                	RegistroLog.registrar("O usuário removeu um produto pela posição\n");
                    break;

                default:
                	if (opcao != 0)
                		System.out.println(localizacao.getTexto("mensagemOpcaoInvalida"));
                	else
                		System.out.println(localizacao.getTexto("mensagemProgramaEncerrado"));
                	break;
                }
            } while (opcao != 0);
        r.close();
        scanner.close();
    }
	
}