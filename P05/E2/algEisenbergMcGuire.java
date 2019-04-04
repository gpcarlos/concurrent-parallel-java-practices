/**
* P5 - E2
* Clase algEisenbergMcGuire que implementa el algoritmo de Eisenberg-McGuire para dos procesos, compuesta por una clase principal, un constructor y una método run.
* @author Carlos Gallardo Polanco
* @version 1.0,  13/11/2017
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class algEisenbergMcGuire implements Runnable{

	public static int n=0;
	public int i;
	public enum pstate{IDLE,WAITING,ACTIVE};
	public pstate[] flags = new pstate[2];
	public int index;
	public int turn;

	/**
    * Contructor de la clase
    * @param i Indica el tipo de hilo
    */
	public algEisenbergMcGuire(int i){
		this.i=i;
	}

	/**
    *Metodo run de la clase
    */
	public void run(){
		for(int j=0;j<500000000;j++){
			do{
				if(i==0){turn=0;}
				else turn=1;
				flags[i]=pstate.WAITING;
				index=turn;
				while (index!=i){
					if(flags[index]!=pstate.IDLE){index=turn;}
					else index=(index+1)%2;
				}
				flags[i]=pstate.ACTIVE;
				index=0;
				while((index<2)&&((index==i)||(flags[index]!=pstate.ACTIVE))){
					index=index+1;
				}
			} while((index<2)||((turn!=i)&&(flags[turn]!=pstate.IDLE)));

			turn=i;
			if(index==0){
				n++;
			}
			if(index==1){
				n--;
			}

			index=(turn+1)%2;
			while(flags[index]==pstate.IDLE){
				index=(index+1)%2;
			}

			turn=index;
			flags[i]=pstate.IDLE;
		}
	}

	/**
    * Método principal de la clase
    * @param args array de cadena de caracteres
    * @throws Exception
    */
	public static void main (String[] args) throws Exception{
		ExecutorService ex = Executors.newFixedThreadPool(2);
		ex.execute(new algEisenbergMcGuire(0));
		ex.execute(new algEisenbergMcGuire(1));
		ex.shutdown();
		while(!ex.isTerminated()){}
		System.out.println("El recurso comun es "+n+". Deberia ser 0.");
	}
}
