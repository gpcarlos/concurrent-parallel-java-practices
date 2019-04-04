import java.util.concurrent.*;

public class clientesCajas implements Runnable {
  static lineaCajas lineacajas = new lineaCajas();
  int thread;

  public clientesCajas(int thread) {
    this.thread = thread;
  }

  public void run() {
    if (thread==1) {
      for (int i=0; i<20; ++i) {
        for (int j=0; j<20; ++j) {
          lineacajas.pedir_caja(j);
        }
      }
    } else {
      for (int i=0; i<20; ++i) {
        for (int j=0; j<20; ++j) {
          lineacajas.dejar_caja(j);
        }
      }
    }
  }

  public static void main (String[] args) throws Exception {
    ThreadPoolExecutor ex = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    ex.execute(new clientesCajas(1));
    ex.execute(new clientesCajas(2));

    ex.shutdown();
    while(!ex.isTerminated()){}
  }
}
