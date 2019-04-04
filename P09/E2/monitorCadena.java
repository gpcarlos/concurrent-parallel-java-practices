/**
* P9 - E2
* Clase monitorCadena, compuesta por un contructor del monitor y los métodos extraer, insertar, procesoA, procesoB y procesoC
* @author Carlos Gallardo Polanco
* @version 18/12/2017
*/

import java.util.*;

public class monitorCadena{
	private static int[][][] buffer_1 = new int[100][10][10];
    private static int[][][] buffer_2 = new int[50][10][10];
    private static int[][] matriz = new int[10][10];
    private static boolean b1=false;
    private static boolean b2=false;
    private static boolean b3=false;
    private static boolean b4=false;

    static Random random = new Random();

	/**
    * Contructor nulo de la clase monitorCadena
    */
	public monitorCadena(){}

	/**
    * Método extraer de la clase monitorCadena
    * @param i Parámetro de tipo entero que indica la posición en el buffer
    * @param buffer Parámetro de tipo entero que indica tipo de buffer
    */
	public synchronized void extraer(int i, int buffer){
		if(buffer==0){
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					matriz[fila][columna]=buffer_1[i][fila][columna];
				}
			}
		}
		else{
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					matriz[fila][columna]=buffer_2[i][fila][columna];
				}
			}
		}
	}

	/**
    * Método insertar de la clase monitorCadena
    * @param i Parámetro de tipo entero que indica la posición en el buffer
    * @param buffer Parámetro de tipo entero que indica tipo de buffer
    */
	public synchronized void insertar(int i, int buffer){
		if(buffer==0){
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					buffer_1[i][fila][columna]=matriz[fila][columna];
				}
			}
		}
		else{
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					buffer_2[i][fila][columna]=matriz[fila][columna];
				}
			}
		}
	}

	/**
    * Método procesoA de la clase monitorCadena
    */
	public synchronized void procesoA(){
		for(int i=0;i<100;i++){
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					matriz[fila][columna]=random.nextInt();
				}
			}
			insertar(i,0);
		}
		b1=true;
		notifyAll();
	}

	/**
    * Método procesoB de la clase monitorCadena
    */
	public synchronized void procesoB(){
		while(!b1){
			try {
         		wait();
      		} catch (InterruptedException e) {}
		}
		int[][] auxiliar = new int[10][10];
		for(int i=0;i<50;i++){
			extraer(i,0);
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					auxiliar[columna][fila]=matriz[columna][fila];
				}
			}
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					matriz[columna][fila]=auxiliar[fila][columna];
				}
			}
			insertar(i,1);
		}

		b2=true;
		notifyAll();

		while(!b3){
			try {
         		wait();
      		} catch (InterruptedException e) {}
		}
		int j=0;
		for(int i=50;i<100;i++){
			extraer(i,0);
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					auxiliar[columna][fila]=matriz[columna][fila];
				}
			}
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					matriz[columna][fila]=auxiliar[fila][columna];
				}
			}
			insertar(j,1);
			j++;
		}

		b4=true;
		notifyAll();
	}

	/**
    * Método procesoC de la clase monitorCadena
    */
	public synchronized void procesoC(){
		while(!b2){
			try {
         		wait();
      		} catch (InterruptedException e) {}
		}
		for(int i=0;i<50;i++){
			extraer(i,1);
			int producto=1;
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					if(fila==columna){producto*=matriz[fila][columna];}
				}
			}
			System.out.println("El producto de la diagonal de la matriz "+(i+1)+" es "+producto);
		}

		b3=true;
		notifyAll();

		while(!b4){
			try {
         		wait();
      		} catch (InterruptedException e) {}
		}
		int j=50;
		for(int i=0;i<50;i++){
			extraer(i,1);
			int producto=1;
			for(int fila=0;fila<10;fila++){
				for(int columna=0;columna<10;columna++){
					if(fila==columna){producto*=matriz[fila][columna];}
				}
			}
			System.out.println("El producto de la diagonal de la matriz "+(j+1)+" es "+producto);
			j++;
		}
	}
}
