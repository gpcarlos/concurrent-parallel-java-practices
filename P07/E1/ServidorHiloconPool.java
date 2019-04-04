/**
* P7 - E1
* Clase ServidorHiloconPool, compuesta por una clase principal, un contructor y un método run.
* @author Carlos Gallardo Polanco
* @version 01/12/2017
*/

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class ServidorHiloconPool extends Thread{
    Socket enchufe;

    /**
    * Contructor de la clase ServidorHiloconPool
    * @param s Parámetro de tipo Socket
    */
    public ServidorHiloconPool(Socket s)
    {enchufe = s;}

    /**
    *Metodo run de la clase ServidorHiloconPool
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
    * Método principal de la clase ServidorHiloconPool
    */
	public static void main (String[] args){
	    int i;
	    int puerto = 2001;
	    int tamPool = 10;

	    ThreadPoolExecutor miPool = new ThreadPoolExecutor(tamPool, tamPool,
	    	60000L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

	    try{
	        ServerSocket chuff = new ServerSocket (puerto, 3000);

	        while (true){
	            System.out.println("Esperando solicitud de conexion...");
	            Socket cable = chuff.accept();
	            System.out.println("Recibida solicitud de conexion...");

	            miPool.execute(new ServidorHiloconPool(cable));
	            miPool.shutdown();
	        }//while
	    } catch (Exception e){System.out.println("Error en sockets...");}
	}//main
}//ServidorHiloconPool
