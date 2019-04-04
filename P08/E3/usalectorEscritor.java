/**
* P8 - E3
* Clase lectorEscritor, dotada de un método principal, un constructor y un método run
* @author Carlos Gallardo Polanco
* @version 11/12/17
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class usalectorEscritor implements Runnable {

	private int tipoHilo;
	private static lectorEscritor lE = new lectorEscritor();

	/**
    * Constructor de la clase usalectorEscritor
    */
	public usalectorEscritor(int tipoHilo) {
		this.tipoHilo=tipoHilo;
	}

	/**
    * Método run de la clase usalectorEscritor
    */
	public synchronized void run() {
		switch (tipoHilo) {
			case 0:
				System.out.println("Se inicia la escritura...");
				lE.inicia_escritura();
				lE.fin_escritura();
				System.out.println("Se termina la escritura...");
			break;
			case 1:
				System.out.println("Se inicia la lectura...");
				lE.inicia_lectura();
				lE.fin_lectura();
				System.out.println("Se termina la lectura...");
			break;
		}
	}

	/**
    * Método principal de la clase usalectorEscritor
    */
	public static void main(String[] args) {
		ExecutorService ex = Executors.newCachedThreadPool();
		int nHilos = Runtime.getRuntime().availableProcessors();
		for (int i=0;i<nHilos;i++) {
			if (i<(nHilos/2)) {
				ex.execute(new usalectorEscritor(0));
			}
			else {
				ex.execute(new usalectorEscritor(1));
			}
		}
		ex.shutdown();
		while(!ex.isTerminated()){}
	}


}
