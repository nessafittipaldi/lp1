package br.edu.ifsp.model.cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoValidacao {
	private static List<String> errosValidacao;
	
	public static List<String> validaCargo(Cargo cargo){
		errosValidacao = new ArrayList<>();
		
		if (!cargo.getDescricao().equals("")) {
			if (cargo.getDescricao().length() < 10 || cargo.getDescricao().length() > 50)
				errosValidacao.add("* O cargo deve ter entre 10 e 50 caracteres.");
		} else {
			errosValidacao.add("* O cargo não foi informado.");
		}
		if (cargo.getDepartamento() == null)
			errosValidacao.add("* O departamento não foi informado.");

		return errosValidacao;
	}
}