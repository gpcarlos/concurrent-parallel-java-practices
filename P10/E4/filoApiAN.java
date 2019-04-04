/**
* P10 - E4
* Clase filoApiAN, dotada de un contructor y los métodos coger_Cuchara y dejar_Cuchara
* @author Carlos Gallardo Polanco
* @version 19/12/2016
*/

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class filoApiAN{
	private boolean[] tenedor = new boolean[5];
	
	ReentrantLock cerrojo = new ReentrantLock();
   	Condition condicion = cerrojo.newCondition();

	/**
    * Constructor nulo de la clase filoApiAN
    */
	public filoApiAN(){}

	/**
    * Método coger_Cuchara de la clase filoApiAN
    * @param i chuchara
    */
	public void coger_Cuchara(int i){
		cerrojo.lock();
		try{
			while(tenedor[i] || tenedor[(i+1)%5]){
				try{
					condicion.await();
				}catch (Exception e){}
			}
			tenedor[i]=true;
			tenedor[(i+1)%5]=true;
		}finally{cerrojo.unlock();}
	}

	/**
    * Método dejar_Cuchara de la clase filoApiAN
    * @param i chuchara
    */
	public void dejar_Cuchara(int i){
		cerrojo.lock();
		try{
			tenedor[i]=false;
			tenedor[(i+1)%5]=false;
			condicion.signalAll();
		}finally{cerrojo.unlock();}
	}

}