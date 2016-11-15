/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Benxamin
 */
public class VistaAhorcado implements KeyListener {
    private String letraActual;
    JFrame ventana = new JFrame("Ahorcado");
    
    public JFrame crearVentana(){
    ventana.setSize(350,350);
    ventana.setLocationRelativeTo(null);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    BorderLayout layout = new BorderLayout();
    ventana.setLayout(layout);
    
    return ventana;
    }
    
    //No se utiliza por ahora, añadir cuando se agreguen las vistas.
    public void mostrarVista(JFrame ventana){
        ventana.setVisible(true);
               
    }
    
    //No se utiliza por ahora, añadir cuando se agreguen las vistas.
    public void añadirListener(JFrame ventana){
        ventana.addKeyListener(this);
    }

    
    //No se utiliza por ahora, añadir cuando se agreguen las vistas.
    @Override
    public void keyTyped(KeyEvent e) {
       ArrayList<String> listaLetras = new ArrayList<>( Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
       String tecla = Character.toString(e.getKeyChar());
       System.out.println("La tecla presionada es " + tecla + ".");
       if (listaLetras.contains(tecla)){
           System.out.println("Tecla valida.");
           tecla=tecla.toLowerCase();
           letraActual=tecla; //
           añadirElementoVista(letraActual, ventana,"centro");
           SwingUtilities.updateComponentTreeUI(ventana);
           
           
       } 
       else {System.out.println("Tecla invalida.");
            
       }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //No se utiliza.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //No se utiliza.
    }
    
    //No se utiliza por ahora, añadir cuando se agreguen las vistas.
    //Agrega un string en forma de label a la vista.
    public void añadirElementoVista(String elemento, JFrame ventana, String posicion){
        JLabel label = new JLabel(elemento);
        if("centro".equals(posicion)){ventana.add(label,BorderLayout.CENTER);}
        else if ("izquierda".equals(posicion)){ventana.add(label,BorderLayout.WEST);}
        else if ("derecha".equals(posicion)){ventana.add(label,BorderLayout.EAST);}
        else if ("arriba".equals(posicion)){ventana.add(label,BorderLayout.NORTH);}
        else if ("abajo".equals(posicion)){ventana.add(label,BorderLayout.SOUTH);}
        SwingUtilities.updateComponentTreeUI(ventana); 
    }
    
    //Agrega un int en forma de label a la vista. Usar al agregar el numero de intentos restantes.
    public void añadirElementoVista(int elemento, JFrame ventana, String posicion){
        String numero = Integer.toString(elemento);
        JLabel label = new JLabel(numero);
        if(posicion=="centro"){ventana.add(label,BorderLayout.CENTER);}
        else if (posicion=="izquierda"){ventana.add(label,BorderLayout.WEST);}
        else if (posicion=="derecha"){ventana.add(label,BorderLayout.EAST);}
        else if (posicion=="arriba"){ventana.add(label,BorderLayout.NORTH);}
        else if (posicion=="abajo"){ventana.add(label,BorderLayout.SOUTH);}
        
    }

    
    public String getLetraActual() {
        return letraActual;
    }
    
    //No se utiliza por ahora, añadir cuando se agreguen las vistas.
    public void agregarBoton(JFrame ventana){
        ventana.getContentPane().add(new JButton ("hola"), BorderLayout.EAST);
    }
    
    
    
   
    
}
