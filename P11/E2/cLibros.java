/**
* P11 - E2
* Clase cLibros que simula un cliente y que contiene un método principal
* @author Carlos Gallardo Polanco
* @version 29-08-2016
*/
import java.rmi.*;
import java.rmi.registry.*;

import java.util.Scanner;

public class cLibros{
	
	/**
	* Método principal de la clase cLibros
	* @throws Exception
	*/
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		int a;     
		String ISBN;
		
		iLibros RefObRemoto = (iLibros)Naming.lookup("//localhost/Servidor");

		System.out.println("Bienvenido a la Base de Datos de la Biblioteca.");
        do{
            System.out.println();
            System.out.println("|               Que desea hacer?             |");
            System.out.println("|--------------------------------------------|");
	        System.out.println("| 0. Insertar un libro nuevo                 |");
	        System.out.println("| 1. Consultar un libro                      |");
	        System.out.println("| 2. Extraer un libro                        |");
	        System.out.println("| -------------------------------------------|");
	        System.out.println("|    (Si no quiere hacer nada, introduzca    |"); 
	        System.out.println("|    un numero distinto al de las opciones)  |");
	        System.out.println("|--------------------------------------------|");
            System.out.print(": ");
            a = sc.nextInt();
            sc.nextLine();

            switch (a){
                case 0:
                    System.out.println("Va a introducir un nuevo libro.");
                    System.out.print("Introduce el Titulo del libro: ");
			 		String Titulo = sc.nextLine();
			 		System.out.print("Introduce el Autor del libro: ");
			 		String Autor = sc.nextLine();
			 		System.out.print("Introduce el Fecha del libro: ");
			 		String Fecha = sc.nextLine();
			 		System.out.print("Introduce el Genero del libro: ");
			 		String Genero = sc.nextLine();
			 		System.out.print("Introduce el ISBN del libro: ");
			 		ISBN = sc.nextLine();
                    RefObRemoto.insertar(Titulo,Autor,Fecha,Genero,ISBN);
                break;

                case 1:
                    System.out.println("Va a consultar un libro.");
                    System.out.print("Introduce el ISBN del libro: ");
 					ISBN = sc.nextLine();
 					System.out.println("[ISBN: "+ISBN+"]");
                    System.out.println(RefObRemoto.consultarDatos(ISBN));
                break;

                case 2:
                    System.out.println("Va a extraer un libro.");
                    System.out.print("Introduce el ISBN del libro: ");
 					ISBN = sc.nextLine();
                    System.out.println(RefObRemoto.extraer(ISBN));
                break;

                default:
                break;
            }
        }while(a>=0 && a<=2); 
	}	
}	