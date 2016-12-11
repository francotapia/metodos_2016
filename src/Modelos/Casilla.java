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
    private Personaje personaje;
    private TipoDeCasilla tipoCasilla;
    private TipoDeEscenario tipoEscenario;

    
   public Casilla(TipoDeEscenario tipoEscenario, Personaje personaje){
       this.personaje = personaje;
       coordenadaX = 0;
       coordenadaY = 0;  
       coordenada = new int[25][25];
       this.altura = 0;
       this.tipoEscenario = tipoEscenario;
       
       
       //this.tipoCasilla = casilla;
   }
   

    //Métodos get y set
     public Personaje getPersonaje() {
        return personaje;
    }
     public Personaje getPersonaje(String nombre) {
        return personaje;
    }
     

    public void setPersonaje(String nombre) {
        this.personaje = new Personaje(nombre);
 
    }
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    public TipoDeEscenario getTipoEscenario() {
        return tipoEscenario;
    }

    public void setTipoEscenario(TipoDeEscenario tipoEscenario) {
        this.tipoEscenario = tipoEscenario;
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
    
    public void setAltura(int altura) {
        this.altura = altura;
    }

       
    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }
   
   
  


    
    
     
   
   
   
  
  
   

  

}