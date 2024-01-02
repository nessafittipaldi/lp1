package EX02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Exercicio2 extends JFrame {
	private JLabel lbTitulo, lbTemperatura, lbOperacao;
    private JTextField tfTemperatura;
    private static final String valDef[] = {"Celsius para Fahrenheit", "Fahrenheit para Celsius", "Celsius para Kelvin", "Kelvin para Celsius", "Fahrenheit para Kelvin", "Kelvin para Fahrenheit"};
    private JRadioButton rbOperacao[];
    private ButtonGroup bgOperacao;
    private Container cp;

	public Exercicio2() {
		
		lbTitulo = new JLabel("Exercicio 2");
		lbTemperatura = new JLabel("Temperatura");
		lbOperacao = new JLabel("Operação");
		tfTemperatura = new JTextField();
		rbOperacao = new JRadioButton[6];
		bgOperacao = new ButtonGroup();
		
		
		setTitle("Exercicio 2");
        setSize(500, 500);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
        
		for (int i = 0; i < rbOperacao.length; i++) {
			rbOperacao[i] = new JRadioButton(valDef[i]);
			rbOperacao[i].setBackground(new Color(180, 205, 205));
			bgOperacao.add(rbOperacao[i]);
		}
		rbOperacao[0].setSelected(true);
		cp = getContentPane();
        cp.setLayout(null);
        cp.setBackground(new Color(180, 205, 205));
        
        lbTitulo.setBounds(135, 10, 300, 25);
        lbTemperatura.setBounds(20, 40, 100, 25);
        tfTemperatura.setBounds(130, 40, 100, 25);
        lbOperacao.setBounds(20, 70, 100, 25);
        rbOperacao[0].setBounds(100, 70, 220, 25);
        rbOperacao[1].setBounds(100, 100, 220, 25);
        rbOperacao[2].setBounds(100, 130, 220, 25);
        rbOperacao[3].setBounds(100, 160, 220, 25);
        rbOperacao[4].setBounds(100, 190, 220, 25);
        rbOperacao[5].setBounds(100, 220, 220, 25);
        
        cp.add(lbTitulo);
        cp.add(lbTemperatura);
        cp.add(tfTemperatura);
        cp.add(lbOperacao);
        cp.add(rbOperacao[0]);
        cp.add(rbOperacao[1]);
        cp.add(rbOperacao[2]);
        cp.add(rbOperacao[3]);
        cp.add(rbOperacao[4]);
        cp.add(rbOperacao[5]);
        
        rbOperacao[0].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        	        double temperatura = Double.parseDouble(tfTemperatura.getText());
        	        double resultado = (temperatura * 1.8) + 32;
        	        JOptionPane.showMessageDialog(Exercicio2.this, "Resultado: " + resultado + " °F", "Conversão", JOptionPane.INFORMATION_MESSAGE);
        	    } catch (NumberFormatException ex) {
        	        JOptionPane.showMessageDialog(Exercicio2.this,"Opção Celsius para Farenhait", "Insira uma temperatura válida.", JOptionPane.ERROR_MESSAGE);
        	    }
        	}		
        });
        
        rbOperacao[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperatura = Double.parseDouble(tfTemperatura.getText());
                    double resultado = (temperatura - 32) / 1.8;
                    JOptionPane.showMessageDialog(Exercicio2.this, "Resultado: " + resultado + " °C", "Conversão", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Exercicio2.this, "Opção Farenhait para Celsius", "Insira uma temperatura válida.", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        rbOperacao[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperatura = Double.parseDouble(tfTemperatura.getText());
                    double resultado = temperatura + 273.15;
                    JOptionPane.showMessageDialog(Exercicio2.this, "Resultado: " + resultado + " K", "Conversão", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Exercicio2.this, "Opção Celsius para Kelvin", "Insira uma temperatura válida.", JOptionPane.ERROR_MESSAGE);
            }
            }
        }); 
        
     
        rbOperacao[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperatura = Double.parseDouble(tfTemperatura.getText());
                    double resultado = temperatura - 273.15;
                    JOptionPane.showMessageDialog(Exercicio2.this, "Resultado: " + resultado + " °C", "Conversão", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Exercicio2.this, "Opção Kelvin para Celsius", "Insira uma temperatura válida.", JOptionPane.ERROR_MESSAGE);
            }
            }
        });

        
        rbOperacao[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperatura = Double.parseDouble(tfTemperatura.getText());
                    double resultado = (temperatura + 459.67) / 1.8;
                    JOptionPane.showMessageDialog(Exercicio2.this, "Resultado: " + resultado + " K", "Conversão", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Exercicio2.this, "Opção Farenhait para Kelvin", "Insira uma temperatura válida.", JOptionPane.ERROR_MESSAGE);
            }
            }
        });

        
        rbOperacao[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperatura = Double.parseDouble(tfTemperatura.getText());
                    double resultado = (temperatura * 1.8) - 459.67;
                    JOptionPane.showMessageDialog(Exercicio2.this, "Resultado: " + resultado + " °F", "Conversão", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Exercicio2.this, "Opção Kelvin para Farenhait", "Insira uma temperatura válida.", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
	}
    
	

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exercicio2().setVisible(true);
            }
        });
    }
}
