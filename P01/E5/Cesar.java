/**
* P1 - E5
* Clase Cesar que cifra una cadena dada
* @author Carlos Gallardo Polanco
* @version 23/10/2017
*/
import java.util.Scanner;

public class Cesar{
	static Scanner sc = new Scanner (System.in);

	/**
	* Método principal de la clase que pide al usuario un texto a cifrar y
	* y un numero en funcion al cual se efectue el cifrado cesar
	* Muestra el texto crifrado
	* @param args array de cadena de caracteres
	*/
	static public void main (String[] args){
		System.out.print("Introduzca el texto a cifrar: ");
		String cadena = sc.nextLine();
		System.out.print("Introduzca el numero en funcion al que se va efectuar el cifrado: ");
		int n = sc.nextInt();
		System.out.println("El texto original es: "+cadena);
		System.out.println("El texto cifrado es: ");

		for(int i=0;i<cadena.length();i++){
			int ascii=cadena.codePointAt(i);
			ascii=cifrado(ascii,n);
			System.out.print((char)ascii);
		}
	}

	/**
	* Método crifrar que devuelve el carácter cifrado
	* @param x Carácter en código ascii descifrado
	* @param n Número en función del cifrado
	* @return ascii cifrado
	*/
	static public int cifrado (int x, int n){
		if(x==32){
			return x;
		}else{
			if(x+n%27>122||(x+n%27>90&&x+n%27<97)){
				return x+n%27-26;
			}else{
				return x+n%27;
			}
		}
	}
}
