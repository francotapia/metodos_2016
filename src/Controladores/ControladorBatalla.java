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
    private int turno = 0;
    
   public ControladorBatalla(ArrayList<Personaje> usuario) {
        vb = new VistaBatalla();
        vb.agregarListener(this);
        vb.setVisible(true);
        batalla = new Batalla(usuario);
        tipoEsc = new TipoDeEscenario();
        personaje = new Personaje();
        batalla.getEscenario().asignarAlturasModuloBasico();
        batalla.getEscenario().posicionarPersonajeUsuario(batalla.getEquipoUsuario());
        batalla.getEscenario().posicionarPersonajeCpu(batalla.getEquipoCPU());
        batalla.agregarListasVelocidades();
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
                if(batalla.getEscenario().getMatrizCoordenada()[i][j].getPersonaje().getDueñoPersonaje() == "usuario"){
                    vb.marcarPosicion(i, j);
                }
                if(batalla.getEscenario().getMatrizCoordenada()[i][j].getPersonaje().getDueñoPersonaje() == "cpu"){
                    vb.marcarCpu(i, j);
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
            vb.getAtaqueL().setEnabled(true);
            vb.getMover().setEnabled(true);
            turno = turno + 1;
            System.out.println("turno :" + turno);
            vb.desactivarTablero();
        }
        
        if(vb.getMover() == (JButton)ae.getSource()){
            vb.activarTablero();
            vb.getMover().setEnabled(false);
            boton = 1;
        }
        
        if(vb.getAtaqueL() == (JButton)ae.getSource()){
            vb.activarTablero();
            vb.getAtaqueL().setEnabled(false);
            boton = 2;
        }
            

        for(int i = 0; i<25; i++){
            for(int j=0; j<25; j++){
                if(batalla.pasarTurno(turno)){
                    nombre = batalla.getListaOrdenada().get(turno).getNombrePersonaje();
                    
                  
                }
                 if(batalla.getEscenario().getMatrizCoordenada()[i][j].getPersonaje().getNombrePersonaje() == nombre ){
                   vb.getCasillas()[i][j].setBackground(Color.CYAN);
                    x = i;
                    y = j;
                   
                }
                
                if(boton == 1){
                    if(vb.getCasillas()[i][j]==(JButton)ae.getSource()){
                        if(batalla.getEscenario().getMatrizCoordenada()[x][y].getPersonaje().getPuntoMovimiento()>0){
                            int movimiento = batalla.getEscenario().getMatrizCoordenada()[x][y].getPersonaje().getPuntoMovimiento();
                            if(batalla.getEscenario().verificarPosicionLibre(i, j)){
                                if(batalla.getEscenario().moverDiferenciaAltura(i, j,x,y) ){
                                    if(batalla.getEscenario().getMatrizCoordenada()[i][j].getTipoEscenario().getMatrizTerreno()[i][j] != "rio"){
                                        if(batalla.getEscenario().moverCasilla(i, j,x,y,nombre)){                                   
                                            vb.pintarAlturas(x,y, batalla.getEscenario().getMatrizCoordenada()[x][y].getAltura());
                                            batalla.getEscenario().getMatrizCoordenada()[i][j].setPersonaje(batalla.getEscenario().getMatrizCoordenada()[x][y].getPersonaje());
                                            vb.marcarPosicion(i, j);
                                            batalla.getEscenario().getMatrizCoordenada()[i][j].getPersonaje().setPuntoMovimiento(movimiento - 1);
                                            batalla.getEscenario().getMatrizCoordenada()[x][y].setPersonaje(personaje = new Personaje(null));
                                            x = i;
                                            y = j;
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
                                batalla.atacarOponente(i, j, x, y);
                                System.out.println(batalla.getEscenario().getMatrizCoordenada()[i][j].getPersonaje().getPuntosVida());
                                 System.out.println(batalla.getEscenario().getMatrizCoordenada()[x][y].getPersonaje().getPuntosVida());
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