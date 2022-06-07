package model.view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.dao.MotoristaDAO;
import model.vo.MotoristaVO;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import java.awt.Canvas;

public class PanelMotorista extends JPanel {
	private JTextField textHabilitação;
	private JTextField textCNH;
	private JTextField textNome;
	private JTextField textCategoriaCarteira;

	/**
	 * Create the panel.
	 */
	public PanelMotorista(MotoristaVO motorista) {
		setBackground(new Color(112, 128, 144));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		setLayout(new MigLayout("", "[200px][100px,grow][4px][200px]", "[][24.00px][54.00px][20px][20px][23.00px][16.00][][][][][][][][][]"));
		
				
				JLabel lblNewLabel_3 = new JLabel("INSERIR MOTORISTA");
				lblNewLabel_3.setFont(new Font("Constantia", Font.PLAIN, 20));
				add(lblNewLabel_3, "cell 0 1 4 1,alignx center,growy");
		add(separator, "cell 1 2 2 1,growx,aligny center");
		
		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel, "cell 1 3,alignx left,aligny center");
		
		textNome = new JTextField();
		add(textNome, "cell 1 4,growx");
		textNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CNH:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_1, "cell 1 5,alignx left,aligny center");
		
		textCNH = new JTextField();
		add(textCNH, "cell 1 6,growx");
		textCNH.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CATEGORIA DA CARTEIRA");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel_4, "cell 1 7");
		
		textCategoriaCarteira = new JTextField();
		add(textCategoriaCarteira, "cell 1 8,growx");
		textCategoriaCarteira.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("HABILITA\u00C7\u00C3O");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_2, "cell 1 9,alignx left,aligny bottom");
		
		textHabilitação = new JTextField();
		textHabilitação.setColumns(10);
		add(textHabilitação, "cell 1 10,growx,aligny top");
		
		JButton btnEnter = new JButton("     Enter    ");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnEnter.setForeground(new Color(112, 128, 144));
		btnEnter.setBackground(new Color(255, 255, 255));
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(btnEnter, "cell 1 12 1 3,alignx center,growy");

	}

}
