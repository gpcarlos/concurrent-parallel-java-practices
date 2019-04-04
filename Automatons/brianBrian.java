
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class brianBrian implements Runnable {
  static Scanner sc = new Scanner(System.in);

  static int cores = Runtime.getRuntime().availableProcessors();
  static CyclicBarrier br = new CyclicBarrier(cores);
  static CyclicBarrier doublebr = new CyclicBarrier(cores*2);
  static int usedCores=1, dim=800;
  static double g=Math.pow(2,10); // Debería ser Math.pow(10,10) pero es interminable....
  static int[][] cells, sucessor;
  int type, ulimit, llimit, thread;

  public brianBrian(int ulimit, int llimit, int thread, int type) {
    this.ulimit = ulimit;
    this.llimit = llimit;
    this.thread = thread;
    this.type = type;
  }

  public void run() {
    switch (type) {
      case 1: // Opción 1
        automaticSetUp();
        computation();
      break;
      case 2: // Opción 2
        computation();
      break;
      default:
      break;
    }
  }

  public void automaticSetUp() {
    Random rd = new Random();
    for (int i=llimit; i<ulimit; ++i) {
      for (int j=0; j<dim; ++j) {
        cells[i][j] = rd.nextInt(3);
      }
    }
    if (usedCores==cores) {
      try { br.await();} catch(Exception e){}
    } else {
      if (usedCores==cores*2)
        try { doublebr.await();} catch(Exception e){}
    }
    // if (thread==0) paint();
  }

  public static void manualSetup() {
    System.out.println("Introduccion manual de las "+dim*dim+" celulas. Introduzca solo 0, 1 o 2.");
    for (int i=0; i<dim; ++i) {
      for (int j=0; j<dim; ++j) {
        System.out.print("Posicion "+i+","+j+": ");
        cells[i][j] = sc.nextInt();
      }
    }
  }

  public void computation() {
    for (double gen=0; gen<g; ++gen) {
      nextGen();
      if (usedCores==cores) {
        try { br.await();} catch(Exception e){}
      } else {
        if (usedCores==cores*2)
          try { doublebr.await();} catch(Exception e){}
      }

      for (int i=llimit; i<ulimit; ++i) {
        for (int j=0; j<dim; ++j) {
          cells[i][j] = sucessor[i][j];
        }
      }

      if (usedCores==cores) {
        try { br.await();} catch(Exception e){}
      } else {
        if (usedCores==cores*2)
          try { doublebr.await();} catch(Exception e){}
      }
      // if (thread==0) paint();
    }
  }

  public void nextGen() {
    for (int i=llimit; i<ulimit; ++i) {
      for (int j=0; j<dim; ++j) {
        if (cells[i][j]==0 && neighbours(i,j)==2) {
          sucessor[i][j]=1;
        } else {
          if (cells[i][j]==1) {
            sucessor[i][j]=2;
          } else {
            if (cells[i][j]==2) {
              sucessor[i][j]=0;
            } else {
              sucessor[i][j]=cells[i][j];
            }
          }
        }
      }
    }
  }

  public int neighbours(int f, int c) {
    int count=0;
    for(int i=f-1; i<=f+1; ++i)
      for(int j=c-1; j<=c+1; ++j)
        if (0<=i && i<=dim-1 && 0<=j && j<=dim-1 &&
          !(i==f && j==c) && cells[i][j]==2)
          count++;
    return count;
  }

  public static void paint() {
    for (int i=0; i<dim; ++i) {
      for (int j=0; j<dim; ++j) {
        if (cells[i][j]==0) {
          System.out.print(" 0"+ new String(Character.toChars(0x2591)));
        } else {
          if (cells[i][j]==1) {
            System.out.print(" 1"+ new String(Character.toChars(0x2592)));
          } else {
            System.out.print(" 2"+ new String(Character.toChars(0x2593)));
          }
        }
      } System.out.println();
    } System.out.println();
  }

  public static void main(String[] args) throws Exception {

    System.out.println("Elige una opcion:");
    System.out.println("1) Ejecucion automatica durante "+g+" pasos de tiempo. Muesta SpeedUp nThreads="+cores+" y nThreads="+cores*2);
    System.out.println("2) Definir tamanio, inicializar manualmente e indicar las generaciones. Imprime la primera y ultima generacion.");
    int option = sc.nextInt();
    switch (option) {
      case 1:
      System.out.println("AVISO. Esta opcion puede tardar mucho debido al numero de pasos de tiempo.");
// Begin Case 1
  cells = new int[dim][dim];
  sucessor = new int[dim][dim];


  long inicCronom, finCronom, tiempoSecuencial=1, tiempoParalelo1=1, tiempoParalelo2=1;

  // Secuencial
  System.out.println("Empieza el trabajo secuencial...");
  inicCronom = System.currentTimeMillis();
  Thread t = new Thread(new brianBrian(dim,0,0,1));
  t.start();
  t.join();
  finCronom = System.currentTimeMillis();
  tiempoSecuencial = finCronom - inicCronom;
  System.out.println("Termina el trabajo secuencial...");

  // Parallel
  ThreadPoolExecutor ex;
  usedCores = cores;

  for (int k=0; k<2; ++k) {
    ex = new ThreadPoolExecutor(usedCores, usedCores, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    int window=dim/usedCores, lower=0, upper=window;

    System.out.println("Empieza el trabajo paralelo con hilos="+usedCores+"..");
    inicCronom = System.currentTimeMillis();

    for (int i=0; i<usedCores; ++i) {
      ex.execute(new brianBrian(upper,lower,i,1));
      lower=upper;
      upper+=window;
      if ((i==usedCores-2)&&(window*usedCores!=dim))
        upper+=(dim-window*usedCores);
    }
    ex.shutdown();
    while(!ex.isTerminated()){}

    finCronom = System.currentTimeMillis();
    System.out.println("Termina el trabajo paralelo con hilos="+usedCores+"...");
    if (usedCores==cores) {
      tiempoParalelo1 = finCronom - inicCronom;
    } else  {
      if (usedCores==cores*2) {
        tiempoParalelo2 = finCronom - inicCronom;
      }
    }

    usedCores = cores*2;
  }

  System.out.println();
  System.out.println("Tiempo Secuencial       -> "+tiempoSecuencial);
  System.out.println("Tiempo Paralelo hilos="+cores+" -> "+tiempoParalelo1);
  System.out.println("Tiempo Paralelo hilos="+cores*2+" -> "+tiempoParalelo2);
  System.out.println();

  System.out.println("Para una reticula de "+dim*dim+" celdas en "+g+" pasos de tiempo:");
  System.out.println("Con hilos="+cores+" -> SpeedUp="+(double)tiempoSecuencial/tiempoParalelo1);
  System.out.println("Con hilos="+cores*2+" -> SpeedUp="+(double)tiempoSecuencial/tiempoParalelo2);

// End Case 1
      break;
      case 2:
// Begin Case 2
  System.out.print("Introduzca la dimension: ");
  dim = sc.nextInt();
  System.out.print("Introduzca el numero de generaciones: ");
  g = sc.nextInt();
  cells = new int[dim][dim];
  sucessor = new int[dim][dim];
  manualSetup();

  System.out.println("Primera generacion: ");
  paint();

  usedCores = cores;
  ex = new ThreadPoolExecutor(usedCores, usedCores, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
  int window=dim/usedCores, lower=0, upper=window;

  System.out.println("Empieza el trabajo paralelo con hilos="+usedCores+"...");

  for (int i=0; i<usedCores; ++i) {
    ex.execute(new brianBrian(upper,lower,i,2));
    lower=upper;
    upper+=window;
    if ((i==usedCores-2)&&(window*usedCores!=dim))
      upper+=(dim-window*usedCores);
  }
  ex.shutdown();
  while(!ex.isTerminated()){}

  System.out.println("Termina el trabajo paralelo con hilos="+usedCores+"...");

  System.out.println("Ultima generacion: ");
  paint();

// End Case 2
      break;
      default:
        System.out.println("Carapan, elige una de las opciones posibles");
      break;
    }


  }
}
