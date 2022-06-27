package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DateTimePicker;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import controller.VeiculoController;
import model.dao.VeiculoDAO;
import model.exception.ErroAoSalvarVeiculoException;
import model.vo.VeiculoVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class PanelVeiculo extends JPanel {
	private JTextField textModelo;
	private JFormattedTextField textPlaca;
	private JTextField textRenavam;
	private VeiculoVO veiculo = new VeiculoVO();
	private VeiculoController veiculoController = new VeiculoController();
	private JTextField textAno;
	private JTextArea textAreaValoresCamposComMascara;
	private JLabel lblErro;
	private String marcas[]= {"FIAT","GOL","BMW","AUDI","CITROEN","BENTLY","FERRARI","FORD"
			,"HONDA","JEEP","JAGUAR","HYUNDAI","KIA","LAMBORGHINI","LAND ROVER","LEXUS","MASERATI"
			,"MERCEDES-BENZ","NISSAN","PEUGEOT","MINI","RENAULT","VOLVO","VW","TOYOTA"};

	JFrame frame;
	private JComboBox comboBox;
	private String placaCompleta;
	/**
	 * Create the panel.
	 */
	public PanelVeiculo(VeiculoVO veiculo) {
		setBackground(new Color(0, 102, 102));
		setLayout(new MigLayout("", "[][grow][]", "[][][][][][][][][][][][][][][][][][][][][][53.00]"));

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

		comboBox = new JComboBox(marcas);
		add(comboBox, "cell 1 6,growx");

		JLabel lblNewLabel_2 = new JLabel("PLACA");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_2, "cell 1 8");

		
		try {
			MaskFormatter mascaraPlaca = new MaskFormatter("UUU-####");
			
			
			textPlaca = new JFormattedTextField(mascaraPlaca);
			add(textPlaca, "cell 1 9,growx");
			textPlaca.setColumns(10);
			
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


		JLabel lblNewLabel_3 = new JLabel("RENAVAM");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_3, "cell 1 10");

		textRenavam = new JTextField();
		add(textRenavam, "cell 1 11,growx");
		textRenavam.setColumns(10);

		JButton btnNewButton = new JButton("     ENTER     ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
		
				
				
				salvar();
			}
		});

		JLabel lblNewLabel_4 = new JLabel("ANO");
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_4, "cell 1 12");

		textAno = new JTextField();
		add(textAno, "cell 1 13");
		textAno.setColumns(10);

		lblErro = new JLabel("");
		lblErro.setForeground(new Color(255, 0, 0));
		lblErro.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblErro, "cell 1 15,alignx center,aligny center");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		add(btnNewButton, "cell 1 21,alignx center,growy");
		comboBox.setSelectedIndex(-1);
		//REMOVER PARA INCLUSÃO


	}

	protected void salvar(){

		String letras=textPlaca.getText().substring(0,3);
		String numeros=textPlaca.getText().substring(4,8);
		
		
		try {
			String placa=(letras+numeros);
		
			veiculo.setPlaca(placa);
			
		} catch (Exception e2) {
		}
			
		
		
		veiculo.setModelo(textModelo.getText());
		veiculo.setRenavam(textRenavam.getText());
		String mensagem;
		try {
			if(comboBox.getSelectedItem()!=null) {

				veiculo.setMarca(comboBox.getSelectedItem().toString());
			}
			veiculo.setAno(Integer.parseInt(textAno.getText()));
		} catch (NumberFormatException e) {
		}	
		try {
			mensagem=veiculoController.salvar(veiculo);
			lblErro.setText(mensagem);
			lblErro.setForeground(new Color(0,255,0));
			lblErro.setText("Salvo com sucesso");
			limpar();
		} catch (ErroAoSalvarVeiculoException e) {
			lblErro.setText(e.getMessage());
		}

	}
	protected void limpar() {
		textAno.setText("");
		textModelo.setText("");
		textPlaca.setText("");
		textRenavam.setText("");
		comboBox.setSelectedIndex(-1);
	}

}
