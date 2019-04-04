/**
* P1 - E1
* Clase Circulo que calcula el volumen de un cono
* @author Carlos Gallardo Polanco
* @version 23/10/2017
*/

import java.util.Scanner;

public class Circulo{
	static final double PI = 3.1416;
	static Scanner sc = new Scanner (System.in);

	/**
	* Método principal de la clase que pide al usuario el diametro y la altura
	* del cono y le muestra en pantalla el volumen del mismo
	* @param args array de cadena de caracteres
	*/
	public static void main(String[] args){
		System.out.print("Introduce el diametro del cono: ");
		double d = sc.nextDouble();
		System.out.print("Introduce la altura del cono:");
		double h = sc.nextDouble();
		System.out.println("El volumen del cono es: "+volumen(d,h));
	}

	/**
	* Método volumen que calcula el volumen de un cono
	* @param d diametro del cono
	* @param h altura del cono
	* @return volumen del cono
	*/
	public static double volumen (double d, double h){
		return (PI*Math.pow(d/2,2)*h)/3;
	}


}
