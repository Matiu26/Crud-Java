package diseño;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dato.Dato;
import negocio.Miaplicacion;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//aplicacion

public class Aplicacion extends JFrame {
	private JPanel panel_ced;
	private JTextField txtCedula2;
	private JTextField txtNombre;
	private JPanel panel_alta;
	private JButton btnEditar;
	private JLabel ibl_Nuevo;
	private JButton btnCon;
	private JPasswordField nueva_con;
	private JPanel panel_dir;
	private JButton btn_cambioCon;
	private JButton btn_cambio;
	private JButton btnConfirmar;
	private JButton btnconF;
	private JButton btnconfirF;
	private JButton btn_ediF;
	private JLabel lblNewLabel_1_1_1_1_2;
	private JPasswordField contra;
	private JLabel lbl_contra;
	private JComboBox ComboT;
	private JLabel cedula1;
	private JLabel nombre1;
	private JLabel tipo1;
	private JLabel lblDatos;
	private JLabel lblDatos_1;
	private JLabel lblNombre;
	private JLabel lblTipoFuncionario;
	private JPanel panel_info;
	private JButton Mostrar;
	private JButton btnMostrar;

	public Aplicacion(String Cedula_) {

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Mateo Ferreira\\Desktop\\istockphoto-1024633926-170667a.jpg"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Login miLogin = new Login();
				miLogin.setVisible(true);
			}
		});
		setTitle("Aplicacion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1194, 728);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Imagen = new JLabel("");
		Imagen.setBounds(0, 10, 298, 194);
		Imagen.setIcon(new ImageIcon("C:\\Users\\Mateo Ferreira\\Desktop\\istockphoto-1024633926-170667a.jpg"));
		contentPane.add(Imagen);

		JLabel Nombre = new JLabel("Masarak  ENTERPRISES");
		Nombre.setBounds(10, 214, 257, 49);
		Nombre.setForeground(Color.WHITE);
		Nombre.setFont(new Font("Corbel", Font.ITALIC, 25));
		contentPane.add(Nombre);

		panel_ced = new JPanel();
		panel_ced.setVisible(false);
		panel_ced.setBounds(389, 515, 699, 166);
		panel_ced.setBackground(new Color(0, 0, 51));
		contentPane.add(panel_ced);
		panel_ced.setLayout(null);

		JLabel lbl_cedu = new JLabel("C\u00E9dula de identidad\r\n");
		lbl_cedu.setBounds(92, 23, 216, 34);
		panel_ced.add(lbl_cedu);
		lbl_cedu.setForeground(Color.WHITE);
		lbl_cedu.setFont(new Font("Corbel", Font.ITALIC, 25));

		JTextField txtCedula = new JTextField();
		txtCedula.setBounds(298, 23, 179, 26);
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
		panel_ced.add(txtCedula);
		txtCedula.setForeground(Color.WHITE);
		txtCedula.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		txtCedula.setColumns(10);
		txtCedula.setBackground(new Color(102, 102, 102));

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setVisible(false);
		btnConfirmar.setBounds(492, 122, 197, 34);
		btnConfirmar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarExistencia(txtCedula.getText())) {
					Miaplicacion.baja(txtCedula.getText());
				} else if (txtCedula.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"La cédula que ingresó no existe, para realizar una baja la misma debe existir ",
							"No existe la Cédula", JOptionPane.ERROR_MESSAGE);
					txtCedula.requestFocus();
				}
				cedula1.setText("");
				nombre1.setText("");

				tipo1.setText("");
				txtCedula.setText("");
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnConfirmar.setBackground(new Color(102, 102, 102));
		panel_ced.add(btnConfirmar);

		JLabel lbl_con = new JLabel("Nueva contrase\u00F1a\r\n");
		lbl_con.setForeground(Color.WHITE);
		lbl_con.setFont(new Font("Corbel", Font.ITALIC, 25));
		lbl_con.setBounds(92, 67, 189, 34);
		panel_ced.add(lbl_con);

		btn_cambio = new JButton("Cambiar");
		btn_cambio.setVisible(false);
		btn_cambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarExistencia(txtCedula.getText())) {
					Miaplicacion.cambiarContra(txtCedula.getText(), nueva_con.getText());

					txtCedula.setText("");
					nueva_con.setText("");
					cedula1.setText("");
					nombre1.setText("");

					tipo1.setText("");
				}
				if (txtCedula.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "",
							JOptionPane.ERROR_MESSAGE);
				}
				if (nueva_con.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Tienes que ingresar una contraseña ", "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"La cédula que ingresó no existe, para realizar un cambio de contraseña la misma debe existir ",
							"No existe la Cédula", JOptionPane.ERROR_MESSAGE);
					txtCedula.requestFocus();
				}
			}
		});
		btn_cambio.setForeground(Color.WHITE);
		btn_cambio.setFont(new Font("Corbel", Font.ITALIC, 20));
		btn_cambio.setBackground(new Color(102, 102, 102));
		btn_cambio.setBounds(376, 122, 162, 34);
		panel_ced.add(btn_cambio);

		nueva_con = new JPasswordField();
		nueva_con.setForeground(Color.WHITE);
		nueva_con.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		nueva_con.setBackground(new Color(102, 102, 102));
		nueva_con.setBounds(298, 72, 169, 26);
		panel_ced.add(nueva_con);

		btnconfirF = new JButton("Confirmar\r\n");
		btnconfirF.setVisible(false);
		btnconfirF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarExistencia(txtCedula.getText())) {
					Miaplicacion.baja_A(txtCedula.getText());
				} else if (txtCedula.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"La cédula que ingresó no existe, para realizar una baja la misma debe existir ",
							"No existe la Cédula", JOptionPane.ERROR_MESSAGE);
					txtCedula.requestFocus();

				}
				cedula1.setText("");
				nombre1.setText("");

				tipo1.setText("");
				txtCedula.setText("");
			}
		});
		btnconfirF.setForeground(Color.WHITE);
		btnconfirF.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnconfirF.setBackground(new Color(102, 102, 102));
		btnconfirF.setBounds(505, 86, 184, 26);
		panel_ced.add(btnconfirF);

		btnMostrar = new JButton("Mostrar Datos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarExistencia(txtCedula.getText())) {
					Dato dato = Miaplicacion.buscarDatosFuncionario(txtCedula.getText());

					cedula1.setText(dato.getCedula());
					nombre1.setText(dato.getNombre());

					tipo1.setText(dato.getTipoFuncionario());

				} else if (txtCedula.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"La cédula que ingresó no existe, para mostrar los datos de un usuario, el mismo  debe existir ",
							"No existe la Cédula", JOptionPane.ERROR_MESSAGE);
					txtCedula.requestFocus();
				}
				txtCedula.setText("");
			}
		});
		btnMostrar.setVisible(false);
		btnMostrar.setForeground(Color.WHITE);
		btnMostrar.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnMostrar.setBackground(new Color(102, 102, 102));
		btnMostrar.setBounds(525, 54, 164, 28);
		panel_ced.add(btnMostrar);

		panel_dir = new JPanel();
		panel_dir.setBounds(389, 39, 699, 155);
		panel_dir.setBackground(new Color(0, 0, 51));
		contentPane.add(panel_dir);
		panel_dir.setLayout(null);

		String tipoF = Miaplicacion.buscarTipoFuncionario(Cedula_);
		if (tipoF.equals("D") || tipoF.equals("S")) {
			panel_dir.setVisible(true);
		}

		JButton btnAltas = new JButton("Altas");
		btnAltas.setBounds(25, 26, 197, 34);
		panel_dir.add(btnAltas);
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoF = Miaplicacion.buscarTipoFuncionario(Cedula_);
				if (tipoF.equals("D") || tipoF.equals("S")) {
					panel_dir.setVisible(true);
					panel_alta.setVisible(true);
					panel_info.setVisible(false);
					txtCedula2.requestFocus();
					lblNewLabel_1_1_1_1_2.setVisible(true);
					ComboT.setVisible(true);
					panel_ced.setVisible(false);
					Mostrar.setVisible(false);
					btnCon.setVisible(true);
					btnMostrar.setVisible(false);
					btnEditar.setVisible(false);
					ibl_Nuevo.setVisible(false);
					btn_ediF.setVisible(false);
					txtCedula2.setText("");
					txtNombre.setText("");
					cedula1.setText("");
					nombre1.setText("");

					tipo1.setText("");
					ComboT.setSelectedIndex(0);
				} else {
					panel_dir.setVisible(true);
					panel_alta.setVisible(true);
					panel_ced.setVisible(false);
					panel_info.setVisible(false);
					Mostrar.setVisible(false);
					btnMostrar.setVisible(false);
					lblNewLabel_1_1_1_1_2.setVisible(false);
					ComboT.setVisible(false);
					btnconF.setVisible(true);
					btnEditar.setVisible(false);
					ibl_Nuevo.setVisible(false);
					btn_ediF.setVisible(false);
					btnEditar.setVisible(false);
					txtCedula2.setText("");
					txtNombre.setText("");
					cedula1.setText("");
					nombre1.setText("");

					tipo1.setText("");
					ComboT.setSelectedIndex(0);

				}

			}
		});
		btnAltas.setForeground(Color.WHITE);
		btnAltas.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnAltas.setBackground(new Color(102, 102, 102));

		JButton btnBajas = new JButton("Bajas");
		btnBajas.setBounds(463, 26, 197, 34);
		panel_dir.add(btnBajas);
		btnBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tipoF.equals("D") || tipoF.equals("S")) {
					btnConfirmar.setVisible(true);
					btn_cambio.setVisible(false);
					panel_alta.setVisible(false);
					panel_ced.setVisible(true);
					panel_info.setVisible(true);
					btnMostrar.setVisible(true);
					txtCedula.requestFocus();
					lbl_con.setVisible(false);
					nueva_con.setVisible(false);
					ComboT.setSelectedIndex(0);
					cedula1.setText("");
					nombre1.setText("");

					tipo1.setText("");
				} else {

					btnConfirmar.setVisible(false);
					btnconfirF.setVisible(true);
					btn_cambio.setVisible(false);
					panel_alta.setVisible(false);
					panel_ced.setVisible(true);
					panel_info.setVisible(true);
					btnMostrar.setVisible(true);
					txtCedula.requestFocus();
					lbl_con.setVisible(false);
					nueva_con.setVisible(false);
					ComboT.setSelectedIndex(0);
					cedula1.setText("");
					nombre1.setText("");

					tipo1.setText("");
				}
			}
		});
		btnBajas.setForeground(Color.WHITE);
		btnBajas.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnBajas.setBackground(new Color(102, 102, 102));

		JButton btnEdicion = new JButton("Edicion");
		btnEdicion.setBounds(244, 26, 197, 34);
		panel_dir.add(btnEdicion);
		btnEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tipoF.equals("D") || tipoF.equals("S")) {

					panel_alta.setVisible(true);
					txtCedula2.requestFocus();
					panel_ced.setVisible(false);
					btnEditar.setVisible(true);
					btnconF.setVisible(false);
					Mostrar.setVisible(true);
					panel_info.setVisible(true);

					ibl_Nuevo.setVisible(true);
					btnCon.setVisible(false);
					btnMostrar.setVisible(false);
					lblNewLabel_1_1_1_1_2.setVisible(true);
					ComboT.setVisible(true);
					txtCedula2.setText("");
					txtNombre.setText("");
					ComboT.setSelectedIndex(0);
					cedula1.setText("");
					nombre1.setText("");

					tipo1.setText("");
				} else {
					panel_alta.setVisible(true);
					panel_ced.setVisible(false);
					panel_info.setVisible(true);
					Mostrar.setVisible(true);
					btnMostrar.setVisible(false);
					lblNewLabel_1_1_1_1_2.setVisible(false);
					ComboT.setVisible(false);
					ibl_Nuevo.setVisible(true);
					btnconF.setVisible(false);
					btn_ediF.setVisible(true);
					btnEditar.setVisible(false);
					txtCedula2.setText("");
					txtNombre.setText("");
					ComboT.setSelectedIndex(0);
					lblNewLabel_1_1_1_1_2.setVisible(false);
					ComboT.setVisible(false);
					cedula1.setText("");
					nombre1.setText("");

					tipo1.setText("");
				}
			}
		});
		btnEdicion.setForeground(Color.WHITE);
		btnEdicion.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnEdicion.setBackground(new Color(102, 102, 102));

		btn_cambioCon = new JButton("Cambio de contrase\u00F1a");
		btn_cambioCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_alta.setVisible(false);
				panel_ced.setVisible(true);
				panel_info.setVisible(true);
				txtCedula.requestFocus();
				btnMostrar.setVisible(true);
				btnConfirmar.setVisible(false);
				Mostrar.setVisible(false);
				btn_cambio.setVisible(true);
				lbl_con.setVisible(true);
				nueva_con.setVisible(true);
				txtCedula.setText("");
				nueva_con.setText("");
				cedula1.setText("");
				nombre1.setText("");
				tipo1.setText("");
				ComboT.setSelectedIndex(0);

			}
		});
		btn_cambioCon.setBounds(25, 89, 216, 34);
		panel_dir.add(btn_cambioCon);
		btn_cambioCon.setForeground(Color.WHITE);
		btn_cambioCon.setFont(new Font("Corbel", Font.ITALIC, 20));
		btn_cambioCon.setBackground(new Color(102, 102, 102));

		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta consu = new Consulta();
				consu.setVisible(true);
				consu.setLocationRelativeTo(null);
				dispose();
				panel_info.setVisible(false);
				btnMostrar.setVisible(false);

			}
		});
		btnConsultas.setBounds(474, 89, 186, 34);
		panel_dir.add(btnConsultas);
		btnConsultas.setForeground(Color.WHITE);
		btnConsultas.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnConsultas.setBackground(new Color(102, 102, 102));

		panel_alta = new JPanel();
		panel_alta.setVisible(false);
		panel_alta.setBackground(new Color(0, 0, 51));
		panel_alta.setBounds(389, 207, 699, 298);
		contentPane.add(panel_alta);
		panel_alta.setLayout(null);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("C\u00E9dula de identidad\r\n");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Corbel", Font.ITALIC, 25));
		lblNewLabel_1_1_1_1.setBounds(59, 28, 216, 34);
		panel_alta.add(lblNewLabel_1_1_1_1);

		txtCedula2 = new JTextField();
		txtCedula2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (!Character.isDigit(caracter) && caracter != '\s' && caracter != 8) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}

		});
		txtCedula2.setForeground(Color.WHITE);
		txtCedula2.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		txtCedula2.setColumns(10);
		txtCedula2.setBackground(new Color(102, 102, 102));
		txtCedula2.setBounds(266, 33, 179, 26);
		panel_alta.add(txtCedula2);

		btnCon = new JButton("Confirmar\r\n");
		btnCon.setVisible(false);
		btnCon.addActionListener(new ActionListener() {

			String Ced_in;
			String tipo;

			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarExistencia(txtCedula2.getText())) {
					JOptionPane.showMessageDialog(null, "No puedes hacer un alta con una cedula que ya existe",
							"Cedula ya existente", JOptionPane.ERROR_MESSAGE);
					txtCedula2.requestFocus();
				} else {
					if ("".equals(txtCedula2.getText()) || "".equals(txtNombre.getText())
							|| "".equals(ComboT.getSelectedItem())) {
						if ("".equals(txtCedula2.getText())) {
							JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "",
									JOptionPane.ERROR_MESSAGE);
						}
						if ("".equals(txtNombre.getText())) {
							JOptionPane.showMessageDialog(null, "Tienes que ingresar un nombre ", "",
									JOptionPane.ERROR_MESSAGE);
						}
						if ("".equals(ComboT.getSelectedItem())) {
							JOptionPane.showMessageDialog(null, "Tienes que ingresar un tipo de funcionario ", "",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					else if (!txtCedula2.getText().equals("")) {
						Miaplicacion.alta(txtCedula2.getText(), txtNombre.getText(),
								String.valueOf(ComboT.getSelectedItem()));
						if ("A".equals(String.valueOf(ComboT.getSelectedItem()))
								|| "S".equals(String.valueOf(ComboT.getSelectedItem()))) {
							lbl_contra.setVisible(true);
							contra.setVisible(true);
							Ced_in = txtCedula2.getText();
							tipo = String.valueOf(ComboT.getSelectedItem());
						}
					} else if ("".equals(txtCedula2.getText()) && ("A".equals(tipo) || "S".equals(tipo))) {
						Miaplicacion.Contra(Ced_in, contra.getText());
						Ced_in = null;
						tipo = null;
						lbl_contra.setVisible(false);
						contra.setVisible(false);
						return;
					}

					txtCedula2.setText("");
					txtNombre.setText("");
					contra.setText("");

				}
			}
		});
		btnCon.setForeground(Color.WHITE);
		btnCon.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnCon.setBackground(new Color(102, 102, 102));
		btnCon.setBounds(476, 254, 197, 34);
		panel_alta.add(btnCon);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Corbel", Font.ITALIC, 25));
		lblNewLabel_1_1_1_1_1.setBounds(161, 72, 95, 34);
		panel_alta.add(lblNewLabel_1_1_1_1_1);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
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
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		txtNombre.setColumns(10);
		txtNombre.setBackground(new Color(102, 102, 102));
		txtNombre.setBounds(266, 77, 179, 26);
		panel_alta.add(txtNombre);

		lblNewLabel_1_1_1_1_2 = new JLabel("Tipo de Funcionario\r\n");
		lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Corbel", Font.ITALIC, 25));
		lblNewLabel_1_1_1_1_2.setBounds(59, 116, 216, 34);
		panel_alta.add(lblNewLabel_1_1_1_1_2);

		btnEditar = new JButton("Editar\r\n");
		btnEditar.setVisible(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarExistencia(txtCedula2.getText())) {
					Miaplicacion.actualizarCliente(txtCedula2.getText(), txtNombre.getText(),
							String.valueOf(ComboT.getSelectedItem()));
				} else if ("".equals(txtCedula2.getText()) || "".equals(txtNombre.getText())
						|| "".equals(ComboT.getSelectedItem())) {
					if (txtCedula2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "",
								JOptionPane.ERROR_MESSAGE);
					}
					if (txtNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Tienes que ingresar un nombre ", "",
								JOptionPane.ERROR_MESSAGE);
					}
					if (ComboT.getSelectedItem().equals("")) {
						JOptionPane.showMessageDialog(null, "Tienes que ingresar un tipo de funcionario ", "",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(contentPane,
							"La cédula que ingresó no existe, para realizar una edicion la misma debe existir ",
							"No existe la Cédula", JOptionPane.ERROR_MESSAGE);
					txtCedula2.requestFocus();

				}
				txtCedula2.setText("");
				txtNombre.setText("");
				cedula1.setText("");
				nombre1.setText("");
				tipo1.setText("");
				ComboT.setSelectedIndex(0);

			}
		});
		btnEditar.setBounds(393, 258, 119, 26);
		panel_alta.add(btnEditar);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnEditar.setBackground(new Color(102, 102, 102));

		ibl_Nuevo = new JLabel("Nuevo");
		ibl_Nuevo.setVisible(false);
		ibl_Nuevo.setForeground(Color.WHITE);
		ibl_Nuevo.setFont(new Font("Corbel", Font.ITALIC, 25));
		ibl_Nuevo.setBounds(56, 72, 95, 34);
		panel_alta.add(ibl_Nuevo);

		btn_ediF = new JButton("Editar\r\n");
		btn_ediF.setVisible(false);
		btn_ediF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarExistencia(txtCedula2.getText())) {
					Miaplicacion.actualizarCliente_A(txtCedula2.getText(), txtNombre.getText());
				} else if ("".equals(txtCedula2.getText()) || ("".equals(txtNombre.getText()))) {
					if (txtCedula2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
					if (txtNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Tienes que ingresar un nombre ", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"La cédula que ingresó no existe, para realizar una edicion la misma debe existir ",
							"No existe la Cédula", JOptionPane.ERROR_MESSAGE);
					txtCedula2.requestFocus();
				}
				txtCedula2.setText("");
				txtNombre.setText("");
				cedula1.setText("");
				nombre1.setText("");
				tipo1.setText("");
			}
		});
		btn_ediF.setBounds(318, 258, 123, 27);
		panel_alta.add(btn_ediF);
		btn_ediF.setForeground(Color.WHITE);
		btn_ediF.setFont(new Font("Corbel", Font.ITALIC, 20));
		btn_ediF.setBackground(new Color(102, 102, 102));

		btnconF = new JButton("Confirmar\r\n");
		btnconF.setVisible(false);
		btnconF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Miaplicacion.buscarExistencia(txtCedula2.getText())) {
					JOptionPane.showMessageDialog(null, "No puedes hacer un alta con una cedula que ya existe",
							"Cedula ya existente", JOptionPane.ERROR_MESSAGE);
					txtCedula2.requestFocus();
				} else {
					if (txtCedula2.getText().equals("") || txtNombre.getText().equals("")) {

						if (txtCedula2.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
						if (txtNombre.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Tienes que ingresar un nombre ", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					} else if (!txtCedula2.getText().equals("")) {
						Miaplicacion.alta_A(txtCedula2.getText(), txtNombre.getText());
					}

					txtCedula2.setText("");
					txtNombre.setText("");
				}
			}
		});
		btnconF.setForeground(Color.WHITE);
		btnconF.setFont(new Font("Corbel", Font.ITALIC, 20));
		btnconF.setBackground(new Color(102, 102, 102));
		btnconF.setBounds(489, 218, 184, 26);
		panel_alta.add(btnconF);

		lbl_contra = new JLabel("Contrase\u00F1a");
		lbl_contra.setVisible(false);
		lbl_contra.setForeground(Color.WHITE);
		lbl_contra.setFont(new Font("Corbel", Font.ITALIC, 25));
		lbl_contra.setBounds(69, 160, 119, 34);
		panel_alta.add(lbl_contra);

		contra = new JPasswordField();
		contra.setVisible(false);
		contra.setForeground(Color.WHITE);
		contra.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		contra.setBackground(new Color(102, 102, 102));
		contra.setBounds(266, 160, 169, 26);
		panel_alta.add(contra);

		ComboT = new JComboBox();
		ComboT.setMaximumRowCount(4);
		ComboT.setModel(new DefaultComboBoxModel(new String[] { "", "S", "A", "F" }));
		ComboT.setForeground(Color.WHITE);
		ComboT.setBackground(Color.GRAY);
		ComboT.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		ComboT.setBounds(266, 121, 179, 27);
		panel_alta.add(ComboT);

		Mostrar = new JButton("Mostrar Datos");
		Mostrar.setBounds(337, 218, 161, 26);
		panel_alta.add(Mostrar);
		Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCedula2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Tienes que ingresar una cedula ", "Error de ingreso",
							JOptionPane.ERROR_MESSAGE);
				} else if (Miaplicacion.buscarExistencia(txtCedula2.getText())) {
					Dato dato = Miaplicacion.buscarDatosFuncionario(txtCedula2.getText());

					cedula1.setText(dato.getCedula());
					nombre1.setText(dato.getNombre());
					tipo1.setText(dato.getTipoFuncionario());

				}

				else {
					JOptionPane.showMessageDialog(contentPane,
							"La cédula que ingresó no existe, para mostrar los datos de un usuario, el mismo  debe existir ",
							"No existe la Cédula", JOptionPane.ERROR_MESSAGE);
					txtCedula2.requestFocus();

				}
				txtCedula2.setText("");
			}

		});
		Mostrar.setVisible(false);
		Mostrar.setForeground(Color.WHITE);
		Mostrar.setFont(new Font("Corbel", Font.ITALIC, 20));
		Mostrar.setBackground(new Color(102, 102, 102));

		panel_info = new JPanel();
		panel_info.setVisible(false);
		panel_info.setBackground(new Color(102, 102, 102));
		panel_info.setBounds(8, 258, 371, 380);
		contentPane.add(panel_info);
		panel_info.setLayout(null);

		cedula1 = new JLabel("");
		cedula1.setForeground(new Color(255, 255, 255));
		cedula1.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		cedula1.setBounds(145, 61, 216, 30);
		panel_info.add(cedula1);

		nombre1 = new JLabel("");
		nombre1.setForeground(new Color(255, 255, 255));
		nombre1.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		nombre1.setBounds(145, 139, 216, 30);
		panel_info.add(nombre1);

		tipo1 = new JLabel("");
		tipo1.setForeground(new Color(255, 255, 255));
		tipo1.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		tipo1.setBounds(164, 212, 197, 30);
		panel_info.add(tipo1);

		lblDatos = new JLabel("Datos\r\n");
		lblDatos.setForeground(new Color(255, 255, 255));
		lblDatos.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		lblDatos.setBounds(164, 10, 66, 30);
		panel_info.add(lblDatos);

		lblDatos_1 = new JLabel("Cedula:\r\n");
		lblDatos_1.setForeground(new Color(255, 255, 255));
		lblDatos_1.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		lblDatos_1.setBounds(10, 61, 79, 30);
		panel_info.add(lblDatos_1);

		lblNombre = new JLabel("Nombre:\r\n");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		lblNombre.setBounds(10, 139, 79, 30);
		panel_info.add(lblNombre);

		lblTipoFuncionario = new JLabel("Tipo Funcionario:");
		lblTipoFuncionario.setForeground(new Color(255, 255, 255));
		lblTipoFuncionario.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 20));
		lblTipoFuncionario.setBounds(10, 212, 151, 30);
		panel_info.add(lblTipoFuncionario);
		if (tipoF.equals("A")) {

			panel_dir.setVisible(true);
			btn_cambioCon.setVisible(false);
			btn_cambio.setVisible(false);
			btnConfirmar.setVisible(false);
			btnEditar.setVisible(false);
			btnCon.setVisible(false);

		}
	}
}
