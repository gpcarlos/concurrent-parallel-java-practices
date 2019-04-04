import java.rmi.*;
import java.rmi.registry.*;

import java.util.Scanner;

public class clientIntRemote {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    // mcIntRemote obj = (mcIntRemote)Naming.lookup("//localhost:2222/IntRemote");
    mcIntRemote obj = (mcIntRemote)Naming.lookup("IntRemote");

    while (true) {
      System.out.println("Elige:");
      System.out.println("1) Anadir puntos");
      System.out.println("2) Obtener valor de la integral");
      System.out.println(": ");
      int op = sc.nextInt();

      switch (op) {
        case 1:
          System.out.print("Escribe los puntos: ");
          int x = sc.nextInt();
          obj.addPoints(x);
        break;
        case 2:
          double aprox = obj.iValue();
          System.out.println("Aproximacion actual: "+aprox);
        break;
        default:
        break;
      }
    }
  }
}
