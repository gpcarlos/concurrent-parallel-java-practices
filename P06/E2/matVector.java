/**
* P4 - E1
* Clase matVector que realiza la multiplicación entre una  matriz y un vector introducidos por el usuario o rellenados de forma automática mediante el uso de la clase Random
* @author Carlos Gallardo Polanco 
* @version 11/11/2016
*/

import java.util.Scanner;
import java.util.Random;

public class matVector{
	static int[][] mat;
	static int[] vec;

	/**
	* Método principal de la clase matvector
	*/
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.print("Introduce la dimension de la matriz y el vector (la matriz sera cuadrada):");
		int n = sc.nextInt();
		mat = new int[n][n];
		vec = new int[n];
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
		int [] r = producto(mat,vec);
		System.out.println("El producto es: ");
		for(int i=0;i<r.length;i++){
			System.out.println("|"+r[i]+"|");
		}
	}

	/**
	* Método producto que realiza el producto de una matriz y un vector 
	* @param m Matriz
	* @param v Vector
	* @return r Producto
	*/
	public static int[] producto (int[][] m, int[] v){
		int[] r = new int[v.length];
		for(int i=0;i<v.length;i++){
			for(int j=0;j<v.length;j++){
				r[i]+=(m[i][j]*v[j]);
			}
		}
		return r;
	}
}