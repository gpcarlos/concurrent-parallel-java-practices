/**
* P8 - E2
* Clase drakkarVikingo, dotada de un método principal, un constructor y un método run
* @author Carlos Gallardo Polanco
* @version 11/12/17
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class drakkarVikingo implements Runnable{
	private static final Object aComer = new Object();
	private static int N=500;
	private static int marmita=N;
	private int vikingo;

	/**
    * Constructor de la clase drakkarVikingo
    */
	public drakkarVikingo(int vikingo){
		this.vikingo=vikingo;
	}

	/**
    * Método run de la clase drakkarVikingo
    */
	public void run(){
		synchronized(aComer){
			if(vikingo==0){for(;;){cocinar();}} //El cocinero
			else{for(;;){comer(vikingo);}}
		}
	}

	/**
    * Método cocinar de la clase drakkarVikingo
    */
	public synchronized void cocinar(){
		while(marmita>0){
			try{
				aComer.wait();
			}catch (Exception e){}
		}
		marmita=N;
		System.out.println("El cocinero ha rellenado la marmita.");
		aComer.notifyAll();
	}

	/**
    * Método comer de la clase drakkarVikingo
    */
	public synchronized void comer(int vikingo){
		while(marmita==0){
			try{
				System.out.println("Vikingo esperando...");
				aComer.wait();
			}catch (Exception e){}
		}
		marmita--;
		System.out.println("El Vikingo "+vikingo+" ha comido. Quedan "+marmita+" anguilas.");
		aComer.notifyAll();
	}

	/**
    * Método principal de la clase drakkarVikingo
    */
	public static void main (String[] args) throws Exception{
		ExecutorService ex = Executors.newCachedThreadPool();
		int vikingos=Runtime.getRuntime().availableProcessors();
		for(int i=0; i<vikingos+1; i++){ //vikingos+1 porque uno de ellos será el cocinero
			ex.execute(new drakkarVikingo(i));
		}
		ex.shutdown();
		while(!ex.isTerminated()){}
	}
}
