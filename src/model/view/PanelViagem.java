package model.view;

import javax.swing.JPanel;
import model.vo.ViagemVO;

import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;

public class PanelViagem extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelViagem(ViagemVO viagem) {
		setBackground(new Color(153, 153, 153));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(113dlu;default)"),
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
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
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
				RowSpec.decode("default:grow"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PanelViagem.class.getResource("/icon/a40082eab598220b06c3338b0f9594a4.jpg")));
		add(lblNewLabel, "1, 1, 10, 45");
		
		JLabel lblNewLabel_1 = new JLabel("VIAGEM");
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
		add(lblNewLabel_1, "11, 2, 8, 4");
		
		JLabel lblNewLabel_2 = new JLabel("MOTORISTA");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_2, "12, 8");
		
		JComboBox cbMotorista = new JComboBox();
		add(cbMotorista, "12, 10, 9, 1, fill, default");
		
		JLabel lblVeiculo = new JLabel("VEICULO");
		lblVeiculo.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblVeiculo, "12, 12, left, default");
		
		JComboBox cbVeiculo = new JComboBox();
		add(cbVeiculo, "12, 14, 9, 1, fill, default");
		
		JLabel lblNewLabel_4 = new JLabel("REGIONAL");
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_4, "12, 16");
		
		JComboBox cbRegional = new JComboBox();
		add(cbRegional, "12, 18, 9, 1, fill, default");
		
		JLabel lblNewLabel_5 = new JLabel("DATA SAIDA:");
		lblNewLabel_5.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_5, "12, 22");
		
		JLabel lblNewLabel_6 = new JLabel("DATA CHAEGADA:");
		lblNewLabel_6.setFont(new Font("Monospaced", Font.BOLD, 13));
		add(lblNewLabel_6, "16, 22");
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(Color.BLACK);
		add(separator, "12, 26, 9, 1");
		
		table = new JTable();
		add(table, "12, 30, 9, 10, fill, fill");
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBackground(new Color(0, 0, 0));
		add(btnSalvar, "12, 42, 1, 3");
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBackground(new Color(0, 0, 0));
		add(btnAtualizar, "14, 42, 1, 3");
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setBackground(new Color(0, 0, 0));
		add(btnImprimir, "18, 42, 1, 3");
		
		JButton btnExcluirMaterial = new JButton("EXCLUIR");
		btnExcluirMaterial.setBackground(new Color(0, 0, 0));
		add(btnExcluirMaterial, "20, 42, 1, 3");

	}

}
