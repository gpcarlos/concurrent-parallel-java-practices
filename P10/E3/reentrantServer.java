/**
* P10 - E3
* Clase reentrantServer, compuesta por una clase principal, un contructor y un método run.
* @author Carlos Gallardo Polanco
* @version 26-08-2016
*/

import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.*;


public class reentrantServer implements Runnable{
    Socket enchufe;
    static long contador=0;
    ReentrantLock cerrojo = new ReentrantLock();

    /**
    * Contructor de la clase reentrantServer
    * @param s Parámetro de tipo Socket
    */
    public reentrantServer(Socket s)
    {enchufe = s;}

    /**
    *Metodo run de la clase reentrantServer
    */
    public void run(){
	    cerrojo.lock();
	   	try{
		    try{
		        enchufe.close();
		        contador++;
		        System.out.println("Se han realizado la conexion numero "+contador);
		    } catch(Exception e) {System.out.println("Error...");}
		} finally{cerrojo.unlock();}
    }//run

    /**
    * Método principal de la clase reentrantServer
    */
	public static void main (String[] args){
	   	int peticiones = 3000;
	    int puerto = 2001;
	   	ExecutorService ejecutor = Executors.newCachedThreadPool();

	    try{
	        ServerSocket chuff = new ServerSocket (puerto, 3000);
	        for(int a=0; a<peticiones; a++){
	            System.out.println("Esperando solicitud de conexion...");
	            Socket cable = chuff.accept();
	            System.out.println("Recibida solicitud de conexion...");
	            ejecutor.execute(new reentrantServer(cable));
	        }//while
	        ejecutor.shutdown();
	        System.out.println("Se han realizado en total "+contador+" conexiones.");
	    } catch (Exception e){System.out.println("Error en sockets...");}
	}//main

}//reentrantServer

