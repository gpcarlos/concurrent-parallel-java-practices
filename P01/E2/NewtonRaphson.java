/**
* P1 - E2
* Clase NewtonRaphson que calcula la aproximación a 0 de dos funciones
* @author Carlos Gallardo Polanco
* @version 23/10/2017
*/

import java.util.Scanner;

public class NewtonRaphson{
	static Scanner sc = new Scanner (System.in);

	/**
	* Método principal de la clase que pide al usuario la aproximación inicial
	* y el número de iteraciones para hayar una aproximación a 0 para f1 y f2
	* @param args array de cadena de caracteres
	*/
	public static void main (String[] args){
		System.out.println("Introduce la aproximacion inicial: ");
		double x_n = sc.nextDouble();
		double aux = x_n;
		System.out.println("Introduce el numero de iteraciones: ");
		int iteraciones = sc.nextInt();
		System.out.println("Aproximacion f1: ");
		for(int i=0; i<iteraciones; i++){
			System.out.println(aproximacionf1(x_n));
			x_n=aproximacionf1(x_n);
		}
		x_n = aux;
		System.out.println("Aproximacion f2: ");
		for(int i=0; i<iteraciones; i++){
			System.out.println(aproximacionf2(x_n));
			x_n=aproximacionf2(x_n);
		}
	}

	/**
	* Método aproximacionf1 que calcula la aproximación de la funcion 1
	* @param x valor predecesor de la aproximacion
	* @return aproximación siguiente
	*/
	public static double aproximacionf1 (double x){
		return x-((Math.cos(x)-Math.pow(x,3))/(-Math.sin(x)-3*Math.pow(x,2)));
	}

	/**
	* Método aproximacionf2 que calcula la aproximación de la funcion 2
	* @param x valor predecesor de la aproximacion
	* @return aproximación siguiente
	*/
	public static double aproximacionf2 (double x){
		return x-((Math.pow(x,2)-5)/(2*x));
	}
}
