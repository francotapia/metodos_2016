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
    
   private int[][] listaPersonaje;
   private int[][] disponibilidadPosicion;
   private int puntosVida;
   private int puntosMagia;
   private int puntosAtaqueCortos;
   private int puntosAtaqueLargo;
   private int puntoDefensa;
   private int puntoMovimiento;
   private int puntoVelocidad;
   private String armamento;
   private int amistad;
   private int traicion;
   private Tipo tipo;
   private int rango;
   private int[][] posicion;
   private int nivel;
   private int[] stockAtaque;  // 0 bajo, 1 medio, 2 alto,3 especial
   private int[] stockAtaqueAlto;
   private int[] stockAtaqueBajo;
   private int[] stockAtaqueMedio;
   private int[] stockAtaqueEspecial;
   private int posicionX;
   private int posicionY;
   private Escenario escenario;
   
   public Personaje(){
    escenario = new Escenario();
   }
   

    
    
 
   
   
   public Boolean almacenarPersonajeBd() {
      // TODO: implement
      return null;
   }
   

  //Este metodo unicamente cambia la posicion del personaje a la posicion final, no verifica.
  //Hay que terminar de pensar bien la recursion. 
   
   public boolean moverPersonaje(int puntosMovimiento, int x,int y) {
      if(puntosMovimiento > 0){
          this.puntoMovimiento-=1;
          escenario.getDisponibilidadPosicion()[x][y] = 1;
          escenario.getDisponibilidadPosicion()[posicionX][posicionY] = 0;
          return false;
      }
      else if(puntosMovimiento <= 0){
          return true;
      }
    
    
      return true;
   }
   
   
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


//Método que entrega una matriz con las casillas ocupadas
    public int[][] obtenerPosicion() {
        listaPersonaje = new int[25][25];
        disponibilidadPosicion = new int[25][25];
        for(int i =0; i<25;i++){
            for(int j= 0;j<25; j++){
            if(listaPersonaje[i][j] != 0){
                disponibilidadPosicion[i][j] = 1; //se indica esa posicion se encuentra ocupada
                }
            }
        }
        return disponibilidadPosicion;
    }
    //Un simple set.
    public void setPosicion(int[][] posicion) {
        this.posicion = posicion;
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
}

        


