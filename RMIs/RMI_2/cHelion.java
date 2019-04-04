import java.rmi.*;
import java.rmi.registry.*;

import java.util.Random;

public class cHelion {

  static int dimX = 200; //200
  static int dimY = 100; //100

  public static void main(String[] args) throws Exception {
    Random rd = new Random();

    iHelion obj = (iHelion)Naming.lookup("Helion");
    // iHelion obj = (iHelion)Naming.lookup("//localhost:2020/Helion");

    boolean end = false;
    while (!end) {
      int i = rd.nextInt(dimX);
      int j = rd.nextInt(dimY);

      end = obj.shoot(i,j);
    }

  }
}
