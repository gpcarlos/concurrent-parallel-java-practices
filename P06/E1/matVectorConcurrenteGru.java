/**
* P6 - E2
* Clase matVectorConcurrenteGru que realiza la multiplicación entre una  matriz y un vector introducidos por el usuario o rellenados de forma automática mediante el uso de la clase Random
* @author Carlos Gallardo Polanco
* @version 20/11/2017
*/

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class matVectorConcurrenteGru implements Runnable{
	static	int[][] mat;
	static	int[] 	vec, r;
	static 	int 	nHilos = Runtime.getRuntime().availableProcessors();
			int 	linf, lsup;
	// Debido a que el coeficiente de bloqueo es 0, Por la Ecuación de
	// Subramanian, el nHilos = nCores

	/**
	* Constructor de la clase matVectorConcurrenteGru
	* @param linf Límite inferior
	* @param lsup Límite superior
	*/
	public matVectorConcurrenteGru(int linf, int lsup){
		this.linf=linf;
		this.lsup=lsup;
	}

	/**
	* Método run de la clase matVectorConcurrenteGru
	*/
	public void run (){
		for(int fila=linf;fila<lsup;fila++){
			for(int j=0;j<r.length;j++){
				r[fila]+=(mat[fila][j]*vec[j]);
			}
		}
	}

	/**
	* Método principal de la clase matVectorConcurrenteGru
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

		ExecutorService ex = Executors.newCachedThreadPool();
		int ventana = n/nHilos;
		int inf = 0;
		int sup = ventana;

		System.out.println("Comienza el trabajo...");
		long inicCronom = System.nanoTime(); // Establece la hora al inicio en nanosegundos

		for(int i=0; i<nHilos; i++){
			ex.execute(new matVectorConcurrenteGru(inf,sup));
			inf=sup;
			sup+=ventana;
			// Si al dividir el numero de filas que se han de multiplicar entre el nHilos,
			// hay filas que no se le asignan a ningun hilo, serán asignadas al ultimo hilo
			if((i==nHilos-2)&&(ventana*nHilos!=n)){sup+=(n-ventana*nHilos);}
		}
		ex.shutdown();
		while(!ex.isTerminated()){}

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
