/**
* P10 - E4
* Clase usaFiloApiAN, dotada de un método principal, un constructor y un método run
* @author Carlos Gallardo Polanco
* @version 19/12/2016
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class usaFiloApiAN implements Runnable{
	private filoApiAN monitorFilo = new filoApiAN();
	private int idFil;

	/**
    * Constructor de la clase usaFiloApiAN
    * @param idFil id del filosofo
    */
	public usaFiloApiAN(int idFil){
		this.idFil=idFil;
	}

	/**
    * Método run de la clase usaFiloApiAN
    */
	public void run(){
		for(;;){
			System.out.println("El filosofo "+(idFil+1)+" espera a coger la cuchara");
			monitorFilo.coger_Cuchara(idFil);
			System.out.println("El filosofo "+(idFil+1)+" empieza a comer.");
			monitorFilo.dejar_Cuchara(idFil);
			System.out.println("El filosofo "+(idFil+1)+" ha dejado la cuchara.");
		}
	}

	/**
    * Método principal de la clase usaFiloApiAN
    * @param args array de cadena de caracteres
    * @throws Exception
    */
	public static void main(String[] args) throws Exception{
		ExecutorService ex = Executors.newFixedThreadPool(5);
		for(int i=0; i<5; i++){
			ex.execute(new usaFiloApiAN(i));
		}
		ex.shutdown();
        while(!ex.isTerminated()){}
	}

}