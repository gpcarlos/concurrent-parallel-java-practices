import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

import java.util.Random;
import java.util.concurrent.locks.*;

public class serverIntRemote extends UnicastRemoteObject implements mcIntRemote {

  static ReentrantLock l = new ReentrantLock();
  static int dentro=0, total=0;

  public serverIntRemote() throws RemoteException {
    super();
  }

  public void addPoints(int npoints) throws RemoteException {
    Random rd = new Random();
    l.lock();
    try {
      total+=npoints;
    } finally { l.unlock();}
    for (int i=0; i<npoints; ++i) {
      double x = rd.nextDouble();
      double y = rd.nextDouble();
      double valorAproximado = -(Math.pow(x,3)-Math.cos(x));
      if (y<valorAproximado) {
        l.lock();
        try {
          dentro++;
        } finally { l.unlock();}
      }
    }
  }

  public double iValue() throws RemoteException {
    double value = 0;
    l.lock();
    try {
      System.out.println("Hay dentro "+dentro);
      System.out.println("Y total "+total);
      if (total!=0) value = (double)dentro/total;
    } finally { l.unlock();}
    return value;
  }

  public static void main(String[] args) throws Exception {

    mcIntRemote obj = new serverIntRemote();
    // Naming.rebind("//localhost:2222/IntRemote", obj);
    Naming.rebind("IntRemote", obj);

    System.out.println("Servidor listo");
  }
}
