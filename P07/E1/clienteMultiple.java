/**
* P7 - E1
* Clase clienteMultiple, compuesta por una clase principal
* @author Carlos Gallardo Polanco
* @version 01/12/2017
*/

import java.net.*;
import java.io.*;

public class clienteMultiple
{
    /**
    * Método principal de la clase clienteMultiple
    */
    public static void main (String[] args)
    {
        int peticiones = 1;

        for(int n=0;n<peticiones;n++){
            int i = (int)(Math.random()*10);
            int puerto = 2001;
            try{
                System.out.println("Realizando conexion...");
                Socket cable = new Socket("localhost", 2001);
                System.out.println("Realizada conexion a "+cable);
                PrintWriter salida= new PrintWriter(
                                        new BufferedWriter(
                                            new OutputStreamWriter(
                cable.getOutputStream())));
                salida.println(i);
                salida.flush();
                System.out.println("Cerrando conexion...");
                cable.close();

                }//try
                    catch (Exception e)
            {System.out.println("Error en sockets...");}
        }

    }//main
}//clienteMultiple
