/**
* P8 - E1
* Clase que modela la entidad Conductores, dotada de los métodos Insertar, Eliminar, Consultar y CambiarPuntos
* @author Carlos Gallardo Polanco
* @version 11/12/17
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Conductores{
 	Scanner sc = new Scanner (System.in);
	private ArrayList<Conductor> lista = new ArrayList<Conductor>();

	/**
	* Método que inserta un nuevo conductor
	*/
	public synchronized void Insertar(){
		System.out.print("Introduzca el nombre del nuevo conductor: ");
	    String nombre = sc.nextLine();
	    System.out.print("Introduzca el DNI del nuevo conductor: ");
	    String dni = sc.nextLine();
	    System.out.print("Introduzca la direccion del nuevo conductor: ");
	    String direccion = sc.nextLine();
	    System.out.print("Introduzca el telefono del nuevo conductor: ");
	    String telefono = sc.nextLine();
	    System.out.print("Introduzca el tipo de permiso del nuevo conductor: ");
	    String tipodepermiso = sc.nextLine();
	    System.out.print("Introduzca los puntos del nuevo conductor: ");
	    String puntos = sc.nextLine();
	   	lista.add(new Conductor(nombre,puntos,dni,direccion,telefono,tipodepermiso));
	   	System.out.println();
	}

	/**
	* Método que elimina un conductor
	*/
	public synchronized void Eliminar(){
		Iterator<Conductor> itr = lista.iterator();
		//Suponemos que no vamos a tener dos conductores con el mismo DNI.
		System.out.print("Introduzca el DNI del conductor que quiere eliminar: ");
		String dni =sc.nextLine();
		boolean comprobador=false;

		while(itr.hasNext()){
			Conductor conductor = itr.next();
			if(dni.equals(conductor.Get_dni())){
				System.out.println("Estos son los datos del conductor que se acaba de eliminar:");
				System.out.println("DNI: "+conductor.Get_dni());
				System.out.println("Nombre: "+conductor.Get_nombre());
				System.out.println("Direccion: "+conductor.Get_direccion());
				System.out.println("Telefono: "+conductor.Get_telefono());
				System.out.println("Tipo de Permiso: "+conductor.Get_tipodepermiso());
				System.out.println("Puntos: "+conductor.Get_puntos());
				conductor.Set_nombre(null);
				conductor.Set_puntos(null);
				conductor.Set_direccion(null);
				conductor.Set_telefono(null);
				conductor.Set_dni(null);
				conductor.Set_tipodepermiso(null);
				comprobador=true;
			}
		}
		if(!comprobador){
			System.out.println("No existe ningun conductor con DNI "+dni);
		}
	}

	/**
	* Método que permite consultar un conductor
	*/
	public synchronized void Consultar(){
		Iterator<Conductor> itr = lista.iterator();
		//Suponemos que no vamos a tener dos conductores con el mismo DNI.
		System.out.print("Introduzca el DNI del conductor que quiere cosultar: ");
		String dni =sc.nextLine();
		boolean comprobador=false;

		while(itr.hasNext()){
			Conductor conductor = itr.next();
			if(dni.equals(conductor.Get_dni())){
				System.out.println("Los datos del conductor de DNI "+conductor.Get_dni()+" son:");
				System.out.println("DNI: "+conductor.Get_dni());
				System.out.println("Nombre: "+conductor.Get_nombre());
				System.out.println("Direccion: "+conductor.Get_direccion());
				System.out.println("Telefono: "+conductor.Get_telefono());
				System.out.println("Tipo de Permiso: "+conductor.Get_tipodepermiso());
				System.out.println("Puntos: "+conductor.Get_puntos());
				comprobador=true;
			}
		}

		if(!comprobador){
			System.out.println("No existe ningun conductor con DNI "+dni);
		}
	}

	/**
	* Método que permite cambiar los puntos de un conductor
	*/
	public synchronized void CambiarPuntos(){
		Iterator<Conductor> itr = lista.iterator();
		//Suponemos que no vamos a tener dos conductores con el mismo DNI.
		System.out.print("Introduzca el DNI del conductor al que le quiere cambiar los puntos: ");
		String dni =sc.nextLine();
		boolean comprobador=false;

		while(itr.hasNext()){
			Conductor conductor = itr.next();
			if(dni.equals(conductor.Get_dni())){
				System.out.println("Los puntos actuales del conductor con DNI "+conductor.Get_dni()+" son: "+conductor.Get_puntos());
				System.out.print("Introduzca los nuevos puntos del conductor: ");
				String puntos =sc.nextLine();
				conductor.Set_puntos(puntos);
				System.out.println("Ahora los puntos del conductor con DNI "+conductor.Get_dni()+" son: "+conductor.Get_puntos());
				comprobador=true;
			}
		}

		if(!comprobador){
			System.out.println("No existe ningun conductor con DNI "+dni);
		}
	}



}
