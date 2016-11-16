/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  Usuario.java
 * Author:  franco
 * Purpose: Defines the Class Usuario
 ***********************************************************************/

import java.util.*;


public class Usuario extends Jugador {
 
   private String nombre = "franco";

   private String contraseña = "franco";

   private String equipo;

   private ArrayList<Personaje> listaContratos;
   
   private ArrayList<String> ramosCursados;
   
   private String malla;
   
   
   public Boolean verificarSintaxis() {

      return null;
   }
   
  
   public boolean verificarNombreBd(String nombre) {
       if(this.nombre.equals(nombre)){
           return true;
       }
      return false;
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
   

   }

