/**
* P2 - E1
* Clase Paciente que abstrae el concepto de paciente junto con sus correspondientes métodos observadores y modificadores, y su constructor
* @author Carlos Gallardo Polanco
* @version 1.0 23/10/2017
*/

public class Paciente{
	String nombre;
	String dni;
	String direccion;
	String telefono;
	String seguro;

	/**
	* Constructor de la clase
	* @param nombre Nombre del paciente
	* @param dni DNI del paciente
	* @param direccion Dirección del paciente
	* @param telefono Teléfono del paciente
	* @param seguro Seguro del paciente
	*/
	public Paciente(String nombre, String dni, String direccion, String telefono, String seguro){
		this.nombre=nombre;
		this.dni=dni;
		this.direccion=direccion;
		this.telefono=telefono;
		this.seguro=seguro;
	}

	/**
	* Método modificador de la variable nombre
	* @param nombre Nombre del paciente
	*/
	public void set_nombre (String nombre){this.nombre=nombre;}

	/**
	* Método modificador de la variable dni
	* @param dni DNI del paciente
	*/
	public void set_dni (String dni){this.dni=dni;}

	/**
	* Método modificador de la variable direccion
	* @param direccion Dirección del paciente
	*/
	public void set_direccion (String direccion){this.direccion=direccion;}

	/**
	* Método modificador de la variable telefono
	* @param telefono Teléfono del paciente
	*/
	public void set_telefono (String telefono){this.telefono=telefono;}

	/**
	* Método modificador de la variable seguro
	* @param seguro Seguro del paciente
	*/
	public void set_seguro (String seguro){this.seguro=seguro;}

	/**
	* Método observador de la variable nombre
	* @return nombre Nombre del paciente
	*/
	public String get_nombre (){return nombre;}

	/**
	* Método observador de la variable dni
	* @return dni DNI del paciente
	*/
	public String get_dni (){return dni;}

	/**
	* Método observador de la variable direccion
	* @return direccion Dirección del paciente
	*/
	public String get_direccion (){return direccion;}

	/**
	* Método observador de la variable telefono
	* @return telefono Teléfono del paciente
	*/
	public String get_telefono (){return telefono;}

	/**
	* Método observador de la variable seguro
	* @return seguro Seguro del paciente
	*/
	public String get_seguro (){return seguro;}
}
