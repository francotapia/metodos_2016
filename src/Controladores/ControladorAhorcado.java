/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Ahorcado;
import Vistas.VistaAhorcado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Benxamin
 */
public class ControladorAhorcado implements ActionListener {
    VistaAhorcado va;
    Ahorcado ah;
    
    public ControladorAhorcado(){
        ah=new Ahorcado(10);
        va = new VistaAhorcado();
        va.ActionListener(this);
        va.setVisible(true);
        String palabra=ah.elegirPalabra();
        ah.setPalabra(palabra);
        String espacios=ah.crearEspacios(palabra);
        ah.setEspacios(espacios);
        System.out.println(ah.getEspacios());
        va.setLabelNumeroIntentos(ah.getIntentos());
        va.setLabelPalabra(espacios);   
    }
        
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (va.getBtnIngresar() == (JButton)e.getSource()) {
            String letra = va.getEntradaPalabra();
            System.out.println(letra);
            String palabra = ah.getPalabra();
            boolean validacion= ah.validarLetra(letra);
            boolean verificacion = ah.verificarLetra(letra, palabra);
            if(validacion){
                if (verificacion){
                    ah.actualizarEspacios(letra, palabra,ah.getEspacios());
                    String espacios= ah.getEspacios();
                    va.setLabelPalabra(espacios);
                    System.out.println(espacios);
                    if(espacios.equals(palabra)){
                        va.mostrarVentanaVictoria(palabra);
                        System.out.println("La palabra es:"+palabra);
                        System.out.println("Ganaste!");
                        ah.setIntentos(0);
                        }
                }
                else {
                    System.out.println("Letra incorrecta.");
                    ah.setIntentos(ah.getIntentos()-1);
                    va.setLabelNumeroIntentos(ah.getIntentos());
                    System.out.println("Intentos restantes:"+ah.getIntentos());
                    if(ah.getIntentos()==0){
                        va.mostrarVentanaFallo();
                        System.out.println("Perdiste!");
                        ControladorBiblioteca vb = new ControladorBiblioteca();
                    }
                }
            }
            else{System.out.println("Entrada invalida.");
            va.mostrarEntradaInvalida();
            }
            
        }
    }
}
