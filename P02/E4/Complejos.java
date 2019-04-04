/**
* P2 - E4
* Clase Complejos que modela un numero complejo y los métodos suma, resta, módulo, producto y cociente
* @author Carlos Gallardo Polanco
* @version 1.0 23/10/2017
*/

public class Complejos{

	private double[] numero = new double[2];

	/**
	* Constructor nulo de la clase
	*/
	public Complejos(){}

	/**
	* Constructor de la clase
	* @param real Parte real del número complejo
	* @param imag Parte imaginaria del número complejo
	*/
	public Complejos(double real, double imag){
		numero[0]=real;
		numero[1]=imag;
	}

	/**
	* Método observador de la parte real del numero complejo
	* @return numero[0] Parte real del numero complejo
	*/
	public double get_real(){
		return numero[0];
	}

	/**
	* Método observador de la parte imaginaria del numero complejo
	* @return numero[1] Parte imaginaria del numero complejo
	*/
	public double get_imag(){
		return numero[1];
	}

	/**
	* Método modificador de la parte real del numero complejo
	* @param real Parte real del numero complejo
	*/
	public void set_real(double real){
		numero[0]=real;
	}

	/**
	* Método modificador de la parte imaginaria del numero complejo
	* @param imag Parte imaginaria del numero complejo
	*/
	public void set_imag(double imag){
		numero[1]=imag;
	}

	/**
	* Método suma que realiza la suma de dos números complejos
	* @param n1 Primer número complejo
	* @param n2 Segundo número coplejo
	*/
	public void suma (Complejos n1, Complejos n2){
		System.out.println("La suma es ("+(n1.get_real()+n2.get_real())+","+(n1.get_imag()+n2.get_imag())+"i)");
	}

	/**
	* Método resta que realiza la resta de dos números complejos
	* @param n1 Primer número complejo
	* @param n2 Segundo número coplejo
	*/
	public void resta (Complejos n1, Complejos n2){
		System.out.println("La resta es ("+(n1.get_real()-n2.get_real())+","+(n1.get_imag()-n2.get_imag())+"i)");
	}

	/**
	* Método cociente que realiza el cociente de dos números complejos
	* @param n1 Primer número complejo
	* @param n2 Segundo número coplejo
	*/
	public void producto (Complejos n1, Complejos n2){
		System.out.println("El producto es ("+((n1.get_real()*n2.get_real())-(n1.get_imag()*n2.get_imag()))+","+((n1.get_real()*n2.get_imag())+(n1.get_imag()*n2.get_real()))+"i)");
	}

	/**
	* Método cociente que realiza el cociente de dos números complejos
	* @param n1 Primer número complejo
	* @param n2 Segundo número coplejo
	*/
	public void cociente (Complejos n1, Complejos n2){
		System.out.println("El cociente es ("+((n1.get_real()*n2.get_real()+n1.get_imag()*n2.get_imag())/(Math.pow(n2.get_real(),2)+Math.pow(n2.get_imag(),2)))+","+((n1.get_imag()*n2.get_real()+n1.get_real()*n2.get_imag())/(Math.pow(n2.get_real(),2)+Math.pow(n2.get_imag(),2)))+"i)");
	}

	/**
	* Método módulo que realiza el módulo de un número complejo
	* @param n1 Primer número complejo
	*/
	public void modulo (Complejos n1){
		System.out.println("El modulo es: "+(Math.sqrt(Math.pow(n1.get_real(),2)+Math.pow(n1.get_imag(),2))));
	}
}
