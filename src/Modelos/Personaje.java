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
   
   
   
   
   public Boolean almacenarPersonajeBd() {
      // TODO: implement
      return null;
   }
   

  //Este metodo unicamente cambia la posicion del personaje a la posicion final, no verifica.
  //Hay que terminar de pensar bien la recursion. 
   public int[][] moverPersonaje(int puntosMovimiento, int[][] puntoInicio, int[][] puntoObjetivo) {
      int contador = puntosMovimiento;
    
      return null;
   }
   
   
   //
   public boolean aplicarDaño(int daño, int vida){
       int nuevaVida=vida-daño;
       if(nuevaVida<0){
       nuevaVida=0;
       }
       return true;
   }
   /** @param objeto
    * @pdOid 21087316-493a-48ae-bb01-aab28ffd3016 */
   public Boolean equiparObjeto(Objeto objeto) {
      // TODO: implement
      return null;
   }
   
   /** @param objetoEquipado
    * @pdOid 751a23f4-f79a-48e9-8abf-38d29840e8fe */
   public Boolean quitarObjeto(String objetoEquipado) {
      // TODO: implement
      return null;
   }
   
   /** @param ataqueAtacante 
    * @param defensaDefensor 
    * @param vidaDefensor
    * @pdOid 9a236967-06c9-4646-891b-33502775de81 */
   public int calcularDanoRecibido(int ataqueAtacante, int defensaDefensor, int vidaDefensor) {
      // TODO: implement
      return 0;
   }
   
   /** @param personajeObjetivo
    * @pdOid 29db8cd3-b20b-494f-88ec-6a45934135eb */
   public Boolean seleccionarObjetivoAtaque(String personajeObjetivo) {
      // TODO: implement
      return null;
   }
   
   /** @param traicionActual 
    * @param tipo
    * @pdOid 9504eb66-42b5-485d-b807-890d53d5231c */
   public Boolean verificarTraicion(int traicionActual, Tipo tipo) {
      // TODO: implement
      return null;
   }
   
   /** @param dano
    * @pdOid 85ff5424-ded1-492d-886b-8558a59e5152 */
   public Boolean generarDano(int dano) {
      // TODO: implement
      return null;
   }


//Entrega el arreglo de coordenadas.
    public int[][] obtenerPosicion() {
        return posicion;
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
    public Boolean movimientoCasilla(int i, int j) { //metodo que comprueba si el movimiento realizado corresponde a una distacia de casilla
        int coordenadaX = 0;
     	int filaA = Math.abs(i - coordenadaX);
       int coordenadaY = 0;
     	int columnaA = Math.abs(j - coordenadaY);
     
     	if (filaA == 1){ //verificar si se ha movido una casilla
        	 return true;
     	}
    	 else if (columnaA == 1){ //verificar si se ha movido una casilla
         return true;
     	}
      	return false;
   }
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

        


