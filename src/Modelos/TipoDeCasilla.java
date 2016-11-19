/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  TipoCasilla.java
 * Author:  franco
 * Purpose: Defines the Class TipoCasilla
 ***********************************************************************/

import java.util.*;


public class TipoDeCasilla {

   private int coordenadaFinal;
   private int tierra;
   private int monataña;
   private int rio;
   private int bosque;
   private int[] altura;
    
   
  public int[] rangoAlturaTierra(){
      altura = new int[5];
      for(int i = 0; i<5; i++){
          altura[i] = i;
      }
      return altura;
  }
   public int[] rangoAlturaMontaña(){
      altura = new int[5];
      for(int i = 0; i<5; i++){
          altura[i] = i;
      }
      return altura;
  }
   public int[] rangoAlturaRio(){
      altura = new int[10];
      for(int i = 0; i<10; i++){
          altura[i] = i;
      }
      return altura;
   }
   public int[] rangoAlturaBosque(){
      altura = new int[10];
      for(int i = 0; i<10; i++){
          altura[i] = i;
      }
      return altura;
   }
  
  

   public boolean determinarTerreno(Casilla casillas,int i) {
     
      return false;
   }
}

