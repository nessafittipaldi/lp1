package br.edu.ifsp.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dao.CargoDao;
import br.edu.ifsp.dao.DepartamentoDao;
import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.cargo.CargoValidacao;

public class CargoController {
	private Cargo cargo;
	private List<String> erros;
	
	
	 public List<String> insereCargo(String descricao, Departamento depto) {
	        Cargo cargo = new Cargo();
	        cargo.setDescricao(descricao);
	        cargo.setDepartamento(depto);

	        erros = CargoValidacao.validaCargo(cargo);

	        if (erros.isEmpty()) {
	            CargoDao cargoDao = new CargoDao();
	            List<Cargo> cargos = cargoDao.recuperaCargos(); // Recupera os cargos existentes
	            boolean cargoJaExiste = false;

	            for (Cargo c : cargos) {
	                if (c.getDescricao().equals(descricao) && c.getDepartamento().equals(depto)) {
	                    cargoJaExiste = true;
	                    break;
	                }
	            }

	            if (!cargoJaExiste) {
	                
	                erros.add("Cargo inserido com sucesso.");
	            } else {
	                erros.add("Este cargo já existe.");
	            }
	        }

	        return erros;
	    }
	    
	    
	    public void recebeDadosCargo(Integer id, String descricao, Departamento depto) {
	    	cargo = new Cargo();
	    	erros = new ArrayList<String>();

	    	cargo.setId(id);
	    	cargo.setDescricao(descricao);
			cargo.setDepartamento(depto);
			
			erros = CargoValidacao.validaCargo(cargo);
	    }
	    
	    public List<Departamento> recuperaDepartamentos() {
	    	
			return new DepartamentoDao().recuperaDepartamentos();
	    }
	    
	    public String getExcecao() {
	    	return new CargoDao().getExcecao();
	    }
	}