/**
* P3 - E4
* Clase escalaVector que escala un vector de 10^8 elementos
* @author Carlos Gallardo Polanco
* @version 1.0 06/11/2017
*/

import java.util.Random;

public class escalaVector{
	static int[] vector = new int[100000000];
	static Random rd = new Random();
	static int escala=5;
	/**
	* Método principal de la clase escalaVector
	*/
	public static void main (String[] args){
		for(int i=0; i<vector.length; i++){
			vector[i]=rd.nextInt()*escala;
			System.out.print(" "+vector[i]+" ");
		}
	}

}
