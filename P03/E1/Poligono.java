/**
* P3 - E1
* Clase Poligono que modela la entidad poligono y que contiene diferentes metodos
* @author Carlos Gallardo Polanco
* @version 1.0 06/11/2017
*/

public class Poligono {

	static Punto[] puntos; // Array del tipo Punto, que contendrá los puntos del poligono ordenados de forma consecutiva

	/**
  	* Método constructor de la clase
  	* @param puntos Array de los puntos que tiene el polígono, ordenados de forma consecutiva
  	*/
	public Poligono (Punto[] pun) {
		puntos = new Punto[pun.length];
		for(int i=0; i<pun.length; i++){
	    	puntos[i]=pun[i];
	    }
	}

	/**
  	* Método que calcula la distancia entre dos puntos
  	* @param a Parámetro que representa un punto
  	* @param b Parámetro que representa un punto
  	*/
	public double lado (Punto a, Punto b){
		return Math.sqrt(Math.pow(b.Get_x()-a.Get_x(),2)+Math.pow(b.Get_y()-a.Get_y(),2));
	}

	/**
  	* Método que calcula cuántos lados tiene
  	* @param puntos Array de los puntos que tiene el polígono, ordenados de forma consecutiva
  	*/
	public int clados(){
		int contador=0;
		for(int i=0; i<puntos.length; i++){
			if(puntos[i]!=null){
			contador++;
			}
		}
		return contador;
	}

	/**
  	* Método que calcula cuántos puntos tiene
  	* @param puntos Array de los puntos que tiene el polígono, ordenados de forma consecutiva
  	*/
	public int cpuntos(){
		int contador=0;
		for(int i=0; i<puntos.length; i++){
			if(puntos[i]!=null){
			contador++;
			}
		}
		return contador;
	}

	/**
  	* Método que calcula el perímetro del polígono
  	* @param  puntos Array de los puntos que tiene el polígono, ordenados de forma consecutiva
  	*/
	public double perimetro (){

	  	double perimetro=0;

	  	for(int i=0;i<cpuntos()-1;i++){
	  		perimetro+=lado(puntos[i],puntos[i+1]);
  		}
  		perimetro+=lado(puntos[cpuntos()-1], puntos[0]);

  		return perimetro;
	}

	/**
  	* Método que ve qué lados son iguales
  	* @param  puntos Array de los puntos que tiene el polígono, ordenados de forma consecutiva
  	*/
  	public void iguales(){
	  	for(int x=0;x<(cpuntos()-2);x++){
	  		for(int i=x;i<(cpuntos()-2);i++){
		  		if(lado(puntos[i],puntos[i+1])==lado(puntos[i+1],puntos[i+2])){
		  			System.out.println("El lado del punto "+puntos[i].toString()+" al "+puntos[i+1].toString()+" es igual que el lado del punto"+puntos[i+1].toString()+" al "+puntos[i+2].toString());
		  		}
		  	}
		  	if(lado(puntos[x],puntos[x+1])==lado(puntos[cpuntos()-1],puntos[0])){
		  			System.out.println("El lado del punto "+puntos[x].toString()+" al "+puntos[x+1].toString()+" es igual que el lado del punto"+puntos[cpuntos()-1].toString()+" al "+puntos[0].toString());
		  		}
	  	}
  	}

  	/**
  	* Método que mueve un punto
  	* @param  dx Distancia en la que se mueve x
  	* @param  dy Distancia en la que se mueve y
  	* @param  puntos Array de los puntos que tiene el polígono, ordenados de forma consecutiva
  	* @param  n posicion del Array en la que se encuentra el punto a mover
  	*/
  	public void moverpunto(double dx, double dy, int n){
  		puntos[n].Set_x(puntos[n].Get_x()+dx);
  		puntos[n].Set_y(puntos[n].Get_y()+dy);
  	}

  	/**
  	* Método que escala el polígono
  	* @param  puntos Array de los puntos que tiene el polígono, ordenados de forma consecutiva
  	* @param  escala proporción en la que se escala el polígono
  	*/
  	public void escalar(int escala){
  		for(int i=0;i<cpuntos();i++){
  			puntos[i].Set_x(puntos[i].Get_x()*escala);
  			puntos[i].Set_y(puntos[i].Get_y()*escala);
  		}
  	}
}
