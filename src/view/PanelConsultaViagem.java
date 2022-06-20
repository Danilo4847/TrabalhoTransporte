package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelConsultaViagem extends JPanel {
	private JTable table;
	private JFrame frame;
	private JTextField textDataSaidaHora;
	private JTextField textDataChegadaHora;
	private JTextField textMotorista;
	private JTextField textVeiculo;
	private JTextField textRegional;

	/**
	 * Create the panel.
	 */
	public PanelConsultaViagem() {
		setBackground(new Color(119, 136, 153));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;pref):grow"),
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
				RowSpec.decode("max(27dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(24dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(31dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(142dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(PanelConsultaViagem.class.getResource("/icon/floresta.jpg")));
		add(lblNewLabel_6, "1, 1, 20, 7");
		
		JLabel lblNewLabel_5 = new JLabel("CONSULTA DE VIAGEM");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblNewLabel_5, "2, 8, 19, 1, center, center");
		
		JLabel lblNewLabel = new JLabel("Data saida e hora");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel, "4, 10, default, bottom");
		
		JLabel lblNewLabel_2 = new JLabel("Data chegada e hora ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_2, "6, 10, default, bottom");
		
		JLabel lblNewLabel_1 = new JLabel("Motorista");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_1, "10, 10, left, bottom");
		
		JLabel lblNewLabel_3 = new JLabel("Veiculo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_3, "14, 10, left, bottom");
		
		JLabel lblNewLabel_4 = new JLabel("Regional");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_4, "18, 10, left, bottom");
		
		textDataSaidaHora = new JTextField();
		add(textDataSaidaHora, "4, 12, fill, default");
		textDataSaidaHora.setColumns(10);
		
		textDataChegadaHora = new JTextField();
		add(textDataChegadaHora, "6, 12, fill, default");
		textDataChegadaHora.setColumns(10);
		
		textMotorista = new JTextField();
		add(textMotorista, "10, 12, fill, default");
		textMotorista.setColumns(10);
		
		textVeiculo = new JTextField();
		add(textVeiculo, "14, 12, fill, default");
		textVeiculo.setColumns(10);
		
		textRegional = new JTextField();
		add(textRegional, "18, 12, fill, default");
		textRegional.setColumns(10);
		
		table = new JTable();
		add(table, "4, 16, 15, 1, fill, fill");
		
		JButton btnNewButton = new JButton("EXCLUIR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton, "6, 20, default, fill");
		
		JButton btnNewButton_2 = new JButton("PESQUISAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton_2, "10, 20");
		
		JButton btnNewButton_1 = new JButton("IMPRIMIR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton_1, "14, 20, default, fill");




	}


}
