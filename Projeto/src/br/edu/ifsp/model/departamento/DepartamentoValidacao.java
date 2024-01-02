package br.edu.ifsp.model.departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoValidacao {
	private static List<String> errosValidacao;
	
	
	public static List<String> validaDepartamento(Departamento departamento){
		errosValidacao = new ArrayList<>();
		
		if (!departamento.getNomeDepto().equals("")) {
			if (departamento.getNomeDepto().length() < 10 || departamento.getNomeDepto().length() > 50)
				errosValidacao.add("* O nome do departamento deve ter entre 10 e 50 caracteres.");
		} else {
			errosValidacao.add("* O nome do departamento não foi informado.");
		}
        //if (departamento.getGerente() == null)
       // errosValidacao.add("* O Gerente não foi informado.");

		return errosValidacao; 
	}
}
