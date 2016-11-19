/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Random;

/**
 *
 * @author franco
 */
public class AdivinaLaPalabra {
    private String[] listaPalabra = {"perro","auto","caballo","pantalon","manzana","gatito","canito123"};
    private  int intentos = 5;
    private String palabra;
    private String[] pistas;
    
    
   public int getIntentos() {
        return intentos; //valor de cantidad de intentos base
    }
   
    ///Método que compara palabras, para evaluar igualdad entre ellas////
    //Entrada: String
    //Salida: boolean
    
    public boolean comparar(String palabra){
        
        if(this.palabra.equals(palabra)){  //Si el atributo palabra es igual a la palabra ingresada, se retorna true.
            System.out.println(this.palabra);
            return true;
        }
        return false;
       }
    
    ////Método que disminuye la cantidad de intentos////
    //Entrada: -----------------------------
    //Salida: entero con intentos reducidos
    
    public int disminuirIntentos(){ 
           intentos = intentos - 1 ;   //Los intentos iniciales son iguales a los intentos disponibles menos una unidad.
           System.out.println(intentos); 
           return intentos; //Cantidad de intentos con una unidad menos
   }

  
    ////Método que busca una palabra al azar para poder jugar////
    //Entrada: -----------------------------
    //Salida: -----------------------------
    public void obtenerPalabra(){
        int tamañoLista = this.listaPalabra.length; //tamaño de la lista de palabras
        Random random = new Random(); //se instancia la clase Random
        int posicionAzar =random.nextInt(tamañoLista -1); //se obtiene una posición al azar
        this.palabra = listaPalabra[posicionAzar]; //se muestra palabra al azar
        System.out.println(palabra);

        
       
     }
    
 
   

       
    }
