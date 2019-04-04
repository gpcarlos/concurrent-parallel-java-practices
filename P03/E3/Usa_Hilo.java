/**
* P3 - E3
* Clase Usa_Hilo, dotada de un método principal
* @author Carlos Gallardo Polanco
* @version 1.006/11/2017
*/

import java.util.Scanner;

public class Usa_Hilo{
	/**
	* Método principal de la clase Usa_Hilo
	*/
	public static void main (String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduzca el numero de repeticiones: ");
		int repeticiones = sc.nextInt();

		hilo suma = new hilo(1, repeticiones);
		hilo resta = new hilo(-1, repeticiones);

		suma.start();
		resta.start();
		suma.join();
		resta.join();

		System.out.println(suma.get_n());
	}
}
