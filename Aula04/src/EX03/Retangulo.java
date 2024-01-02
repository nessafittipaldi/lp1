package EX03;

public class Retangulo extends Forma{
	private double base;
    private double altura;

    public Retangulo(double base, double altura, String cor) {
        this.base = base;
        this.altura = altura;
        setCor(cor);
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

}
