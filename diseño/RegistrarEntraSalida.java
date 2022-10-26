package diseño;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

import negocio.Miaplicacion;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//entrada y salida
public class RegistrarEntraSalida extends JFrame {
	private JPanel contentPane;
	private JLabel lbl_Entrada;
	private JButton btn_Salida;
	private JLabel lbl_Salida;

	public RegistrarEntraSalida(String Cedula_) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Login miLogin = new Login();
				miLogin.setVisible(true);
			}

		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Mateo Ferreira\\Desktop\\istockphoto-1024633926-170667a.jpg"));

		setTitle("Registro Entrada/Salida");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Imagen = new JLabel("");
		Imagen.setIcon(new ImageIcon("C:\\Users\\Mateo Ferreira\\Desktop\\istockphoto-1024633926-170667a.jpg"));
		Imagen.setBounds(0, 10, 300, 194);
		contentPane.add(Imagen);

		JLabel Nombre = new JLabel("Masarak  ENTERPRISES");
		Nombre.setForeground(Color.WHITE);
		Nombre.setFont(new Font("Corbel", Font.ITALIC, 25));
		Nombre.setBounds(10, 214, 308, 49);
		contentPane.add(Nombre);

		JButton btn_Entrada = new JButton("Registrar Entrada");
		btn_Entrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Calendar calendar = Calendar.getInstance();

				lbl_Entrada.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":"
						+ calendar.get(Calendar.SECOND));
				btn_Entrada.setEnabled(false);
				String fecha = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
						+ calendar.get(Calendar.DAY_OF_MONTH);
				Miaplicacion.entrada(Cedula_, lbl_Entrada.getText(), fecha, "");

			}
		});
		btn_Entrada.setForeground(Color.WHITE);
		btn_Entrada.setFont(new Font("Corbel", Font.ITALIC, 20));
		btn_Entrada.setBackground(new Color(102, 102, 102));
		btn_Entrada.setBounds(10, 394, 249, 33);
		contentPane.add(btn_Entrada);

		btn_Salida = new JButton("Registrar Salida");
		btn_Salida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendar = Calendar.getInstance();
				lbl_Salida.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":"
						+ calendar.get(Calendar.SECOND));
				String fecha = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
						+ calendar.get(Calendar.DAY_OF_MONTH);
				Miaplicacion.salida(Cedula_, lbl_Salida.getText(), fecha);

			}
		});
		btn_Salida.setForeground(Color.WHITE);
		btn_Salida.setFont(new Font("Corbel", Font.ITALIC, 20));
		btn_Salida.setBackground(new Color(102, 102, 102));
		btn_Salida.setBounds(281, 394, 249, 33);
		contentPane.add(btn_Salida);

		lbl_Entrada = new JLabel("");
		lbl_Entrada.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 25));
		lbl_Entrada.setBackground(new Color(255, 255, 255));
		lbl_Entrada.setForeground(Color.WHITE);
		lbl_Entrada.setBounds(54, 335, 124, 27);
		contentPane.add(lbl_Entrada);

		lbl_Salida = new JLabel("");
		lbl_Salida.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 25));
		lbl_Salida.setForeground(Color.WHITE);
		lbl_Salida.setBackground(Color.GRAY);
		lbl_Salida.setBounds(346, 335, 124, 27);
		contentPane.add(lbl_Salida);

	}
}