package model.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;

public class TelaExecutal extends JFrame{

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExecutal window = new TelaExecutal();
					window.frame.setVisible(true);
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frame.setExtendedState(JFrame.MAXIMIZED_HORIZ);
					window.frame.setExtendedState(JFrame.MAXIMIZED_VERT);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExecutal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 699, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
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
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\danil\\git\\trabalhoTransporte\\trabalhoTransporteVilmar\\src\\icon\\4k-wallpaper-close-up-dew-807598.jpg"));
		frame.getContentPane().add(lblNewLabel, "1, 1, 16, 9");
		
		table = new JTable();
		frame.getContentPane().add(table, "4, 11, 11, 10, fill, fill");
		
		JButton btnAtualizar = new JButton("<<");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnAtualizar, "8, 24, center, center");
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnNewButton, "10, 24, center, center");
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMotorista = new JMenu("MOTORISTA");
		mnMotorista.setFont(new Font("Arial Black", Font.PLAIN, 20));
		menuBar.add(mnMotorista);
		
		JMenuItem mntmInserirMotorista = new JMenuItem("Inserir");
		mntmInserirMotorista.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnMotorista.add(mntmInserirMotorista);
		
		JMenu mnVeiculo = new JMenu("VEICULO");
		mnVeiculo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		menuBar.add(mnVeiculo);
		
		JMenuItem mntmInserirVeiculo = new JMenuItem("Inserir");
		mntmInserirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelVeiculo painelVeiculo = new PanelVeiculo(null);
				frame.setContentPane(painelVeiculo);
				frame.revalidate();
			}
		});
		mntmInserirVeiculo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnVeiculo.add(mntmInserirVeiculo);
		
		JMenu mnViagem = new JMenu("VIAGEM");
		mnViagem.setFont(new Font("Arial Black", Font.PLAIN, 20));
		menuBar.add(mnViagem);
		
		JMenuItem mntmCriarViagem = new JMenuItem("Criar");
		mntmCriarViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelViagem painelViagem = new PanelViagem(null);
				frame.setContentPane(painelViagem);
				frame.revalidate();
			}
		});
		mntmCriarViagem.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnViagem.add(mntmCriarViagem);
		mntmInserirMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMotorista painelMotorista = new PanelMotorista(null);
				frame.setContentPane(painelMotorista);
				frame.revalidate();
			
			}
		});
	

	}
}
