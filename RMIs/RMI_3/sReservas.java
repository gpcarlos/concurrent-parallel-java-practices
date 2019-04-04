import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class sReservas extends UnicastRemoteObject implements iReservas {
  static int maximoVehiculos = 10;
  static int vehiculosDisponibles = maximoVehiculos;
  static Data[] reservas_ = new Data[maximoVehiculos];
  static Object o = new Object();

  public sReservas() throws RemoteException {
    super();
  }

  public int available() throws RemoteException {
    return vehiculosDisponibles;
  }

  public int takeCar(Data d) throws RemoteException {
    synchronized (o) {
      int codigo = 0;
      if (vehiculosDisponibles==0) {
        codigo = -1;
      } else {
        boolean terminado = false;
        for (int i=0; i<maximoVehiculos && !terminado; ++i) {
          if (reservas_[i]==null) {
            reservas_[i] = d;
            vehiculosDisponibles--;
            codigo = i;
            terminado = true;
            System.out.println("Se ha realizado una reserva con codigo "+i);
          }
        }
      }
      return codigo;
    }
  }

  public void nullReserve (int codigo) throws RemoteException {
    synchronized (o) {
      if (reservas_[codigo]!=null) {
        vehiculosDisponibles++;
        reservas_[codigo]=null;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    iReservas obj = new sReservas();
    // Naming.rebind("//localhost:1050/Reserva", obj);
    Naming.rebind("Reserva", obj);

    System.out.println("Servidor listo");
  }
}
