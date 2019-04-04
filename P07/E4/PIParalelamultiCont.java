/**
* P7 - E4
* Clase PIParalelamultiCont, compuesta por una clase principal, un contructor y un método run.
* @author Carlos Gallardo Polanco
* @version 01/12/2017
*/

import java.util.Random;
import java.util.concurrent.*;

public class PIParalelamultiCont implements Runnable{
	Random random = new Random();
	public static int intentos=600000, puntos=0;
	public int linf;
	public int lsup;
	public static int nHilos = Runtime.getRuntime().availableProcessors();

	/**
    * Contructor de la clase PIParalelamultiCont
    * @param inf Parámetro de tipo entero que indica el límite inferior
    * @param sup Parámetro de tipo entero que indica el límite superior
    */
	public PIParalelamultiCont(int inf,int sup){
		this.linf=inf;
		this.lsup=sup;
	}

	/**
    * Metodo run de la clase PIParalelamultiCont
    */
	public void run(){
		int contadorlocal=0;
	    for(int i=linf; i<lsup; i++){
	    	double cx = random.nextDouble();
	    	double cy = random.nextDouble();
	    	if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)contadorlocal++;
	    }
	    puntos+=contadorlocal;
	}

	/**
    * Método principal de la clase PIParalelamultiCont
    * @throws Exception
    */
	public static void main(String[] args) throws Exception{

		ExecutorService ex = Executors.newCachedThreadPool();
   		int ventana=(intentos/nHilos);
   		int inf=0;
   		int sup=ventana;

   		System.out.println("Comienza el trabajo...");
		long inicCronom = System.currentTimeMillis();

   		for(int i=0;i<nHilos;i++){
   			ex.execute(new PIParalelamultiCont(inf,sup));
   			inf=sup;
   			sup+=ventana;
   		}
   		ex.shutdown();
   		while(!ex.isTerminated()){}

		long finCronom = System.currentTimeMillis();
		System.out.println("Acabando trabajo en " + (finCronom - inicCronom) + " milisegundos");
   		System.out.println(puntos);
   		System.out.println(4.0*puntos/intentos);
    }
}
