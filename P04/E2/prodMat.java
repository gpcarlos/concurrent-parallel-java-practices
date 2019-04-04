/**
* P4 - E2
* Clase prodMat que realiza la multiplicación entre dos matrices introducidas por el usuario o rellenadas de forma automática mediante el uso de la clase Random
* @author Carlos Gallardo Polanco 
* @version 11/11/2016
*/

import java.util.Scanner;
import java.util.Random;

public class prodMat{
	static int[][] mat1, mat2, r;
	static int n;

	/**
	* Método principal de la clase matvector
	*/
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.print("Introduce la dimension de las matrices cuadradas:");
		n = sc.nextInt();
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
		r = producto();
		System.out.println("El producto es: ");
		for(int i=0;i<r.length;i++){
			for(int j=0;j<r.length;j++){
				System.out.print(" "+r[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	* Método producto que realiza el producto de una matriz y un vector 
	* @param m1 Matriz 1
	* @param m2 Matriz 2
	* @return r Producto
	*/
	public static int[][] producto (){
		for(int z=0;z<n;z++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					r[z][i]+=(mat1[z][j]*mat2[j][i]);
				}
			}
		}
		return r;
	}
}