import java.rmi.*;
import java.rmi.registry.*;

import java.util.Scanner;

public class cVector {
  public static void main(String[] args) throws Exception {

    float[] v1 = new float[3];
    float[] v2 = new float[3];
    float escalar;

    // iVector obj = (iVector)Naming.lookup("//localhost:2010/Vector");
    iVector obj = (iVector)Naming.lookup("Vector");

    Scanner sc = new Scanner(System.in);
    for (int i=0; i<v1.length; ++i) {
      System.out.print("Vector1 Posicion "+i+": ");
      v1[i] = sc.nextFloat();
    }
    for (int i=0; i<v2.length; ++i) {
      System.out.print("Vector2 Posicion "+i+": ");
      v1[i] = sc.nextFloat();
    }
    System.out.print("Escalar: ");
    escalar = sc.nextFloat();

    System.out.println("Rellena los vectores");

    while (true) {
      System.out.println("Elige una opcion:");
      System.out.println("1) Producto escalar");
      System.out.println("2) Producto por escalar");
      System.out.println("3) Suma de vectores");
      System.out.println("4) Modulo de vectores");
      int op = sc.nextInt();

      float[] resV = new float[v1.length];
      float res;

      switch (op) {
        case 1:
          res = obj.prodEscalar(v1,v2);
          System.out.print("Producto Escalar: "+res);
        break;
        case 2:
          resV = obj.prodporescalar(v1,escalar);
          System.out.print("Prod por Escalar: ");
          for (int i=0; i<resV.length; ++i) {
            System.out.print(" "+resV[i]);
          } System.out.println();
        break;
        case 3:
          resV = obj.vecSuma(v1,v2);
          System.out.print("Suma: ");
          for (int i=0; i<resV.length; ++i) {
            System.out.print(" "+resV[i]);
          } System.out.println();
        break;
        case 4:
          res = obj.vectModulo(v1);
          System.out.println("Modulo: "+res);
        break;
        default:
        break;
      }

    }
  }
}
