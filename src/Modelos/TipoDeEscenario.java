/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Random;

/**
 *
 * @author Maribel
 */
public class TipoDeEscenario {
    
    private int contadorTierra;
    private int contadorMontaña;
    private TipoDeCasilla listaCasillas;
    
    
    public int proporcionPlanComun(){
        int numero;
        if(contadorTierra <3 && contadorMontaña == 0){
            contadorTierra+=1;
            numero = 1;  //terreno de tierra
        }
        else if(contadorTierra == 3 && contadorMontaña == 0){
            contadorTierra = 0;
            contadorMontaña+=1;
            numero = 2; //terreno de montaña
        }
        else{
            contadorMontaña = 0;
            numero = 1;
        }
        return numero;
    }
}
