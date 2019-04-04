/**
* P10 - E2
* Clase UsaRWFileMonitorAN, compuesta por un contructor, un método run y un método principal
* @author Carlos Gallardo Polanco
* @version 19/12/2016
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class UsaRWFileMonitorAN implements Runnable{
	private RWFileMonitorAN monitor=new RWFileMonitorAN();
	private int tipoHilo;

	/**
    *Constructor de la clase UsaRWFileMonitorAN
    * @param tipoHilo Parámetro de tipo entero que indica tipo de hilo
    */
	public UsaRWFileMonitorAN(int tipoHilo){
		this.tipoHilo=tipoHilo;
	}

	/**
    * Método run de la clase UsaRWFileMonitorAN
    */
	public synchronized void run(){
		switch(tipoHilo){
			case 0: monitor.StartRead(); monitor.EndRead(); break;
			case 1: monitor.StartWrite(); monitor.EndWrite(); break;
		}
	}

	/**
    * Método principal de la clase UsaRWFileMonitorAN
    * @param args array de cadena de caracteres
    * @throws Exception 
    */
	public static void main(String[] args) throws Exception{
		ExecutorService ex = Executors.newCachedThreadPool();
		for(int i=0;i<4;i++){
			ex.execute(new UsaRWFileMonitorAN(1));
			ex.execute(new UsaRWFileMonitorAN(0));
		}
		ex.shutdown();
		while(!ex.isTerminated()){}
	}
}