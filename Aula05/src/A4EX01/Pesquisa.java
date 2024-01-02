package A4EX01;

public class Pesquisa {
	protected String texto;


	public String setTexto(String texto) {
		return this.texto = texto;
	}
	
	public String buscarString(String cadeiaCaracteres){
		if(texto.contains(cadeiaCaracteres))
			return "O texto contém " + cadeiaCaracteres;
		else
			return "O texto não contém " + cadeiaCaracteres;
		
	}

}
	