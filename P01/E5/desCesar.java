/**
* P1 - E5
* Clase desCesar que descifra una cadena dada
* @author Carlos Gallardo Polanco
* @version 23/10/2017
*/
import java.util.Scanner;

public class desCesar{
	static Scanner sc = new Scanner (System.in);

	/**
	* Método principal de la clase que pide al usuario un texto cifrado y
	* y un numero en funcion al cual está efectuadp el cifrado cesar.
	* Muestra el texto descrifrado
	* @param args array de cadena de caracteres
	*/
	static public void main(String[] args){
		System.out.print("Introduce el texto cifrado: ");
		String cadena = sc.nextLine();
		System.out.print("Introduzca el numero en funcion al que esta efectuado el cifrado: ");
		int n = sc.nextInt();

		for(int i=0;i<cadena.length();i++){
			int ascii = cadena.codePointAt(i);
			ascii=descifrar(ascii,n);
			System.out.print((char)ascii);
		}
	}

	/**
	* Método descrifrar que devuelve el carácter descifrado
	* @param x Carácter en código ascii cifrado
	* @param n Número en función del cifrado
	* @return ascii descifrado
	*/
	static	public int descifrar (int x, int n){
		if(x==32){
			return x;
		}else{
			if(x-n%27>122||(x-n%27>90&&x-n%27<97)){
				return x-n%27-26;
			}else{
				return x-n%27;
			}
		}
	}
}
