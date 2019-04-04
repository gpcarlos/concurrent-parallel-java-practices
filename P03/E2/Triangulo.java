/**
* P3 - E1
* Clase que modela la entidad Triangulo, dotada de distinto métodos como el contructor.
* @author Carlos Gallardo Polanco
* @version 1.0 06/11/2017
*/

public class Triangulo extends Poligono {

	private Punto[] puntos = new Punto[3];  // Array del tipo Punto, que contendrá los puntos del triangulo ordenados de forma consecutiva

	/**
  * Método constructor de la clase Triangulo
  * @param puntos Array de los puntos que tiene el triangulo, ordenados de forma consecutiva
  */
	public Triangulo (Punto[] pun) {
		super(pun);
		for(int i=0; i<puntos.length; i++){
	    	puntos[i]=pun[i];
	    }
	}

	/**
  * Método que calcula las alturas del triangulo
  * @param puntos Array de los puntos que tiene el triangulo, ordenados de forma consecutiva
  */
	public void alturas(){
		double a=lado(puntos[0],puntos[1]);
		double b=lado(puntos[1],puntos[2]);
		double c=lado(puntos[2],puntos[0]);

		double s=(a+b+c)/2;

  	double ha=(2/a)*(Math.sqrt(s*(s-a)*(s-b)*(s-c)));
  	double hb=(2/b)*(Math.sqrt(s*(s-a)*(s-b)*(s-c)));
  	double hc=(2/c)*(Math.sqrt(s*(s-a)*(s-b)*(s-c)));

  	System.out.println("Las alturas son "+ha+", "+hb+" y "+hc);
  }

  /**
  * Método que calcula las medianas del triangulo
  * @param puntos Array de los puntos que tiene el triangulo, ordenados de forma consecutiva
  */
  public void medianas (){
  	double a=lado(puntos[0],puntos[1]);
		double b=lado(puntos[1],puntos[2]);
		double c=lado(puntos[2],puntos[0]);

  	double ma=(2/a)*Math.sqrt(2*(Math.pow(b,2)+Math.pow(c,2))-Math.pow(a,2));
  	double mb=(2/b)*Math.sqrt(2*(Math.pow(a,2)+Math.pow(c,2))-Math.pow(b,2));
  	double mc=(2/c)*Math.sqrt(2*(Math.pow(a,2)+Math.pow(b,2))-Math.pow(c,2));

  	System.out.println("Las medianas son "+ma+", "+mb+" y "+mc);
  }

  /**
  * Método que calcula el baricentro del triangulo
  * @param puntos Array de los puntos que tiene el triangulo, ordenados de forma consecutiva
  */
  public void baricentro (){
  	double a_x=puntos[0].Get_x();
  	double a_y=puntos[0].Get_y();
  	double b_x=puntos[1].Get_x();
  	double b_y=puntos[1].Get_y();
  	double c_x=puntos[2].Get_x();
  	double c_y=puntos[2].Get_y();

  	double g_x=(a_x+b_x+c_x)/3;
  	double g_y=(a_y+b_y+c_y)/3;

  	System.out.println("El Baricentro es G("+g_x+","+g_y+")");
  }

  /**
  * Método que calcula el area del triangulo
  * @param puntos Array de los puntos que tiene el triangulo, ordenados de forma consecutiva
  */
  public void area (){
  	double a=lado(puntos[0],puntos[1]);
		double b=lado(puntos[1],puntos[2]);
		double c=lado(puntos[2],puntos[0]);

  	double s=(a+b+c)/2;

  	double h=(2/a)*(Math.sqrt(s*(s-a)*(s-b)*(s-c)));

  	double area= (a*h)/2;

  	System.out.println("El area es: "+area);
  }

  /**
  * Método que ve qué lados son iguales
  * @param  puntos Array de los puntos que tiene el polígono, ordenados de forma consecutiva
  */
  public void iguales(){
	  if((lado(puntos[0],puntos[1])==lado(puntos[1],puntos[2]))&&(lado(puntos[1],puntos[2])==lado(puntos[2],puntos[0]))){
	  	System.out.println("Todos los lados son iguales, es un triangulo equilatero.");
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
