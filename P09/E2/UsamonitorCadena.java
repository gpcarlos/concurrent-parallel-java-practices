/**
* P9 - E2
* Clase UsamonitorCadena, compuesta por un contructor, un método run y un método principal
* @author Carlos Gallardo Polanco
* @version 18/12/2017
*/

import java.util.concurrent.*;

public class UsamonitorCadena implements Runnable{
	static monitorCadena monitor=new monitorCadena();
	private int tipoHilo;

	/**
    * Contructor nulo de la clase UsamonitorCadena
    */
	public UsamonitorCadena(){}

	/**
    *Constructor de la clase UsamonitorCadena
    * @param tipoHilo Parámetro de tipo entero que indica tipo de hilo
    */
	public UsamonitorCadena(int tipoHilo){
		this.tipoHilo=tipoHilo;
	}

	/**
    * Método run de la clase UsamonitorCadena
    */
	public synchronized void run(){
		switch(tipoHilo){
			case 0: monitor.procesoA(); break;
			case 1: monitor.procesoB(); break;
			case 2: monitor.procesoC(); break;
		}
	}

	/**
    * Método principal de la clase UsamonitorCadena
    *@throws Exception
    */
	public static void main(String[] args) throws Exception {
		ExecutorService ex = Executors.newCachedThreadPool();

		ex.execute(new UsamonitorCadena(0));
		ex.execute(new UsamonitorCadena(1));
		ex.execute(new UsamonitorCadena(2));

		ex.shutdown();
		while(!ex.isTerminated()){}
	}
}
