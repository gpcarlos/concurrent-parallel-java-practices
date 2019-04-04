/**
* P11 - E2
* Interfaz iLibros, que contiene las especificaciones de los métodos insertar, extraer y consultarDatos
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/

import java.rmi.*;

public interface iLibros extends Remote{
	/**
	* Especficación del método insertar de la interfaz iBonoLoto
	* @throws RemoteException
	* @param Titulo Parámetro que contiene el Titulo del Libro
	* @param Autor Parámetro que contiene los Autor del Libro
	* @param Fecha Parámetro que contiene el Fecha del Libro
	* @param Genero Parámetro que contiene el Genero del Libro
	* @param ISBN Parámetro que contiene el ISBN del Libro
	*/
	public void insertar(String Titulo,String Autor,String Fecha,String Genero,String ISBN) throws RemoteException;

	/**
	* Especficación del método extraer de la interfaz iBonoLoto
	* @throws RemoteException
	* @param ISBN Parámetro que contiene el ISBN del Libro
	*/
	public String extraer(String ISBN)  throws RemoteException;

	/**
	* Especficación del método consultarDatos de la interfaz iBonoLoto
	* @throws RemoteException
	* @param ISBN Parámetro que contiene el ISBN del Libro
	*/
	public String consultarDatos(String ISBN)  throws RemoteException;
}