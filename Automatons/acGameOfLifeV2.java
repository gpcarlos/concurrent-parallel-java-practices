// Para su ejecución:
// javac acGameOfLifeV2.java && java acGameOfLifeV2 <dimensión> <generaciones> <pintar?>
// Si <pintar?>==0, no se pinta. Si <pintar?>!=0, se pinta.
// Ejemplo: javac acGameOfLifeV2.java && java acGameOfLifeV2 20 100 0

import java.util.Random;
import java.util.concurrent.*;

public class acGameOfLifeV2 extends Thread {
  static int cores = Runtime.getRuntime().availableProcessors();
  static CyclicBarrier br = new CyclicBarrier(cores);

  static boolean paralelo = false;
  static int dim, g, pintar;
  static int[][] cells, sucessor;
  int ulimit, llimit, thread;

  public acGameOfLifeV2(int ulimit, int llimit, int thread) {
    this.ulimit = ulimit;
    this.llimit = llimit;
    this.thread = thread;
  }

  public acGameOfLifeV2() {}

  public void run() {
    for (int i=0; i<g; ++i) {
      computation();
    }
  }

  public static void setUp(int d) {
    dim = d;
    cells = new int[dim][dim];
    sucessor = new int[dim][dim];
    firstGen();
  }

  public static void firstGen() {
    Random rd = new Random();
    for (int i=0; i<dim; ++i) {
      for (int j=0; j<dim; ++j) {
        cells[i][j] = rd.nextInt(2);
      }
    }
    if (pintar!=0) paint();
  }

  public void nextGen() {
    for (int i=llimit; i<ulimit; ++i) {
      for (int j=0; j<dim; ++j) {
        int c = cells[i][j];
        int livingNeighbours = neighbours(i,j);
        if (c==1) {
          if (livingNeighbours<2 || 3<livingNeighbours) {
            sucessor[i][j] = 0;
          } else {
            sucessor[i][j] = 1;
          }
        } else {
          if (livingNeighbours==3) {
            sucessor[i][j] = 1;
          }
        }
      }
    }
  }

  public void computation() {
    nextGen();
    if (paralelo) {
      try {
        br.await();
      } catch(Exception e){}
    }
    if (thread==0) {
      for(int i=0; i<dim; ++i){
        for(int j=0; j<dim; ++j){
          cells[i][j]=sucessor[i][j];
        }
      }
      if (pintar!=0) paint();
    }
  }

  public int neighbours(int f, int c) {
    int count = 0;
    for(int i=f-1; i<=f+1; ++i)
      for(int j=c-1; j<=c+1; ++j)
        if (0<=i && i<=dim-1 && 0<=j && j<=dim-1 &&
          !(i==f && j==c) && cells[i][j]==1)
          count++;
    return count;
  }

  public static void paint() {
    for(int i=0; i<dim; ++i){
      for(int j=0; j<dim; ++j){
        if (cells[i][j]==1) {
          System.out.print(" "+ new String(Character.toChars(0x2593)));
        } else {
          System.out.print(" "+ new String(Character.toChars(0x2591)));
        }
      } System.out.println();
    } System.out.println();
  }

  public static void main(String[] args) throws Exception{
    int d = Integer.parseInt(args[0]);
    g = Integer.parseInt(args[1]);
    pintar = Integer.parseInt(args[2]);
    setUp(d);

    long inicCronom, finCronom, tiempoSecuencial, tiempoParalelo;

    System.out.println("Comienza el trabajo en secuencial...");
    inicCronom = System.currentTimeMillis();

    acGameOfLifeV2 t = new acGameOfLifeV2(dim,0,0);
    t.start();
    t.join();
    finCronom = System.currentTimeMillis();

    System.out.println("Finaliza el trabajo en secuencial...");
    tiempoSecuencial = finCronom - inicCronom;

    paralelo = true; setUp(d);
    //ExecutorService ex = Executors.newFixedThreadPool(cores);
    ExecutorService ex = Executors.newCachedThreadPool();
    int window = dim/cores, lower=0, upper=window;

    System.out.println("Comienza el trabajo en paralelo con "+cores+" hilos...");
    inicCronom = System.currentTimeMillis();

    for (int j=0; j<cores; ++j) {
      ex.execute(new acGameOfLifeV2(upper,lower,j));
      lower = upper;
      upper += window;
      if((j==cores-2)&&(window*cores!=dim)){ upper+=(dim-window*cores);}
    }
    ex.shutdown();
    while(!ex.isTerminated()){}

    finCronom = System.currentTimeMillis();
    System.out.println("Finaliza el trabajo en paralelo con "+cores+" hilos...");
    tiempoParalelo = finCronom - inicCronom;

    System.out.println("Tiempo Secuencial -> "+tiempoSecuencial);
    System.out.println("Tiempo Paralelo   -> "+tiempoParalelo);
    System.out.println("SpeedUp -> "+(double)tiempoSecuencial/tiempoParalelo);
  }

}
