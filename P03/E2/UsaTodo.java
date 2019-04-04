/**
* P3 - E2
* Clase usaTodo
* @author Carlos Gallardo Polanco
* @version 1.0 06/11/2017
*/

import java.util.Scanner;

public class UsaTodo{

    /**
    * Método principal de la clase UsaTodo
    */
	public static void main(String[] args){
    Scanner sc = new Scanner (System.in);

    int n, dx, dy, escala;

    Punto p1 = new Punto(3.0,0.0);
    Punto p2 = new Punto(3.0,-6.0);
    Punto p3 = new Punto(-3.0,-6.0);
    Punto p4 = new Punto(-3.0,0.0);
    Punto p5 = new Punto(-2.0,3.0);
    Punto p6 = new Punto(2.0,3.0);
//    Punto p7 = new Punto(5.0,2.0);

    Triangulo triangulo = new Triangulo(new Punto[]{p1,p2,p3});

    System.out.println("|-------------|");
    System.out.println("|  Triangulo  |");
    System.out.println("|-------------|");
    System.out.println("El triangulo tiene "+triangulo.cpuntos()+" puntos.");
    System.out.println("El triangulo tiene "+triangulo.clados()+" lados.");
    System.out.println("El perimetro del triangulo es "+triangulo.perimetro()+".");
    triangulo.iguales();
    System.out.print("Que punto quiere mover?: ");
    n=sc.nextInt();
    System.out.print("Cuanto en x?: ");
    dx=sc.nextInt();
    System.out.print("Cuanto en y?: ");
    dy=sc.nextInt();
    triangulo.moverpunto(dx,dy,n);
    System.out.println("El nuevo perimetro del triangulo es "+triangulo.perimetro()+".");
    System.out.print("Cuanto quiere escalar?: ");
    escala=sc.nextInt();
    triangulo.escalar(escala);
    System.out.println("El nuevo perimetro del triangulo es "+triangulo.perimetro()+".");
    triangulo.alturas();
    triangulo.medianas();
    triangulo.baricentro();
    triangulo.area();

    Cuadrado cuadrado = new Cuadrado(new Punto[]{p1,p2,p3,p4,});

    System.out.println("|------------|");
    System.out.println("|  Cuadrado  |");
    System.out.println("|------------|");
    System.out.println("El Cuadrado tiene "+cuadrado.cpuntos()+" puntos.");
    System.out.println("El Cuadrado tiene "+cuadrado.clados()+" lados.");
    System.out.println("El perimetro del Cuadrado es "+cuadrado.perimetro()+".");
    cuadrado.area();
    cuadrado.iguales();
    System.out.print("Que punto quiere mover?: ");
    n=sc.nextInt();
    System.out.print("Cuanto en x?: ");
    dx=sc.nextInt();
    System.out.print("Cuanto en y?: ");
    dy=sc.nextInt();
    cuadrado.moverpunto(dx,dy,n);
    System.out.println("El nuevo perimetro del Cuadrado es "+cuadrado.perimetro()+".");
    cuadrado.area();
    System.out.print("Cuanto quiere escalar?: ");
    escala=sc.nextInt();
    cuadrado.escalar(escala);
    System.out.println("El nuevo perimetro del Cuadrado es "+cuadrado.perimetro()+".");
    cuadrado.area();

    Pentagono pentagono = new Pentagono(new Punto[]{p1,p2,p3,p4,p5});

    System.out.println("|------------|");
    System.out.println("|  Pentagono |");
    System.out.println("|------------|");
    System.out.println("El Pentagono tiene "+pentagono.cpuntos()+" puntos.");
    System.out.println("El Pentagono tiene "+pentagono.clados()+" lados.");
    System.out.println("El perimetro del Pentagono es "+pentagono.perimetro()+".");
    pentagono.iguales();
    System.out.print("Que punto quiere mover?: ");
    n=sc.nextInt();
    System.out.print("Cuanto en x?: ");
    dx=sc.nextInt();
    System.out.print("Cuanto en y?: ");
    dy=sc.nextInt();
    pentagono.moverpunto(dx,dy,n);
    System.out.println("El nuevo perimetro del Pentagono es "+pentagono.perimetro()+".");
    System.out.print("Cuanto quiere escalar?: ");
    escala=sc.nextInt();
    pentagono.escalar(escala);
    System.out.println("El nuevo perimetro del Pentagono es "+pentagono.perimetro()+".");

    Hexagono hexagono = new Hexagono(new Punto[]{p1,p2,p3,p4,p5,p6});

    System.out.println("|------------|");
    System.out.println("|  Hexagono  |");
    System.out.println("|------------|");
    System.out.println("El Hexagono tiene "+hexagono.cpuntos()+" puntos.");
    System.out.println("El Hexagono tiene "+hexagono.clados()+" lados.");
    System.out.println("El perimetro del Hexagono es "+hexagono.perimetro()+".");
    hexagono.iguales();
    System.out.print("Que punto quiere mover?: ");
    n=sc.nextInt();
    System.out.print("Cuanto en x?: ");
    dx=sc.nextInt();
    System.out.print("Cuanto en y?: ");
    dy=sc.nextInt();
    hexagono.moverpunto(dx,dy,n);
    System.out.println("El nuevo perimetro del Hexagono es "+hexagono.perimetro()+".");
    System.out.print("Cuanto quiere escalar?: ");
    escala=sc.nextInt();
    hexagono.escalar(escala);
    System.out.println("El nuevo perimetro del Hexagono es "+hexagono.perimetro()+".");
  }
}
