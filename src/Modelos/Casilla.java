/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/***********************************************************************
 * Module:  Casilla.java
 * Author:  franco
 * Purpose: Defines the Class Casilla
 ***********************************************************************/

public class Casilla {


   
    private int altura;
    private int[][] coordenada;
    private int coordenadaX;
    private int coordenadaY;
    private TipoDeCasilla tipoCasilla;
    private Personaje personajePosicionado;

    
   public Casilla(int coordenadaX, int coordenadaY,int altura){
       this.altura = altura;
       this.coordenadaX = coordenadaX;
       this.coordenadaY = coordenadaY;
       
       
       //this.tipoCasilla = casilla;
   }
    //Métodos get y set

    public Casilla() {
        
    }
    

   

    
    public int[][] getCoordenada(){
        return coordenada;
    }
    
    public void setCoordenada(int[][] coordenada) {
        this.coordenada = coordenada;
    }
    
    public int getAltura() {
        return altura;
    }

       
    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }
   
   
     /**
     * Metodo que entrega una matriz de enteros, donde cada posicion es 0
     * @return int[][] Retorna una lista de listas de enteros.
     */
  
    
    public int  crearAltura(){
       return 1;
    }
    public boolean movimientoCasilla(int i, int j) { //metodo que comprueba si el movimiento realizado corresponde a una distacia de casilla
     	int filaA = Math.abs(i - coordenadaX);
     	int columnaA = Math.abs(j - coordenadaY);
     	if (filaA == 1){ //verificar si se ha movido una casilla
        	 return true;
     	}
    	 else if (columnaA == 1){ //verificar si se ha movido una casilla
            return true;
     	}
      	return false;
    }
    
    
     
   //Verifica si la posicion esta vacia (true) o no (false).
 
    

    /*public int compararAltura(Casilla primeraCasilla, Casilla segundaCasilla) {
        int primeraAltura = primeraCasilla.getAltura();
        int segundaAltura = segundaCasilla.getAltura();
        int diferenciaAltura;
        if (primeraAltura>segundaAltura){        
            diferenciaAltura = primeraAltura - segundaAltura;}
        else {
            diferenciaAltura = segundaAltura - primeraAltura;}
        return diferenciaAltura;
    }*/
   
   
  
  
   

  

}