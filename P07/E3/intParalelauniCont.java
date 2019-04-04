/**
* P7 - E3
* Clase intParalelauniCont, compuesta por una clase principal, un contructor y un método run.
* @author Carlos Gallardo Polanco
* @version 01/12/2017
*/

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class intParalelauniCont implements Runnable{
	public static Random random = new Random();
	public static int intentos=600000;
	public static int puntos=0;
	public int linf;
	public int lsup;
	public static int nHilos = Runtime.getRuntime().availableProcessors();

	/**
    * Contructor de la clase intParalelauniCont
    * @param inf Parámetro de tipo entero que indica el límite inferior
    * @param sup Parámetro de tipo entero que indica el límite superior
    */
	public intParalelauniCont(int inf,int sup){
		this.linf=inf;
		this.lsup=sup;
	}

	/**
    * Metodo run de la clase intParalelauniCont
    */
	public void run(){
	    for(int i=linf; i<lsup; i++){
	    	double cx = random.nextDouble();
	    	double cy = random.nextDouble();
	    	double valoraprox = Math.sin(cx);
	    	if(cy<valoraprox){
	    		puntos++;
	    	}
	    }
	}

	/**
    * Método principal de la clase intParalelauniCont
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
   			ex.execute(new intParalelauniCont(inf,sup));
   			inf=sup;
   			sup+=ventana;
   			if((i==nHilos-2)&&(ventana*nHilos!=intentos)){sup+=intentos-ventana*nHilos;}
   		}
   		ex.shutdown();
   		while(!ex.isTerminated()){}

		long finCronom = System.currentTimeMillis();
		System.out.println("Acabando trabajo en " + (finCronom - inicCronom) + " milisegundos");
   		System.out.println(puntos);
   		System.out.println((double)puntos/intentos);
    }
}
