/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ActividadUsuario.ActividadUsuario;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Maribel
 */
public class ControladorBatalla implements MouseListener {
        
    private VistaBatalla vb;
    private Personaje personaje;
    private Batalla batalla;
    private Casilla casilla;
    private TipoDeEscenario tipoEsc; 
    private int boton = 0;
    private int x;
    private int y;
    private String nombre;
    
    ControladorBatalla() {
        vb = new VistaBatalla();
        vb.agregarListener(this);
        vb.setVisible(true);
        batalla = new Batalla();
        tipoEsc = new TipoDeEscenario();
        personaje = new Personaje();
        batalla.getEscenario().asignarAlturasModuloBasico();
        batalla.getEscenario().posicionarPersonaje(batalla.getPersonajesVivosJugador());
        dibujarEscenario();
        vb.desactivarTablero();
    }
    
    
    public void dibujarEscenario(){
        
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                int altura = batalla.getEscenario().getMatrizCoordenada()[i][j].getAltura();
                vb.pintarAlturas(i, j, altura);
                if(batalla.getEscenario().getMatrizCoordenada()[i][j].getTipoEscenario().getMatrizTerreno()[i][j] == "rio"){
                    vb.marcarRio(i, j);
                    }
                if(batalla.getEscenario().getMatrizCoordenada()[i][j].getPersonaje().getNombrePersonaje() != null){
                    vb.marcarPosicion(i, j);
                }
            } 
        }
    }
    


    @Override
    public void mouseClicked(MouseEvent ae) {
        
           if(vb.getAtaqueC() == (JButton)ae.getSource()){
            ControladorCombateCorto corto = new ControladorCombateCorto();
            ActividadUsuario.actividadUsuario("Usuario realiza ataque a corta distancia con " + personaje.getNombrePersonaje());
            vb.desactivarBotonAtaqueCorto();
        }
        if(vb.getVolver() == (JButton)ae.getSource()){
            ControladorMenuPrincipal cm = new ControladorMenuPrincipal();
            vb.setVisible(false);
         }
        
        if(vb.getPasar() == (JButton)ae.getSource()){
            vb.desactivarTablero();
        }
        
        if(vb.getMover() == (JButton)ae.getSource()){
            vb.activarTablero();
            boton = 1;
        }
        
        if(vb.getAtaqueL() == (JButton)ae.getSource()){
            vb.activarTablero();
            boton = 2;
        }
            

        for(int i = 0; i<25; i++){
            for(int j=0; j<25; j++){
                if(batalla.getEscenario().getMatrizCoordenada()[i][j].getPersonaje().getNombrePersonaje() == "1" ){
                   nombre = "1";
                   vb.getCasillas()[i][j].setBackground(Color.CYAN);
                    x = i;
                    y = j;
                   
                }
                if(boton == 1){
                    if(vb.getCasillas()[i][j]==(JButton)ae.getSource()){
                        if(personaje.getPuntoMovimiento()>0){
                            if(batalla.getEscenario().verificarPosicionLibre(i, j)){
                                if(batalla.getEscenario().moverDiferenciaAltura(i, j,x,y) ){
                                    if(batalla.getEscenario().getMatrizCoordenada()[i][j].getTipoEscenario().getMatrizTerreno()[i][j] != "rio"){
                                        if(batalla.getEscenario().moverCasilla(i, j,x,y,nombre)){                                    
                                            batalla.getEscenario().getMatrizCoordenada()[x][y].getPersonaje().setNombrePersonaje(null);
                                            vb.pintarAlturas(x,y, batalla.getEscenario().getMatrizCoordenada()[x][y].getAltura());
                                            batalla.getEscenario().getMatrizCoordenada()[i][j].setPersonaje(nombre);
                                            vb.marcarPosicion(i, j);
                                            personaje.setPuntoMovimiento(personaje.getPuntoMovimiento()-1);
                                        }
                                    }
                                }
                            }
                        }     
                   } 
                }
                
                if(boton == 2){
                    if(vb.getCasillas()[i][j] == (JButton)ae.getSource()){
                        if(batalla.calcularDistanciaAtaque(i, j, x, y)){
                            if(batalla.casillaDesocupada(i, j)){
                                System.out.println("atacar");
                            }
                            
                        }
                    }
                }
            }
        }  
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j <25; j++) {
              
                
            }
  
        }
           
      
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
       
    }
}