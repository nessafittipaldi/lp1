package br.edu.ifsp.view.cargo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.ifsp.controller.CargoController;
import br.edu.ifsp.model.departamento.Departamento;

@SuppressWarnings("serial")
public class CargoCadastro extends JDialog {
	private JLabel lbTitulo, lbNome, lbDepartamento;
	private JTextField tfNome;
	private JComboBox<Departamento> cbDepartamento;
	private JButton btCadastrar;
	private Container cp; // Container para organizar os componentes na janela.

	public CargoCadastro() {
	setTitle("Cadastro de Cargos"); // Título da janela.
	setSize(500, 335); // Tamanho da janela em pixels.
	setLocationRelativeTo(null); // Centraliza a janela na tela.
	setModal(true); // Torna a janela "modal" (janela que não permite acesso a outras janelas abertas).
	
	lbTitulo = new JLabel("Cadastro de Cargos");
	lbTitulo.setFont(new Font("Arial", Font.BOLD, 19)); // Ajusta a fonte do JLabel.
	
	lbNome = new JLabel("Nome do Cargo");
	tfNome = new JTextField();
	lbDepartamento = new JLabel("Departamento");
	
	cbDepartamento = new JComboBox<>();
	
	List<Departamento> departamentos = new ArrayList<Departamento>();
	
	departamentos = new CargoController().recuperaDepartamentos();
	if (departamentos != null)
		for (Departamento d : departamentos)
			cbDepartamento.addItem(d);
	
	String erro = new CargoController().getExcecao();
	
	if (erro != null) // Caso ocorra qualquer tipo de exceção.
		JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados dos departamentos:\n" + erro, 
				                      "Erro", JOptionPane.ERROR_MESSAGE);
	
	btCadastrar = new JButton("Cadastrar");

	cp = getContentPane(); // Instancia o container da janela.
	cp.setLayout(null); // Configura o layout do container como nulo.
	cp.setBackground(new Color(180, 205, 205)); // Configura a cor de fundo do container.
	
	lbTitulo.setBounds(125, 10, 300, 25); // x, y, largura, altura.
	lbNome.setBounds(20, 50, 300, 25);
	tfNome.setBounds(50, 80, 360, 25);
	lbDepartamento.setBounds(20, 130, 300, 25);
	cbDepartamento.setBounds(50, 160, 300, 25);
	btCadastrar.setBounds(200, 250, 150, 25);

	// Adição dos componentes de interface ao container.
	cp.add(lbTitulo);
	cp.add(lbNome);
	cp.add(tfNome);
	cp.add(lbDepartamento);
	cp.add(cbDepartamento);
	cp.add(btCadastrar);

	// Declaração do processador de evento referente ao clique no botão Cadastrar.
	btCadastrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)  {
			btCadastrarAction();
		}
	});
} // Final do construtor.
	private void btCadastrarAction() { // Método acionado pelo clique no botão Cadastrar.

		List<String> erros = new ArrayList<String>();
		
		// Envia os dados do funcionário (informados no formulário) ao controller. 
		// O controller retorna então um ArrayList contendo os erros encontrados.
		erros = new CargoController().insereCargo(tfNome.getText(),
												      
										                      (Departamento) cbDepartamento.getSelectedItem());
		
		if (erros.get(0) == null) { // Se o primeiro elemento do ArrayList for null.
			JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso.", 
					                      "Informação", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false); // Fecha a janela.
		} else { // Se o primeiro elemento do ArrayList não for null.
			String mensagem = "Não foi possível cadastrar o funcionário:\n";
			for (String e : erros) // Cria uma mensagem contendo todos os erros armazenados no ArrayList.
				mensagem = mensagem + e + "\n";
			JOptionPane.showMessageDialog(this, mensagem, "Erros", JOptionPane.ERROR_MESSAGE);
		}
	}
}

