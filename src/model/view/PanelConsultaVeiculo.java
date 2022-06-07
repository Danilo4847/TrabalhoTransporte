package model.view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelConsultaVeiculo extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PanelConsultaVeiculo() {
		setBackground(new Color(112, 128, 144));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(52dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(62dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(31dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(51dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PanelConsultaVeiculo.class.getResource("/icon/floresta.jpg")));
		add(lblNewLabel, "1, 1, 20, 5");
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA DE VEICULO");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 30));
		add(lblNewLabel_1, "1, 6, 20, 1, center, center");
		
		JLabel lblNewLabel_2 = new JLabel("RENAVAM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_2, "4, 8, left, default");
		
		JLabel lblNewLabel_3 = new JLabel("PLACA");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_3, "10, 8, left, default");
		
		JLabel lblNewLabel_4 = new JLabel("MARCA");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_4, "16, 8, left, default");
		
		textField = new JTextField();
		add(textField, "4, 10, 3, 2, fill, default");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1, "10, 10, 3, 2, fill, default");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		add(textField_2, "16, 10, 3, 2, fill, default");
		textField_2.setColumns(10);
		
		table = new JTable();
		add(table, "3, 14, 16, 1, fill, fill");
		
		JButton btnNewButton = new JButton("EXCLUIR");
		add(btnNewButton, "4, 17, 3, 3");
		
		JButton btnNewButton_2 = new JButton("CONSULTAR");
		add(btnNewButton_2, "10, 17, 3, 3");
		
		JButton btnNewButton_1 = new JButton("IMPRIMIR");
		add(btnNewButton_1, "16, 17, 3, 3");

	}

}
