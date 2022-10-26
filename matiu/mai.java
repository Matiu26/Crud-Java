package matiu;

import javax.swing.JOptionPane;

public class mai {

	public static void main(String[] args) {
		

      String deposito = "";

      int monto = 0, suma=0, montofinal;

      Object moneda;

      Object plazos;

      do {

    	  deposito = JOptionPane.showInputDialog("Ingrese  monto a depositar: ");
      if (deposito.matches("[0-9]*")) {
          break;
      }else {
          JOptionPane.showMessageDialog(null, "Error, Ingrese un numero.");
      }
      }while (!deposito.matches("[0-9]*"));

      monto = Integer.parseInt(deposito);

      moneda = JOptionPane.showInputDialog(null, "Ingrese  tipo de moneda: ", "Ingreso de moneda.", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Pesos Uruguayos","Euro","Dolar"}, "Pesos Uruguayos");

      if (moneda == "Euro") {

          plazos = JOptionPane.showInputDialog(null, "Ingrese un plazo: ", "Plazos.", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"1% a 30 dias","3% a 60 dias","10% a 120 dias","15% a 180 dias","24% a plazo fijo"}, "1% a 30 dias");

      }else { 
          plazos = JOptionPane.showInputDialog(null, "Ingrese un plazo: ", "Plazos.", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"1% a 30 dias","3% a 60 dias","10% a 120 dias","15% a 180 dias","21% a plazo fijo"}, "1% a 30 dias");
      }

      switch (plazos.toString()) {
      
	case "1% a 30 dias":
		suma=monto/100;
		break;
	case "3% a 60 dias":
		suma=(monto*3)/100;
		break;
	case "10% a 120 dias":
		suma=(monto*10)/100;
		break;
	case "15% a 180 dias":
		suma=(monto*15)/100;
        break;
	case "21% a plazo fjo":
		suma=(monto*21)/100;
		break;
	case "24 a plazo fijo":
		suma=(monto*24)/100;
		break;
	default:
		System.out.println("Error al ejecutar");
		break;
	}
      
      montofinal=monto+suma;

	JOptionPane.showMessageDialog(null, 
    		  "El monto a despositar es: "+deposito+"\n"+
    		  	 "El tipo de moneda es: "+moneda+"\n"+
    		  		"La ganancia que usted obtiene al ingresar el tipo de moneda es: "+suma+"\n"+
    		  		  "El monto final que usted va a recibir es de : "+montofinal+"\n",
    		  		
    		  		 "Total" , JOptionPane.QUESTION_MESSAGE, null);
      
  }

}