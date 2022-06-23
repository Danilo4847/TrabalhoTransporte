package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.MotoristaController;

import model.seletor.SeletorMotorista;
import model.vo.MotoristaVO;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelConsultaMotorista extends JPanel {
	private JTable table;
	private JTextField textNome;
	private JTextField textCnh;
	private JTextField textCategoriaCarteira;
	private MotoristaController motoristaController= new MotoristaController();
	private SeletorMotorista seletor= new SeletorMotorista();

	private List<MotoristaVO> motoristas=new ArrayList<MotoristaVO>();
	private JLabel lblErro;
	
	/**
	 * Create the panel.
	 */
	public PanelConsultaMotorista() {
		setBackground(new Color(112, 128, 144));
		FormLayout formLayout = new FormLayout(new ColumnSpec[] {
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
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.GLUE_ROWSPEC,});
		formLayout.setRowGroups(new int[][]{new int[]{2, 4, 6, 9, 11, 14, 16, 18, 19, 22, 27}});
		setLayout(formLayout);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PanelConsultaMotorista.class.getResource("/icon/floresta.jpg")));
		add(lblNewLabel, "1, 1, 10, 7");
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA MOTORISTA");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 30));
		add(lblNewLabel_1, "1, 8, 10, 3, center, default");
		
		JLabel lblNewLabel_2 = new JLabel("NOME");
		add(lblNewLabel_2, "4, 11");
		
		JLabel lblNewLabel_3 = new JLabel("CNH");
		add(lblNewLabel_3, "6, 11");
		
		JLabel lblNewLabel_4 = new JLabel("CATEGORIA DA CARTEIRA");
		add(lblNewLabel_4, "8, 11");
		
		textNome = new JTextField();
		add(textNome, "4, 13, fill, default");
		textNome.setColumns(10);
		
		textCnh = new JTextField();
		add(textCnh, "6, 13, fill, default");
		textCnh.setColumns(10);
		
		textCategoriaCarteira = new JTextField();
		add(textCategoriaCarteira, "8, 13, fill, default");
		textCategoriaCarteira.setColumns(10);
		
		table = new JTable();
		add(table, "3, 15, 7, 5, fill, fill");
		
		lblErro = new JLabel("New label");
		add(lblErro, "2, 21, 9, 1, center, center");
		
		JButton btnNewButton = new JButton("EXCLUIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MotoristaVO motoristaSelecionado = new MotoristaVO();
				int indiceSelecionado = table.getSelectedRow();
				motoristaSelecionado = motoristas.get(indiceSelecionado - 1);
				
			
				motoristaController.excluirMotorista(motoristaSelecionado.getIdMotorista());
				JOptionPane.showMessageDialog(btnNewButton, motoristaSelecionado.getIdMotorista());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton, "4, 22, 1, 5, fill, center");
		
		JButton btnNewButton_1 = new JButton("IMPRIMIR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnNewButton_1, "8, 22, 1, 5, fill, center");
		
		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				seletor.setCategoriaCarteira(textCategoriaCarteira.getText());
				seletor.setCNH(textCnh.getText());
				seletor.setNome(textNome.getText());
				atualizarTabela();
				
			}
		});
		add(btnPesquisar, "6, 22, 1, 5, fill, center");

	}
	
	protected void atualizarTabela() {
		motoristas=motoristaController.consulta(seletor);
		
		table.setModel(new DefaultTableModel(new String[][] { 
			{ "id","CNH","Nome","categoria" }, },
			new String[] { "id","CNH","Nome","categoria"}));
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		for(MotoristaVO motorista: motoristas) {
			String[] novaLinha = new String[] {
					motorista.getIdMotorista()+"",
				motorista.getCnh(),
				motorista.getNome(),
				motorista.getCategoriaCarteira()
			};
			
			modelo.addRow(novaLinha);
		}
	}

	public JLabel getLblErro() {
		return lblErro;
	}

	public void setLblErro(JLabel lblErro) {
		this.lblErro = lblErro;
	}
	
	}


		
	
