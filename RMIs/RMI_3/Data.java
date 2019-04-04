import java.io.*;

public class Data implements Serializable {
  public String nombre, apellidos, dni, telefono, direccion;

  public Data(String nombre, String apellidos, String dni, String telefono, String direccion) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dni = dni;
    this.telefono = telefono;
    this.direccion = direccion;
  }
}
