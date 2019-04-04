/**
* P10 - E2
* Clase RWFileMonitorAN, compuesta por un contructor del monitor y los métodos StartRead, EndRead, StartWrite y EndWrite
* @author Carlos Gallardo Polanco
* @version 19/12/2016
*/

import java.util.Random;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.*;

public class RWFileMonitorAN {
  Random random = new Random();
  private volatile int readers = 0;
  private volatile boolean writing = false;
  private RandomAccessFile data;

  ReentrantLock cerrojo = new ReentrantLock();
  Condition condicion = cerrojo.newCondition();

  /**
  *Constructor de la clase RWFileMonitorAN
  */
  public RWFileMonitorAN(){
        try{
            data = new RandomAccessFile("data.dat","rw");
        }catch(Exception e){}
    }

  /**
  * Método StartRead de la clase RWFileMonitorAN
  */
  public void StartRead() {
    cerrojo.lock();
    try{
      while (writing){
        try {
          condicion.await();
        } catch (InterruptedException e) {}
      }
      readers = readers + 1;
      System.out.println("Lector inicia lectura..."); 
    }finally{cerrojo.unlock();}
  }

  /**
  * Método EndRead de la clase RWFileMonitorAN
  */
  public void EndRead() {
    cerrojo.lock();
    try{
      try{
        System.out.println("Se lee: "+data.readInt());
      }catch(Exception e){System.out.println("No hay nada que leer.");}

      readers = readers - 1;
      if (readers == 0) condicion.signalAll();
      System.out.println("Lector finaliza lectura...");
    }finally{cerrojo.unlock();}
  }

  /**
  * Método StartWrite de la clase RWFileMonitorAN
  */
  public void StartWrite() {
    cerrojo.lock();
    try{
      while (writing || (readers != 0))
        try {
           condicion.await();
        } catch (InterruptedException e) {}
      writing = true;
      System.out.println("Escritor inicia escritura...");
    }finally{cerrojo.unlock();}
  }

  /**
  * Método EndWrite de la clase RWFileMonitorAN
  */
  public void EndWrite() {
    cerrojo.lock();
    try{
      try{
        data.writeInt(random.nextInt(50));
        writing = false;
      }catch(Exception e){}
      condicion.signalAll();
      System.out.println("Escritor finaliza escritura...");
    }finally{cerrojo.unlock();}
  }
}