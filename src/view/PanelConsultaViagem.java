package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.ViagemController;
import model.seletor.SeletorViagem;

import model.vo.GeradorPlanilhaViagem;
import model.vo.ViagemVO;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelConsultaViagem extends JPanel {
	private JTable table;
	private JFrame frame =new JFrame();
	private JTextField textMotorista;
	private JTextField textVeiculo;
	private JTextField textRegional;
	private ArrayList<ViagemVO>viagens=new ArrayList<ViagemVO>();
	private ViagemController viagemController= new ViagemController();
	private SeletorViagem seletor = new SeletorViagem();
	private LocalDate datasaida;
	private LocalTime horasaida;
	private LocalDate datachegada;
	private LocalTime horachegada;
	private LocalDateTime dataHoraSaida;
	private LocalDateTime dataHoraChegada;
	private ViagemVO viagemSelecionada = new ViagemVO();
	
	/**
	 * Create the panel.
	 */
	public PanelConsultaViagem() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 102, 102));
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
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
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
		add(lblNewLabel_6, "1, 1, 20, 8, fill, fill");
		
		JLabel lblNewLabel_5 = new JLabel("CONSULTA DE VIAGEM");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblNewLabel_5, "2, 9, 19, 3, center, center");
		
		JLabel lblNewLabel = new JLabel("Data saida e hora");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel, "4, 12, default, bottom");
		
		JLabel lblNewLabel_2 = new JLabel("Data chegada e hora ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_2, "6, 12, default, bottom");
		
		JLabel lblNewLabel_1 = new JLabel("Motorista");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_1, "10, 12, left, bottom");
		
		JLabel lblNewLabel_3 = new JLabel("Veiculo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_3, "14, 12, left, bottom");
		
		JLabel lblNewLabel_4 = new JLabel("Regional");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_4, "18, 12, left, bottom");
		
		
		final DateTimePicker dataSaida = new DateTimePicker();
		
		add(dataSaida, "4, 14, fill, default");
		
		
		final DateTimePicker dataChegada = new DateTimePicker();
		
		
		add(dataChegada, "6, 14, fill, default");
	
		
		textMotorista = new JTextField();
		textMotorista.setBackground(SystemColor.controlHighlight);
		add(textMotorista, "10, 14, fill, default");
		textMotorista.setColumns(10);
		
		textVeiculo = new JTextField();
		textVeiculo.setBackground(SystemColor.controlHighlight);
		add(textVeiculo, "14, 14, fill, default");
		textVeiculo.setColumns(10);
		
		textRegional = new JTextField();
		textRegional.setBackground(SystemColor.controlHighlight);
		add(textRegional, "18, 14, fill, default");
		textRegional.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 viagemSelecionada= new ViagemVO();
				int selecionado=table.getSelectedRow();
				
				viagemSelecionada= viagens.get(selecionado-1);

			}
		});
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		add(table, "4, 16, 15, 1, fill, fill");
		
		JButton btnNewButton_2 = new JButton("PESQUISAR");
		btnNewButton_2.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				datasaida=dataSaida.getDatePicker().getDate();
				horasaida=dataSaida.getTimePicker().getTime();


				datachegada=dataChegada.getDatePicker().getDate();
				horachegada=dataChegada.getTimePicker().getTime();


				try {
					dataHoraSaida=LocalDateTime.of(datasaida, horasaida);
					dataHoraChegada=LocalDateTime.of(datachegada, horachegada);
				} catch (Exception e1) {

				}

				
			seletor.setDataChegada(dataHoraChegada);
			seletor.setDataSaida(dataHoraSaida);
			seletor.setMotorista(textMotorista.getText());
			seletor.setRegional(textRegional.getText());
			seletor.setVeiculo(textVeiculo.getText());
				atualizarTabela();
			}
		});
		
		JButton btnNewButton_1 = new JButton("IMPRIMIR");
		btnNewButton_1.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser janela = new JFileChooser();
				int selecionado = janela.showSaveDialog(null);
				if(selecionado==JFileChooser.APPROVE_OPTION) {
					String caminho=janela.getSelectedFile().getAbsolutePath();
					GeradorPlanilhaViagem planilha = new GeradorPlanilhaViagem();
					
					String mensagem =planilha.geradorPlanilha(caminho, viagens);
					
					JOptionPane.showMessageDialog(null, mensagem);
					
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton_1, "8, 20, fill, center");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton_2, "10, 20, fill, center");
		
		JButton btnNewButton = new JButton("EXCLUIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viagemController.excluirViagem(viagemSelecionada.getIdviagem());
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton, "12, 20, fill, center");
		
	}

protected void atualizarTabela() {

		viagens=viagemController.consulta(seletor);
		
		table.setModel(new DefaultTableModel(new String[][] { 
			{ "data saida","data chegada","Nome motorista","Modelo veiculo","Reginal","conteudo","quantidade" }, },
			new String[] { "data saida","data chegada","Nome motorista","Modelo veiculo","Regional","conteudo","quantidade"}));
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		for(ViagemVO viagem: viagens) {
			String[] novaLinha = new String[] {
		viagem.getDataSaida()+"",
		viagem.getDataChegada()+"",
		viagem.getMotorista().getNome(),
		viagem.getVeiculo().getModelo(),
		viagem.getRegional(),
		viagem.getMaterial().getConteudo(),
		viagem.getMaterial().getQuantidade()+""
			};
			
			modelo.addRow(novaLinha);
		}
	}

}
