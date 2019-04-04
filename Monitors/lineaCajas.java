import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class lineaCajas {

  final ReentrantLock l = new ReentrantLock();
  final Condition c = l.newCondition();

  int[] cajas = new int[20];
  int cajasLibres = 20;

  public void pedir_caja(int i) {
    l.lock();
    try {
      while (cajas[i]==10) {
        try {
          c.await();
        } catch(InterruptedException e){}
      }
      cajas[i]++;
      System.out.println("[PIDE] Caja numero "+i+" con"+cajas[i]+" clientes");
      c.signalAll();
    } finally { l.unlock();}
  }

  public void dejar_caja(int i) {
    l.lock();
    try {
      while (cajas[i]==0) {
        try {
          c.await();
        } catch(InterruptedException e){}
      }
      cajas[i]--;
      System.out.println("[DEJA] Caja numero "+i+" con"+cajas[i]+" clientes");
      c.signalAll();
    } finally { l.unlock();}
  }

}
