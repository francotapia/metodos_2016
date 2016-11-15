/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  Batalla.java
 * Author:  franco
 * Purpose: Defines the Class Batalla
 ***********************************************************************/

import java.util.*;

/** @pdOid f9b0b4a4-39d7-4807-8436-508c8faaab7f */
public class Batalla {
   /** @pdOid 486a58ea-79e4-41f6-9151-1a231a88e790 */
   private ArrayList<Personaje> personajesVivos;
   
   /** @pdRoleInfo migr=no name=Escenario assc=association1 mult=1..1 */
   public Escenario escenario;
   /** @pdRoleInfo migr=no name=Jugador assc=association2 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Jugador> jugador;
   
   /** @param puntoInicio
    * @pdOid 23704036-8dda-4369-b3d8-3d0bdfd55120 */
   public int calcularDistanciaAtaque(int puntoInicio) {
      // TODO: implement
      return 0;
   }
   
   /** @param puntoInicio
    * @pdOid 0613186e-b15c-4af6-a729-63b399f29d57 */
   public int calcularDistanciaMovimiento(int puntoInicio) {
      // TODO: implement
      return 0;
   }
   
   /** @param bool
    * @pdOid dc7c8334-66a0-4b28-b44a-d847c17a2321 */
   public Boolean sumarTraicion(java.lang.Boolean bool) {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 1adbfd9c-b921-4515-abae-25febb2c2294 */
   public Boolean asignarTurnos() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 72bf33a0-fdb6-4299-95f5-6a46ad5414a7 */
   public Boolean alternarTurnos() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 6447d48a-51ae-4200-8a99-39390283bda3 */
   public Personaje crearListaPersonajesVivos() {
      // TODO: implement
      return null;
   }
   
   /** @param listaPersonajes
    * @pdOid 865fdf33-3746-40e5-93ca-603ef2e80b1c */
   public Personaje modificarListaPersonajesVivos(Personaje listaPersonajes) {
      // TODO: implement
      return null;
   }
   
   /** @param listaPersonajeVivo
    * @pdOid eefe6fd7-44c0-4b3b-a222-6fd629e94eb5 */
   public Boolean determinarGanador(Personaje listaPersonajeVivo) {
      // TODO: implement
      return null;
   }
   
   /** @param personaje
    * @pdOid 2d193403-5c84-484a-af36-1f4df2602ed5 */
   public int solicitarMovimientos(Personaje personaje) {
      // TODO: implement
      return 0;
   }
   
   /** @param personaje
    * @pdOid f3a852ef-a9d7-40d8-a867-502c17a524c7 */
   public int solicitarNivel(Personaje personaje) {
      // TODO: implement
      return 0;
   }
   
   /** @param movmoentoMaquina 
    * @param nivelMaquina 
    * @param nivelUsuario
    * @pdOid 19bfe872-55ef-4c3d-8ff7-be8f1d6af97e */
   public Boolean generarAtaquesVisibles(int movmoentoMaquina, int nivelMaquina, int nivelUsuario) {
      // TODO: implement
      return null;
   }
   
   /** @param personaje 
    * @param ataque
    * @pdOid c92e09b0-36f8-4fb3-a9f8-a11dba0cba30 */
   public Boolean atacar(Personaje personaje, int ataque) {
      // TODO: implement
      return null;
   }
   
   public void ataqueCortoRango(Personaje primerPersonaje, Personaje segundoPersonaje){
        //Cada ataque ganado le quita vida al oponente.
        //Cada rol de personaje quita cierto porcentaje pero el nivel y los objetos no alteran los valores.
        int primeraBarraVida;
        int segundaBarraVida;
       
        /*
        solicitarSecuenciaAtaques(Personaje); Esta retorna una arraylist con los ataques. 
        calcularSecuenciaAtaquesCPU(Personaje); Esta retorna una arraylist con los ataques.
       
        calcularAtaquesVisibles();
        compararSecuanciaAtaques(ArrayList, ArrayList) //Va a tener un ciclo dentro que recorra ambas listas de secuencias. 
        //Este metodo tiene una lista de booleanos y por cada comparacion agrega un valor a la lista, devuelve esa lista y 
        //y luego la vista los muestra de a uno. 
        
        modificarVida(Personaje (rol)); k= guerrero 4, arquero 3, ninja 2, mago 1. Cada ataque quita k*x%. 
        Devuelve una lista con ints.
        
        recibirDañoTotal(daño de la vista)
        
       
       
      
        
        */      
   
   }
   
   
   

}
