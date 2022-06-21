package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.github.lgooddatepicker.components.DateTimePicker;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import controller.VeiculoController;
import model.dao.VeiculoDAO;
import model.exception.ErroAoSalvarVeiculoException;
import model.vo.VeiculoVO;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelVeiculo extends JPanel {
	private JTextField textModelo;
	private JTextField textMarca;
	private JTextField textPlaca;
	private JTextField textRenavam;
	private VeiculoVO veiculo = new VeiculoVO();
	private VeiculoController veiculoController = new VeiculoController();
	private JTextField textAno;
	private JLabel lblErro;
	JFrame frame;
	/**
	 * Create the panel.
	 */
	public PanelVeiculo(VeiculoVO veiculo) {
		setBackground(new Color(112, 128, 144));
		setLayout(new MigLayout("", "[][grow][]", "[][][][][][][][][][][][][][][][][][][53.00]"));

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

		JButton btnNewButton = new JButton("     ENTER     ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				salvar();

			}
		});

		JLabel lblNewLabel_4 = new JLabel("ANO");
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_4, "cell 1 11");

		textAno = new JTextField();
		add(textAno, "cell 1 12");
		textAno.setColumns(10);
		
		lblErro = new JLabel("");
		lblErro.setForeground(new Color(255, 0, 0));
		lblErro.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblErro, "cell 1 14,alignx center,aligny center");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		add(btnNewButton, "cell 1 18,alignx center,growy");
		
		//REMOVER PARA INCLUSÃO

	}

	protected void salvar() {
		veiculo.setMarca(textMarca.getText());
		veiculo.setModelo(textModelo.getText());
		veiculo.setPlaca(textPlaca.getText());
		veiculo.setRenavam(textRenavam.getText());
		try {
			veiculo.setAno(Integer.parseInt(textAno.getText()));
			veiculoController.salvar(veiculo);
			
		} catch (NumberFormatException e) {
			lblErro.setBackground(new Color(255,0,0));
			lblErro.setText("Informe o ANO com somente dígitos");
		} catch (ErroAoSalvarVeiculoException e) {
			lblErro.setText(e.getMessage());
		}
		
	
		
	}

}
