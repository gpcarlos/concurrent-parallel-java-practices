/**
* P11 - E2
* Clase sLibros que simula un servidor y que contiene los métodos insertar, extraer y consultarDatos, a parte de un contructor y un método principal
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

import java.util.*;
import java.util.Scanner;
 
public class sLibros extends UnicastRemoteObject implements iLibros{
	public static ArrayList<Libros> biblioteca = new ArrayList<Libros>();

 	/**
	* Método insertar de la clase sLibros
	* @throws RemoteException
	* @param Titulo Parámetro que contiene el Titulo del Libro
	* @param Autor Parámetro que contiene los Autor del Libro
	* @param Fecha Parámetro que contiene el Fecha del Libro
	* @param Genero Parámetro que contiene el Genero del Libro
	* @param ISBN Parámetro que contiene el ISBN del Libro
	*/
 	public void insertar(String Titulo,String Autor,String Fecha,String Genero,String ISBN) throws RemoteException {
 		Libros Libro = new Libros(Titulo,Autor,Fecha,Genero,ISBN);
 		biblioteca.add(Libro);
 	}  
 	
 	/**
	* Método extraer de la clase sLibros
	* @throws RemoteException
	* @param ISBN Variable del tipo String que representa el ISBN del libro
	* @return "Se ha extraido."
	* @return "No se ha encontrado."
	*/
 	public String extraer(String ISBN) throws RemoteException {
 		Libros auxiliar = new Libros();
 		Boolean existe=false;
 		for(Libros iter : biblioteca){
 			if(iter.Get_ISBN().equals(ISBN)){
 				auxiliar=iter;
 				existe=true;
 			}
 		}
 		if(existe){
 			biblioteca.remove(auxiliar);
 			return "Se ha extraido.";
 		}else{
 			return "No se ha encontrado.";
 		}
 	}

 	/**
	* Método consultarDatos de la clase sLibros
	* @throws RemoteException
	* @param ISBN Variable del tipo String que representa el ISBN del libro
	* @return "[Titulo: "+auxiliar.Get_Titulo()+"] [Autor: "+auxiliar.Get_Autor()+"] [Fecha: "+auxiliar.Get_Fecha()+"] [Genero: "+auxiliar.Get_Genero()+"]"; Cadena que indica todos los datos del libro
	* @return "No se ha encontrado.";
	*/
 	public String consultarDatos(String ISBN) throws RemoteException {
 		Libros auxiliar = new Libros();
 		Boolean existe=false;
 		for(Libros iter : biblioteca){
 			if(iter.Get_ISBN().equals(ISBN)){
 				auxiliar=iter;
 				existe=true;
 			}
 		}
 		if(existe){
 			return "[Titulo: "+auxiliar.Get_Titulo()+"] [Autor: "+auxiliar.Get_Autor()+"] [Fecha: "+auxiliar.Get_Fecha()+"] [Genero: "+auxiliar.Get_Genero()+"]";
 		}else{
 			return "No se ha encontrado.";
 		}
 	}  
 	
 	/**
	* Constructor de la clase sLibros
	* @throws RemoteException
	*/
 	public sLibros() throws RemoteException
 	{super();}  
 	
 	/**
	* Método principal de la clase sLibros que realiza el registro del servicio
	* @throws Exception
	*/
 	public static void main(String[] args) throws Exception{ 	    
 		//Se crea el objeto remoto. Podriamos crear mas si interesa.
 		iLibros ORemoto = new sLibros();
 		
 		//Se registra el servicio
 		Naming.bind("Servidor", ORemoto);
 		  
 		System.out.println("Servidor Remoto Preparado");
 	}	  
 	
 	
 }	                              
                               