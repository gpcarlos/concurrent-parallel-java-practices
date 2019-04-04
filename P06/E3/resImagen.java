/**
* P6 - E4
* Clase resImagen que contiene un método principal y un método resaltado
* @author Carlos Gallardo Polanco
* @version 21/11/2016
*/

import java.util.Random;

public class resImagen{
	static Random rd = new Random();
	static int n=10;
	static int[][] imagen = new int[n][n];
	static int[][] resalt = new int[n][n];

	/**
	* Método principal de la clase resImagen
	*/
	public static void main (String[] args){
		for(int i=0;i<n;i++){
			for(int j=1;j<n;j++){
				imagen[i][j]=rd.nextInt(19);
			}
		}
		
		System.out.println("Imagen:");
		for(int i=0;i<n;i++){
			for(int j=1;j<n;j++){
				System.out.print("| "+imagen[i][j]+" ");
			}
			System.out.println("|");
		}

		resaltado();

		System.out.println("Resaltado:");
		for(int i=0;i<n;i++){
			for(int j=1;j<n;j++){
				System.out.print("| "+resalt[i][j]+" ");
			}
			System.out.println("|");
		}
	}

	/**
	* Método resaltado
	*/
	public static void resaltado (){
		for(int i=0;i<n;i++){
	    	for(int j=0;j<n;j++){
	            if(i==0){
	          		if(j==0) {resalt[i][j]=(4*imagen[i][j]-imagen[i+1][j]-imagen[i][j+1])/8;}
	           		else{
	           			if(j==n-1) {resalt[i][j]=(4*imagen[i][j]-imagen[i+1][j]-imagen[i][j-1])/8;}
	        			else {resalt[i][j]=(4*imagen[i][j]-imagen[i+1][j]-imagen[i][j+1]-imagen[i][j-1])/8;}
	           		}
	           	}
	           	else{
	           		if(i==n-1){
	           			if(j==0) {resalt[i][j]=(4*imagen[i][j]-imagen[i][j+1]-imagen[i-1][j])/8;}
	           			else{
	           				if(j == n-1) {resalt[i][j]=(4*imagen[i][j]-imagen[i-1][j]-imagen[i][j-1])/8;}
	           				else {resalt[i][j]=(4*imagen[i][j]-imagen[i][j+1]-imagen[i-1][j]-imagen[i][j-1])/8;}
	           			}
	           		}
	           		else{
	           			if (j==0) {resalt[i][j]=(4*imagen[i][j]-imagen[i+1][j]-imagen[i][j+1]-imagen[i-1][j])/8;}
	           			else{
	    					if (j==n-1) {resalt[i][j]=(4*imagen[i][j]-imagen[i+1][j]-imagen[i-1][j]-imagen[i][j-1])/8;}
	            			else {resalt[i][j]=(4*imagen[i][j]-imagen[i+1][j]-imagen[i][j+1]-imagen[i-1][j]-imagen[i][j-1])/8;}
            			}
    	   			}
        		}
        	}
        }
	}
}