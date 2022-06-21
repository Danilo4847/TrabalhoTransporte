package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;

public class Tela extends JPanel {

	/**
	 * Create the panel.
	 */
	public Tela() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("186px"),
				ColumnSpec.decode("100px"),},
			new RowSpec[] {
				RowSpec.decode("100px"),
				RowSpec.decode("30px"),
				RowSpec.decode("60px"),
				RowSpec.decode("14px"),}));
		
		final DateTimePicker f = new DateTimePicker();
		add(f, "1, 3, fill, fill");
		
		JLabel lblNewLabel = new JLabel("Nome");
		add(lblNewLabel, "1, 4, left, top");
		

	}
}
