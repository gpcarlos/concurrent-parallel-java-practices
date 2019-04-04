/**
* P4 - E2
* Clase prodMat que realiza la multiplicación entre dos matrices introducidas por el usuario o rellenadas de forma automática mediante el uso de la clase Random
* @author Carlos Gallardo Polanco
* @version 06/11/2017
*/

import java.util.Scanner;
import java.util.Random;

public class prodMatConcurrente implements Runnable{
	static int[][] mat1, mat2, r;
	int fila;

	/**
	* Constructor de la clase prodMatConcurrente
	* @param f fila que le corresponde al hilo
	*/
	public prodMatConcurrente (int f){
		fila=f;
	}

	/**
	* Método run de la clase prodMatConcurrente
	*/
	public void run(){
		for(int i=0;i<r.length;i++){
			for(int j=0;j<r.length;j++){
				r[fila][i]+=(mat1[fila][j]*mat2[j][i]);
			}
		}

	}


	/**
	* Método principal de la clase matvector
	*/
	public static void main (String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.print("Introduce la dimension de las matrices cuadradas:");
		int n = sc.nextInt();
		mat1 = new int[n][n];
		mat2 = new int[n][n];
		r = new int[n][n];
		System.out.println("Quiere introducir manualmete la matriz y el vector o que se rellenen automaticamente?");
		System.out.println("1- Manual");
		System.out.println("2- Automatico");
		System.out.print(": ");
		int op = sc.nextInt();
		switch(op){
			case 1:
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						System.out.print("Matriz 1. Posicion ["+(i+1)+"]["+(j+1)+"]: ");
						mat1[i][j] = sc.nextInt();
					}
				}
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						System.out.print("Matriz 2. Posicion ["+(i+1)+"]["+(j+1)+"]: ");
						mat2[i][j] = sc.nextInt();
					}
				}
			break;
			case 2:
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						mat1[i][j] = rd.nextInt();
						mat2[i][j] = rd.nextInt();
					}
				}
			break;
			default: break;
		}

		Runnable[] h = new prodMatConcurrente[n];
		for(int i=0;i<n;i++){
			h[i] = new prodMatConcurrente(i);
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
			for(int j=0;j<r.length;j++){
				System.out.print(" "+r[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Acabando en " + (finCronom - inicCronom) + " nanosegundos");
		// La resta resulta el tiempo en nanosegundos que ha durado la ejecución
	}
}
