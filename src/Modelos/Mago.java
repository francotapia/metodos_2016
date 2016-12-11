/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  Mago.java
 * Author:  franco
 * Purpose: Defines the Class Mago
 ***********************************************************************/
import java.util.*;

/** @pdOid b1259be4-3038-4699-b24c-b7f70f6992d2 */
public class Mago extends Personaje {
   /** @pdOid abe47136-4287-465d-bd81-0bc7d647ba53 */
   private int puntosMovimiento;
   /** @pdOid 57401b39-c713-4b85-bd25-7ed1d56afe33 */
   private int puntosAtaqueMagico=20;
   private int rango=7;

    public Mago(String nombrePersonaje) {
        super(nombrePersonaje);
    }
   
   /** @param parameter1
    * @pdOid ba4e1bba-520e-47f9-be73-4672b8654e6c */
   public int lanzarHechizo(int parameter1) {
      // TODO: implement
      return 0;
   }

   public String obtenerClase(){
       return "mago";
   }
}

