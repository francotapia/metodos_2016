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
   
   
   
    public int[][] mostrarCoordenadas() {
        coordenada = new int[25][25];
        for(int i=0; i<25;i++){
            for(int j=0; j<25;j++){
                coordenada = new int[i][j];
                
            }
            
        }
        return coordenada;
    }
   
   //Verifica si la posicion esta vacia (true) o no (false).
    public Boolean verificarPosicionOcupada(int posicionObjetivo, Personaje[] listaPersonajes) {
        for(Personaje personaje:listaPersonajes){
            int[][] posicion = personaje.obtenerPosicion();
            if(posicion.equals(posicionObjetivo)){
                 return false;} //Apenas se cumple esta condicion retorna un false y detiene la funcion.
        }
        return true;
    }

    
    public Boolean distanciaCasillas(int[][] coordenadaActual, int[][] coordenadaFinal) {
        return null;
    }

    public int compararAltura(Casilla primeraCasilla, Casilla segundaCasilla) {
        int primeraAltura = primeraCasilla.getAltura();
        int segundaAltura = segundaCasilla.getAltura();
        int diferenciaAltura;
        if (primeraAltura>segundaAltura){        
            diferenciaAltura = primeraAltura - segundaAltura;}
        else {
            diferenciaAltura = segundaAltura - primeraAltura;}
        return diferenciaAltura;
    }
   
   
  
  
   

  

}