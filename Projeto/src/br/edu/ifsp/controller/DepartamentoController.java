package br.edu.ifsp.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dao.DepartamentoDao;
import br.edu.ifsp.dao.FuncionarioDao;
import br.edu.ifsp.model.funcionario.Funcionario;
import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.departamento.DepartamentoValidacao;

public class DepartamentoController {
	private Departamento departamento;
	private List<String> erros;
	 public List<String> insereDepartamento(String nomeDepto, Funcionario gerente) {
	    	recebeDadosDepartamento(null, nomeDepto, gerente);
	    	
			if (erros.size() == 0)
				erros.add(new DepartamentoDao().insereDepartamento(departamento));			
			
			return erros; 
	    }
	    
	    public void recebeDadosDepartamento(Integer id, String nomeDepto, Funcionario gerente) {
	    	departamento = new Departamento();
	    	erros = new ArrayList<String>();

	    	departamento.setId(id);
	    	departamento.setNomeDepto(nomeDepto);
			departamento.setGerente(gerente);
	        
			erros = DepartamentoValidacao.validaDepartamento(departamento);
	    }
	    
	    public List<Funcionario> recuperaFuncionarios() {
			return new FuncionarioDao().recuperaFuncionarios();
	    }
	    
	    public String getExcecao() {
	    	return new DepartamentoDao().getExcecao();
	    }
	}