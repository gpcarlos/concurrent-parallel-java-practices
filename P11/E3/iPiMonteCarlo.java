/**
* P11 - E3
* Interfaz iPiMonteCarlo que contiene las especificaciones de los métodos reset, masPuntos y aproximacion
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/
import java.rmi.*;

public interface iPiMonteCarlo
  extends Remote
{
  /**
  * Método reset de la interfaz iPiMonteCarlo
  * @throws RemoteException
  */
  public void reset() throws RemoteException;

  /**
  * Método masPuntos de la interfaz iPiMonteCarlo
  * @throws RemoteException
  * @param nPuntos variable de tipo entero que repesenta el numero de puntos que va a intentar
  */
  public void masPuntos(int nPuntos)  throws RemoteException;

  /**
  * Método masPuntos de la interfaz iPiMonteCarlo
  * @throws RemoteException
  */
  public double aproximacion()  throws RemoteException;

}