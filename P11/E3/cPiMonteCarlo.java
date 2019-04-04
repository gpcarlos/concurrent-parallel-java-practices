/**
* P11 - E3
* Clase cPiMonteCarlo que simula un cliente y que contiene un método principal
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/
import java.rmi.*;
import java.rmi.registry.*;

import java.util.Scanner;

public class cPiMonteCarlo{
	
	/**
	* Método principal de la clase cPiMonteCarlo
	* @throws Exception
	*/
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		int a;     
		
		iPiMonteCarlo RefObRemoto = (iPiMonteCarlo)Naming.lookup("//localhost/Servidor");

        do{
            System.out.println();
            System.out.println("|               Que desea hacer?             |");
            System.out.println("|--------------------------------------------|");
	        System.out.println("| 0. Anadir mas puntos                       |");
	        System.out.println("| 1. Ver la aproximacion a PI actual         |");
	        System.out.println("| 2. reset                                   |");
	        System.out.println("| -------------------------------------------|");
	        System.out.println("|    (Si no quiere hacer nada, introduzca    |"); 
	        System.out.println("|    un numero distinto al de las opciones)  |");
	        System.out.println("|--------------------------------------------|");
            System.out.print(": ");
            a = sc.nextInt();
            sc.nextLine();

            switch (a){
                case 0:
                    System.out.print("Introduce el numero de puntos: ");
			 		int nPuntos = sc.nextInt();
                    RefObRemoto.masPuntos(nPuntos);
                break;

                case 1:
                    System.out.println("La aproximacion actual es "+RefObRemoto.aproximacion());
                break;

                case 2:
                    System.out.println("reset");
                    RefObRemoto.reset();
                break;

                default:
                break;
            }
        }while(a>=0 && a<=2); 
	}	
}	