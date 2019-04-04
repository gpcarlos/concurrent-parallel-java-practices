/**
* P3 - E4
* Clase escalaVectorParalelo que escala un vector de 10^8 elementos de manera multihebrada. Dotado de un método principal, un constructor y un método run.
* @author Carlos Gallardo Polanco
* @version 1.0 04/11/2016
*/

import java.util.Random;

public class escalaVectorParalelo extends Thread{
	Random rd = new Random();
	int escala=5;
	static int[] vector = new int[1000000];
	int limiteInf;
	int limiteSup;

	/**
	* Constructor de la clase escalaVectorParalelo
	*/
	public escalaVectorParalelo (int limiteInf, int limiteSup){
		this.limiteInf=limiteInf;
		this.limiteSup=limiteSup;
	}
	/**
	* Método run de la clase escalaVectorParalelo
	*/
	public void run (){
		for(int i=limiteInf; i<limiteSup; i++){
			vector[i]=rd.nextInt()*escala;
			System.out.print(" "+vector[i]+" ");
		}
	}

	/**
	* Método principal de la clase escalaVectorParalelo
	*/
	public static void main (String[] args) throws Exception{
		int tramo = vector.length/4;
		escalaVectorParalelo A = new escalaVectorParalelo(0,tramo);
		escalaVectorParalelo B = new escalaVectorParalelo(tramo,tramo*2);
		escalaVectorParalelo C = new escalaVectorParalelo(tramo*2,tramo*3);
		escalaVectorParalelo D = new escalaVectorParalelo(tramo*3,tramo*4);

		A.start();
		B.start();
		C.start();
		D.start();
		A.join();
		B.join();
		C.join();
		D.join();
		
	}

}