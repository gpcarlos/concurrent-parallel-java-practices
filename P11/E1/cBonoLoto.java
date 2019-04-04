/**
* P11 - E2
* Clase cBonoLoto que simula un cliente y que contiene un método principal
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/
import java.rmi.*;
import java.rmi.registry.*;

import java.util.Scanner;
import java.util.Arrays;

public class cBonoLoto{
	
	/**
	* Método principal de la clase cBonoLoto
	* @throws Exception
	*/
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		int[] apuesta = new int[6];

		iBonoLoto RefObRemoto = (iBonoLoto)Naming.lookup("//localhost/Servidor");

		while(true){
			System.out.println("Introduzca su apuesta [Numeros de 1 a 49, incluido ellos]: ");
			for(int i=0;i<6;i++){
				do{
					System.out.print("Numero "+(i+1)+" de la apuesta: ");
					apuesta[i]=sc.nextInt();
				}while(apuesta[i]<1||apuesta[i]>49);
			}
	
			System.out.println("Su apuesta es "+Arrays.toString(apuesta));
			System.out.println("La combiancion ganadora es "+RefObRemoto.resetServidor());
			if(RefObRemoto.compApuesta(apuesta)){
				System.out.println("HA GANADO!!!");
			}else{System.out.println("Siga intentandolo...");}
		}
		
	}	
}	