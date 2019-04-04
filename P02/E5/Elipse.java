/**
* P2 - E5
* Clase Elipse que modela a la entidad elipse y que está dotada de un contructor, los métodos observadores y modificadores y un método pertenece que comprueba si un punto pertenece a ella
* @author Carlos Gallardo Polanco
* @version 1.0 23/10/2017
*/

public class Elipse{
	int[] centro = new int[2];
	int ejemayor;
	int ejemenor;

	/**
	* Constructor nulo de la clase elipse
	*/
	public Elipse (){}

	/**
	* Constructor de la clase elipse
	* @param centro Centro de la elipse
	* @param ejemayor Eje mayor de la elipse
	* @param ejemenor Eje menor de la elipse
	*/
	public Elipse (int[] centro, int ejemayor, int ejemenor){
		this.centro=centro;
		this.ejemayor=ejemayor;
		this.ejemenor=ejemenor;
	}

	/**
	* Método observador de la variable centro
	* @return centro Centro de la elipse
	*/
	public int[] get_centro(){
		return centro;
	}

	/**
	* Método observador de la variable ejemayor
	* @return ejemayor Eje mayor de la elipse
	*/
	public int get_ejemayor(){
		return ejemayor;
	}

	/**
	* Método observador de la variable ejemenor
	* @return ejemenor Eje menor de la elipse
	*/
	public int get_ejemenor(){
		return ejemenor;
	}

	/**
	* Método modificador de la variable centro
	* @param centro Centro de la elipse
	*/
	public void set_centro(int[] centro){
		this.centro=centro;
	}

	/**
	* Método modificador de la variable ejemayor
	* @param ejemayor Eje mayor de la elipse
	*/
	public void set_ejemayor(int ejemayor){
		this.ejemayor=ejemayor;
	}

	/**
	* Método modificador de la variable ejemenor
	* @param ejemenor Eje menor de la elipse
	*/
	public void set_ejemenor(int ejemenor){
		this.ejemenor=ejemayor;
	}

	/**
	* Método pertenece que indica si un punto dado pertenece a la elipse de la clase
	* @param punto[] Punto a comprobar
	* @return true si pertence a la elipse o false si no pertenece
	*/
	public boolean pertenece (int[] punto){
		if(((Math.pow(punto[0]-centro[0],2)/Math.pow((ejemayor/2),2))+((Math.pow(punto[1]-centro[1],2))/(Math.pow(ejemenor/2,2))))==1){
			return true;
		}else{
			return false;
		}
	}
}
