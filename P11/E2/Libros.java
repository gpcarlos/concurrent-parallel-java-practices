/**
* P11 - E2
* Clase que modela la entidad Libros, dotada de los métodos observadores, modificadores. 
* @author Carlos Gallardo Polanco
* @version 09/01/2017
*/

public class Libros {
  private String Titulo;    
  private String Autor;  	
  private String Fecha;      
  private String Genero; 
  private String ISBN;  
  

  /**
  * Constructor nulo de la clase Libros
  */
  public Libros(){}

  /**
  * Constructor de la clase Libros
  * @param Titulo Parámetro que contiene el Titulo del Libro
  * @param Autor Parámetro que contiene los Autor del Libro
  * @param Fecha Parámetro que contiene el Fecha del Libro
  * @param Genero Parámetro que contiene el Genero del Libro
  * @param ISBN Parámetro que contiene el ISBN del Libro
  */
  public Libros(String Titulo,String Autor, String Fecha, String Genero, String ISBN){
    this.Titulo=Titulo;
    this.Autor=Autor;
    this.Fecha=Fecha;
    this.Genero=Genero;
    this.ISBN=ISBN;
  }

  /**
  * Método observador de la variable Titulo
  * @return Titulo Titulo del Libro
  */
  public String Get_Titulo (){
    return Titulo;
  }

  /**
  * Método observador de la variable Autor
  * @return Autor Autor del Libro
  */
  public String Get_Autor (){
    return Autor;
  }

  /**
  * Método observador de la variable Fecha
  * @return Fecha Fecha del Libro
  */
  public String Get_Fecha (){
    return Fecha;
  }

  /**
  * Método observador de la variable Genero
  * @return Genero Genero del Libro
  */
  public String Get_Genero (){
    return Genero;
  }

  /**
  * Método observador de la variable ISBN
  * @return ISBN ISBN del Libro
  */
  public String Get_ISBN (){
    return ISBN;
  }

  /**
  * Método modificador de la variable Titulo 
  * @param Titulo Titulo del Libro
  */
  public void Set_Titulo (String Titulo){
    this.Titulo=Titulo;
  }

  /**
  * Método modificador de la variable Autor 
  * @param Autor Autor del Libro
  */
  public void Set_Autor (String Autor){
    this.Autor=Autor;
  }

  /**
  * Método modificador de la variable Fecha 
  * @param Fecha Fecha del Libro
  */
  public void Set_Fecha (String Fecha){
    this.Fecha=Fecha;
  }

  /**
  * Método modificador de la variable Genero 
  * @param Genero Genero del Libro
  */
  public void Set_Genero (String Genero){
    this.Genero=Genero;
  }

  /**
  * Método modificador de la variable ISBN 
  * @param ISBN ISBN del Libro
  */
  public void Set_ISBN (String ISBN){
    this.ISBN=ISBN;
  }

}