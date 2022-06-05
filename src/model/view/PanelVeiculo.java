package model.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import model.vo.VeiculoVO;

import javax.swing.JLabel;
import java.awt.Color;

public class PanelVeiculo extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelVeiculo(VeiculoVO veiculo) {
		setBackground(new Color(32, 178, 170));
		setLayout(new MigLayout("", "[][][][grow]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("Modelo");
		add(lblNewLabel, "cell 0 2");
		
		textField = new JTextField();
		add(textField, "cell 3 2,growx");
		textField.setColumns(10);

	}

}
