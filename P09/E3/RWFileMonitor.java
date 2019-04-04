/**
* P9 - E3
* Clase RWFileMonitor, compuesta por un contructor del monitor y los métodos StartRead, EndRead, StartWrite y EndWrite
* @author Carlos Gallardo Polanco
* @version 18/12/2017
*/

import java.io.RandomAccessFile;
import java.util.Random;

class RWFileMonitor {
  volatile int readers = 0;
  volatile boolean writing = false;
  static RandomAccessFile data;

  static Random random = new Random();

  /**
  *Constructor de la clase RWFileMonitor
  */
  public RWFileMonitor(){
        try{
            data = new RandomAccessFile("data.dat","rw");
        }catch(Exception e){}
    }

  /**
  * Método StartRead de la clase RWFileMonitor
  */
  synchronized void StartRead() {
    while (writing)
      try {
         wait();
      } catch (InterruptedException e) {}
    readers = readers + 1;
    System.out.println("Lector inicia lectura...");
    notifyAll();
  }

  /**
  * Método EndRead de la clase RWFileMonitor
  */
  synchronized void EndRead() {
    try{
      System.out.println("Se lee: "+data.readInt());
    }catch(Exception e){System.out.println("No hay nada que leer.");}
    readers = readers - 1;
    if (readers == 0) notifyAll();
    System.out.println("Lector finaliza lectura...");
  }

  /**
  * Método StartWrite de la clase RWFileMonitor
  */
  synchronized void StartWrite() {
    while (writing || (readers != 0))
      try {
         wait();
      } catch (InterruptedException e) {}
    writing = true;
    System.out.println("Escritor inicia escritura...");
  }

  /**
  * Método EndWrite de la clase RWFileMonitor
  */
  synchronized void EndWrite() {
    try{
      data.writeInt(random.nextInt(50));
      writing = false;
    }catch(Exception e){}
    notifyAll();
    System.out.println("Escritor finaliza escritura...");
  }
}
