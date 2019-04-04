import java.rmi.*;

public interface mcIntRemote extends Remote {
  public void addPoints(int npoints) throws RemoteException;
  public double iValue() throws RemoteException;
}
