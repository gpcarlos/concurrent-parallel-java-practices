/**
* P9 - E1
* Clase monitorImpresion, compuesta por un contructor del monitor, un método pedir_imp y otro dejar_imp
* @author Carlos Gallardo Polanco
* @version 18/12/2017
*/

public class monitorImpresion{
	private int  i=0;
	private static int impresoras=3;
	private static boolean[] estadoimpresora = new boolean[3];

	/**
    * Contructor de la clase monitorImpresion
    */
	public monitorImpresion(){
		for(i=0;i<3;i++){
			estadoimpresora[i]=true;
		}
	}

	/**
    *Metodo pedir_imp de la clase monitorImpresion
    */
	public synchronized int pedir_imp(){
		while(impresoras==0){
			try {
         		wait();
      		} catch (InterruptedException e) {}
		}
		int n=0;
		while(!estadoimpresora[n]){n++;}
		estadoimpresora[n]=false;
		impresoras--;
		notifyAll();
		return n;
	}

	/**
    *Metodo dejar_imp de la clase monitorImpresion
    */
	public synchronized int dejar_imp(){
		while(impresoras==3){
			try {
         		wait();
      		} catch (InterruptedException e) {}
		}
		int n=0;
		while(estadoimpresora[n]){n++;}
		estadoimpresora[n]=true;
		impresoras++;
		notifyAll();
		return n;
	}
}
