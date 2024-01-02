package EX01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Exercicio extends JFrame{
	
	private JLabel lbTitulo, lbValor1, lbValor2, lbOperacao;
	private JTextField tfValor1, tfValor2;
	private JComboBox<String> cbOperacao;
	private static final String valOp[] = {"Adicao","Subtracao","Multiplicacao","Divisao","Resto"};
	private JButton btCalcular;
	private Container cp;

	public Exercicio() {
		lbTitulo = new JLabel("Exercicio 1");
		lbValor1 = new JLabel("Valor 1");
		lbValor2 = new JLabel("Valor 2");
		lbOperacao = new JLabel("Operação");
		tfValor1 = new JTextField();
		tfValor2 = new JTextField();
		cbOperacao = new JComboBox<>(valOp);
		btCalcular = new JButton("Calcular");
		
		setTitle("Exercicio 1");
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		
		btCalcular.setToolTipText("Realiza a Operação");
        cp = getContentPane();
        cp.setLayout(null);
        cp.setBackground(new Color(180, 205, 205));
		
		lbTitulo.setBounds(135, 10, 300, 25);
		lbValor1.setBounds(20, 40, 100, 25);
		tfValor1.setBounds(100, 40, 150, 25);
		lbValor2.setBounds(20, 70, 100, 25);
		tfValor2.setBounds(100, 70, 150, 25);
		lbOperacao.setBounds(20, 160, 100, 25);
		cbOperacao.setBounds(100, 160, 150,25);
		btCalcular.setBounds(200, 220, 100, 25);
		
		cp.add(lbTitulo);
		cp.add(lbValor1);
	    cp.add(tfValor1);
	    cp.add(lbValor2);
	    cp.add(tfValor2);
	    cp.add(lbOperacao);
	    cp.add(cbOperacao);
	    cp.add(btCalcular);
	    
	    btCalcular.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		btCalcularAction();
	    	}
	    }); 
		
	
	}
	
	private void btCalcularAction() {
		try {
            int valor1 = Integer.parseInt(tfValor1.getText());
            int valor2 = Integer.parseInt(tfValor2.getText());
            String operacao = cbOperacao.getSelectedItem().toString();

            int resultado = 0;
          


		    switch (operacao) {
		        case "Adicao":
		            resultado = valor1 + valor2;
		            break;
		        case "Subtracao":
		            resultado = valor1 - valor2;
		            break;
		        case "Multiplicacao":
		            resultado = valor1 * valor2;
		            break;
		        case "Divisao":
		            resultado = valor1 / valor2;
		            break;
		        case "Resto":
		            if (valor2 == 0) {
		                JOptionPane.showMessageDialog(this, "Divisão por zero não é permitida.");
		                return;
		            }
		            resultado = valor1 % valor2;
		            break;
		    }
		
		
		
		int resposta = JOptionPane.showConfirmDialog(this,
														"Operação Realizada:\n" +
														"Operação"+ operacao + "\n" +
														"Valor1: " + valor1 + "\n" +
														"Valor2: " + valor2 + "\n" +
														"Resultado: " + resultado,
														"Deseja continuar?",
														JOptionPane.YES_NO_OPTION,
														JOptionPane.QUESTION_MESSAGE);
		if (resposta == 0) {
            tfValor1.setText("");
            tfValor2.setText("");
        } else if (resposta == 1) {
            System.exit(0);
        }
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Certifique-se de inserir apenas números inteiros válidos.");
        }
    } 	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Exercicio().setVisible(true);
			}
		});
	}
}