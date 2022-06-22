package view;

import javax.swing.JPanel;

import model.exception.ErroAoSalvarViagemException;
import model.vo.MaterialVO;
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
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class PanelViagem extends JPanel {
	private JTable table;
	private MotoristaController motoristaControlle= new MotoristaController();
	private ArrayList<MotoristaVO>motoristas= new ArrayList<MotoristaVO>();
	private JComboBox cbMotorista;
	private ArrayList<VeiculoVO> veiculos = new ArrayList<VeiculoVO>();
	private VeiculoController veiculoController = new VeiculoController();
	private JComboBox cbRegional;
	private ArrayList<ViagemVO>regionais = new ArrayList<ViagemVO>();
	private ViagemController viagemController = new ViagemController();
	private ArrayList<MaterialVO>setor= new ArrayList<MaterialVO>();

	private JFrame frame = new JFrame();
	private JTextField textMaterial;
	private JTextField textQuantidade;
	private JComboBox comboMotorista;
	private JComboBox comboVeiculo;
	private JComboBox comboRegional;
	private JComboBox comboSetor;
	private LocalDateTime dataHoraSaida;
	private LocalDateTime dataHoraChegada;
	private LocalDate datasaida;
	private LocalTime horasaida;
	private LocalDate datachegada;
	private LocalTime horachegada;
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





		JLabel lblData = new JLabel("Data saida");
		lblData.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(lblData, "2, 16, left, bottom");
		FormLayout formLayout_1 = new FormLayout(new ColumnSpec[] {
				FormSpecs.GROWING_BUTTON_COLSPEC,
				ColumnSpec.decode("236px:grow"),
				FormSpecs.GROWING_BUTTON_COLSPEC,
				ColumnSpec.decode("239px:grow"),
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("30px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				RowSpec.decode("19px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,});
		setLayout(formLayout_1);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(PanelViagem.class.getResource("/icon/floresta.jpg")));
		add(lblNewLabel_9, "1, 1, 5, 8");

		JLabel lblNewLabel_8 = new JLabel("CRIAR VIAGEM");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblNewLabel_8, "1, 9, 5, 1, center, center");

		JLabel lblNewLabel_4 = new JLabel("Motorista");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_4, "2, 11");

		comboMotorista = new JComboBox();
		add(comboMotorista, "2, 13, 3, 1, fill, default");

		JLabel lblNewLabel_3 = new JLabel("Ve\u00EDculo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_3, "2, 15");

		comboVeiculo = new JComboBox();
		add(comboVeiculo, "2, 17, 3, 1, fill, default");

		JLabel lblNewLabel_2 = new JLabel("Regional");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_2, "2, 19");

		comboRegional = new JComboBox();
		add(comboRegional, "2, 21, 3, 1, fill, default");

		JLabel lblNewLabel_1 = new JLabel("Data saida:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_1, "2, 22");

		JLabel lblNewLabel = new JLabel("Data chegada");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 12));
		add(lblNewLabel, "4, 22, left, top");


		final DateTimePicker dataSaida = new DateTimePicker();
		add(dataSaida, "2, 24, fill, center");

		datasaida=dataSaida.getDatePicker().getDate();
		horasaida=dataSaida.getTimePicker().getTime();



		final DateTimePicker dataChegada = new DateTimePicker();
		add(dataChegada, "4, 24, fill, center");

		datachegada=dataSaida.getDatePicker().getDate();
		horachegada=dataSaida.getTimePicker().getTime();


		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		add(separator, "2, 28, 3, 1");

		JLabel lblNewLabel_5 = new JLabel("Material");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_5, "2, 32");

		JLabel lblNewLabel_6 = new JLabel("Quantidade");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_6, "3, 32");

		JLabel lblNewLabel_7 = new JLabel("Setor");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_7, "4, 32");

		textMaterial = new JTextField();
		add(textMaterial, "2, 34, fill, default");
		textMaterial.setColumns(10);

		textQuantidade = new JTextField();
		add(textQuantidade, "3, 34, left, default");
		textQuantidade.setColumns(10);

		comboSetor = new JComboBox();
		add(comboSetor, "4, 34, fill, default");

		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					salvar();
				} catch (ErroAoSalvarViagemException e1) {
					JOptionPane.showMessageDialog(btnNewButton, "ERRO FATAL. O SEU COMPUTADOR VAI EXPLODIR EM 5..4...3...2...1.................PEGADINHA");
					e1.printStackTrace();
				}

			}
		});

		JButton btnNewButton_2 = new JButton("+");
		add(btnNewButton_2, "5, 34, left, default");
		add(btnNewButton, "2, 38");

		JButton btnNewButton_1 = new JButton("CRIAR");
		add(btnNewButton_1, "4, 38");

		veiculos=veiculoController.consultaModelo();
		for(VeiculoVO v:veiculos) {
			comboVeiculo.addItem(v.getModelo());	
		}
		motoristas=motoristaControlle.consultaNome();
		for(MotoristaVO m:motoristas) {
			comboMotorista.addItem(m.getNome());
		}
		regionais=viagemController.consultaRegional();
		for(ViagemVO v:regionais) {
			comboRegional.addItem(v.getRegional());
		}
		setor=viagemController.setor();
		for(MaterialVO m : setor) {
			comboSetor.addItem(m.getSetor());
		}


	}
	protected void salvar() throws ErroAoSalvarViagemException {

		ViagemVO viagem = new ViagemVO();
		MaterialVO material = new MaterialVO();

		material.setConteudo(textMaterial.getText());

		try {
			material.setQuantidade(Integer.parseInt(textQuantidade.getText()));			
		} catch (NumberFormatException e) {

		}

		material.setSetor(comboSetor.toString());

		/*	viagem.setMotorista();
		String nomeMotorista=comboMotorista.toString();
		viagem.setMotorista(motoristaControlle.motorista(motoristaControlle.ConsultaMotorista(nomeMotorista).getIdMotorista()));

		String modeloVeiculo=comboVeiculo.toString();

		viagem.setVeiculo(veiculoController.veiculo(veiculoController.veicuo(modeloVeiculo).getIdVeiculo()));
		 */		
		
		
		viagem.setMaterial(material);
		viagem.setRegional(comboRegional.toString());
		viagem.setDataSaida(dataHoraSaida);
		viagemController.salvar(viagem);
		viagem.setDataChegada(dataHoraChegada);
		dataHoraChegada=LocalDateTime.of(datachegada, horachegada);
		dataHoraSaida=LocalDateTime.of(datasaida, horasaida);
	}
}

