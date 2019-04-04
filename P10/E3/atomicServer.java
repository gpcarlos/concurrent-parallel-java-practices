/**
* P10 - E6
* Clase atomicServer, compuesta por una clase principal, un contructor y un método run.
* @author Carlos Gallardo Polanco
* @version 19/12/2016
*/

import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.*;

public class atomicServer implements Runnable{
    Socket enchufe;
    static AtomicLong contador = new AtomicLong();

    /**
    * Contructor de la clase atomicServer
    * @param s Parámetro de tipo Socket
    */
    public atomicServer(Socket s)
    {enchufe = s;}

    /**
    *Metodo run de la clase atomicServer
    */
    public void run(){
	    try{
	        enchufe.close();
	        System.out.println("Se han realizado la conexion numero "+(contador.getAndIncrement()+1));
	    } catch(Exception e) {System.out.println("Error...");}
    }//run


    /**
    * Método principal de la clase atomicServer
    * @param args array de cadena de caracteres
    */
	public static void main (String[] args){
		int peticiones = 3000;
	    int puerto = 2001;
	   	ExecutorService ex = Executors.newCachedThreadPool();

	    try{
	        ServerSocket chuff = new ServerSocket (puerto, 3000);
	        for(int a=0; a<peticiones; a++){
	            System.out.println("Esperando solicitud de conexion...");
	            Socket cable = chuff.accept();
	            System.out.println("Recibida solicitud de conexion...");
	            ex.execute(new atomicServer(cable));
	        }//while
	        ex.shutdown();
	        System.out.println("Se han realizado en total "+contador.get()+" conexiones.");
	    } catch (Exception e){System.out.println("Error en sockets...");}
	}//main

}//atomicServer

