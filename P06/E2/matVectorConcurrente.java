/**
* P4 - E1
* Clase matVectorConcurrente que realiza la multiplicación entre una  matriz y un vector introducidos por el usuario o rellenados de forma automática mediante el uso de la clase Random
* @author Carlos Gallardo Polanco 
* @version 11/11/2016
*/

import java.util.Scanner;
import java.util.Random;

public class matVectorConcurrente implements Runnable{
	static int[][] mat;
	static int[] vec, r;
	int fila;

	/**
	* Constructor de la clase matVectorConcurrente
	* @param fila fila de la que se encarga el hilo
	*/
	public matVectorConcurrente(int fila){
		this.fila=fila;
	}

	/**
	* Método run de la clase matVectorConcurrente
	*/
	public void run (){
		for(int j=0;j<r.length;j++){
			r[fila]+=(mat[fila][j]*vec[j]);
		}
	}

	/**
	* Método principal de la clase matVectorConcurrente
	* @throws Exception
	*/
	public static void main (String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.print("Introduce la dimension de la matriz y el vector (la matriz sera cuadrada):");
		int n = sc.nextInt();
		mat = new int[n][n];
		vec = new int[n];
		r = new int[n];
		System.out.println("Quiere introducir manualmete la matriz y el vector o que se rellenen automaticamente?");
		System.out.println("1- Manual");
		System.out.println("2- Automatico");
		System.out.print(": ");
		int op = sc.nextInt();
		switch(op){
			case 1:
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						System.out.print("Matriz. Posicion ["+(i+1)+"]["+(j+1)+"]: ");
						mat[i][j] = sc.nextInt();
					}
				}
				for(int i=0; i<n; i++){
					System.out.print("Vector. Posicion ["+(i+1)+"]: ");
					vec[i] = sc.nextInt();
				}
			break;
			case 2:
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						mat[i][j] = rd.nextInt();
					}
				}
				for(int i=0; i<n; i++){
					vec[i] = rd.nextInt();
				}
			break;
			default: break;
		}

		
		Runnable[] h = new matVectorConcurrente[n];
		for(int i=0; i<n; i++){
			h[i] = new matVectorConcurrente(i);
		}

		
		System.out.println("Comienza el trabajo...");
		long inicCronom = System.nanoTime(); // Establece la hora al inicio en nanosegundos

		for(int i=0; i<n; i++){
			new Thread(h[i]).start();
		}
		for(int i=0; i<n; i++){
			new Thread(h[i]).join();
		}
		
		long finCronom = System.nanoTime(); // Establece la hora al final en nanosegundos
				
		System.out.println("El producto es: ");
		for(int i=0;i<r.length;i++){
			System.out.println("|"+r[i]+"|");
		}

		System.out.println();
		System.out.println("Acabando en " + (finCronom - inicCronom) + " nanosegundos"); 
		// La resta resulta el tiempo en nanosegundos que ha durado la ejecución
	}
}