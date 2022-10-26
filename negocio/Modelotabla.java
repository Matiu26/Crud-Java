package negocio;

import javax.swing.table.DefaultTableModel;

public class Modelotabla extends DefaultTableModel {
	public Modelotabla(String[] cabecera) {
		setColumnIdentifiers(cabecera);

	}

	@Override
	public boolean isCellEditable(int row, int column) {

		return false;
	}
}
