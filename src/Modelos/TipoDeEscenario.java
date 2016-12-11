/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Maribel
 */
public class TipoDeEscenario {
    
    private String[][] matrizTerreno;
    private int contadorTierra;
    private int contadorMontaña;
    private TipoDeCasilla listaCasillas;
    private int[] numeros;
    private Escenario escenario;
    
    public TipoDeEscenario(){
        determinarTerrenoModuloBasico();
       
    }

    public String[][] getMatrizTerreno() {
        return matrizTerreno;
    }
    
      public String[][] determinarTerrenoModuloBasico() {
       int StockRio=78;
       int riosx[]=getNumeroRandom(0,24);  
       int riosy[]=getNumeroRandom(0,24); 
       matrizTerreno = new String[25][25];
       
        for (int i = 0; i < StockRio; i++) {
            matrizTerreno[riosx[i]][riosy[i]]="tierra";
            
        }
       
       int cantRio = 0;
       int cantTierra= 0;
       
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24; j++) {
                
                   if (matrizTerreno[i][j] ==  "tierra"){
                       matrizTerreno[i][j+1]= "tierra";  }
                   if ( matrizTerreno[i][j] != "tierra"){
		   matrizTerreno[i][j]= "rio";}
            }
        }
       
        
        for (int j = 0; j < 25; j++) {
            for (int k = 0; k < 25; k++) {
                if (matrizTerreno[j][k]!="rio"){ matrizTerreno[j][k]="tierra";}
                  
                    }}
        
            for (int k = 0; k < 25; k++) {
                for (int l = 0; l < 25; l++) {
                    
                if (matrizTerreno[k][l]=="rio"){cantRio++;}
                if (matrizTerreno[k][l]=="tierra"){cantTierra++;}

                    
                }
                
            }
            
       matrizTerreno[0][24]="tierra"; 
       matrizTerreno[24][0]="tierra";
       matrizTerreno[24][24]="tierra";
       matrizTerreno[0][0]="rio";
       return matrizTerreno;
  
   
    }

 public int[] getNumeroRandom(int min, int max){
       numeros = new int[78];
       for(int i = 0; i<78;i++){
       numeros[i] = ThreadLocalRandom.current().nextInt(min, max);
       
       }
       return numeros;
   }
}