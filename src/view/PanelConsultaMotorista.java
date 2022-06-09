package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class PanelConsultaMotorista extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PanelConsultaMotorista() {
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
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(49dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("54px:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.MIN_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PanelConsultaMotorista.class.getResource("/icon/floresta.jpg")));
		add(lblNewLabel, "1, 1, 10, 5");
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA MOTORISTA");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 30));
		add(lblNewLabel_1, "1, 8, 10, 1, center, default");
		
		JLabel lblNewLabel_2 = new JLabel("NOME");
		add(lblNewLabel_2, "4, 10");
		
		JLabel lblNewLabel_3 = new JLabel("CNH");
		add(lblNewLabel_3, "6, 10");
		
		JLabel lblNewLabel_4 = new JLabel("MATRICULA");
		add(lblNewLabel_4, "8, 10");
		
		textField = new JTextField();
		add(textField, "4, 12, fill, default");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1, "6, 12, fill, default");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		add(textField_2, "8, 12, fill, default");
		textField_2.setColumns(10);
		
		table = new JTable();
		add(table, "3, 14, 7, 5, fill, fill");
		
		JButton btnNewButton = new JButton("EXCLUIR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton, "4, 22, fill, fill");
		
		JButton btnNewButton_1 = new JButton("IMPRIMIR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton_1, "8, 22, fill, fill");

	}

}
