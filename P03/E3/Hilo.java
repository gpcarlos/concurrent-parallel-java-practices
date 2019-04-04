/**
* P3 - E3
* Clase Hilo que modela dos Hilos que incrementan y decrementan una variable común
* @author Carlos Gallardo Polanco
* @version 1.0 06/11/2017
*/

public class Hilo extends Thread{
	static int n=0;
	int op;
	int repeticiones;

	/**
	* Constructor de la clase Hilo
	* @param op, entero que indica la operación a realizar el Hilo
	* @param repeticiones, numero de veces que se va a ejecutar la operacion
	*/
	public Hilo (int op, int repeticiones){
		this.op=op;
		this.repeticiones=repeticiones;
	}

	/**
	* Método run del Hilo
	*/
	public void run(){
		for(int i=0; i<repeticiones;i++){
			n+=op;
		}
	}

	/**
	* Método observador de la variable n
	* @return n variable compartida
	*/
	public int get_n(){
		return n;
	}
}
