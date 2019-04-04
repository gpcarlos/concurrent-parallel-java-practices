/**
* P3 - E5
* Clase Usa_Cajero
* @author Carlos Gallardo Polanco
* @version 1.0 06/11/2017
*/

public class Usa_Cajero{
	/**
	* Método Principal de la clase
	*/
	public static void main (String[] args) throws Exception{
		Cuenta_Banca2 cuenta = new Cuenta_Banca2(123456789, 100, "Carlos");
		Cajero cajeroIngresa = new Cajero(cuenta,2000,1);
		Cajero cajeroRetira = new Cajero(cuenta,2000,2);

		Thread hilo1 = new Thread(cajeroIngresa);
		Thread hilo2 = new Thread(cajeroRetira);

		hilo1.start();
		hilo2.start();
		hilo1.join();
		hilo2.join();

		System.out.println(cuenta.Saldo());
	}
}
