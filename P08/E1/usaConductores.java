/**
* P8 - E1
* Clase usaConductores, dotada de un método principal, un constructor y un método run
* @author Carlos Gallardo Polanco
* @version 11/12/17
*/

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class usaConductores implements Runnable{
    static Scanner sc = new Scanner (System.in);
    static Conductores cond = new Conductores();  //Objeto cond del tipo Conductores
    public int a;

    /**
    * Constructor de la clase usaConductores
    */
    public usaConductores(int a){
        this.a=a;
    }

    /**
    * Método run de la clase usaConductores
    */
    public void run(){
         switch (a){
            case 1:
                cond.Insertar();
            break;

            case 2:
                cond.Consultar();
            break;

            case 3:
                cond.CambiarPuntos();
            break;

            case 4:
                cond.Eliminar();
            break;

            default:
            break;
        }
    }

    /**
    * Método principal de la clase usaConductores
    */
    public static void main (String[] args) throws Exception{
    	ExecutorService ex = Executors.newCachedThreadPool();
        int i;
        do{
            System.out.println("Introduzca la opcion que desea: ");
            System.out.println("1- Insertar conductor");
            System.out.println("2- Consultar conductor");
            System.out.println("3- Cambiar puntos de un conductor");
            System.out.println("4- Eliminar conductor");
            System.out.println("Para salir pulse otra tecla cualquiera");
            System.out.print(": ");
            i = sc.nextInt();

            switch(i){
                case 1:
                    ex.execute(new usaConductores(i));
                break;
                case 2:
                    ex.execute(new usaConductores(i));
                break;
                case 3:
                    ex.execute(new usaConductores(i));
                break;
                case 4:
                    ex.execute(new usaConductores(i));
                break;
                default:
                    System.out.println("Saliendo...");
                break;
            }
            System.out.println("En 20seg se le permitira elegir una nueva opcion");
            Thread.sleep(20000);
        }while(i>=1||i<=4);
        ex.shutdown();
        while(!ex.isTerminated()){}
    }
  }
