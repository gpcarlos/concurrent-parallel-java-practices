/**
* P3 - E1
* Clase que modela la entidad Hexagono, dotada de distinto métodos como el contructor.
* @author Carlos Gallardo Polanco
* @version 1.0 24/10/2016
*/

public class Hexagono extends Poligono {

	private Punto[] puntos = new Punto[6];  // Array del tipo Punto, que contendrá los puntos del Hexagono ordenados de forma consecutiva

	/**
  * Método constructor de la clase Hexagono
  * @param puntos Array de los puntos que tiene el Hexagono, ordenados de forma consecutiva
  */
	public Hexagono (Punto[] pun) {
		super(pun);
		for(int i=0; i<puntos.length; i++){
	    	puntos[i]=pun[i];
	    }
	}

  public void iguales(){
	  if((lado(puntos[0],puntos[1])==lado(puntos[1],puntos[2]))&&(lado(puntos[1],puntos[2])==lado(puntos[2],puntos[0]))){
	  	System.out.println("Todos los lados son iguales, es un Hexagono regular.");
	  }
	  else{
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
	}

  
}