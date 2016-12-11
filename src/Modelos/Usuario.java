
package Modelos;

/***********************************************************************
 * Module:  Usuario.java
 * Author:  franco
 * Purpose: Defines the Class Usuario
 ***********************************************************************/

import BaseDatos.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Usuario extends Jugador {


   private Connection conexion;
   private String nombre ;
   private String contraseña;
   private String personajePrincipal;
   private String personajeAmigo;
   private ArrayList<Personaje> equipo;
   private int nivel;
   private ArrayList<Personaje> listaContratos;
   private ArrayList<String> ramosCursados;
   private String malla;
   private ArrayList<String> listaUsuarios = new ArrayList<>();
   private ArrayList<String> listaContraseñas = new ArrayList<>();
   private int dinero;
   
      public Usuario(){
       equipo = new ArrayList<>();   
    
   }
     
    
    public Personaje identificarPersonaje(String nombre){
        for(Personaje p : equipo){
            if(p.getNombrePersonaje().equals(nombre)){
               return p;
           }
       }
       return null;
   }
    
    
    //metodo que identifica si el nombre de usuario existe
   public boolean usuarioExistente(String usuario) throws SQLException{
      
       try{
           BaseDatos conexionBD = new BaseDatos();
           conexionBD.conectar(); //Se conecta con la base de datos
           Statement stmt = conexionBD.crearConsulta(); //Se establecen las consultas
           final String consulta = "SELECT NOMBRE_USUARIO FROM USUARIO WHERE (NOMBRE_USUARIO = '"+usuario+"')"; //Se seleccionan los nombres de usuario de la tabla USUARIO
           ResultSet resultados = stmt.executeQuery(consulta); //Obteniendo los resultados de la columma NOMBRE_USUARIO
           if(resultados.next()){ //Si el parametro buscado se encuentra en la base de datos
               return true;
           }
         
       }
       catch (SQLException ex) {
                System.err.println("Base de datos no conectada");
                return false;
        }
       return false;
   }
   public boolean contraseñaExistente(String contraseña) throws SQLException{
      
       try{
           BaseDatos conexionBD = new BaseDatos();
           conexionBD.conectar();//Se conecta con la base de datos
           Statement stmt = conexionBD.crearConsulta(); //Se establecen las consultas
           final String consulta = "SELECT CONTRASEÑA_USUARIO FROM USUARIO WHERE (CONTRASEÑA_USUARIO = '"+contraseña+"')"; //Se selecciona las contraseñas de la tabla de USUARIO
           ResultSet resultados = stmt.executeQuery(consulta); //se obttiene los resultados de la columna CONTRASEÑA_USURIO
           if(resultados.next()){ //Si el parametro buscado se encuentra en la base de datos
               conexionBD.desconectar(); //Se desconecta de la base de datos
               return true;
           }
           else{
               return false;
           }
       }
       catch (SQLException ex) {
                System.err.println("Base de datos no conectada");
                return false;
        }
   }
   public boolean registrarBD(){
        try{
            BaseDatos conexionBD = new BaseDatos();
            conexionBD.conectar();
            Statement stmt = conexionBD.crearConsulta();
            if(usuarioExistente(nombre) == false ){ //si el usuario no existe en la base de datos
                final String consulta = "INSERT INTO USUARIO (NOMBRE_USUARIO, CONTRASEÑA_USUARIO,PERSONAJE_PRINCIPAL,PERSONAJE_AMIGO,MALLA) VALUES ('"+nombre+"','"+contraseña+"','"+personajePrincipal+"','"+personajeAmigo+"','"+malla+"')";
               
                int resultado = stmt.executeUpdate(consulta); //Se ingresa en nombre, contraseña,personajePrincipal,personajeAmigo, malla
                conexionBD.desconectar();
                return true;
            }
            
       }
        catch(java.sql.SQLIntegrityConstraintViolationException e) {
            System.err.println("Usuario ya registrado");
                return false;
                }
        catch(java.sql.SQLException e) {
                System.err.println("BD no conectada");
                    return false;
            }
       return false;
   }
   
 
   
   public Boolean verificarSintaxis(String entrada) {
      String caracteresValidos = "[A-Za-z0-9]+";
      if (entrada.matches(caracteresValidos)){
        return true;
      }
      else{
        return false;
      }
   }
   
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setMalla(String malla) {
        this.malla = malla;
    }
   public int getDinero() {
        return dinero;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
  
    public ArrayList<Personaje> getEquipo() {
        return equipo;
    }

   
   public boolean verificarContrasenaBd(String contraseña) {
       if(this.contraseña.equals(contraseña)){
         return true;  
       }
   return false; 
   }
   
   public Personaje contratarPersonaje(String personaje, int dinero) {
   
      return null;
   }
   
    public String getPersonajePrincipal() {
        return personajePrincipal;
    }

    public void setPersonajePrincipal(String personajePrincipal) {
        this.personajePrincipal = personajePrincipal;
    }

    public String getPersonajeAmigo() {
        return personajeAmigo;
    }

    public void setPersonajeAmigo(String personajeAmigo) {
        this.personajeAmigo = personajeAmigo;
    }

    public ArrayList<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<String> getListaContraseñas() {
        return listaContraseñas;
    }

    public void setListaContraseñas(ArrayList<String> listaContraseñas) {
        this.listaContraseñas = listaContraseñas;
    }
   
   
   public void agregarUsuario(String nombre){
       this.listaUsuarios.add(nombre);
   }
   
   public void agregarContraseña(String contraseña){
       this.listaContraseñas.add(contraseña);
   }
   

   }

