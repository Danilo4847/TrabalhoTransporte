package view;

import javax.swing.JPanel;

import model.vo.MotoristaVO;
import model.vo.VeiculoVO;
import model.vo.ViagemVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.MotoristaController;
import controller.VeiculoController;
import controller.ViagemController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;

public class PanelViagem extends JPanel {
	private JTable table;
	private MotoristaController motoristaControlle= new MotoristaController();
	private ArrayList<MotoristaVO>motoristas= new ArrayList<MotoristaVO>();
	private JComboBox cbMotorista;
	private JComboBox cbVeiculo;
	private ArrayList<VeiculoVO> veiculos = new ArrayList<VeiculoVO>();
	private VeiculoController veiculoController = new VeiculoController();
	private JComboBox cbRegional;
	private ArrayList<ViagemVO>regionais = new ArrayList<ViagemVO>();
	private ViagemController viagemController = new ViagemController();
	private JFrame frame = new JFrame();
	private JTextField textQTD;
	private JTextField textMaterial;
	private JComboBox comboVeiculo;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	public PanelViagem(ViagemVO viagem) {
		frame.getContentPane().setBackground(new Color(119, 136, 153));

		setBackground(new Color(119, 136, 153));
		FormLayout formLayout = new FormLayout(new ColumnSpec[] {
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("max(61dlu;min)"),
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),});
		formLayout.setRowGroups(new int[][]{new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 3, 2}});
		frame.getContentPane().setLayout(formLayout);
/*
		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);
		
		TimePickerSettings timeSettings = new TimePickerSettings();
		timeSettings.setAllowKeyboardEditing(false);*/
	
				JLabel lblNewLabel_2 = new JLabel("New label");
				lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\danil\\OneDrive\\Documentos\\TRABALHO_TRANSPORTE\\src\\icon\\floresta.jpg"));
				frame.getContentPane().add(lblNewLabel_2, "1, 1, 5, 8");
				
				JLabel lblNewLabel_1 = new JLabel("CRIAR VIAGEM");
				lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 30));
				frame.getContentPane().add(lblNewLabel_1, "1, 9, 5, 1, center, center");
				
				JLabel lblNewLabel_5 = new JLabel("Regional");
				lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD, 15));
				frame.getContentPane().add(lblNewLabel_5, "2, 10, left, bottom");
				
				JComboBox comboRegional = new JComboBox();
				frame.getContentPane().add(comboRegional, "2, 11, 3, 1, fill, default");
				
				JLabel lblNewLabel_4 = new JLabel("Motorista");
				lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 15));
				frame.getContentPane().add(lblNewLabel_4, "2, 12, left, bottom");
				
				JComboBox comboMotorista = new JComboBox();
				frame.getContentPane().add(comboMotorista, "2, 13, 3, 1, fill, default");
				
				JLabel lblNewLabel_3 = new JLabel("Veiculo");
				lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 15));
				frame.getContentPane().add(lblNewLabel_3, "2, 14, left, bottom");
				
				comboVeiculo = new JComboBox();
				frame.getContentPane().add(comboVeiculo, "2, 15, 3, 1, fill, default");
		
				veiculos=veiculoController.consultaModelo();
				for(VeiculoVO v:veiculos) {
				comboVeiculo.addItem(v.getMarca());;	
				}
				
				JLabel lblData = new JLabel("Data saida");
				lblData.setFont(new Font("Cambria", Font.BOLD, 15));
				frame.getContentPane().add(lblData, "2, 16, left, bottom");
		
		
		final DateTimePicker dataSaida = new DateTimePicker();
		frame.getContentPane().add(dataSaida, "2, 17, 3, 1, fill, fill");
		
		JLabel lblNewLabel = new JLabel("Data chegada");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel, "2, 18, left, bottom");
		
		
		final DateTimePicker dataChegada = new DateTimePicker();
		frame.getContentPane().add(dataChegada, "2, 19, 3, 1, fill, fill");
		
		JLabel lblNewLabel_6 = new JLabel("QTD");
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_6, "2, 20, left, bottom");
		
		JLabel lblNewLabel_7 = new JLabel("Material");
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_7, "3, 20, left, bottom");
		
		JLabel lblNewLabel_8 = new JLabel("Setor");
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_8, "4, 20, left, bottom");
		
		textQTD = new JTextField();
		frame.getContentPane().add(textQTD, "2, 21, left, center");
		textQTD.setColumns(10);
		
		textMaterial = new JTextField();
		frame.getContentPane().add(textMaterial, "3, 21, fill, center");
		textMaterial.setColumns(10);
		
		JComboBox comboSetor = new JComboBox();
		frame.getContentPane().add(comboSetor, "4, 21, fill, default");
		
		JButton btnNewButton = new JButton("IMPRIMIR");
		frame.getContentPane().add(btnNewButton, "2, 23");
		
		JButton btnNewButton_1 = new JButton("SALVAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				LocalDate dataSelecionadaChegada = dataChegada.getDatePicker().getDate();
				LocalTime horaSelecionadaChegada = dataChegada.getTimePicker().getTime();
				
				LocalDate dataSelecionadaSaida = dataSaida.getDatePicker().getDate();
				LocalTime horaSelecionadaSaida = dataSaida.getTimePicker().getTime();
				
				
		
				if(dataSelecionadaSaida != null && horaSelecionadaSaida != null) {
					LocalDateTime dataComHora = LocalDateTime.of(dataSelecionadaSaida, horaSelecionadaSaida);

				}
				}
	
			
		});
		
		frame.getContentPane().add(btnNewButton_1, "3, 23");
		
		JButton btnNewButton_2 = new JButton("ATUALIZAR");
		frame.getContentPane().add(btnNewButton_2, "4, 23");
		
		 panel = new JPanel();
		frame.getContentPane().add(panel, "2, 25, fill, fill");
		
	
	}

}
	
