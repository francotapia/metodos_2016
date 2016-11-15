/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
/**
 *
 * @author franco
 */
public class AdivinaLaPalabra {
    
    private String palabra = "perro";

  
    private  int intentos;

    
    public AdivinaLaPalabra(int intentos){
        this.intentos = intentos;
    }
    ///Método que compara palabras////
    
    public boolean comparar(String palabra){
        
        if(this.palabra.equals(palabra)){
            return true;
        }
        return false;
       }
    
    public int disminuirIntentos(int intentos){
           this.intentos = intentos - 1 ;  
           System.out.println(this.intentos);
           return this.intentos;
       
   }
        
    
      public int getIntentos() {
        return intentos;
    }

       
    }

