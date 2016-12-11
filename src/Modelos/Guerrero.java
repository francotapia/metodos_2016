/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  Guerrero.java
 * Author:  franco
 * Purpose: Defines the Class Guerrero
 ***********************************************************************/

import java.util.*;

/** @pdOid 67af88a6-8ea9-409b-8269-8bf4010f2285 */
public class Guerrero extends Personaje {
   /** @pdOid 4bd59fb6-0568-42f5-84f2-185599003b19 */
   private int puntosMovimiento;
   private int ataqueLargo;
   private int rango=4;
   

    public Guerrero(String nombrePersonaje) {
        super(nombrePersonaje);
    }
   public String obtenerClase(){
       return "guerrero";
   }
       public int calcularDaño(int ataquePersonajeA, int defensaPersonajeD){
        int daño=ataquePersonajeA-defensaPersonajeD;
        daño=daño/4; //al ser guerrero se le hara un cuarto del daño
        if(daño<0){
        daño=0;}
        return daño;
        }
       
       
       
       
    
}