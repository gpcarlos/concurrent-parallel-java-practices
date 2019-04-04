/**
* P2 - E3
* Clase Estadistica que calcula la media, moda, varianza y desviación típica de n valores
* @author Carlos Gallardo Polanco
* @version 1.0 23/10/2017
*/

import java.util.Scanner;

public class Estadistica{

	/**
	* Método principal de la clase que lee los valores con los que se efectuaran las diferentes operaciones estadísticas
	* @param args array de cadena de caracteres. args[0] será el numero de valores a leer
	*/
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		int n = Integer.valueOf(args[0]).intValue();

		double[] vector = new double[n];
		for(int i=0; i<n;i++){
			System.out.print("Introduce el valor numero "+(i+1)+": ");
			vector[i] = sc.nextDouble();
		}
		int o=0;
		while(true){
			do{
			System.out.println("1) Media");
			System.out.println("2) Moda");
			System.out.println("3) Varianza");
			System.out.println("4) Desviacion Tipica");
			System.out.print(": ");
			o = sc.nextInt();
				switch(o){
					case 1: System.out.println("Media: "+media(vector)); break;
					case 2: System.out.println("Moda: "+moda(vector)); break;
					case 3: System.out.println("Varianza: "+varianza(vector)); break;
					case 4: System.out.println("Desviacion Tipica: "+desviacion_tipica(vector)); break;
					default: System.out.println("ERROR"); break;
				}
			}while(o>4||o<1);
		}

	}

	/**
	* Método media que calcula la media de la secuencia de valores
	* @param vector, secuencia de valores con lo que calculará la media
	* @return la media de la secuencia de valores
	*/
	public static double media (double[] vector){
		double sumatorio=0;
		for (int i=0;i<vector.length;i++){
			sumatorio+=vector[i];
		}
		return sumatorio/vector.length;
	}

	/**
	* Método moda que calcula la moda de la secuencia de valores
	* @param vector, secuencia de valores con lo que calculará la moda
	* @return la moda de la secuencia de valores
	*/
	public static double moda (double[] vector){
		double max=vector[0];
		for (int i=1;i<vector.length;i++){
			if(vector[i]>max){max=vector[i];}
		}
		return max;
	}

	/**
	* Método varianza que calcula la varianza de la secuencia de valores
	* @param vector, secuencia de valores con lo que calculará la varianza
	* @return la varianza de la secuencia de valores
	*/
	public static double varianza (double[] vector){
		double sumatorio=0;
		for (int i=0;i<vector.length;i++){
			sumatorio+=Math.pow((vector[i]-media(vector)),2);
		}
		return sumatorio/vector.length;
	}

	/**
	* Método desviazión típica que calcula la desviazión típica de la secuencia de valores
	* @param vector, secuencia de valores con lo que calculará la desviazión típica
	* @return la desviazión típica de la secuencia de valores
	*/
	public static double desviacion_tipica (double[] vector){
		return Math.sqrt(varianza(vector));
	}

}
