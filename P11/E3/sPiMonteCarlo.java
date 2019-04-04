/**
* P11 - E3
* Clase sPiMonteCarlo que simula un servidor y que contiene los métodos reset, masPuntos y aproximacion, a parte de un contructor y un método principal
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
 
public class sPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo{
  static int intentos = 0;
  static int puntos = 0;

  /**
  * Método reset de la clase sPiMonteCarlo
  * @throws RemoteException
  */
  public void reset() throws RemoteException {
    intentos = 0;
    puntos = 0;
  }  
  
  /**
  * Método masPuntos de la clase sPiMonteCarlo
  * @throws RemoteException
  * @param nPuntos variable de tipo entero que repesenta el numero de puntos que va a intentar
  */
  public void masPuntos(int nPuntos) throws RemoteException {
    intentos+=nPuntos;
    for(int i=0; i<nPuntos; i++){
      double cx = Math.random();
      double cy = Math.random();
      if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)puntos++;
    }
  }

  /**
  * Método masPuntos de la clase sPiMonteCarlo
  * @throws RemoteException
  * @return aproximacionPI Parámetro que contiene la aproximación actual a PI
  */
  public double aproximacion() throws RemoteException {
    double aproximacionPI=(4.0*puntos/intentos);
    return aproximacionPI;
  }

  /**
  * Constructor de la clase sPiMonteCarlo
  * @throws RemoteException
  */
  public sPiMonteCarlo() throws RemoteException
  {super();}  
  
  /**
  * Método principal de la clase sPiMonteCarlo que realiza el registro del servicio
  * @throws Exception
  */
  public static void main(String[] args) throws Exception{
    //Se crea el objeto remoto. Podriamos crear mas si interesa.
    iPiMonteCarlo ORemoto = new sPiMonteCarlo();
    
    //Se registra el servicio
    Naming.bind("Servidor", ORemoto);
      
    System.out.println("Servidor Remoto Preparado");
  }   
  
  
 }                                

