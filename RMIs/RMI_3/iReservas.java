import java.rmi.*;

public interface iReservas extends Remote {
  public int available() throws RemoteException;
  public int takeCar(Data datos) throws RemoteException;
  public void nullReserve (int codigo) throws RemoteException;

}
