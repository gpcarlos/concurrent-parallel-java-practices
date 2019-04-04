/**
* P2 - E2
* Clase Biblioteca
* @author Carlos Gallardo Polanco
* @version 1.0 23/10/2017
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Paciente> biblio = new ArrayList<Paciente>();

	/**
	* Método insertar que permite insertar un objeto Paciente al ArrayList
	*/
	public static void insertar (){
		System.out.print("Introduce el nombre: "); String nombre = sc.nextLine();
		System.out.print("Introduce el dni: "); String dni = sc.nextLine();
		System.out.print("Introduce el direccion: "); String direccion = sc.nextLine();
		System.out.print("Introduce el telefono: "); String telefono = sc.nextLine();
		System.out.print("Introduce el seguro: "); String seguro = sc.nextLine();
		biblio.add(new Paciente(nombre,dni,direccion,telefono,seguro));
	}

	/**
	* Método borrar que permite borrar un objeto Paciente del ArrayList
	* @param pac Index del paciente a borrar en el ArrayList
	*/
	public static void borrar (int pac){
		biblio.remove(pac);
		System.out.println("Paciente borrado");
	}

	/**
	* Método borrar que permite borrar un objeto Paciente del ArrayList
	* @param pac Index del paciente a borrar en el ArrayList
	*/
	public static void consultar(int pac){
		Paciente paciente = biblio.get(pac);
		System.out.println("Paciente: ");
		System.out.println("Nombre: "+paciente.get_nombre());
		System.out.println("DNI: "+paciente.get_dni());
		System.out.println("Direccion: "+paciente.get_direccion());
		System.out.println("Telefono: "+paciente.get_telefono());
		System.out.println("Seguro: "+paciente.get_seguro());
	}

	public static void main (String[] args){
		while(true){
			int o1=0, o2=0, pac=-1;
			String dato;
			do{
				System.out.println("Que desea hacer?");
				System.out.println("1) Insertar paciente");
				System.out.println("2) Borrar paciente");
				System.out.println("3) Consultar paciente");
				System.out.print(":");
				o1 = sc.nextInt();
				sc.nextLine();
			}while(o1<=0||o1>=4);
			if(o1==2||o1==3){
				do{
					System.out.println("Como desea encontrar al paciente");
					System.out.println("1) Por nombre");
					System.out.println("2) Por DNI");
					System.out.println("3) Por direccion");
					System.out.println("4) Por telefono");
					System.out.println("5) Por seguro");
					System.out.print(":");
					o2 = sc.nextInt();
					sc.nextLine();
				}while(o2<=0||o2>=6);
				System.out.print("Introduzcalo:");
				dato = sc.nextLine();
				Iterator<Paciente> itr = biblio.iterator();
				while(itr.hasNext()){
					Paciente n = itr.next();
					switch(o2){
						case 1: if(dato.equals(n.get_nombre())){pac=biblio.indexOf(n);}
						break;
						case 2:	if(dato.equals(n.get_dni())){pac=biblio.indexOf(n);}
						break;
						case 3: if(dato.equals(n.get_direccion())){pac=biblio.indexOf(n);}
						break;
						case 4: if(dato.equals(n.get_telefono())){pac=biblio.indexOf(n);}
						break;
						case 5: if(dato.equals(n.get_seguro())){pac=biblio.indexOf(n);}
						break;
						default: break;
					}
				}
			}
			switch(o1){
				case 1: insertar();
				break;
				case 2:
					if(pac==-1){System.out.println("No se ha encontrado a ningun paciente con ese dato");}
					else{borrar(pac);}
				break;
				case 3:
					if(pac==-1){System.out.println("No se ha encontrado a ningun paciente con ese dato");}
					else{consultar(pac);}
				break;
				default: break;
			}
		}
	}
}
