import java.rmi.*;

public interface iHelion extends Remote {
  public boolean shoot(int x, int y) throws RemoteException;
}
