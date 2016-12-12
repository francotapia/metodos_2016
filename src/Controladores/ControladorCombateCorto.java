/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Batalla;
import Modelos.Personaje;
import Vistas.VistaCombateCortoRango;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class ControladorCombateCorto implements ActionListener {
    
    private VistaCombateCortoRango vCombateCorta;
    private Batalla batalla;
    private Personaje personaje;
    private Personaje personajeEnemigo;
    private ArrayList<String> secuenciaAtaques = new ArrayList<>();
            
    public ControladorCombateCorto(){
          personaje = new Personaje("benja","usuario","compañero","arquero","alumno",100,100,100,100,5,1,1,3,3,3,0,7);
          personajeEnemigo = new Personaje("fabian","usuario","compañero","guerrero","alumno",100,100,100,100,5,1,1,3,3,3,0,7);
            vCombateCorta = new VistaCombateCortoRango();
            vCombateCorta.agregarListener(this);
            batalla = new Batalla();
    //        personaje = new Personaje(3,5,100,10,50);
    //        personajeEnemigo = new Personaje(2,3,80,10,30);
            int cantidadAtaquesVisibles = batalla.calcularAtaquesVisibles(personaje,personajeEnemigo);
            ArrayList<String> secuenciaCPU = batalla.solicitarSecuenciaAtaquesCPU(personajeEnemigo);
            batalla.setSecuenciaCPU(secuenciaCPU);
            String listaCPU = batalla.obtenerListaAtaquesStringCPU(secuenciaCPU,cantidadAtaquesVisibles);
            System.out.println(listaCPU);
            vCombateCorta.setLabelSecuenciaCPU(listaCPU);
            vCombateCorta.setVisible(true);
            }

  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vCombateCorta.getBotonAlto() == (JButton)e.getSource()){
            if (secuenciaAtaques.size()<7) {
                boolean valor = (batalla.solicitarSecuenciaAtaques(personaje, secuenciaAtaques, "alto"));
                if(false==valor){
                    vCombateCorta.mostrarVentanaAtaqueInsuficiente();  
                }
                else{
                    vCombateCorta.setSecuenciaElegida(batalla.obtenerListaAtaquesString());
                }
                
            }
            else{
                vCombateCorta.mostrarVentanaListaCompleta();
            }
        }
        if (vCombateCorta.getBotonMedio()==(JButton)e.getSource()) {
            if (secuenciaAtaques.size()<7) {
                boolean valor = (batalla.solicitarSecuenciaAtaques(personaje, secuenciaAtaques, "medio"));
                if(false==valor){
                    vCombateCorta.mostrarVentanaAtaqueInsuficiente();  
                }
                else{
                    vCombateCorta.setSecuenciaElegida(batalla.obtenerListaAtaquesString());
                }
            }
            else{
                vCombateCorta.mostrarVentanaListaCompleta();
            }
        }
        if (vCombateCorta.getBotonBajo()==(JButton)e.getSource()){
            if (secuenciaAtaques.size()<7) {
                boolean valor = (batalla.solicitarSecuenciaAtaques(personaje, secuenciaAtaques, "bajo"));
                if(false==valor){
                    vCombateCorta.mostrarVentanaAtaqueInsuficiente();  
                }
                else{
                    vCombateCorta.setSecuenciaElegida(batalla.obtenerListaAtaquesString());
                }
            }
            else{
                vCombateCorta.mostrarVentanaListaCompleta();
            }
           
        }
        if (vCombateCorta.getBotonEspecial()==(JButton)e.getSource()) {
            if (secuenciaAtaques.size()<7) {
                boolean valor = (batalla.solicitarSecuenciaAtaques(personaje, secuenciaAtaques, "especial"));
                if(false==valor){
                    vCombateCorta.mostrarVentanaAtaqueInsuficiente();  
                }
                else{
                    vCombateCorta.setSecuenciaElegida(batalla.obtenerListaAtaquesString());
                }
            }
            else{
                vCombateCorta.mostrarVentanaListaCompleta();
            }
           
        }
       
        if (vCombateCorta.getBtnOk()==(JButton)e.getSource()) {
            if (batalla.getSecuenciaAtaques().size()<7) {
                vCombateCorta.mostrarVentanaSecuenciaIncompleta();
            }
            else{
                int[] comparaciones = batalla.compararSecuenciaAtaques(secuenciaAtaques, batalla.getSecuenciaCPU());
                String resultado = "";
                int i = 0;
                while (i<7){
                    if (comparaciones[i]==0) {
                        resultado=resultado+"Gana Jugador /";
                    }
                    else if (comparaciones[i]==1) {
                        resultado=resultado+"Gana CPU /";
                    }
                    else{
                        resultado=resultado+"Empate /";
                    }
                    i++;
                }
                ArrayList<Integer> dañoPersonajeJugador = batalla.modificarVida(personaje, personajeEnemigo, comparaciones);
                ArrayList<Integer> dañoPersonajeCPU = batalla.modificarVidaCPU(personajeEnemigo, personaje, comparaciones);
                String mensajeDañosJugador = "Los daños recibidos por personaje del jugador son: " + batalla.obtenerDañosDeListaModificaciones(dañoPersonajeJugador)+"\n";
                String mensajeDañosCPU = "Los daños recibidos por personaje de la CPU son: " + batalla.obtenerDañosDeListaModificaciones(dañoPersonajeCPU)+"\n";
                String mensajeVidaJugador ="La vida restante del personaje del jugador es: " + batalla.obtenerStringVidaFinalListaModificaciones(dañoPersonajeJugador)+"/"+String.valueOf(personaje.getPuntosVida())+"\n";
                String mensajeVidaCPU = "La vida restante del personaje de la CPU es: " + batalla.obtenerStringVidaFinalListaModificaciones(dañoPersonajeCPU)+"/"+String.valueOf(personajeEnemigo.getPuntosVida())+"\n";
                vCombateCorta.mostrarVentanaFinal(resultado+"\n"+mensajeDañosJugador+mensajeDañosCPU+mensajeVidaJugador+mensajeVidaCPU, "Resultados");
                personaje.setPuntosVida(dañoPersonajeJugador.get(7));
                personajeEnemigo.setPuntosVida(dañoPersonajeCPU.get(7));
                System.out.println(personaje.getPuntosVida());
                System.out.println(personajeEnemigo.getPuntosVida());
            }
            
        }
    }
}
