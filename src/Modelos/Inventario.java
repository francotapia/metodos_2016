/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  Inventario.java
 * Author:  franco
 * Purpose: Defines the Class Inventario
 ***********************************************************************/

import java.util.*;

/** @pdOid 20b091d7-485c-4a87-8d90-2bbf3035dbe6 */
public class Inventario {
   /** @pdOid ec08bb46-464a-483c-a816-56cfa3d4ddfd */
   private int largoMaximo;
   
   /** @pdRoleInfo migr=no name=Objeto assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Objeto> objeto;
   
   /** @param objetoComprado
    * @pdOid 436e92f5-c148-46a8-bfed-99799b9cc18a */
   public Boolean agregarObjetoComprado(String objetoComprado) {
      // TODO: implement
      return null;
   }
   
   /** @param objeto
    * @pdOid 2533492e-263c-4b35-9177-0ca7cddd9474 */
   public Boolean quitarObjeto(String objeto) {
      // TODO: implement
      return null;
   }
   
   /** @param dinero
    * @pdOid 625f85ce-471f-4d9c-9182-451570abe650 */
   public Boolean seleccionarObjetoReemplazar(int dinero) {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 75378264-7f06-4f76-9479-17740ff9f86e */
   public Boolean mostrarMoneda() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 9c21a532-cc52-48a2-be87-1fc96890f9d3 */
   public Boolean comprobarEspacio() {
      // TODO: implement
      return null;
   }
   
   /** @param precio
    * @pdOid 1ba48ea6-4366-430f-8f2b-f0b3aec7485d */
   public Boolean restarDinero(int precio) {
      // TODO: implement
      return null;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Objeto> getObjeto() {
      if (objeto == null)
         objeto = new java.util.HashSet<Objeto>();
      return objeto;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorObjeto() {
      if (objeto == null)
         objeto = new java.util.HashSet<Objeto>();
      return objeto.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newObjeto */
   public void setObjeto(java.util.Collection<Objeto> newObjeto) {
      removeAllObjeto();
      for (java.util.Iterator iter = newObjeto.iterator(); iter.hasNext();)
         addObjeto((Objeto)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newObjeto */
   public void addObjeto(Objeto newObjeto) {
      if (newObjeto == null)
         return;
      if (this.objeto == null)
         this.objeto = new java.util.HashSet<Objeto>();
      if (!this.objeto.contains(newObjeto))
         this.objeto.add(newObjeto);
   }
   
   /** @pdGenerated default remove
     * @param oldObjeto */
   public void removeObjeto(Objeto oldObjeto) {
      if (oldObjeto == null)
         return;
      if (this.objeto != null)
         if (this.objeto.contains(oldObjeto))
            this.objeto.remove(oldObjeto);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllObjeto() {
      if (objeto != null)
         objeto.clear();
   }

}