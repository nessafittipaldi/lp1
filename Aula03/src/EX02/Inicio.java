package EX02;

public class Inicio {

	public static void main(String[] args) {

			Conta conta1 = new Conta();
			conta1.setId(1);
			conta1.setAgencia(1230);
			conta1.setnumeroConta("45666");
			conta1.setCliente("Vanessa", "222147564", "Rua Pedro Vincente", "aluno@ifsp.edu.br");

	        System.out.println("Dados da Conta:");
	        System.out.println("ID: " + conta1.getId());
	        System.out.println("Agência: " + conta1.getAgencia());
	        System.out.println("Número da Conta: " + conta1.getnumeroConta());
	        System.out.println("\nDados do Cliente:" + conta1.getCliente());
	    
	}

}
