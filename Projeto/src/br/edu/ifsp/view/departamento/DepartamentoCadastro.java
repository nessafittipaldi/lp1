package br.edu.ifsp.view.departamento;

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


import br.edu.ifsp.controller.DepartamentoController;

import br.edu.ifsp.model.funcionario.Funcionario;


@SuppressWarnings("serial")
public class DepartamentoCadastro extends JDialog {
	
	private JLabel lbTitulo, lbNome, lbGerente;
	private JTextField tfNome;
	private JComboBox<Funcionario> cbGerente;
	private JButton btCadastrar;
	private Container cp;
	
	public DepartamentoCadastro() { // Construtor.
		
		setTitle("Cadastro de Departamentos");
		setSize(500, 335); 
		setLocationRelativeTo(null); 
		setModal(true); 
		
		lbTitulo = new JLabel("Cadastro de Departamentos");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19)); // Ajusta a fonte do JLabel.
		
		lbNome = new JLabel("Nome do Departamento");
		tfNome = new JTextField();
		lbGerente = new JLabel("Gerente");
		
		cbGerente = new JComboBox<>();
		List<Funcionario> funcionarios = new DepartamentoController().recuperaFuncionarios();
        String erro = new DepartamentoController().getExcecao();

        if (erro != null) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados dos funcionários:\n" + erro,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        if (funcionarios != null) {
            for (Funcionario f : funcionarios) {
                cbGerente.addItem(f);
            }
        }
		
		btCadastrar = new JButton("Cadastrar");

		cp = getContentPane(); // Instancia o container da janela.
		cp.setLayout(null); // Configura o layout do container como nulo.
		cp.setBackground(new Color(180, 205, 205)); // Configura a cor de fundo do container.

		// Posicionamento dos componentes de interface na janela.
		lbTitulo.setBounds(125, 10, 300, 25); // x, y, largura, altura.
		lbNome.setBounds(20, 50, 300, 25);
		tfNome.setBounds(20, 80, 360, 25);
		lbGerente.setBounds(20, 130, 300, 25);
		cbGerente.setBounds(20, 160, 220, 25);
		btCadastrar.setBounds(200, 250, 150, 25);
		
		// Adição dos componentes de interface ao container.
		cp.add(lbTitulo);
		cp.add(lbNome);
		cp.add(tfNome);
		cp.add(lbGerente);
		cp.add(cbGerente);
		cp.add(btCadastrar);


		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				btCadastrarAction();
			}
		});
	} // Final do construtor.
	

    private void btCadastrarAction() {
        List<String> erros = new ArrayList<String>();
        

        erros = new DepartamentoController().insereDepartamento(tfNome.getText(), 
        															(Funcionario) cbGerente.getSelectedItem());

        if (erros.get(0) == null) {
            JOptionPane.showMessageDialog(this, "Departamento cadastrado com sucesso.",
                    "Informação", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        } else {
            String mensagem = "Não foi possível cadastrar o departamento:\n";
            for (String e : erros) {
                mensagem = mensagem + e + "\n";
            }
            JOptionPane.showMessageDialog(this, mensagem, "Erros", JOptionPane.ERROR_MESSAGE);
        }
    }
		
}




