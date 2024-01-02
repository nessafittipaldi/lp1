package EX02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Retângulo");
            System.out.println("2 - Círculo");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a base do retângulo:");
                    double baseRetangulo = scanner.nextDouble();
                    System.out.println("Digite a altura do retângulo:");
                    double alturaRetangulo = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.println("Digite a cor do retângulo:");
                    String corRetangulo = scanner.nextLine();

                    Retangulo retangulo = new Retangulo(baseRetangulo, alturaRetangulo, corRetangulo);
                    double areaRetangulo = retangulo.calcularArea();
                    System.out.println("Área do retângulo: " + areaRetangulo + " - Cor: " + retangulo.getCor());
                    break;

                case 2:
                    System.out.println("Digite o raio do círculo:");
                    double raioCirculo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite a cor do círculo:");
                    String corCirculo = scanner.nextLine();

                    Circulo circulo = new Circulo(raioCirculo, corCirculo);
                    double areaCirculo = circulo.calcularArea();
                    System.out.println("Área do círculo: " + areaCirculo + " - Cor: " + circulo.getCor());
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
}	