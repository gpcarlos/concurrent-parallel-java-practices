/**
* P8 - E1
* Clase que modela la entidad Conductor, dotada de los métodos observadores, modificadores.
* @author Carlos Gallardo Polanco
* @version 11/12/17
*/

public class Conductor {
  private String nombre;          // nombre y Apellidos del conductor
  private String puntos;          // puntos del conductor
  private String dni;             // dni del conductor
  private String direccion;       // direccion del conductor
  private String telefono;        // telefono del conductor
  private String tipodepermiso;   // Tipo de permiso del conductor

  /**
  * Constructor nulo de la clase Conductor
  */
  public Conductor(){}

  /**
  * Constructor de la clase Conductor
  * @param nombre Parámetro que contiene el nombre del conductor
  * @param puntos Parámetro que contiene los puntos del conductor
  * @param dni Parámetro que contiene el dni del conductor
  * @param direccion Parámetro que contiene la direccion del conductor
  * @param telefono Parámetro que contiene el telefono del conductor
  * @param tipodepermiso Parámetro que contiene el tipodepermiso del conductor
  */
  public Conductor(String nombre,String puntos, String dni, String direccion, String telefono, String tipodepermiso){
    this.nombre=nombre;
    this.puntos=puntos;
    this.dni=dni;
    this.direccion=direccion;
    this.telefono=telefono;
    this.tipodepermiso=tipodepermiso;
  }

  /**
  * Método observador de la variable nombre
  * @return nombre nombre del conductor
  */
  public String Get_nombre (){
    return nombre;
  }

  /**
  * Método observador de la variable puntos
  * @return puntos puntos del conductor
  */
  public String Get_puntos (){
    return puntos;
  }

  /**
  * Método observador de la variable dni
  * @return dni dni del conductor
  */
  public String Get_dni (){
    return dni;
  }

  /**
  * Método observador de la variable direccion
  * @return direccion direccion del conductor
  */
  public String Get_direccion (){
    return direccion;
  }

  /**
  * Método observador de la variable telefono
  * @return telefono telefono del conductor
  */
  public String Get_telefono (){
    return telefono;
  }

  /**
  * Método observador de la variable tipodepermiso
  * @return tipodepermiso tipodepermiso del conductor
  */
  public String Get_tipodepermiso (){
    return tipodepermiso;
  }

  /**
  * Método modificador de la variable nombre
  * @param nombre nombre del conductor
  */
  public void Set_nombre (String nombre){
    this.nombre=nombre;
  }

  /**
  * Método modificador de la variable puntos
  * @param puntos puntos del conductor
  */
  public void Set_puntos (String puntos){
    this.puntos=puntos;
  }

  /**
  * Método modificador de la variable dni
  * @param dni dni del conductor
  */
  public void Set_dni (String dni){
   this. dni=dni;
  }

  /**
  * Método modificador de la variable direccion
  * @param direccion direccion del conductor
  */
  public void Set_direccion (String direccion){
    this.direccion=direccion;
  }

  /**
  * Método modificador de la variable telefono
  * @param telefono telefono del conductor
  */
  public void Set_telefono (String telefono){
    this.telefono=telefono;
  }

  /**
  * Método modificador de la variable tipodepermiso
  * @param tipodepermiso tipodepermiso del conductor
  */
  public void Set_tipodepermiso (String tipodepermiso){
    this.tipodepermiso=tipodepermiso;
  }

}
