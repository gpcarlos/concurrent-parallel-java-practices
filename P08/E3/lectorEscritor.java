/**
* P8 - E3
* Clase lectorEscritor, dotada de un constructor y los métodos inicia_escritura, fin_escritura, inicia_lectura y fin_lectura
* @author Carlos Gallardo Polanco
* @version 11/12/17
*/

import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class lectorEscritor{
    static int nLectores=0;
    static boolean escribiendo=false;
    static RandomAccessFile file;

    /**
    * Constructor de la clase lectorEscritor
    */
    public lectorEscritor(){
        try{
            file = new RandomAccessFile("lectorEscritor.txt","rw");
        }catch(Exception e){}
    }

    /**
    * Método inicia_lectura de la clase lectorEscritor
    */
    public synchronized void inicia_lectura(){
        while(escribiendo){
            try{
                wait();
            }catch(Exception e){}
        }
    	nLectores++;
    	notifyAll();
    }

    /**
    * Método fin_lectura de la clase lectorEscritor
    */
    public synchronized void fin_lectura(){
    	nLectores--;
        try{
            System.out.println("Se ha leido: "+file.readChar());
        }catch(Exception e){}
    	if(nLectores==0){notifyAll();}
    }

    /**
    * Método inicia_escritura de la clase lectorEscritor
    */
    public synchronized void inicia_escritura(){
    	while(nLectores!=0||escribiendo){
            try{
                wait();
            }catch(Exception e){}
        }
    	escribiendo=true;
    }

    /**
    * Método fin_escritura de la clase lectorEscritor
    */
    public synchronized void fin_escritura(){
        try{
            escribiendo=false;
            file.writeChar('H');
            file.writeChar('O');
            file.writeChar('L');
            file.writeChar('A');
        }catch(Exception e){}
        notifyAll();
    }

}
