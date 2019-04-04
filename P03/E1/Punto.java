/**
* P3 - E1
* Clase Punto que modela la entidad punto y que contiene diferentes metodos
* @author Carlos Gallardo Polanco
* @version 1.0 06/11/2017
*/

public class Punto {
  double x, y; //Coordenadas del punto

  /**
  * Metodo constructor de la clase
  * @param x Coordenada x de un punto
  * @param y Coordenada y de un punto
  */
  public Punto(double x, double y) {
    this.x=x; this.y=y;
  }

  /**
  * Metodo observador de la coordenada x del punto
  * @return this.x Coordenada x del punto
  */
  public double Get_x(){
    return this.x;
  }

  /**
  * Metodo observador de la coordenada y del punto
  * @return this.y Coordenada y del punto
  */
  public double Get_y(){
    return this.y;
  }

  /**
  * Metodo modificador de la coordenada x del punto
  * @param x Coordenada x del punto
  */
  public void Set_x(double x){
    this.x=x;
  }

  /**
  * Metodo modificador de la coordenada y del punto
  * @param y Coordenada y del punto
  */
  public void Set_y(double y){
    this.y=y;
  }

  /**
  * Metodo que cambia las cordenadas de un punto
  * @param dx Distancia que se mueve la coordenada x
  * @param dy Distancia que se mueve la coordenada y
  */
  public void moverEn(double dx, double dy) {
    this.x+= dx; this.y+= dy;
  }

  /**
  * Metodo que muestra, en forma de cadena, las coordenadas de un punto
  * @return Cadena que representa las coordenadas del punto
  */
  public String toString() {
    return "("+this.x+","+this.y+")";
  }

  /**
  * Metodo que indica si el punto est� en el origen
  * @param x Coordenada x de un punto
  * @param y Coordenada y de un punto
  */
  public void origen(double x, double y){
    if(x==0&&y==0) System.out.println("Esta en el origen");
  }

  /**
  * Metodo que indica el cuadrante en el que est� el punto
  * @param x Coordenada x de un punto
  * @param y Coordenada y de un punto
  */
  public void cuadrante (double x, double y){
    if(x==0&&y==0) origen(x,y);
    else{
      if((x>=0&&y>0)||(x>0&&y>=0)) System.out.println("Esta en el cuadrante 1");
      else{
        if((x>=0&&y<0)||(x>0&&y<=0)) System.out.println("Esta en el cuadrante 2");
        else{
          if((x<=0&&y<0)||(x<0&&y<=0)) System.out.println("Esta en el cuadrante 3");
          else System.out.println("Esta en el cuadrante 4");
        }
      }
    }
  }

}
