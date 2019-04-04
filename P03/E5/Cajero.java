/**
* P3 - E5
* Clase Cajero que utiliza la clase Cuenta_Banca2.java, está dotada por un contructor, un método run
* @author Carlos Gallardo Polanco
* @version 1.0 06/11/2017
*/

public class Cajero implements Runnable{
	Cuenta_Banca2 cuenta;
	int repeticiones=25;
	int op;

	/**
	* Constructor de la clase Cajero
	*/
	public Cajero (Cuenta_Banca2 cuenta, int repeticiones, int op){
		this.cuenta=cuenta;
		this.repeticiones=repeticiones;
		this.op=op;
	}

	/**
	* Método run
	*/
	public void run(){
		switch(op){
			case 1:
				for (int i=0;i<repeticiones ; i++) {
					cuenta.Deposito(100);
				}
			break;
			case 2:
				for (int i=0;i<repeticiones ; i++) {
					cuenta.Reintegro(100);
				}
			break;
			default: break;
		}
	}
}
