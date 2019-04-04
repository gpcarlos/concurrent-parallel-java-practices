/**
* P5 - E3
* Clase algoLamport que implementa el algoritmo de la panadería de Lamport, compuesta por una clase principal, un constructor y una método run.
* @author Carlos Gallardo Polanco
* @version 1.0, 13/11/2017
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class algoLamport implements Runnable{
	public static int N=5;
	public static volatile int[] numero = new int[N];
	public static volatile boolean[] eligiendo = new boolean[N];
	public 		  int i;
	public static int ncompartida=0;

	/**
    * Contructor de la clase
    * @param i Indica la fila con la que trabajar
    */
	public algoLamport(int i){
		this.i=i;
	}

	/**
    *Metodo run de la clase
    */
	public void run(){
		for(int k=0;k<1000;k++){
			eligiendo[i]=true;
			numero[i]=i+max(numero);
			eligiendo[i]=false;
			for(int j=0;j<N;j++){
				while(eligiendo[j]){}
				while((numero[j]!=0)&&((numero[j]<numero[i])||((numero[j]==numero[i])&&(j<i)))){}
				// SC
				ncompartida++;
				// SC
				numero[i]=0;
				System.out.println(" ");
			}
		}
	}

	/**
    * Método max, que encuentra el mayor entero del vector numero
    * @param numero array de enteros
    * @return maximo maximo del array de enteros numero
    */
	public int max(int[] numero){
		int maximo=0;
		for(int i=0;i<N;i++){
			if(numero[i]>maximo){maximo=numero[i];}
		}
		return maximo;
	}

	/**
    * Método principal de la clase algoLamport
    * @param args array de cadena de caracteres
    */
	public static void main (String[] args) throws Exception{
		ExecutorService ex = Executors.newFixedThreadPool(N);
		for(int i=0;i<N;i++){ex.execute(new algoLamport(i));}
		ex.shutdown();
		while(!ex.isTerminated()){}
		System.out.println("El recurso comun es "+ncompartida);
	}
}
