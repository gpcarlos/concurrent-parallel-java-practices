/**
* P7 - E4
* Clase PIParaleloFutureCont, compuesta por una clase principal, un contructor y un método call.
* @author Carlos Gallardo Polanco
* @version 01/12/2017
*/

import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.*;

public class PIParaleloFutureCont implements Callable<Integer> {
	public static Random random = new Random();
	public static int intentos=600000;
	public static int puntos=0;
	public int linf;
	public int lsup;
	public static int nHilos = Runtime.getRuntime().availableProcessors();

	/**
    * Contructor de la clase PIParaleloFutureCont
    * @param inf Parámetro de tipo entero que indica el límite inferior
    * @param sup Parámetro de tipo entero que indica el límite superior
    */
	public PIParaleloFutureCont(int inf,int sup){
		this.linf=inf;
		this.lsup=sup;
	}

	/**
    * Metodo call de la clase PIParaleloFutureCont
    * @throws Exception
    */
	public Integer call() throws Exception{
		int contadorlocal=0;
		for(int i=linf; i<lsup; i++){
			double cx = random.nextDouble();
		    double cy = random.nextDouble();
		    if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)contadorlocal++;
		}
		return contadorlocal;
	}

	/**
    * Método principal de la clase PIParaleloFutureCont
    * @throws Exception
    */
	public static void main(String[] args) throws Exception{

		ArrayList<Future<Integer>> array = new ArrayList<Future<Integer>>();

		ExecutorService ex = Executors.newCachedThreadPool();
   		int ventana=(intentos/nHilos);
   		int inf=0;
   		int sup=ventana;

   		System.out.println("Comienza el trabajo...");
		long inicCronom = System.currentTimeMillis();

   		for(int i=0;i<nHilos;i++){
   			array.add(ex.submit(new PIParaleloFutureCont(inf,sup)));
   			inf=sup;
   			sup+=ventana;
   		}

   		for(Future<Integer> intento: array)
     		try{
     			puntos+=(intento.get());
     		}catch (InterruptedException e){
     	}catch (ExecutionException e){
     	}

     	ex.shutdown();
     	while(!ex.isTerminated()){}

		long finCronom = System.currentTimeMillis();
		System.out.println("Acabando trabajo en " + (finCronom - inicCronom) + " milisegundos");
   		System.out.println(puntos);
   		System.out.println(4.0*puntos/intentos);
    }
}
