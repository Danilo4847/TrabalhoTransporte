package model.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import model.vo.VeiculoVO;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class PanelVeiculo extends JPanel {
	private JTextField textModelo;
	private JTextField textMarca;
	private JTextField textPlaca;
	private JTextField textRenavam;

	/**
	 * Create the panel.
	 */
	public PanelVeiculo(VeiculoVO veiculo) {
		setBackground(new Color(112, 128, 144));
		setLayout(new MigLayout("", "[][grow][]", "[][][][][][][][][][][][][][53.00]"));
		
		JLabel lblNewLabel_5 = new JLabel("CADASTRAR VEICULO");
		lblNewLabel_5.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(lblNewLabel_5, "cell 1 0 1 3,alignx center,aligny center");
		
		JLabel lblNewLabel = new JLabel("MODELO");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel, "cell 1 3");
		
		textModelo = new JTextField();
		add(textModelo, "cell 1 4,growx");
		textModelo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("MARCA");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_1, "cell 1 5");
		
		textMarca = new JTextField();
		add(textMarca, "cell 1 6,growx");
		textMarca.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PLACA");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_2, "cell 1 7");
		
		textPlaca = new JTextField();
		add(textPlaca, "cell 1 8,growx");
		textPlaca.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("RENAVAM");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_3, "cell 1 9");
		
		textRenavam = new JTextField();
		add(textRenavam, "cell 1 10,growx");
		textRenavam.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ANO");
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_4, "cell 1 11");
		
		JButton btnNewButton = new JButton("     ENTER     ");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		add(btnNewButton, "cell 1 13,alignx center,growy");

	}

}
