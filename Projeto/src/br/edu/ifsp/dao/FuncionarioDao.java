package br.edu.ifsp.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.funcionario.Funcionario;

public class FuncionarioDao extends GenericDao {
	private String instrucaoSql; // Atributo para armazenar a instrução SQL a ser executada.
	private PreparedStatement comando; // Atributo usado para preparar e executar instru��es SQL.
	private ResultSet registros; // Atributo que recebe os dados retornados por uma instru��o SQL.
	private static String excecao = null; // Atributo para armazenar mensagens de excecao.

    public String insereFuncionario(Funcionario funcionario) {
        instrucaoSql = "INSERT INTO Funcionario (Nome, Sexo, Salario, PlanoSaude, IdCargo) VALUES (?,?,?,?,?)";
        return insere(instrucaoSql, funcionario.getNome(), funcionario.getSexo().toString(), funcionario.getSalario(),
        	                        funcionario.isPlanoSaude(), funcionario.getCargo().getId());
    }
    
    public List<Funcionario> recuperaFuncionarios() {
        Funcionario funcionario;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        instrucaoSql = "SELECT * FROM Funcionario";
        
        try {
        	excecao = ConnectionDatabase.conectaBd(); 
        	if (excecao == null) {
               
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                
              
                registros = comando.executeQuery();
                
                if (registros.next()) { 
                    registros.beforeFirst(); 
        	        while (registros.next()) {
                       
         	            funcionario = new Funcionario();
        	            funcionario.setId(registros.getInt("Id"));
        	            funcionario.setNome(registros.getString("Nome"));
        	            funcionario.setSexo(registros.getString("Sexo").charAt(0));
        	            funcionario.setSalario(registros.getBigDecimal("Salario"));
        	            funcionario.setPlanoSaude(registros.getBoolean("PlanoSaude"));
        	            funcionarios.add(funcionario);
        	        }
        	    }
                registros.close();
                comando.close();
                
                ConnectionDatabase.getConexaoBd().close(); 
            }
        } catch (Exception e) {
        	excecao = "Tipo de Excecao: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
        	funcionarios = null; 
        }
        return funcionarios; 
    }
    
    
	public String getExcecao() {
		return excecao;
	}
}
    
   