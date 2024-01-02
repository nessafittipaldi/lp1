package EX02;


public abstract class Forma {
	private String cor;
	
	public void setCor(String cor) {
		this.cor = cor;
	    }

	public String getCor() {
		return cor;
	    }

	public abstract double calcularArea();

}

