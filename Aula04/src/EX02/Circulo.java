package EX02;

public class Circulo extends Forma{
	private double raio;

    public Circulo(double raio, String cor) {
        this.raio = raio;
        setCor(cor);
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

}
