/**
* P7 - E1
* Clase ServidorHilosinPool, compuesta por una clase principal, un contructor y un método run.
* @author Carlos Gallardo Polanco
* @version 01/12/2017
*/

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class ServidorHilosinPool extends Thread{
    Socket enchufe;

    /**
    * Contructor de la clase ServidorHilosinPool
    * @param s Parámetro de tipo Socket
    */
    public ServidorHilosinPool(Socket s)
    {enchufe = s;}

    /**
    *Metodo run de la clase ServidorHilosinPool
    */
    public void run(){
	    try{
	        BufferedReader entrada = new BufferedReader(
	                                    new InputStreamReader(
	                                        enchufe.getInputStream()));
	        String datos = entrada.readLine();
	        int j;
	        int i = Integer.valueOf(datos).intValue();
	        for(j=1; j<=20; j++){
	        System.out.println("El hilo "+this.getName()+" escribiendo el dato "+i);
	        sleep(1000);}
	        enchufe.close();
	        System.out.println("El hilo "+this.getName()+"cierra su conexion...");
	    } catch(Exception e) {System.out.println("Error...");}
    }//run

    /**
    * Método principal de la clase ServidorHilosinPool
    */
	public static void main (String[] args){
	    int i;
	    int puerto = 2001;

	    try{
	        ServerSocket chuff = new ServerSocket (puerto, 3000);

	        while (true){
	            System.out.println("Esperando solicitud de conexion...");
	            Socket cable = chuff.accept();
	            System.out.println("Recibida solicitud de conexion...");

	           ServidorHilosinPool hilo = new ServidorHilosinPool(cable);
	           hilo.start();
	           hilo.join();
	        }//while
	    } catch (Exception e){System.out.println("Error en sockets...");}
	}//main
}//ServidorHilosinPool
