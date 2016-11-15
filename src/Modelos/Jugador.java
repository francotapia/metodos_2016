/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  Jugador.java
 * Author:  franco
 * Purpose: Defines the Class Jugador
 ***********************************************************************/

import java.util.*;

/** @pdOid cf236ec8-8ff4-40b2-9dfa-3fbb7f2d5a0e */
public class Jugador {
   /** @pdRoleInfo migr=no name=Inventario assc=association3 mult=1..1 type=Aggregation */
   public Inventario inventario;
   /** @pdRoleInfo migr=no name=Personaje assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Personaje> personaje;
   
   /** @pdOid 5148762f-cc63-4f86-9ceb-6463dc4a2584 */
   public void getNivel() {
      // TODO: implement
   }
   
   /** @pdOid 97b29299-9441-4839-aa70-9875fea83867 */
   public Boolean validadMovimiento() {
      // TODO: implement
      return null;
   }
   
   /** @param tipoAtaque
    * @pdOid f6d37dc1-5ef5-400a-8d7b-7b2b0c890a84 */
   public String obtenerAtaque(String tipoAtaque) {
      // TODO: implement
      return null;
   }
   
   /** @param ataque
    * @pdOid da24bc5b-66bb-47bb-a9ec-01a5cedec6c4 */
   public int danar(String ataque) {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 8bcadf00-cb1a-4da7-978d-185da243f6ee */
   public int generarMovimiento() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Personaje> getPersonaje() {
      if (personaje == null)
         personaje = new java.util.HashSet<Personaje>();
      return personaje;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPersonaje() {
      if (personaje == null)
         personaje = new java.util.HashSet<Personaje>();
      return personaje.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPersonaje */
   public void setPersonaje(java.util.Collection<Personaje> newPersonaje) {
      removeAllPersonaje();
      for (java.util.Iterator iter = newPersonaje.iterator(); iter.hasNext();)
         addPersonaje((Personaje)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPersonaje */
   public void addPersonaje(Personaje newPersonaje) {
      if (newPersonaje == null)
         return;
      if (this.personaje == null)
         this.personaje = new java.util.HashSet<Personaje>();
      if (!this.personaje.contains(newPersonaje))
         this.personaje.add(newPersonaje);
   }
   
   /** @pdGenerated default remove
     * @param oldPersonaje */
   public void removePersonaje(Personaje oldPersonaje) {
      if (oldPersonaje == null)
         return;
      if (this.personaje != null)
         if (this.personaje.contains(oldPersonaje))
            this.personaje.remove(oldPersonaje);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPersonaje() {
      if (personaje != null)
         personaje.clear();
   }

}