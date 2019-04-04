/**
* P1 - E3
* Clase intDefinidaMonteCarlo que calcula la aproximacion a la integral de dos funciones
* @author Carlos Gallardo Polanco
* @version 23/10/2017
*/

import java.util.Scanner;
import java.util.Random;

public class intDefinidaMonteCarlo{
	static Scanner sc = new Scanner (System.in);
	static Random rd = new Random();

	/**
	* Método principal de la clase que pide al usuario un numero total de
	* puntos aleatorios para calcular la aproximacion a la integral de f1 y f2
	* @param args array de cadena de caracteres
	*/
	public static void main (String[] args){
		System.out.print("Introduzca total de puntos aleatorios que quiere crear: ");
		int total = sc.nextInt();
		double contadorf1=0;
		double contadorf2=0;
		for(int i=0;i<total;i++){
			double x = rd.nextDouble();
		    double y = rd.nextDouble();
		    double valoraproxf1 = -(Math.pow(x,3)-Math.cos(x));
		    double valoraproxf2 = x;
		    if(y<valoraproxf1){
		    	contadorf1++;
		    }
		    if(y<valoraproxf2){
		    	contadorf2++;
		    }
		}

		System.out.println("La aproximacion a la integral de f1 es: "+contadorf1/total);
		System.out.println("La aproximacion a la integral de f2 es: "+contadorf2/total);
	}
}
