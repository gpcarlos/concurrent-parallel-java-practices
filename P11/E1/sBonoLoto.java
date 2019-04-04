/**
* P11 - E1
* Clase sBonoLoto que simula un servidor y que contiene los métodos resetServidor y compApuesta, a parte de un contructor y un método principal
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

import java.util.Random;
import java.util.Arrays;

public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto{
	public static int[] ganador = new int[6];
 	static Random random = new Random();

 	/**
	* Método resetServidor de la clase sBonoLoto
	* @throws RemoteException
	* @return Arrays.toString(ganador) Cadena que muestra la combinación ganadora
	*/
 	public String resetServidor() throws RemoteException {
 		for(int i=0;i<6;i++){
 			ganador[i]=random.nextInt(48)+1;
 		}
 		return Arrays.toString(ganador);
 	}

 	/**
	* Método compApuesta de la clase sBonoLoto
	* @throws RemoteException
	* @return Arrays.equals(apuesta,ganador) Devuelve true o false dependiendo de si los dos arrays son iguales
	*/
 	public boolean compApuesta(int[] apuesta) throws RemoteException{
 		return Arrays.equals(apuesta,ganador); //devuelve true o false
 	}

 	/**
	* Constructor de la clase sBonoLoto
	* @throws RemoteException
	*/
 	public sBonoLoto() throws RemoteException
 	{super();}

 	/**
	* Método principal de la clase sBonoLoto que realiza el registro del servicio
	* @throws Exception
	*/
 	public static void main(String[] args) throws Exception{
 		//Se crea el objeto remoto. Podriamos crear mas si interesa.
 		iBonoLoto ORemoto = new sBonoLoto();

 		//Se registra el servicio
 		Naming.bind("Servidor", ORemoto);

 		System.out.println("Servidor Remoto Preparado");
 	}


 }
