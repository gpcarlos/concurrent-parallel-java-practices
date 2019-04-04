/**
* P5 - E1
* Clase algDekker que implementa el algoritmo de Dekker
* @author Carlos Gallardo Polanco
* @version 1.0, 13/11/2017
*/

class algDekker{

    static final int iteraciones = 1000;  // Iteraciones que dara cada hilo
    static volatile int enteroCompartido = iteraciones; // Recurso compartido
    static volatile boolean wantp = false; // Representa el deseo del hilo P de entrar en la seccion critica
    static volatile boolean wantq = false; // Representa el deseo del hilo Q de entrar en la seccion critica
    static volatile boolean wantz = false; // Representa el deseo del hilo Z de entrar en la seccion critica
    static volatile int turn = 1; // Representa de quien es el turno

    /**
    * Clase P
    * @extends Thread
    */
    class P extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                wantp = true;
                while (wantq||wantz) {
                    if (turn == 2||turn == 3) {
                        wantp = false;
                        while (turn == 2||turn == 3)
                            Thread.yield();
                        wantp = true;
                    }
                }
                // SC
                ++enteroCompartido;
                // SC
                turn = 2;
                wantp = false;
            }
        }
    }

    /**
    * Clase Q
    * @extends Thread
    */
    class Q extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                wantq = true;
                while (wantp||wantz) {
                    if (turn == 1||turn == 3) {
                        wantq = false;
                        while (turn == 1||turn == 3)
                            Thread.yield();
                        wantq = true;
                    }
                }
                // SC
                --enteroCompartido;
                // SC
                turn = 1;
                wantq = false;
            }
        }
    }

    /**
    * Clase Z
    * @extends Thread
    */
    class Z extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                wantz = true;
                while (wantp||wantq) {
                    if (turn == 1||turn == 2) {
                        wantz = false;
                        while (turn == 1||turn == 2)
                            Thread.yield();
                        wantz = true;
                    }
                }
                // SC
                --enteroCompartido;
                // SC
                turn = 3;
                wantz = false;
            }
        }
    }

    /**
    * Constructor de la clase
    */
    algDekker() {
        Thread p = new P();
        Thread q = new Q();
        Thread z = new Z();
        p.start();
        q.start();
        z.start();

        try {
            p.join();
            q.join();
            z.join();
            System.out.println("El valor del recurso compartido es " + enteroCompartido);
            System.out.println("Deberia ser 0");
        }
        catch (InterruptedException e) {}
    }

    /**
    * Método principal de la clase
    * @param args array de cadena de caracteres
    */
    public static void main(String[] args) {
        new algDekker();
    }
}
