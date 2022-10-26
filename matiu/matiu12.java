package matiu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class matiu12 extends JFrame {

	private JPanel contentPane;
	private JTextField cedula;
	private JTextField nombre;
	private JTextField textField_2;
	private JTextField txtPrecio;
	private JTextField txtIva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					matiu12 frame = new matiu12();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public matiu12() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Mateo Ferreira\\Desktop\\Utu matiu\\2\u00B0\\programacion\\clase\\flor.png"));

		setBounds(100, 100, 1183, 659);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00E9dula del Cliente");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(102, 153, 102));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(106, 81, 162, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNumeroDeHabitaciones = new JLabel("Num de habitaciones \r\n\r\n");
		lblNumeroDeHabitaciones.setOpaque(true);
		lblNumeroDeHabitaciones.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNumeroDeHabitaciones.setBackground(new Color(102, 153, 102));
		lblNumeroDeHabitaciones.setBounds(106, 221, 162, 28);
		contentPane.add(lblNumeroDeHabitaciones);

		JLabel lblNombreDelCliente = new JLabel("Nombre del Cliente");
		lblNombreDelCliente.setOpaque(true);
		lblNombreDelCliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNombreDelCliente.setBackground(new Color(102, 153, 102));
		lblNombreDelCliente.setBounds(106, 152, 162, 28);
		contentPane.add(lblNombreDelCliente);

		cedula = new JTextField();
		cedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ced) {

				char caracter = ced.getKeyChar();

				if (!Character.isDigit(caracter) && caracter != '\s' && caracter != 8) {
					Toolkit.getDefaultToolkit().beep();
					ced.consume();
				}

			}
		});
		cedula.setBounds(282, 83, 213, 28);
		contentPane.add(cedula);
		cedula.setColumns(10);

		nombre = new JTextField();
		nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent nom) {

				char caracter = nom.getKeyChar();

				if (!Character.isLetter(caracter) && caracter != '\s' && caracter != 8) {
					Toolkit.getDefaultToolkit().beep();
					nom.consume();
				}
			}
		});
		nombre.setColumns(10);
		nombre.setBounds(282, 154, 213, 28);
		contentPane.add(nombre);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aVA\\Desktop\\1f3fa.png"));
		lblNewLabel_1.setBounds(10, 11, 64, 76);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Salir\r\n\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNewButton.setBounds(784, 385, 127, 43);
		contentPane.add(btnNewButton);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, null, 25, 1));
		spinner.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		spinner.setBounds(286, 222, 209, 28);
		contentPane.add(spinner);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Contado", "Cr\u00E9dito" }));
		comboBox.setBounds(301, 286, 261, 37);
		contentPane.add(comboBox);

		JLabel lblTotalAPagar = new JLabel("Total  a pagar\r\n");
		lblTotalAPagar.setOpaque(true);
		lblTotalAPagar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTotalAPagar.setBackground(new Color(102, 153, 102));
		lblTotalAPagar.setBounds(106, 485, 162, 28);
		contentPane.add(lblTotalAPagar);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(282, 488, 213, 28);
		contentPane.add(textField_2);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cedula.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "La cedula del cliente no puede estar vacia",
							"error de ingreso", JOptionPane.ERROR_MESSAGE);

				}

				if (nombre.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "El nombre  del cliente no puede estar vacio",
							"error de ingreso", JOptionPane.ERROR_MESSAGE);

				}

				double precio_ini, precio_fin, descuento, IVA;
				int cant_habit= (int) spinner.getValue ();
				

			}
		});
		btnCalcular.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnCalcular.setBounds(131, 388, 131, 37);
		contentPane.add(btnCalcular);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrecio.setText("Precio:\r\n");
		txtPrecio.setBounds(282, 399, 127, 29);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtIva = new JTextField();
		txtIva.setText("I.V.A:");
		txtIva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIva.setColumns(10);
		txtIva.setBounds(491, 399, 162, 29);
		contentPane.add(txtIva);

	}
}
