/**
* P2 - E4
* Clase usaComplejos que permite al usuario elegir la opcion a realizar e introducir los números complejos
* @author Carlos Gallardo Polanco
* @version 1.0 23/10/2017
*/

import java.util.Scanner;

public class usaComplejos{

	/**
	* Método principal de la clase
	* @param args array de cadena de caracteres
	*/
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		Complejos complejo1 = new Complejos();
		Complejos complejo2 = new Complejos();
		int a;

		do{
			System.out.println();
			System.out.println("Elige la operacion a realizar: ");
			System.out.println("1- Suma");
			System.out.println("2- Resta");
			System.out.println("3- Modulo");
			System.out.println("4- Producto");
			System.out.println("5- Cociente");
			System.out.println("Si quiere salir pulse cualquier otra tecla");
			System.out.print(": ");
			a = sc.nextInt();
			switch(a){
				case 1:
					System.out.print("Parte real del numero 1: ");
					double r1 = sc.nextDouble();
					complejo1.set_real(r1);
					System.out.print("Parte imaginaria del numero 1: ");
					double i1 = sc.nextDouble();
					complejo1.set_imag(i1);
					System.out.print("Parte real del numero 2: ");
					double r2 = sc.nextDouble();
					complejo2.set_real(r2);
					System.out.print("Parte imaginaria del numero 2: ");
					double i2 = sc.nextDouble();
					complejo2.set_imag(i2);
					complejo1.suma(complejo1,complejo2);
				break;
				case 2:
					System.out.print("Parte real del numero 1: ");
					r1 = sc.nextDouble();
					complejo1.set_real(r1);
					System.out.print("Parte imaginaria del numero 1: ");
					i1 = sc.nextDouble();
					complejo1.set_imag(i1);
					System.out.print("Parte real del numero 2: ");
					r2 = sc.nextDouble();
					complejo2.set_real(r2);
					System.out.print("Parte imaginaria del numero 2: ");
					i2 = sc.nextDouble();
					complejo2.set_imag(i2);
					complejo1.resta(complejo1,complejo2);
				break;
				case 3:
					System.out.print("Parte real del numero: ");
					r1 = sc.nextDouble();
					complejo1.set_real(r1);
					System.out.print("Parte imaginaria del numero: ");
					i1 = sc.nextDouble();
					complejo1.set_imag(i1);
					complejo1.modulo(complejo1);
				break;
				case 4:
					System.out.print("Parte real del numero 1: ");
					r1 = sc.nextDouble();
					complejo1.set_real(r1);
					System.out.print("Parte imaginaria del numero 1: ");
					i1 = sc.nextDouble();
					complejo1.set_imag(i1);
					System.out.print("Parte real del numero 2: ");
					r2 = sc.nextDouble();
					complejo2.set_real(r2);
					System.out.print("Parte imaginaria del numero 2: ");
					i2 = sc.nextDouble();
					complejo2.set_imag(i2);
					complejo1.producto(complejo1,complejo2);
				break;
				case 5:
					System.out.print("Parte real del numero 1: ");
					r1 = sc.nextDouble();
					complejo1.set_real(r1);
					System.out.print("Parte imaginaria del numero 1: ");
					i1 = sc.nextDouble();
					complejo1.set_imag(i1);
					System.out.print("Parte real del numero 2: ");
					r2 = sc.nextDouble();
					complejo2.set_real(r2);
					System.out.print("Parte imaginaria del numero 2: ");
					i2 = sc.nextDouble();
					complejo2.set_imag(i2);
					complejo1.cociente(complejo1,complejo2);
				break;
				default:
					System.out.println("Saliendo...");
				break;
			}
		}while(a<=5&&a>=1);
	}
}
