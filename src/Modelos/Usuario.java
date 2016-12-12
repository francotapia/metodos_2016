
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
       Personaje personaje1 = new Personaje("benja","usuario","compañero","arquero","alumno",100,100,100,100,5,1,1,3,3,3,0,7);
       Personaje personaje2 = new Personaje("fabian","usuario","compañero","guerrero","alumno",100,100,100,100,5,1,1,3,3,3,0,7);
       Personaje personaje3 = new Personaje("mariely","usuario","compañero","guerrero","alumno",100,100,100,100,5,1,1,3,3,3,0,8);
       Personaje personaje4 = new Personaje("franco","usuario","compañero","arquero","alumno",100,100,100,100,5,1,1,3,3,3,0,7);
       Personaje personaje5 = new Personaje("mr_t","usuario","compañero","guerrero","alumno",150,110,110,110,6,1,1,3,3,3,0,10);
       equipo.add(personaje1);
       equipo.add(personaje2);
       equipo.add(personaje3);
       equipo.add(personaje4);
       equipo.add(personaje5);
    
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
                final String consulta2 = "UPDATE PERSONAJE SET TIPO_JUGADOR = 'usuario', ESTADO_PERSONAJE = 'principal',ROL_PERSONAJE = '"+personajePrincipal+"' WHERE ID_PERSONAJE = 2 ";
                int resultado2 = stmt.executeUpdate(consulta2); 
                final String consulta3 = "UPDATE PERSONAJE SET TIPO_JUGADOR = 'usuario', ESTADO_PERSONAJE = 'acompañante',ROL_PERSONAJE = '"+personajeAmigo+"' WHERE ID_PERSONAJE = 3 ";
                int resultado3 = stmt.executeUpdate(consulta3);
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
   
   public boolean obtenerPersonaje(String nombre) throws SQLException{
        BaseDatos conexionBD = new BaseDatos();
        conexionBD.conectar();//Se conecta con la base de datos
        Statement stmt = conexionBD.crearConsulta(); //Se establecen las consultas
        final String consulta = "SELECT PUNTOS_MOVIMIENTO,ROL_PERSONAJE,TIPO_PERSONAJE,NOMBRE_PERSONAJE,TIPO_JUGADOR,ESTADO_PERSONAJE,PUNTOS_VIDA,PUNTOS_DEFENSA,PUNTOS_ATAQUE_CORTO,PUNTOS_ATAQUE_LARGO,NIVEL,STOCK_ESPECIAL,STOCK_BAJO,STOCK_MEDIO,STOCK_ALTO,TRAICION FROM PERSONAJE WHERE (NOMBRE_PERSONAJE = '"+nombre+"')"; 
        ResultSet resultados = stmt.executeQuery(consulta); 
        if(resultados.next()){ //Si el parametro buscado se encuentra en la base de datos
            String nombrePersonaje = resultados.getString("NOMBRE_PERSONAJE");
            String rol = resultados.getString("ROL_PERSONAJE");
            String tipo = resultados.getString("TIPO_PERSONAJE");
            String tipoJugador = resultados.getString("TIPO_JUGADOR");
            String estado = resultados.getString("ESTADO_PERSONAJE");
            int vida = resultados.getInt("PUNTOS_VIDA");
            int defensa = resultados.getInt("PUNTOS_DEFENSA");
            int ataqueC = resultados.getInt("PUNTOS_ATAQUE_CORTO");
            int ataqueL = resultados.getInt("PUNTOS_ATAQUE_LARGO");
            int nivel = resultados.getInt("NIVEL");
            int stockE = resultados.getInt("STOCK_ESPECIAL");
            int stockB = resultados.getInt("STOCK_BAJO");
            int stockM = resultados.getInt("STOCK_MEDIO");
            int stockA = resultados.getInt("STOCK_ALTO");
            int traicion = resultados.getInt("TRAICION");
            int movimiento = resultados.getInt("PUNTOS_MOVIMIENTO");
            //Personaje personaje = new Personaje(nombrePersonaje,tipoJugador,estado,rol,tipo,vida,defensa,ataqueL,ataqueC,movimiento,nivel,stockE,stockB,stockM,stockA,traicion);
           //equipo.add(personaje);
            return true;
           }
        return false;
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

