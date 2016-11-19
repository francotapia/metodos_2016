/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Batalla;
import Modelos.Casilla;
import Modelos.Escenario;
import Modelos.Personaje;
import Modelos.TipoDeEscenario;
import Vistas.VistaBatalla;
import java.awt.Color;
import static java.awt.Color.black;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Maribel
 */
public class ControladorBatalla implements ActionListener {
        
    private VistaBatalla vb;
    private Escenario escenario;
    private Personaje personaje;
    private Batalla batalla;
    private Casilla casilla;
    private TipoDeEscenario tipoEsc; 
    
    ControladorBatalla() {
        vb = new VistaBatalla();
        batalla = new Batalla();
        escenario = new Escenario();
        personaje = new Personaje();
        casilla =  new Casilla();
        tipoEsc = new TipoDeEscenario();
        vb.agregarListener(this);
        vb.setVisible(true);
        vb.desactivarTablero();
    }
    
    
     
    public void actionPerformed(ActionEvent ae) {
        
        if(vb.getVolver() == (JButton)ae.getSource()){
            ControladorMenuPrincipal cm = new ControladorMenuPrincipal();
            vb.setVisible(false);
         }
        
        if(vb.getPasar() == (JButton)ae.getSource()){
            vb.desactivarTablero();
        }
       
        for(int i = 0; i<25; i++){
            for(int j=0; j<25; j++){
                if(vb.getMover() == (JButton)ae.getSource()){
                    vb.activarTablero();
                    if(escenario.getDisponibilidadPosicion()[i][j] == 1){
                        vb.marcarPosicion(i, j);
                        if(casilla.movimientoCasilla(i, j)){
                            if(personaje.moverPersonaje(5, i, j)){
                            }
                        }  
                    }  
                     
                }
                if(vb.getCasillas()[i][j]==(JButton)ae.getSource()){
                    vb.activarTablero();
                    System.out.println(+i+","+j +"," +escenario.getAltura()[i][j]);
                    System.out.println(tipoEsc.getMatrizTerreno()[i][j]);     
                           
                    vb.marcarPosicion(i, j);
                }
            }
        }   
    }
}