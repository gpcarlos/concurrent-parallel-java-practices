/**
* P2 - E2
* Clase Ack que calcula la función Ackermann
* @author Carlos Gallardo Polanco
* @version 1.0 23/10/2017
*/

public class Ack{

	/**
	* Método principal de la clase que lee dos valores m y n de la línea de comandos y llama a la función Ackermann
	* @param args array de cadena de caracteres. args[0] será 'm' y args n será 'n'
	*/
	public static void main (String[] args){
		int m = Integer.valueOf(args[0]).intValue();
		int n = Integer.valueOf(args[1]).intValue();
		System.out.println("Ack("+m+","+n+")="+Ackermann(m,n));
	}

	/**
	* Método Ackermann que efectua la función Ackermann
	* @param m numero natural
	* @param n numero natural
	* @return resultado de la fución
	*/
	public static int Ackermann (int m, int n){
		if(m==0){
			return n+1;
		}else{
			if(n==0){
				return Ackermann(m-1,1);
			}else{
				return Ackermann(m-1,Ackermann(m,n-1));
			}
		}
	}
}
