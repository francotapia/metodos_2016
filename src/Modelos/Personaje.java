/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  Personaje.java
 * Author:  Maribel
 * Purpose: Defines the Class Personaje
 ***********************************************************************/

import java.util.*;

/** @pdOid d9f2219b-a6c8-4650-b6f8-08525e692b3a */
public class Personaje {

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getDueñoPersonaje() {
        return dueñoPersonaje;
    }
    
   private String dueñoPersonaje;
   private String nombrePersonaje;
   private int puntosVida;
   private int puntosMagia;
   private int puntosAtaqueCortos;
   private int puntosAtaqueLargo;
   private int puntoDefensa;
   private int puntoMovimiento ;
   private int puntoVelocidad;
   private String armamento;
   private int amistad;
   private int traicion;
   private String tipo;
   private String rol;
   private int rango;
   private int nivel;
   private int stockAtaque;  // 0 bajo, 1 medio, 2 alto,3 especial
   private int stockAtaqueAlto;
   private int stockAtaqueBajo;
   private int stockAtaqueMedio;
   private int stockAtaqueEspecial;
   private TipoDeEscenario tipoEscenario;
   private ArrayList<String> listaPersonaje ;
   private String estadoPersonaje;
   private int ataqueLargo;
   private int velocidad;
   
   public Personaje(String personaje){
        this.nombrePersonaje = personaje;
        puntoMovimiento = 0;
   }
    public Personaje(){
       

   }
    public Personaje (String nombrePersonaje,String tipoJugador,String estadoPersonaje,String rolPersonaje,String tipoPersonaje,int vida,int defensa,int ataqueLargo,int ataqueCorto,int movimiento,int nivel,int especial,int bajo,int medio,int alto,int traicion,int velocidad) {
        this.stockAtaqueAlto=alto;
        this.stockAtaqueMedio=medio;
        this.stockAtaqueBajo=bajo;
        this.stockAtaqueEspecial= especial;
        this.nivel=nivel;
        this.puntosAtaqueCortos=ataqueCorto;
        this.puntoDefensa=defensa;
        this.puntosVida=vida;
        this.nombrePersonaje=nombrePersonaje;
        this.tipo = tipoPersonaje;
        this.rol = rolPersonaje;
        this.dueñoPersonaje = tipoJugador;
        this.estadoPersonaje = estadoPersonaje;
        this.ataqueLargo = ataqueLargo;
        this.puntoMovimiento = movimiento;
        this.traicion = traicion;
        this.velocidad = velocidad;
        }


    public Personaje(int i){
        this.stockAtaqueAlto=i;
        this.stockAtaqueMedio=i;
        this.stockAtaqueBajo=i;
        this.stockAtaqueEspecial=i;
    }
    
   
    
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public int getPuntoMovimiento() {
        return puntoMovimiento;
    }

    public void setPuntoMovimiento(int puntoMovimiento) {
        this.puntoMovimiento = puntoMovimiento;
    }
    public int getNivel() {
        return nivel;
    }
     
    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getPuntosAtaqueCortos() {
        return puntosAtaqueCortos;
    }

    public void setPuntosAtaqueCortos(int puntosAtaqueCortos) {
        this.puntosAtaqueCortos = puntosAtaqueCortos;
    }

    public int getPuntosAtaqueLargo() {
        return puntosAtaqueLargo;
    }

    public void setPuntosAtaqueLargo(int puntosAtaqueLargo) {
        this.puntosAtaqueLargo = puntosAtaqueLargo;
    }

    public int getPuntoDefensa() {
        return puntoDefensa;
    }

