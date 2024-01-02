package A3EX03;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PessoaFisica[] pessoasFisicas = new PessoaFisica[10];
        PessoaJuridica[] pessoasJuridicas = new PessoaJuridica[10];

        int codigoPF = 1;
        int codigoPJ = 1;
        int opcao;
        

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Inserir cliente");
            System.out.println("2 - Remover cliente");
            System.out.println("3 - Consultar clientes");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo de cliente (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipoCliente = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoCliente == 1) {
                        PessoaFisica novaPF = cadastrarPessoaFisica(scanner, codigoPF);
                        pessoasFisicas[codigoPF - 1] = novaPF;
                        codigoPF++;
                    } else if (tipoCliente == 2) {
                        PessoaJuridica novaPJ = cadastrarPessoaJuridica(scanner, codigoPJ);
                        pessoasJuridicas[codigoPJ - 1] = novaPJ;
                        codigoPJ++;
                    } else {
                        System.out.println("Cliente inválido.");
                    }
                    break;

                case 2:
                    System.out.println("Digite o tipo de cliente (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipoClienteRemover = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o código do cliente:");
                    int codigoRemover = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoClienteRemover == 1) {
                        pessoasFisicas[codigoRemover - 1] = null;
                    } else if (tipoClienteRemover == 2) {
                        pessoasJuridicas[codigoRemover - 1] = null;
                    } else {
                        System.out.println("Cliente inválido.");
                    }
                    break;

                case 3:
                    System.out.println("Pessoas Físicas cadastradas:");
                    for (PessoaFisica pf : pessoasFisicas) {
                        if (pf != null) {
                        	 System.out.println(pf.getNome() + " - CPF: " + pf.getCpf());
                        }
                    }

                    System.out.println("\nPessoas Jurídicas cadastradas:");
                    for (PessoaJuridica pj : pessoasJuridicas) {
                        if (pj != null) {
                        	System.out.println(pj.getRazaoSocial() + " - CNPJ: " + pj.getCnpj());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        
        

        scanner.close();   
    }
    
    
    private static PessoaFisica cadastrarPessoaFisica(Scanner scanner, int codigo) {
    	
    	
        PessoaFisica novaPF = new PessoaFisica();
        
        try {
        
        System.out.println("Digite o nome:");
        novaPF.setNome(scanner.nextLine());

        System.out.println("Digite o CPF:");
        novaPF.setCpf(scanner.nextLine());

        System.out.println("Digite o endereço:");
        novaPF.setEndereco(scanner.nextLine());

        System.out.println("Digite o telefone:");
        novaPF.setTelefone(scanner.nextLine());

        novaPF.setCodigo(codigo);
        
   
    	}catch(InputMismatchException e) {
    		System.out.println("Erro: Entrada inválida.");
  
    	}finally {
	        System.out.println("Cliente pessoa jurídica cadastrado.");
	    }

	    return novaPF;
    }

    private static PessoaJuridica cadastrarPessoaJuridica(Scanner scanner, int codigo) {
        
    	PessoaJuridica novaPJ = new PessoaJuridica();
    	
    	try {
        System.out.println("Digite a razão social:");
        novaPJ.setRazaoSocial(scanner.nextLine());

        System.out.println("Digite o CNPJ:");
        novaPJ.setCnpj(scanner.nextLine());

        System.out.println("Digite o endereço:");
        novaPJ.setEndereco(scanner.nextLine());

        System.out.println("Digite o telefone:");
        novaPJ.setTelefone(scanner.nextLine());

        novaPJ.setCodigo(codigo);

        
	    }catch(InputMismatchException e) {
			System.out.println("Erro: Entrada inválida.");
	
		}finally {
	        System.out.println("Cliente pessoa jurídica cadastrado.");
	    }

	    return novaPJ;
    
    }
}

