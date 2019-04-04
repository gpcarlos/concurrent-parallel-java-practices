import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;

public class aRendimiento implements Runnable {
  private static final int nIter = 100000;
  private static int nIterActual;
  private static long var = 0;
  private int type;

  private static Object o = new Object();
  private static ReentrantLock l = new ReentrantLock();
  private static AtomicLong varAtomic = new AtomicLong(0);

  public aRendimiento(int type){
    this.type=type;
  }

  public void run() {
    for (int i=0; i<nIterActual; ++i) {
      switch (type) {
        case 0:
          calculoReentratlock();
        break;
        case 1:
          calculoSynchronized();
        break;
        case 2:
          calculoAtomic();
        break;
      }
    }
  }

  public void calculoReentratlock() {
    l.lock();
    try {
        var++;
    } finally { l.unlock();}
  }

  public void calculoSynchronized() {
   synchronized(o){
      var++;
   }
  }

  public void calculoAtomic() {
    varAtomic.getAndIncrement();
  }

  public static void main(String[] args) throws Exception {
    int cores = Runtime.getRuntime().availableProcessors();

    long inicCronom, finCronom, tiempo1, tiempo2, tiempo3;

    System.out.println("Iter\tReent\tSynch\tAtom");

    for (nIterActual=5000; nIterActual<=nIter; nIterActual+=5000) {

      // ReentrantLock ----------------
      ExecutorService ex = Executors.newFixedThreadPool(cores);
      inicCronom = System.currentTimeMillis();
      for (int i=0; i<cores; ++i) {
        ex.execute(new aRendimiento(0));
      }
      ex.shutdown();
      while(!ex.isTerminated()){}
      finCronom = System.currentTimeMillis();
      tiempo1 = finCronom - inicCronom;

      // Synchronized ----------------
      ex = Executors.newFixedThreadPool(cores);
      inicCronom = System.currentTimeMillis();
      for (int i=0; i<cores; ++i) {
        ex.execute(new aRendimiento(1));
      }
      ex.shutdown();
      while(!ex.isTerminated()){}
      finCronom = System.currentTimeMillis();
      tiempo2 = finCronom - inicCronom;

      // Atomic ----------------
      ex = Executors.newFixedThreadPool(cores);
      inicCronom = System.currentTimeMillis();
      for (int i=0; i<cores; ++i) {
        ex.execute(new aRendimiento(2));
      }
      ex.shutdown();
      while(!ex.isTerminated()){}
      finCronom = System.currentTimeMillis();
      tiempo3 = finCronom - inicCronom;

      System.out.println(nIterActual+"\t"+tiempo1+"ms\t"+tiempo2+"ms\t"+tiempo3+"ms");
    }

  }

}
