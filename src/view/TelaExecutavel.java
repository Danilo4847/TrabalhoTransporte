package view;

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
import java.awt.Panel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import java.awt.Insets;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class TelaExecutavel extends JFrame{

	private JFrame frame;
	private JTable table;
	private JPanel contenPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExecutavel window = new TelaExecutavel();
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
	public TelaExecutavel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBounds(100, 100, 800, 499);
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
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(54dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaExecutavel.class.getResource("/icon/floresta.jpg")));
		frame.getContentPane().add(lblNewLabel, "1, 1, 16, 11");
		
		table = new JTable();
		frame.getContentPane().add(table, "4, 13, 11, 14, fill, fill");
		
		JButton btnAtualizar = new JButton("<<");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnAtualizar, "8, 28, center, center");
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnNewButton, "10, 28, center, center");
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(10, 10, 0, 0));
		menuBar.setBackground(new Color(255, 255, 255));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("HOME");
		mnNewMenu.setFont(new Font("Monospaced", Font.BOLD, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("TELA PRINCIPAL");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExecutavel tela = new TelaExecutavel();
			
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		mntmNewMenuItem.setFont(new Font("Monospaced", Font.BOLD, 20));
		mntmNewMenuItem.setBackground(Color.WHITE);
		
		JMenu mnMotorista = new JMenu("MOTORISTA");
		mnMotorista.setBackground(new Color(0, 0, 0));
		mnMotorista.setSelectedIcon(new ImageIcon(TelaExecutavel.class.getResource("/icon/Graphicloads-Polygon-Book.ico")));
		mnMotorista.setIcon(new ImageIcon(TelaExecutavel.class.getResource("/icon/Graphicloads-Polygon-Book.ico")));
		mnMotorista.setFont(new Font("Monospaced", Font.BOLD, 20));
		menuBar.add(mnMotorista);
		
		JMenuItem mntmInserirMotorista = new JMenuItem("Inserir");
		mntmInserirMotorista.setIcon(new ImageIcon(TelaExecutavel.class.getResource("/icon/Graphicloads-Polygon-Car.ico")));
		mntmInserirMotorista.setFont(new Font("Monospaced", Font.BOLD, 14));
		mnMotorista.add(mntmInserirMotorista);
		
		JMenuItem mntmConsultarMotorista = new JMenuItem("Consultar");
		mntmConsultarMotorista.setFont(new Font("Monospaced", Font.BOLD, 14));
		mntmConsultarMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelConsultaMotorista panelConsulta = new PanelConsultaMotorista();
				frame.setContentPane(panelConsulta);
				frame.revalidate();
				
			}
		});
		mnMotorista.add(mntmConsultarMotorista);
		
		JMenu mnVeiculo = new JMenu("VEICULO");
		mnVeiculo.setFont(new Font("Monospaced", Font.BOLD, 20));
		menuBar.add(mnVeiculo);
		
		JMenuItem mntmInserirVeiculo = new JMenuItem("Inserir");
		mntmInserirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelVeiculo painelVeiculo = new PanelVeiculo(null);
				frame.setContentPane(painelVeiculo);
				frame.revalidate();
			}
		});
		mntmInserirVeiculo.setFont(new Font("Monospaced", Font.BOLD, 14));
		mnVeiculo.add(mntmInserirVeiculo);
		
		JMenuItem mntmConsultaVeiculo = new JMenuItem("Consultar");
		mntmConsultaVeiculo.setFont(new Font("Monospaced", Font.BOLD, 14));
		mntmConsultaVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final PanelConsultaVeiculo panelConsulta = new PanelConsultaVeiculo();

				
				frame.setContentPane(panelConsulta);
				frame.revalidate();
				
			}
		});
		mnVeiculo.add(mntmConsultaVeiculo);
		
		JMenu mnViagem = new JMenu("VIAGEM");
		mnViagem.setFont(new Font("Monospaced", Font.BOLD, 20));
		menuBar.add(mnViagem);
		
		JMenuItem mntmCriarViagem = new JMenuItem("Criar");
		mntmCriarViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelViagem painelViagem = new PanelViagem(null);
				frame.setContentPane(painelViagem);
				frame.revalidate();
			}
		});
		mntmCriarViagem.setFont(new Font("Monospaced", Font.BOLD, 14));
		mnViagem.add(mntmCriarViagem);
		
		JMenuItem mntmConsultaViagem = new JMenuItem("Consultar");
		mntmConsultaViagem.setFont(new Font("Monospaced", Font.BOLD, 14));
		mntmConsultaViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelConsultaViagem panel = new PanelConsultaViagem();
				frame.setContentPane(panel);
				frame.revalidate();
				
				
			}
		});
		mnViagem.add(mntmConsultaViagem);
		mntmInserirMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMotorista painelMotorista = new PanelMotorista(null);
				frame.setContentPane(painelMotorista);
				frame.revalidate();
			
			}
		});
	

	}
}
