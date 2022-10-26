package negocio;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dato.Dato;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import diseño.Login;
import diseño.Aplicacion;

public class Miaplicacion {

	private static String usuario = "root";
	private static String contra = "Mateobarsa04";
	private static String dataBase = "prog";
	private static String url = "jdbc:mysql://localhost:3306/";

	private static Connection conectar = null;
	private static Statement sentencia = null;
	private static ResultSet resultado = null;

	public static void main(String[] args) {
		if (Driver()) {
			Login miVentana = new Login();
			miVentana.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos");
			System.exit(0);
		}

	}

	public static boolean Driver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	public static boolean buscarFuncionario(String cedula) {
		String sentenciaSQL = "SELECT * FROM prog.personas where Cedula=" + cedula;

		try {

			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);

			sentencia = conectar.createStatement();

			resultado = sentencia.executeQuery(sentenciaSQL);

			if (resultado.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean buscarEstado(String cedula) {
		String sentenciaSQL = "SELECT Estado FROM prog.personas where Cedula= '" + cedula + "'";

		try {

			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);

			sentencia = conectar.createStatement();

			resultado = sentencia.executeQuery(sentenciaSQL);

			resultado.next();
			if (resultado.getString(1).equals("I")) {
				return false;

			} else {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean buscarExistencia(String cedula) {
		String sentenciaSQL = "SELECT Cedula FROM prog.personas where Cedula= '" + cedula + "'";

		try {

			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);

			sentencia = conectar.createStatement();

			resultado = sentencia.executeQuery(sentenciaSQL);

			resultado.next();
			if (resultado.getString(1).equals("")) {
				return false;

			} else {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static String buscarTipoFuncionario(String cedula) {
		// int ced = Integer.parseInt(cedula.getText());
		String sentenciaSQL = "SELECT * FROM prog.personas where Cedula=" + cedula;

		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			sentencia = conectar.createStatement();
			resultado = sentencia.executeQuery(sentenciaSQL);

			if (resultado.next()) {

				return resultado.getString("Tipo_Funcionario");
			}

			conectar.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}

	public static String buscarContrasenia(JTextField cedula) {
		int ced = Integer.parseInt(cedula.getText());
		String sentenciaSQL = "SELECT * FROM prog.personas; where Cedula=" + ced;
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			sentencia = conectar.createStatement();
			resultado = sentencia.executeQuery(sentenciaSQL);
			if (resultado.next()) {
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}

	public static boolean buscarContraseniayUsuario(String cedula, String contrasenia) {
		String sentenciaSQL = "select count(*) from personas where cedula=" + cedula + " and contrasenia = '"
				+ contrasenia + "'";
		boolean vacio = false;
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			sentencia = conectar.createStatement();
			resultado = sentencia.executeQuery(sentenciaSQL);
			resultado.next();
			if (resultado.getInt(1) == 1) {
				vacio = true;
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return vacio;
	}

	public static boolean alta(String cedula, String nombre, String tipoFuncionario) {
		String sentencia = "INSERT INTO personas (Cedula, Nombre, tipo_Funcionario, Estado) VALUES (" + cedula + ", '"
				+ nombre + "', '" + tipoFuncionario + "', 'A');";
		int filas_afectadas;
		try {

			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			filas_afectadas = statement.executeUpdate(sentencia);
			conectar.close();
			JOptionPane.showMessageDialog(null, "Añadido correctamente", "", JOptionPane.PLAIN_MESSAGE);

			return true;
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062)
				JOptionPane.showMessageDialog(null, "Esta Cédula de Identidad ya existe", "Cédula Duplicada",
						JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean baja(String cedula) {
		String sentencia = "update personas set Estado = 'I' where Cedula= '" + cedula
				+ "' and Tipo_Funcionario not in ('D', 'S')";
		int filas_afectadas;
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			filas_afectadas = statement.executeUpdate(sentencia);
			conectar.close();
			if (filas_afectadas == 1) {
				JOptionPane.showMessageDialog(null, "Dado de baja correctamente", "", JOptionPane.PLAIN_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						"No tienes el rango suficiente para dar de baja a un Director o Subdirector ", "",
						JOptionPane.ERROR_MESSAGE);

			}
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean actualizarCliente(String cedula, String nombre, String tipoFuncionario) {
		String sentencia = "UPDATE personas SET Nombre = '" + nombre + "', tipo_Funcionario = '" + tipoFuncionario
				+ "'  WHERE Cedula = " + cedula + " and Tipo_Funcionario not in ('D','S')";
		int filas_afectadas;
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			filas_afectadas = statement.executeUpdate(sentencia);
			conectar.close();
			if (filas_afectadas == 1) {
				JOptionPane.showMessageDialog(null, "Editado correctamente", "", JOptionPane.PLAIN_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						"No tienes el rango suficiente para editar a un Director o Subdirector ", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			}
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean alta_A(String cedula, String nombre) {
		String sentencia = "insert into personas (cedula, nombre, tipo_funcionario,Estado) values (" + cedula + " , '"
				+ nombre + "','F', 'A')";
		int filas_afectadas;
		try {

			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			filas_afectadas = statement.executeUpdate(sentencia);
			conectar.close();
			JOptionPane.showMessageDialog(null, "Añadido correctamente", "", JOptionPane.PLAIN_MESSAGE);

			return true;
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062)
				JOptionPane.showMessageDialog(null, "Esta Cédula de Identidad ya existe", "Cédula Duplicada",
						JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean baja_A(String cedula) {
		String sentencia = "update  personas set Estado = 'I' where Cedula= '" + cedula
				+ "' and Tipo_Funcionario not in ('D', 'S','A')";
		int filas_afectadas;
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			filas_afectadas= statement.executeUpdate(sentencia);
			conectar.close();
			if (filas_afectadas == 1) {
				JOptionPane.showMessageDialog(null, "Dado de baja correctamente", "", JOptionPane.PLAIN_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						"No tienes el rango suficiente para dar de baja a un Director,Subdirector o Administrativo", "",
						JOptionPane.ERROR_MESSAGE);

			}
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean actualizarCliente_A(String cedula, String nombre) {
		String sentencia = "UPDATE personas SET Nombre = '" + nombre + "'  WHERE Cedula = " + cedula
				+ " and Tipo_Funcionario not in ('D', 'S', 'A') ";

		int filas_afectadas;
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			filas_afectadas = statement.executeUpdate(sentencia);
			conectar.close();
			if (filas_afectadas == 1) {
				JOptionPane.showMessageDialog(null, "Editado  correctamente", "", JOptionPane.PLAIN_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						"No tienes el rango suficiente para editar a un Director,Subdirector o Administrativo", "",
						JOptionPane.ERROR_MESSAGE);

			}
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean Contra(String cedula, String contrasenia) {

		String sentencia = "UPDATE personas SET contrasenia = '" + contrasenia + "'  WHERE Cedula = " + cedula
				+ " and Tipo_Funcionario not in ('D', 'S')";
		int filas_afectadas;

		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			filas_afectadas = statement.executeUpdate(sentencia);
			conectar.close();
			JOptionPane.showMessageDialog(null, "Contraseña añadida correctamente", "", JOptionPane.PLAIN_MESSAGE);

			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean cambiarContra(String cedula, String contrasenia) {

		String sentencia = "UPDATE personas SET contrasenia = '" + contrasenia + "'  WHERE Cedula = " + cedula
				+ " and Tipo_Funcionario not in ('D', 'S')";
		int filas_afectadas;

		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			filas_afectadas = statement.executeUpdate(sentencia);
			conectar.close();
			if (filas_afectadas == 1) {
				JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente", "", JOptionPane.PLAIN_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						"No tienes el rango suficiente para actualizar la contraseña de un Director o Subdirector", "",
						JOptionPane.ERROR_MESSAGE);

			}

			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean entrada(String cedula, String entrada, String fecha, String salida) {
		String sentencia = "insert into registro values	(" + cedula + ",'" + fecha + "','" + entrada + "','" + salida
				+ "')";
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			statement.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean salida(String cedula, String salida, String fecha) {
		String sentencia = "UPDATE registro SET Salida = '" + salida + "'  WHERE fecha = '" + fecha
				+ "' and   Cedula = " + cedula + "";
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			statement.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void consulta_ced(String cedula, String fecha1, String fecha2, DefaultTableModel modelo) {
		String sentenciaSQL = "select cedula 'Cedula', fecha 'Fecha', entrada 'Entrada', salida 'Salida' from prog.registro where cedula = "
				+ cedula + " and " + " fecha between '" + fecha1 + "' and '" + fecha2 + "'";
		vaciarTabla(modelo);
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			sentencia = conectar.createStatement();
			resultado = sentencia.executeQuery(sentenciaSQL);

			while (resultado.next()) {
				Object[] fila = new Object[4];
				fila[0] = resultado.getString("Cedula");
				fila[1] = resultado.getString("Fecha");
				fila[2] = resultado.getString("Entrada");
				fila[3] = resultado.getString("Salida");
				modelo.addRow(fila);
			}

			conectar.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void consulta_nom(String nombre, DefaultTableModel modelo) {
		String sentenciaSQL = "select re.cedula, re.fecha, re.entrada, re.salida  from registro re join personas pe on re.cedula = pe.cedula  where nombre = '"
				+ nombre + "'";
		vaciarTabla(modelo);
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			sentencia = conectar.createStatement();
			resultado = sentencia.executeQuery(sentenciaSQL);

			while (resultado.next()) {
				Object[] fila = new Object[4];
				fila[0] = resultado.getString("cedula");
				fila[1] = resultado.getString("fecha");
				fila[2] = resultado.getString("entrada");
				fila[3] = resultado.getString("salida");
				modelo.addRow(fila);
			}

			conectar.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void vaciarTabla(DefaultTableModel modelo) {
		for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
			modelo.removeRow(i);

		}

	}

	public static Dato buscarDatosFuncionario(String cedula) {
		Dato dato = new Dato();
		String sentencia = "SELECT * from personas where cedula = '" + cedula + "' ";
		try {
			conectar = DriverManager.getConnection(url + "" + dataBase, usuario, contra);
			Statement statement = conectar.createStatement();
			ResultSet resultado = statement.executeQuery(sentencia);
			resultado.next();
			dato.setCedula(resultado.getString("Cedula"));
			dato.setNombre(resultado.getString("Nombre"));
			dato.setContrasenia(resultado.getString("Contrasenia"));
			dato.setTipoFuncionario(resultado.getString("Tipo_Funcionario"));
			conectar.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

		return dato;
	}
}
