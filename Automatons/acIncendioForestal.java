// Para su ejecución:
// javac acIncendioForestal.java && java acIncendioForestal <número de focos> <número de árboles> <generaciones> <pintar?>
// Si <pintar?>==0, no se pinta. Si <pintar?>!=0, se pinta.
// Ejemplo: javac acIncendioForestal.java && java acIncendioForestal 20 250 100 0

import java.util.Random;
import java.util.concurrent.*;

public class acIncendioForestal implements Runnable {
  static int dim=20, n, m, g, pintar;
  static double p=0.001,  // probabilidad de reproducción
                f=0.00001;// probabilidad de propagación por viento
  static int[][] bosque, sucesor;

  int ulimit, llimit, thread;
  static int cores = Runtime.getRuntime().availableProcessors();
  static int usedCores = 1;
  static CyclicBarrier br = new CyclicBarrier(cores);
  static CyclicBarrier midbr = new CyclicBarrier(cores/2);

  public acIncendioForestal(int ulimit, int llimit, int thread) {
    this.ulimit = ulimit;
    this.llimit = llimit;
    this.thread = thread;
  }

  public acIncendioForestal() {}

  public void run () {
    for (int i=0; i<g; ++i) {
      computation();
    }
  }

  public static void setUp() {
    Random rd = new Random();
    bosque = new int[dim][dim];
    sucesor = new int[dim][dim];
    int i, j;
    for (int k=0; k<m; ++k) { // Colocamos los árboles
      do { i = rd.nextInt(dim); j = rd.nextInt(dim);
      } while (bosque[i][j]!=0);
      bosque[i][j] = 1;
    }
    for (int k=0; k<n; ++k) { // Colocamos los focos.
      do { i = rd.nextInt(dim); j = rd.nextInt(dim);
      } while (bosque[i][j]!=1);
      bosque[i][j] = 2;
    }
  }

  public void computation() {
    nextGen();
    // Utiliza una barrera u otra dependiendo del nThreads
    if (usedCores==cores){
      try {
        br.await();
      } catch(Exception e){}
    } else {
      if (usedCores==cores/2) {
        try {
          midbr.await();
        } catch(Exception e){}
      }
    }
    if (thread==0) {
      for (int i=0; i<dim; ++i) {
        for (int j=0; j<dim; ++j) {
          bosque[i][j]=sucesor[i][j];
        }
      }
      if (pintar!=0) paint();
    }
  }

  public void nextGen() {
    Random rd = new Random();
    for (int i=llimit; i<ulimit; ++i) {
      for (int j=0; j<dim; ++j) {
        int c = bosque[i][j];
        boolean burningN = burningNeighbours(i,j);
        if (bosque[i][j]==2) {
          sucesor[i][j] = 0;
        } else {
          if (bosque[i][j]==1 && burningN) {
            sucesor[i][j] = 2;
          } else {
            double probP = rd.nextDouble();
            if (bosque[i][j]==0 && probP<p) {
              sucesor[i][j] = 1;
            } else {
              double probF = rd.nextDouble();
              if (bosque[i][j]==1 && probF<f) {
                sucesor[i][j] = 2;
              } else {
                sucesor[i][j] = bosque[i][j];
              }
            }
          }
        }
      }
    }
  }

  // Comprueba si tiene algún vecino quemandose
  public boolean burningNeighbours(int f, int c) {
    boolean burning = false;
    for(int i=f-1; i<=f+1; ++i)
      for(int j=c-1; j<=c+1; ++j)
        if (0<=i && i<=dim-1 && 0<=j && j<=dim-1 &&
          !(i==f && j==c) && bosque[i][j]==2)
          burning=true;
    return burning;
  }

  public static void paint() {
    for (int i=0; i<dim; ++i) {
      for (int j=0; j<dim; ++j) {
        if (bosque[i][j]==0) {
          System.out.print(" "+ new String(Character.toChars(0x2591)));
        } else {
          if (bosque[i][j]==1) {
            System.out.print(" "+ new String(Character.toChars(0x2592)));
          } else {
            System.out.print(" "+ new String(Character.toChars(0x2593)));
          }
        }
      } System.out.println();
    } System.out.println();
  }

  public static void main (String[] args) throws Exception {
    n = Integer.parseInt(args[0]);
    m = Integer.parseInt(args[1]);
    g = Integer.parseInt(args[2]);
    pintar = Integer.parseInt(args[3]);

    if (n<m && m<dim*dim) {
      long inicCronom, finCronom, tiempoSecuencial, tiempoParalelo1=1, tiempoParalelo2=1;

      // Calculo tiempo secuencial
      setUp();
      System.out.println("Comienza el trabajo en secuencial...");
      inicCronom = System.currentTimeMillis();

      if (pintar!=0) paint();
      Thread t = new Thread(new acIncendioForestal(dim,0,0));
      t.start();
      t.join();

      finCronom = System.currentTimeMillis();
      System.out.println("Finaliza el trabajo en secuencial...");
      tiempoSecuencial = finCronom - inicCronom;

      // Calculo tiempo paralelo con nThreads=cores y nThreads=cores/2
      usedCores = cores;
      for (int x=0; x<2; ++x) {
        int window, lower, upper;
        setUp();
        System.out.println("Comienza el trabajo en paralelo con "+usedCores+" hilos...");
        inicCronom = System.currentTimeMillis();

        if (pintar!=0) paint();
        ThreadPoolExecutor ex = new ThreadPoolExecutor(usedCores, usedCores, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        window=dim/usedCores; lower=0; upper=window;

        for (int c=0; c<usedCores; ++c) {
          ex.execute(new acIncendioForestal(upper,lower,c));
          lower=upper;
          upper+=window;
          if ((c==usedCores-2)&&(window*usedCores!=dim))
            upper+=(dim-window*usedCores);
        }

        ex.shutdown();
        while(!ex.isTerminated()){}

        finCronom = System.currentTimeMillis();
        System.out.println("Finaliza el trabajo en paralelo con "+usedCores+" hilos...");

        if (x==0) {
          tiempoParalelo1 = finCronom - inicCronom;
        } else {
          tiempoParalelo2 = finCronom - inicCronom;
        }

        usedCores = cores/2;
      }

      System.out.println();

      System.out.println("tiempoSecuencial ->       "+tiempoSecuencial);
      System.out.println("tiempoParalelo hilos="+cores+" -> "+tiempoParalelo1);
      System.out.println("tiempoParalelo hilos="+cores/2+" -> "+tiempoParalelo2);

      System.out.println();

      System.out.println("Para una reticula de "+dim*dim+" celdas, "+g+" generaciones y con un estado inicial de "+m+" arboles y "+n+" focos distribuido de forma aleatoria:");
      System.out.println("Con hilos="+cores+" -> SpeedUp="+(double)tiempoSecuencial/tiempoParalelo1);
      System.out.println("Con hilos="+cores/2+" -> SpeedUp="+(double)tiempoSecuencial/tiempoParalelo2);

    } else {
      System.out.println("Los valores introducidos no son correcto. Recuerde que debe ser n<m<"+dim*dim);
    }
  }
}
