
import java.util.concurrent.*;

public class drakkarVikingo implements Runnable {
  private static final Object aComer = new Object();
  private static int N=10;
  private static int marmita=N;
  private int vikingo;

  public drakkarVikingo(int vikingo) {
    this.vikingo = vikingo;
  }

  public void run() {
    synchronized(aComer) {
      if (vikingo==0) for(;;) cocinar();
      else for(;;) comer(vikingo);
    }
  }

  public synchronized void cocinar() {
    while (marmita>0) {
      try {
        aComer.wait();
      } catch (Exception e){}
    }
    marmita=N;
    System.out.println("Cocinero ha cocinado");
    aComer.notifyAll();
  }

  public synchronized void comer(int vikingo) {
    while (marmita==0) {
      try {
        aComer.wait();
        System.out.println("Vikingo espera");
      } catch (Exception e){}
    }
    marmita--;
    System.out.println("Vikingo "+vikingo+" come una de las "+marmita+" restantes");
    aComer.notifyAll();
  }

  public static void main(String[] args) throws Exception {
    ExecutorService ex = Executors.newCachedThreadPool();
    int vikingos = Runtime.getRuntime().availableProcessors();

    for (int i=0; i<vikingos; ++i) {
      ex.execute(new drakkarVikingo(i));
    }
    ex.shutdown();
    while(!ex.isTerminated()){}
  }

}
