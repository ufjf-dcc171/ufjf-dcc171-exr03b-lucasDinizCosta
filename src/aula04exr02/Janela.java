package aula04exr02;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Janela extends JFrame {

    /**
     * Exercício 3 - B) Construa uma aplicação gráfica em Java que leia dois
     * números e permita apresentar as quatro operações fundamentais sobre os
     * dois (soma, subtração, produto e divisão). Adicione um botão para cada
     * operação.
     */
    private final JTextField caixa_Numero_1;
    private final JTextField caixa_Numero_2;
    private final JLabel escrito_Titulo = new JLabel("<HTML>Digite dois numeros e escolha a <br>operação a fazer: </HTML>");
    private final JLabel escrito_Numero_1 = new JLabel("Numero 1: ");
    private final JLabel escrito_Numero_2 = new JLabel("Numero 2: ");
    private final JButton soma = new JButton("+");
    private final JButton subtracao = new JButton("-");
    private final JButton multiplicacao = new JButton("*");
    private final JButton divisao = new JButton("/");
    private final JLabel resultado = new JLabel("Resultado: ");

    public Janela() throws HeadlessException {
        super("Calculadora");
        caixa_Numero_1 = new JTextField(20);
        caixa_Numero_2 = new JTextField(20);
        setLayout(new FlowLayout());
        soma.addActionListener(new funcoes());
        subtracao.addActionListener(new funcoes());
        multiplicacao.addActionListener(new funcoes());
        divisao.addActionListener(new funcoes());
        add(escrito_Titulo);
        add(escrito_Numero_1);
        add(caixa_Numero_1);
        add(escrito_Numero_2);
        add(caixa_Numero_2);
        add(soma);
        add(subtracao);
        add(multiplicacao);
        add(divisao);
        add(resultado);
    }

    private class funcoes implements ActionListener {

        public funcoes() {
        }

        public void actionPerformed(ActionEvent e) {
            try {
                Double numero_1 = Double.parseDouble(caixa_Numero_1.getText());
                Double numero_2 = Double.parseDouble(caixa_Numero_2.getText());
                if (e.getSource() == soma) {
                    resultado.setText("Resultado: "+ numero_1 + " + " + numero_2 + " = " + (numero_1+numero_2));
                }
                else if (e.getSource() == subtracao) {
                    resultado.setText("Resultado: "+ numero_1 + " - " + numero_2 + " = " + (numero_1-numero_2));
                }
                else if (e.getSource() == multiplicacao) {
                    resultado.setText("Resultado: "+ numero_1 + " * " + numero_2 + " = " + (numero_1*numero_2));
                }
                else if (e.getSource() == divisao) {
                    if(numero_2 != 0)
                        resultado.setText("Resultado: "+ numero_1 + " / " + numero_2 + " = " + (numero_1/numero_2));
                    else
                        JOptionPane.showMessageDialog(null, "Não é possivel divisão por zero", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException erro) {
                if (caixa_Numero_1.getText().equals("") || caixa_Numero_2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha os dois numeros para que a operação possa ser realizada.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(null, "Numero invalido, digite novamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
