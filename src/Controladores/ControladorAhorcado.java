/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Ahorcado;
import Vistas.VistaAhorcado;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Benxamin
 */
public class ControladorAhorcado {
    
    
    public ControladorAhorcado(){
        Ahorcado ah = new Ahorcado();
        String palabra=ah.elegirPalabra();
        String espacios=ah.crearEspacios(palabra);
        System.out.println(espacios);
        int i = 4;
        while (i>0){
            String letra=ah.pedirLetra();
            boolean validacion= ah.validarLetra(letra);
            boolean verificacion = ah.verificarLetra(letra, palabra);
            if(validacion){
                if (verificacion){
                    espacios=ah.actualizarEspacios(letra, palabra,espacios);
                    System.out.println(espacios);
                    if(espacios.equals(palabra)){
                        System.out.println("La palabra es:"+palabra);
                        System.out.println("Ganaste!");
                        i=0;
                    }
                }
                else {
                    System.out.println("Letra incorrecta.");
                    i=i-1;
                    System.out.println("Intentos restantes:"+i);
                    if(i==0){System.out.println("Perdiste!");}
                }
            }
            else{System.out.println("Entrada invalida.");
                        
            }
        }
        
        
        //No se utiliza por ahora, añadir cuando se agreguen las vistas.
        
        /*Ahorcado ah = new Ahorcado();
        VistaAhorcado va = new VistaAhorcado();
        JFrame ventana = va.crearVentana();
        String palabra = ah.elegirPalabra();
        va.mostrarVista(ventana);
        va.añadirListener(ventana);
        va.añadirElementoVista(palabra, ventana,"arriba");*/
        //va.agregarBoton(ventana);
        //SwingUtilities.updateComponentTreeUI(ventana); //Actualiza la vista.
        //String letra = va.getLetraActual();
        //va.añadirElementoVista(letra, ventana);
        
        
   
    }
}
