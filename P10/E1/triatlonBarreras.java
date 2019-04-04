/**
* P10 - E1
* Clase triatlonBarreras, compuesta por un constructor de la clase, un método run y un método principal
* @author Carlos Gallardo Polanco
* @version 19/12/2016
*/

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class triatlonBarreras implements Runnable{
	public static int 			N=100; //Nº de participantes
	public static int 			TMAX=100; //Máximo tiempo que tardará un participante en pasar una Posta
	public 		  int 			participante;
	public static CyclicBarrier meta1 = new CyclicBarrier (N);
	public static CyclicBarrier meta2 = new CyclicBarrier (N);
	public static CyclicBarrier meta3 = new CyclicBarrier (N);
	public static long[] 		tiempoTotal = new long[N];

	static Random random = new Random();

	/**
	* Constructor de la clase triatlonBarreras
	* @param int participante variable que hace referencia al participante de la carrera
	*/
	public triatlonBarreras(int participante){
		this.participante = participante; 
	}

	/**
	* Método run de la clase triatlonBarreras
	*/
	public void run(){
		//Posta 1
		System.out.println("El participante "+(participante+1)+" ha empezado la Posta 1.");
		int rand = random.nextInt(TMAX); //Se le asigna a rando un tiempo aleatorio, que será el tiempo que se dormirá el hilo en esta Posta

		//Empieza a cronometrar
		long inicCronom = System.currentTimeMillis();
			try{
				Thread.sleep(rand);
			}catch(InterruptedException e){}
		long finCronom = System.currentTimeMillis();
		//Termina de cronometrar

		tiempoTotal[participante]+= (finCronom - inicCronom);
		System.out.println("El participante "+(participante+1)+" ha tardado: "+(finCronom-inicCronom)+" milisegundos.");

		//Espera a que todos lleguen a la meta 1
		try {
			meta1.await();
		}catch (BrokenBarrierException e){}
		 catch (InterruptedException e){}
		
		//Posta 2
		System.out.println("El participante "+(participante+1)+" ha empezado la Posta 2.");
		rand = random.nextInt(TMAX); //Se le asigna a rando un tiempo aleatorio, que será el tiempo que se dormirá el hilo en esta Posta

		//Empieza a cronometrar
		inicCronom = System.currentTimeMillis();
			try{
				Thread.sleep(rand);
			}catch(InterruptedException e){}
		finCronom = System.currentTimeMillis();
		//Termina de cronometrar

		tiempoTotal[participante]+= (finCronom - inicCronom);
		System.out.println("El participante "+(participante+1)+" ha tardado: "+(finCronom-inicCronom)+" milisegundos.");

		//Espera a que todos lleguen a la meta2
		try {
			meta2.await();
		}catch (BrokenBarrierException e){}
		 catch (InterruptedException e){}
		
		//Posta 3
		System.out.println("El participante "+(participante+1)+" ha empezado la Posta 3.");
		rand = random.nextInt(TMAX); //Se le asigna a rando un tiempo aleatorio, que será el tiempo que se dormirá el hilo en esta Posta
		
		//Empieza a cronometrar
		inicCronom = System.currentTimeMillis();
			try{
				Thread.sleep(rand);
			}catch(InterruptedException e){}
		finCronom = System.currentTimeMillis();
		//Termina de cronometrar

		tiempoTotal[participante]+= (finCronom - inicCronom);
		System.out.println("El participante "+(participante+1)+" ha tardado: "+(finCronom-inicCronom)+" milisegundos.");

		//Espera a que todos lleguen a la meta3
		try {
			meta3.await();
		}catch (BrokenBarrierException e){}
		 catch (InterruptedException e){}

		//El triatlon ha terminado y dice el tiempo total que ha tardado el participante
		System.out.println("El participante "+(participante+1)+" ha terminado el triatlon en "+tiempoTotal[participante]+" milisegundos.");
		
	}

	/**
	* Método principal de la clase triatlonBarreras
	* @throws Exception
	*/
	public static void main(String[] args) throws Exception{
		ExecutorService ex = Executors.newCachedThreadPool();
		triatlonBarreras[] participante = new triatlonBarreras[N];

		System.out.println("Comienza el triatlon!!!!");
    	for(int i=0; i<N; i++) {
     		participante[i]=new triatlonBarreras(i);
     		ex.execute(participante[i]);
    	}
    	ex.shutdown();
    	while(!ex.isTerminated()){}

	    long menorTiempo=tiempoTotal[0];
	    int ganador=0;
	    for(int i=1;i<N;i++){
	    	if(tiempoTotal[i]<menorTiempo){
	    		menorTiempo=tiempoTotal[i];
	    		ganador=i;
	    	}
	    }

	    System.out.println("El ganador de triatlon es el participante "+(ganador+1)+" Enhorabuena!!!!");
	    
	}
}
	
		