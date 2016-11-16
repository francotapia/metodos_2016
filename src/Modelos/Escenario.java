/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Maribel
 */
public class Escenario {
    private int Ancho;
    private int Largo;
    private int[][] coordenada;
    private Casilla casilla;
    private TipoDeEscenario tipoEscenario;
    private TipoDeCasilla tipoCasilla;
    
    
     public int[][] mostrarCoordenadas() {
        coordenada = new int[25][25];
        for(int i=0; i<25;i++){
            for(int j=0; j<25;j++){
                coordenada = new int[i][j];
            }
            
        }
        return coordenada;
    }
    
}
