package diseño;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import diseño.Aplicacion;
import diseño.RegistrarEntraSalida;
import negocio.Miaplicacion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordContra;
	private JPanel panelBotones;
	private JPanel panelContra;
	private JButton btnEntrarALa;
	private JPanel panel_ced;
	private JTextField txtCedula;

	/**
	 * Create the frame.
	 */
	public Login() {
		setForeground(new Color(0, 0, 139));
		setFont(new Font("Corbel", Font.ITALIC, 16));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Mateo Ferreira\\Desktop\\istockphoto-1024633926-170667a.jpg"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1228, 761);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Imagen = new JLabel("");
		Imagen.setBounds(0, 10, 342, 194);
		contentPane.add(Imagen);
		Imagen.setIcon(new ImageIcon("C:\\Users\\Mateo Ferreira\\Desktop\\istockphoto-1024633926-170667a.jpg"));

		JLabel Nombre = new JLabel("Masarak ENTERPRISES");
		Nombre.setBounds(10, 214, 252, 49);
		Nombre.setFont(new Font("Corbel", Font.ITALIC, 25));
		Nombre.setForeground(new Color(255, 255, 255));
		contentPane.add(Nombre);

		JLabel Titulo = new JLabel("Ingreso al sistema\r\n");
		Titulo.setBounds(517, 46, 308, 49);
		Titulo.setForeground(Color.WHITE);
		Titulo.setFont(new Font("Corbel", Font.ITALIC, 32));
		contentPane.add(Titulo);

		JSeparator separator = new JSeparator();
		separator.setBounds(334, 93, 901, 2);
		contentPane.add(separator);

		panelBotones = new JPanel();
		panelBotones.setVisible(false);
		panelBotones.setBounds(154, 334, 940, 150);
		panelBotones.setBackground(new Color(0, 0, 51));
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);

		btnEntrarALa = new JButton("Entrar a la aplicacion\r\n");
		btnEntrarALa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelContra.setVisible(true);
				passwordContra.requestFocus();

			}
		});
		btnEntrarALa.setBounds(609, 65, 240, 33);
		panelBotones.add(btnEntrarALa);
		btnEntrarALa.setBackground(new Color(102, 102, 102));
		btnEntrarALa.setForeground(new Color(255, 255, 255));
		btnEntrarALa.setFont(new Font("Corbel", Font.ITALIC, 20));

		JButton btnRegistrarEntradasalida = new JButton("Registrar entrada/salida");
		btnRegistrarEntradasalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEntraSalida miRegistro = new RegistrarEntraSalida(txtCedula.getText());
				miRegistro.setVisible(true);
				miRegistro.setLocationRelativeTo(null);

				dispose();

			}
		});
		btnRegistrarEntradasalida.setForeground(Color.WHITE);
		btnRegistrarEntradasalida.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnRegistrarEntradasalida.setBackground(new Color(102, 102, 102));
		btnRegistrarEntradasalida.setBounds(127, 65, 249, 33);
		panelBotones.add(btnRegistrarEntradasalida);

		panelContra = new JPanel();
		panelContra.setVisible(false);
		panelContra.setBounds(154, 506, 940, 150);
		panelContra.setLayout(null);
		panelContra.setBackground(new Color(0, 0, 51));
		contentPane.add(panelContra);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Corbel", Font.ITALIC, 25));
		lblNewLabel_1_1_1_1.setBounds(377, 43, 123, 34);
		panelContra.add(lblNewLabel_1_1_1_1);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Miaplicacion.buscarContraseniayUsuario(txtCedula.getText(), passwordContra.getText())) {
					Aplicacion miAplica = new Aplicacion(txtCedula.getText());
					miAplica.setVisible(true);
					txtCedula.setText("");
					passwordContra.setText("");
					panel_ced.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "La contraseña es Incorrecta", "Error de contraseña",
							JOptionPane.ERROR_MESSAGE);
					passwordContra.setText("");
					passwordContra.requestFocus();

				}

			}

		});
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnIngresar.setBackground(new Color(102, 102, 102));
		btnIngresar.setBounds(721, 106, 197, 34);
		panelContra.add(btnIngresar);

		passwordContra = new JPasswordField();
		passwordContra.setForeground(Color.WHITE);
		passwordContra.setBackground(new Color(102, 102, 102));
		passwordContra.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		passwordContra.setBounds(510, 48, 169, 26);
		panelContra.add(passwordContra);

		panel_ced = new JPanel();
		panel_ced.setBackground(new Color(0, 0, 51));
		panel_ced.setBounds(362, 131, 732, 139);
		contentPane.add(panel_ced);
		panel_ced.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("C\u00E9dula de identidad\r\n");
		lblNewLabel_1_1_1.setBounds(56, 41, 216, 34);
		panel_ced.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Corbel", Font.ITALIC, 25));

		txtCedula = new JTextField();
		txtCedula.setBounds(282, 46, 179, 26);
		panel_ced.add(txtCedula);
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char caracter = e.getKeyChar();

				if (!Character.isDigit(caracter) && caracter != '\s' && caracter != 8) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}

			}
		});
		txtCedula.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		txtCedula.setForeground(new Color(255, 255, 255));
		txtCedula.setBackground(new Color(102, 102, 102));
		txtCedula.setColumns(10);

		JButton confirmar = new JButton("CONFIRMAR");
		confirmar.setBounds(510, 95, 197, 34);
		panel_ced.add(confirmar);
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarFuncionario(txtCedula.getText())) {
					String tipoF = Miaplicacion.buscarTipoFuncionario(txtCedula.getText());

					if (Miaplicacion.buscarEstado(txtCedula.getText())) {
						if (tipoF.equals("D") || tipoF.equals("S") || tipoF.equals("A")) {
							panelBotones.setVisible(true);
							txtCedula.setEnabled(false);
							confirmar.setEnabled(false);
						} else {
							if (!tipoF.equals("F")) {
								JOptionPane.showMessageDialog(contentPane,
										"La cédula que ingresó no esta registrada o no es un usuario válido",
										"No existe la Cédula", JOptionPane.ERROR_MESSAGE);
								txtCedula.requestFocus();
							} else {
								txtCedula.setEnabled(false);
								confirmar.setEnabled(false);
								panelBotones.setVisible(true);
								btnEntrarALa.setVisible(false);
								panelContra.setVisible(false);
							}
						}

					} else {
						JOptionPane.showMessageDialog(contentPane, "Usuario Inactivo", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						txtCedula.requestFocus();

					}
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"La cédula que ingresó no esta registrada o no es un usuario válido", "No existe la Cédula",
							JOptionPane.ERROR_MESSAGE);
					txtCedula.requestFocus();
				}

			}

		});
		confirmar.setForeground(new Color(255, 255, 255));
		confirmar.setBackground(new Color(102, 102, 102));
		confirmar.setFont(new Font("Corbel", Font.ITALIC, 20));
	}
}
