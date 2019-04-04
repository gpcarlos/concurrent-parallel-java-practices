/**
* P11 - E1
* Interfaz iBonoLoto, que contiene las especificaciones de los métodos resetServidor y compApuesta
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/
import java.rmi.*;

public interface iBonoLoto extends Remote{
	/**
	* Especficación del método resetServidor de la interfaz iBonoLoto
	* @throws RemoteException
	*/
	public String resetServidor() throws RemoteException;

	/**
	* Especficación del método compApuesta de la interfaz iBonoLoto
	* @throws RemoteException
	*/
	public boolean compApuesta(int[] apuesta)  throws RemoteException;
}