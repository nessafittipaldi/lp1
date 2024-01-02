package EX03;

import javax.swing.*;
import java.text.DecimalFormat;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Exercicio3 extends JFrame {
    private JLabel lbTitulo, lbValorProduto, lbFidelidade, lbEstado, lbTipodePostagem, lbValordoProduto, lbValorFrete, lbValorTotal;
    private JTextField tfValorProduto;
    private static final String valPost[] = {"Sedex", "Sedex 10"};
    private JRadioButton rbTipodePostagem[];
    private ButtonGroup bgTipodePostagem;
    private JCheckBox cbFidelidade;
    private JComboBox<String> cbEstado;
    private static final String valEs[] = {"SP", "RJ", "MG", "ES"};
    private JButton btCalcular;    
    private Container cp;

    public Exercicio3() {
        lbTitulo = new JLabel("Exercicio 3");
        lbValorProduto = new JLabel("Valor do Produto");
        lbFidelidade = new JLabel("Cliente com Fidelidade");
        lbEstado = new JLabel("Estado");
        lbValordoProduto = new JLabel("Valor do Produto: ");
        lbValorFrete = new JLabel("Valor do Frete: ");
        lbValorTotal = new JLabel("Valor Total: ");
        lbTipodePostagem = new JLabel("Tipo de Postagem");
        tfValorProduto = new JTextField();
        cbFidelidade = new JCheckBox();
        cbEstado = new JComboBox<>(valEs);
        rbTipodePostagem = new JRadioButton[2];
        bgTipodePostagem = new ButtonGroup();
        btCalcular = new JButton("Calcular");
        		


        setTitle("Exercicio 3");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
        
        for (int i = 0; i < rbTipodePostagem.length; i++) {
        	rbTipodePostagem[i] = new JRadioButton(valPost[i]);
        	rbTipodePostagem[i].setBackground(new Color(180, 205, 205));
        	bgTipodePostagem.add(rbTipodePostagem[i]);
		}
        rbTipodePostagem[0].setSelected(true);
        btCalcular.setToolTipText("Realiza a Operação");
        cp = getContentPane();
        cp.setLayout(null);
        cp.setBackground(new Color(180, 205, 205));

        lbTitulo.setBounds(120, 10, 200, 25);
        lbValorProduto.setBounds(20, 40, 170, 25);
        tfValorProduto.setBounds(150, 40, 100, 25);
        lbFidelidade.setBounds(50, 70, 170, 25);
        cbFidelidade.setBounds(20, 70, 25, 25);
        lbEstado.setBounds(20, 100, 150, 25);
        cbEstado.setBounds(100, 100, 150, 25);
        lbTipodePostagem.setBounds(20, 135, 150, 25);
        rbTipodePostagem[0].setBounds(20, 160, 150, 25);
        rbTipodePostagem[1].setBounds(20, 180, 150, 25);
        lbValordoProduto.setBounds(300, 40, 170, 25);
        lbValorFrete.setBounds(300, 70, 170, 25);
        lbValorTotal.setBounds(300, 100, 170, 25);
        btCalcular.setBounds(200, 220, 100, 25);

        cp.add(lbTitulo);
        cp.add(lbValorProduto);
        cp.add(tfValorProduto);
        cp.add(lbFidelidade);
        cp.add(cbFidelidade);
        cp.add(lbEstado);
        cp.add(cbEstado);
        cp.add(lbTipodePostagem);
        cp.add(rbTipodePostagem[0]);
        cp.add(rbTipodePostagem[1]);
        cp.add(lbValordoProduto);
        cp.add(lbValorFrete);
        cp.add(lbValorTotal);
        cp.add(btCalcular);

        
        btCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btCalcularAction();
            }
        });
        
    }

    private void btCalcularAction() {
        double valorProduto = 0.0;
        double valorFrete = 0.0;
        double valorTotal = 0.0;

        try {
            valorProduto = Double.parseDouble(tfValorProduto.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor de produto válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean clienteFidelidade = cbFidelidade.isSelected();
        String estado = valEs[cbEstado.getSelectedIndex()];
        String tipoPostagem = "";

        for (JRadioButton rb : rbTipodePostagem) {
            if (rb.isSelected()) {
                tipoPostagem = rb.getText();
                break;
            }
        }

        
        if (clienteFidelidade) {
            valorProduto = valorProduto - (valorProduto * 0.10);
        }

        if (estado.equals("SP")) {
            if (tipoPostagem.equals("Sedex")) {
                valorFrete = valorProduto * 0.10;
            } else if (tipoPostagem.equals("Sedex 10")) {
                valorFrete = valorProduto * 0.30;
            }
        } else if (estado.equals("RJ")) {
            if (tipoPostagem.equals("Sedex")) {
                valorFrete = valorProduto * 0.15;
            } else if (tipoPostagem.equals("Sedex 10")) {
                valorFrete = valorProduto * 0.35;
            }
        } else if (estado.equals("MG")) {
            if (tipoPostagem.equals("Sedex")) {
                valorFrete = valorProduto * 0.15;
            } else if (tipoPostagem.equals("Sedex 10")) {
                valorFrete = valorProduto * 0.35;
            }
        } else if (estado.equals("ES")) {
            if (tipoPostagem.equals("Sedex")) {
                valorFrete = valorProduto * 0.20;
            } else if (tipoPostagem.equals("Sedex 10")) {
                valorFrete = valorProduto * 0.40;
            }
        }

        valorTotal = valorProduto + valorFrete;
        
        DecimalFormat df = new DecimalFormat("#0.00");
        String valorProdutoFormatado = df.format(valorProduto);
        String valorFreteFormatado = df.format(valorFrete);
        String valorTotalFormatado = df.format(valorTotal);


        lbValordoProduto.setText("Valor do Produto: " + valorProdutoFormatado);
        lbValorFrete.setText("Valor do Frete: " + valorFreteFormatado);
        lbValorTotal.setText("Valor Total: " + valorTotalFormatado);


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
				new Exercicio3().setVisible(true);
            }
        });
    }
}
