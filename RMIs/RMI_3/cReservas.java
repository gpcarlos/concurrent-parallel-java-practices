import java.rmi.*;
import java.rmi.registry.*;

import java.util.Scanner;

public class cReservas {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    iReservas obj = (iReservas)Naming.lookup("Reserva");

    System.out.println("Conectado al servidor");

    while (true) {
      int op = -1;
      do {
        System.out.println("Elige una opcion:");
        System.out.println("1) Take a car");
        System.out.println("2) Get available cars");
        System.out.println("3) Null reserve");
        System.out.print(": ");
        op = sc.nextInt(); sc.nextLine();
      } while (op<1 || 3<op);

      switch (op) {
        case 1:
          reservar(obj);
        break;
        case 2:
          disponibles(obj);
        break;
        case 3:
          anular(obj);
        break;
        default:
        break;
      }
    }
  }

  public static void reservar(iReservas obj) throws Exception {
    System.out.print("nombre: ");
    String nombre = sc.nextLine();
    System.out.print("apellidos: ");
    String apellidos = sc.nextLine();
    System.out.print("dni: ");
    String dni = sc.nextLine();
    System.out.print("telefono: ");
    String telefono = sc.nextLine();
    System.out.print("direccion: ");
    String direccion = sc.nextLine();
    int codigo = obj.takeCar(new Data(nombre,apellidos,dni,telefono,direccion));

    if (codigo!=-1)
      System.out.println("Codigo de la reserva "+codigo);
    else
      System.out.println("No hay reservas disponibles");

  }

  public static void disponibles(iReservas obj) throws Exception {
    int count = obj.available();

    System.out.println("Hay "+count+" disponibles.");
  }

  public static void anular(iReservas obj) throws Exception {
    System.out.print("codigo: ");
    int codigo = sc.nextInt();
    obj.nullReserve(codigo);
  }
}
