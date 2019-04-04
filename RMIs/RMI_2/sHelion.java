import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

import java.util.Random;

public class sHelion extends UnicastRemoteObject implements iHelion {
  static int dimX = 200; //200
  static int dimY = 100; //100
  static int world[][] = new int [dimX][dimY];
  static int numCities = 2500; //2500
  static int limitAmsesty = 2400; //2400
  static int destruidas = 0;


  public sHelion() throws RemoteException{
    super();
  }

  public synchronized boolean shoot(int x, int y) throws RemoteException{;
    boolean end = true;

    if (world[x][y]==1) {
      destruidas++; world[x][y]=0;
      System.out.println("Ciudad destruida!");
      // paint();
    } else {
      if (world[x][y]==2) {
        destruidas=numCities;
        System.out.println("WOOOOOOO Agujero negro destruido!");
      } else System.out.println("Disparo fallido!");
    }

    if (destruidas==limitAmsesty)
      System.out.println("Petición de amnistia!!!");
    else
      if (destruidas==numCities)
        System.out.println("Planeta destruido!!!");
      else
        end = false;

    return end;

  }

  public static void paint() {
    for (int i=0; i<dimX; ++i) {
      for (int j=0; j<dimY; ++j) {
        System.out.print(" "+world[i][j]);
      } System.out.println();
    } System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Random rd = new Random();

    int countNumCities = numCities;
    while (countNumCities!=0) {
      int i = rd.nextInt(dimX),
          j = rd.nextInt(dimY);

      if (world[i][j]!=1) {
        world[i][j]=1;
        countNumCities--;
      }
    }

    boolean darkHole = false;
    while (!darkHole) {
      int i = rd.nextInt(dimX),
          j = rd.nextInt(dimY);

      if (world[i][j]!=1) {
        world[i][j]=2;
        darkHole=true;
      }
    }

    // paint();

    iHelion obj = new sHelion();
    // Naming.rebind("//localhost:2020/Helion", obj);
    // No está conectandose al puerto 2020, como debería según el enunciado
    Naming.rebind("Helion", obj);

    System.out.println("Servidor listo");
  }



}
