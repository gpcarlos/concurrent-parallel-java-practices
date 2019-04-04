/**
* P9 - E3
* Clase UsaRWFileMonitor, compuesta por un contructor, un método run y un método principal
* @author Carlos Gallardo Polanco
* @version 18/12/2017
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class UsaRWFileMonitor implements Runnable{
	static RWFileMonitor monitor=new RWFileMonitor();
	private int tipoHilo;

	/**
    * Contructor nulo de la clase UsaRWFileMonitor
    */
	public UsaRWFileMonitor(){}

	/**
    * Constructor de la clase UsaRWFileMonitor
    * @param tipoHilo Parámetro de tipo entero que indica tipo de hilo
    */
	public UsaRWFileMonitor(int tipoHilo){
		this.tipoHilo=tipoHilo;
	}

	/**
    * Método run de la clase UsaRWFileMonitor
    */
	public synchronized void run(){
		switch(tipoHilo){
			case 0: monitor.StartRead(); monitor.EndRead(); break;
			case 1: monitor.StartWrite(); monitor.EndWrite(); break;
		}
	}

	/**
    * Método principal de la clase UsaRWFileMonitor
    * @throws Exception
    */
	public static void main(String[] args) throws Exception{
		ExecutorService ex = Executors.newCachedThreadPool();
		for(int i=0;i<4;i++){
			ex.execute(new UsaRWFileMonitor(1));
			ex.execute(new UsaRWFileMonitor(0));
		}
		ex.shutdown();
		while(!ex.isTerminated()){}
	}
}
