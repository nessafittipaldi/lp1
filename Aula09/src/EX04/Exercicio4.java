package EX04;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Exercicio4 extends JFrame{
	private JMenuBar mbBarra;
	private JMenu mnCadastro;
	
	private JMenu mnCadCliente;
	private JMenuItem miCadCliente[];
	private static final String cadClientItens[] = { "Pessoa Física", "Pessoa Jurídica"};
	private JMenuItem miCadFornecedor;
	private JMenuItem miCadSair;
	
	
	public Exercicio4() {
		
		mbBarra = new JMenuBar();
		mnCadastro = new JMenu("Cadastro");
		mnCadCliente = new JMenu("Cliente");
		miCadCliente = new JMenuItem[2];
		miCadFornecedor = new JMenuItem("Fornecedor");
		miCadSair = new JMenuItem("Sair");
		
		setTitle("Exercicio 4");
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(180, 205, 205));
		mnCadCliente.setMnemonic('P');
		miCadFornecedor.setMnemonic('F');
		miCadSair.setMnemonic('S');
		for (int i = 0; i < miCadCliente.length; i++) {
			miCadCliente[i] = new JMenuItem(cadClientItens[i]);
			mnCadCliente.add(miCadCliente[i]);
		}
		mnCadastro.add(mnCadCliente);
		mnCadastro.add(miCadFornecedor);
		mnCadastro.addSeparator();
		mnCadastro.add(miCadSair);
		mbBarra.add(mnCadastro);
		setJMenuBar(mbBarra);
	
		miCadSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				miCadSairAction();
			}
		});
		
	}
	
	
	private void miCadSairAction() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new Exercicio4().setVisible(true);
			}
		});
	}

}
