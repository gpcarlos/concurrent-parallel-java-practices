/**
* P7 - E2
* Clase ficheroSeguro, compuesta por una clase principal, un contructor y un método run.
* @author Carlos Gallardo Polanco
* @version 28/11/2016
*/

import java.io.*;
import java.util.concurrent.*;

public class ficheroSeguro implements Runnable{
	static char[] vector ={'H','o','l','a'};
	static RandomAccessFile fichero;
	int pos;

	/**
    * Contructor de la clase ficheroSeguro
    * @param s Parámetro de tipo entero que indica la posición del vector
    */
	public ficheroSeguro(int pos){
		this.pos=pos;
	}

	/**
    *Metodo run de la clase ficheroSeguro
    */
	public synchronized void run(){
			try{
				fichero.writeChar(vector[pos]);
			} catch(FileNotFoundException e) {
				System.out.println("No hay fichero");
			} catch(IOException e){}
	}

	/**
    * Método principal de la clase ficheroSeguro
    */
	public static void main(String[] args) throws Exception{
		fichero=new RandomAccessFile(new File("fichero.txt"), "rw");

		ExecutorService ejecutor = Executors.newCachedThreadPool();

		for(int i=0;i<vector.length;i++){
			ejecutor.execute(new ficheroSeguro(i));
		}

		ejecutor.shutdown();
		while(!ejecutor.isTerminated()){}
		
	}
}