/**
* P1 - E6
* Clase aleatorios que genera numeros aleatorios
* @author Carlos Gallardo Polanco
* @version 23/10/2017
*/
import java.util.Scanner;

public class aleatorios{
	static Scanner sc = new Scanner (System.in);

	/**
	* Método principal de la clase que pide al usuario cuántos numeros aleatorios
	* quiere que el programa genere y muestre
	* @param args array de cadena de caracteres
	*/
	static public void main (String[] args){
		System.out.print("Introduce cuantos numeros aleatorios quiere: ");
		int n = sc.nextInt();

		for(int i=0;i<n;i++){
			System.out.println(Math.random());
		}
	}
}
