/**
* P3 - E1
* Clase que modela la entidad Cuadrado, dotada de distinto métodos como el contructor.
* @author Carlos Gallardo Polanco
* @version 1.0 24/10/2016
*/

public class Cuadrado extends Poligono {

	private Punto[] puntos = new Punto[4];  // Array del tipo Punto, que contendrá los puntos del Cuadrado ordenados de forma consecutiva

	/**
  * Método constructor de la clase Cuadrado
  * @param puntos Array de los puntos que tiene el Cuadrado, ordenados de forma consecutiva
  */
	public Cuadrado (Punto[] pun) {
		super(pun);
		for(int i=0; i<puntos.length; i++){
	    	puntos[i]=pun[i];
	    }
	}

  /**
  * Método que calcula el area del Cuadrado
  * @param puntos Array de los puntos que tiene el Cuadrado, ordenados de forma consecutiva
  */
  public void area (){
  	double a=lado(puntos[0],puntos[1]);
		double b=lado(puntos[1],puntos[2]);

  	double area= a*b;

  	System.out.println("El area es: "+area);
  }  
}