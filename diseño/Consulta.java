package diseño;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import negocio.Miaplicacion;
import negocio.Modelotabla;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Consulta extends JFrame {
	private JTextField txtCedula;
	private JTextField Nom;
	private JTable table;
	private DefaultTableModel modelo_Nombres = new Modelotabla(new String[] { "cedula", "fecha", "entrada", "salida" });
	private JDateChooser date1;
	private JDateChooser date2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Consulta() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Mateo Ferreira\\Desktop\\istockphoto-1024633926-170667a.jpg"));
		setTitle("Consultas");
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(null);

		JLabel Imagen = new JLabel("");
		Imagen.setIcon(new ImageIcon("C:\\Users\\Mateo Ferreira\\Desktop\\istockphoto-1024633926-170667a.jpg"));
		Imagen.setBounds(10, 10, 342, 194);
		getContentPane().add(Imagen);

		JLabel Nombre = new JLabel("Masarak  ENTERPRISES");
		Nombre.setForeground(Color.WHITE);
		Nombre.setFont(new Font("Corbel", Font.ITALIC, 25));
		Nombre.setBounds(10, 214, 308, 49);
		getContentPane().add(Nombre);

		JButton ConC = new JButton("Confirmar\r\n");
		ConC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
				String fecha1 = formato.format(date1.getDate());
				String fecha2 = formato.format(date2.getDate());
				Miaplicacion.consulta_ced(txtCedula.getText(), fecha1, fecha2, modelo_Nombres);
				txtCedula.setText("");

			}
		});
		ConC.setForeground(Color.WHITE);
		ConC.setFont(new Font("Corbel", Font.ITALIC, 20));
		ConC.setBackground(new Color(102, 102, 102));
		ConC.setBounds(483, 213, 197, 34);
		getContentPane().add(ConC);

		JButton ConN = new JButton("Confirmar\r\n");
		ConN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Miaplicacion.consulta_nom(Nom.getText(), modelo_Nombres);
			}
		});
		ConN.setForeground(Color.WHITE);
		ConN.setFont(new Font("Corbel", Font.ITALIC, 20));
		ConN.setBackground(new Color(102, 102, 102));
		ConN.setBounds(676, 328, 197, 34);
		getContentPane().add(ConN);

		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (!Character.isDigit(caracter) && caracter != '\s' && caracter != 8) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				Nom.setText("");
			}
		});
		txtCedula.setForeground(Color.WHITE);
		txtCedula.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		txtCedula.setColumns(10);
		txtCedula.setBackground(new Color(102, 102, 102));
		txtCedula.setBounds(530, 97, 179, 26);
		getContentPane().add(txtCedula);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Consulta por CI");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Corbel", Font.ITALIC, 25));
		lblNewLabel_1_1_1_1.setBounds(323, 92, 216, 34);
		getContentPane().add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Consulta por nombre");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Corbel", Font.ITALIC, 25));
		lblNewLabel_1_1_1_1_1.setBounds(252, 301, 216, 34);
		getContentPane().add(lblNewLabel_1_1_1_1_1);

		Nom = new JTextField();
		Nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio)) {
					e.consume();
				}
			}
		});
		Nom.setForeground(Color.WHITE);
		Nom.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		Nom.setColumns(10);
		Nom.setBackground(new Color(102, 102, 102));
		Nom.setBounds(483, 306, 179, 26);
		getContentPane().add(Nom);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 21));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(79, 385, 864, 169);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setSelectionBackground(new Color(0, 0, 51));
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(new Color(0, 0, 51));
		table.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 18));
		table.setForeground(new Color(255, 255, 255));
		table.setModel(modelo_Nombres);

		date1 = new JDateChooser();
		date1.setBounds(402, 149, 242, 34);
		getContentPane().add(date1);

		date2 = new JDateChooser();
		date2.setBounds(715, 149, 242, 34);
		getContentPane().add(date2);

		JSeparator separator = new JSeparator();
		separator.setBounds(284, 257, 743, 6);
		getContentPane().add(separator);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Login miLogin = new Login();
				miLogin.setVisible(true);
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1041, 637);
	}
}
