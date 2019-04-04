/**
* P2 - E5
* Clase usaElipse que utiliza la clase Elipse y los métodos de los que está dotada
* @author Carlos Gallardo Polanco
* @version 1.0 23/10/2017
*/

import java.util.Scanner;

public class usaElipse{

	/**
	* Método principal de la clase usa_elipse
	*/
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);

		int[] centro = new int[2];
		System.out.println("Introduzca el centro de la elipse: ");
		System.out.print("x: ");
		centro[0] = sc.nextInt();
		System.out.print("y: ");
		centro[1] = sc.nextInt();
		System.out.print("Introduce el Eje Mayor: ");
		int ejemayor = sc.nextInt();
		System.out.print("Introduce el Eje Menor: ");
		int ejemenor = sc.nextInt();

		Elipse elip = new Elipse(centro, ejemayor, ejemenor);

		int[] punto = new int[2];
		System.out.println("Introduzca el punto que quiere comprobar si pertenece a la elipse: ");
		System.out.print("x: ");
		punto[0] = sc.nextInt();
		System.out.print("y: ");
		punto[1] = sc.nextInt();

		if(elip.pertenece(punto)){
			System.out.println("El punto pertenece a la elipse");
		}else{
			System.out.println("El punto no pertenece a la elipse");
		}

	}

}
