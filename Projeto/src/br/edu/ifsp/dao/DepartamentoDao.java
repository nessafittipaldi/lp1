package br.edu.ifsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.departamento.Departamento;


public class DepartamentoDao extends GenericDao {
	private String instrucaoSql; // Atributo para armazenar a instru��o SQL a ser executada.
	private PreparedStatement comando; // Atributo usado para preparar e executar instru��es SQL.
	private ResultSet registros; // Atributo que recebe os dados retornados por uma instru��o SQL.
	private static String excecao = null; // Atributo para armazenar mensagens de excecao.

    public String insereDepartamento(Departamento departamento) {
        instrucaoSql = "INSERT INTO Departamento(NomeDepto, IdFuncGerente) VALUES (?,?)";
        return insere(instrucaoSql, departamento.getNomeDepto(), departamento.getGerente().getId());
    }
    
    public List<Departamento> recuperaDepartamentos() {
        Departamento departamento;
        List<Departamento> departamentos = new ArrayList<Departamento>();
        instrucaoSql = "SELECT * FROM Departamento";
        
        try {
        	excecao = ConnectionDatabase.conectaBd(); 
        	if (excecao == null) {
                
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                
               
                registros = comando.executeQuery();
                
                if (registros.next()) { 
                    registros.beforeFirst(); 
        	        while (registros.next()) {
                       
        	            departamento = new Departamento();
        	            departamento.setId(registros.getInt("Id"));
        	            departamento.setNomeDepto(registros.getString("nomeDepto"));
        	            departamentos.add(departamento);
        	        }
        	    }
                registros.close(); 
                comando.close(); 
               
                ConnectionDatabase.getConexaoBd().close(); 
            }
        } catch (Exception e) {
        	excecao = "Tipo de Excecao: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
        	departamentos = null; 
        }
        return departamentos; 
    }
    
    
	public String getExcecao() {
		return excecao;
	}
}