    public void setPuntoDefensa(int puntoDefensa) {
        this.puntoDefensa = puntoDefensa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getListaPersonaje() {
        return listaPersonaje;
    }

    public int getStockAtaqueAlto() {
        return stockAtaqueAlto;
    }

    public int getStockAtaqueBajo() {
        return stockAtaqueBajo;
    }

    public int getStockAtaqueMedio() {
        return stockAtaqueMedio;
    }

    public int getStockAtaqueEspecial() {
        return stockAtaqueEspecial;
    }
    
   
   
   
   public Boolean almacenarPersonajeBd() {
      // TODO: implement
      return null;
   }
   

  //Este metodo unicamente cambia la posicion del personaje a la posicion final, no verifica.
  //Hay que terminar de pensar bien la recursion. 
   
 
   
  
   
    
   
   //
   
   
   public boolean aplicarDaño(int daño, int vida){
       int nuevaVida=vida-daño;
       if(nuevaVida<0){
       nuevaVida=0;
       }
       return true;
   }

   public Boolean equiparObjeto(Objeto objeto) {

      return null;
   }
   

   public Boolean quitarObjeto(String objetoEquipado) {

      return null;
   }
   
   /** @param ataqueAtacante 
    * @param defensaDefensor 
    * @param vidaDefensor
 */
   public int calcularDanoRecibido(int ataqueAtacante, int defensaDefensor, int vidaDefensor) {
 
      return 0;
   }
   
   /** @param personajeObjetivo
  */
   public Boolean seleccionarObjetivoAtaque(String personajeObjetivo) {
      // TODO: implement
      return null;
   }
   
   /** @param traicionActual 
    * @param tipo
 */
   public Boolean verificarTraicion(int traicionActual, Tipo tipo) {
      // TODO: implement
      return null;
   }
   
   /** @param dano
*/
   public Boolean generarDano(int dano) {
      // TODO: implement
      return null;
   }



    //Un simple set.

    
    public ArrayList<String> listaVelocidades(Personaje ListaPersonajes){
        ArrayList<String> OrdenVelocidades = new ArrayList<>();
        ArrayList<Personaje> ListaP= new ArrayList<>();
        ArrayList<String>ListaNombres= new ArrayList<>();
        int velocidadMaxima =0;
        ArrayList<Integer> ListaVelocidades = new ArrayList<>();
        
        
        int i;
        
        for(i=0; i < listaPersonaje.size(); i++){
            String pj = ListaP.get(i).getNombrePersonaje();
            ListaNombres.add(pj);
            //int velocidades= ListaP.get(i).getpuntoVelocidad;
            //ListaVelocidades.add(velocidades);
            
        }
        for(int j =0; j< ListaVelocidades.size(); j++){
            if (velocidadMaxima < ListaVelocidades.get(j)){
                int maximaVelocidad = j;
                OrdenVelocidades.add(ListaNombres.get(maximaVelocidad));
                ListaVelocidades.remove(maximaVelocidad);
              
            }
        }
       return OrdenVelocidades;
   
    }
    
    
    /*Calcula la distancia entre dos coordenadas especificas.[Esta distancia es especificamente para el ataque 
    ya que no forma un "circulo" alrededor de el personaje sino que funciona como un cuadrado */
    public int calcularDistanciaAtaque(ArrayList<Integer> posicionSeleccionada, ArrayList<Integer> posicionPersonajeA){
        int distancia;
        Integer xSeleccionado= posicionSeleccionada.get(0);
        Integer ySeleccionado= posicionSeleccionada.get(1);
        Integer x= posicionPersonajeA.get(0);
        Integer y= posicionPersonajeA.get(1);
        int diferenciaX=Math.abs(xSeleccionado-x);
        int diferenciaY=Math.abs(ySeleccionado-y);
        if(diferenciaX>diferenciaY){
            distancia=diferenciaX;
        }
        else{
            distancia=diferenciaY;}
        return distancia;}

    public int obtenerRango() {
        return rango;
    }

//////////////agregar en casilla////////////////////////////////
    

    //¡ESTO ES ESPECIFICAMENTE PARA EL ATAQUE, NO TIENE QUE VER CON EL MOVIMIENTO.
    public boolean validarPosicion(ArrayList<Integer> posicionSeleccionada, ArrayList<Integer> posicionPersonajeA, int rango){
        Integer xSeleccionado= posicionSeleccionada.get(0);
        Integer ySeleccionado= posicionSeleccionada.get(1);
        Integer x= posicionPersonajeA.get(0);
        Integer y= posicionPersonajeA.get(1);
        int diferenciaX=Math.abs(xSeleccionado-x);
        int diferenciaY=Math.abs(ySeleccionado-y);
        int numeroElegido;
        if(diferenciaX>diferenciaY){
            numeroElegido=diferenciaX;
        }
        else{
            numeroElegido=diferenciaY;
        }
        if (numeroElegido<=rango){
            return true;
        }
        else{
            return false;
        }
        }

///////////////////////////agregar en Personaje////////////////////
    
    //public void moverPersonaje(int puntosMovimiento, ArrayList<int[]> puntoInicio, ArrayList<int[]> puntoObjetivo) {
      //int contador = puntosMovimiento;
      //if (Casilla.movimientoCasilla(rango, rango) == false){ //método que rectifica si el movimiento es realizado de casilla
        //contador=contador-1;
        //posicion=puntoObjetivo;
        //System.out.println(contador);
      //}
    //}
//Esta funcion entrega el daño.
    public int calcularDaño(int ataquePersonajeA, int defensaPersonajeD){
        int daño=ataquePersonajeA-defensaPersonajeD;
        if(daño<0){
        daño=0;}
        return daño;
        }
    
    
    
    public boolean equals(Personaje obj){
        Personaje p = obj;
        return p.getNombrePersonaje().equals(this.nombrePersonaje);
    }
    

    public String getClase(){
        return "guerrero";
    }
    
    
    
    
}

        


