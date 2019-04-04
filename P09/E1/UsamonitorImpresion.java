/**
* P9 - E1
* Clase UsamonitorImpresion, compuesta por un contructor, un método run y un método principal
* @author Carlos Gallardo Polanco
* @version 18/12/2017
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class UsamonitorImpresion implements Runnable {
	private	static 	monitorImpresion impresion=new monitorImpresion();
	private			int tipoHilo;

	/**
    * Contructor nulo de la clase UsamonitorImpresion
    */
	public UsamonitorImpresion() {}

	/**
    *Constructor de la clase UsamonitorImpresion
    * @param tipoHilo Parámetro de tipo entero que indica tipo de hilo
    */
	public UsamonitorImpresion(int tipoHilo) {
		this.tipoHilo=tipoHilo;
	}

	/**
    *Metodo run de la clase UsamonitorImpresion
    */
	public synchronized void run() {
		switch(tipoHilo) {
			case 0:
				System.out.println("Se ha cogido la impresora "+(impresion.pedir_imp()+1));
			break;
			case 1:
				System.out.println("Se ha dejado la impresora "+(impresion.dejar_imp()+1));
			break;
		}
	}

	/**
    * Método principal de la clase UsamonitorImpresion
    * @throws Exception
    */
	public static void main(String[] args) throws Exception {
		ExecutorService ex = Executors.newFixedThreadPool(20);
        for(;;){
            ex.execute(new UsamonitorImpresion(0));
            ex.execute(new UsamonitorImpresion(1));
        }

	}
}
