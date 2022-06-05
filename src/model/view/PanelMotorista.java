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

public class PanelMotorista extends JPanel {
	private JTextField textNome;
	private JTextField textCnh;
	private JTextField textHabilitação;

	/**
	 * Create the panel.
	 */
	public PanelMotorista(MotoristaVO motorista) {
		setBackground(new Color(95, 158, 160));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		setLayout(new MigLayout("", "[38px][2px][88.00px][188.00][4px][257px]", "[44px][2px][20px][20px][20px][23.00px][16.00][][][][][][][][][]"));
		
				
				JLabel lblNewLabel_3 = new JLabel("INSERIR MOTORISTA");
				lblNewLabel_3.setFont(new Font("Constantia", Font.PLAIN, 20));
				add(lblNewLabel_3, "cell 0 0 6 1,alignx center,growy");
		add(separator, "cell 5 1,alignx center,aligny top");
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel, "cell 0 3,alignx left,aligny center");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		add(textNome, "cell 2 3 4 1,growx,aligny top");
		
		JLabel lblNewLabel_1 = new JLabel("CNH:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_1, "cell 0 5,alignx left,aligny center");
		
		textCnh = new JTextField();
		textCnh.setColumns(10);
		add(textCnh, "cell 2 5 4 1,growx,aligny top");
		
		JLabel lblNewLabel_2 = new JLabel("Habilita\u00E7\u00E3o:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_2, "cell 0 7,alignx left,aligny bottom");
		
		textHabilitação = new JTextField();
		textHabilitação.setColumns(10);
		add(textHabilitação, "cell 2 7 4 1,growx,aligny top");
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotoristaDAO dao = new MotoristaDAO();
				MotoristaVO vo = new MotoristaVO();
				vo.setNome(textNome.getText());
				vo.setCnh(textCnh.getText());
				vo.setCategoriaCarteira(textHabilitação.getText());
				dao.inserirMotorista(vo);
			}
		});
		btnEnter.setForeground(new Color(112, 128, 144));
		btnEnter.setBackground(new Color(255, 255, 255));
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(btnEnter, "cell 5 15,growx,aligny top");

	}

}
