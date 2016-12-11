/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaBibliotecaCentral;
import Vistas.VistaBuscaminas;
import Vistas.VistaGato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorBiblioteca implements ActionListener{

    VistaBibliotecaCentral vBiblio;
  
    public ControladorBiblioteca(){
        vBiblio = new VistaBibliotecaCentral();
        vBiblio.agregarListener(this);
        vBiblio.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vBiblio.getAtras()== (JButton)ae.getSource()){
            ControladorMenuPrincipal cBiblio = new ControladorMenuPrincipal();
            vBiblio.dispose();
        }
         if(vBiblio.getIniciarAdivina()== (JButton)ae.getSource()){
            ControladorMenuAdivina cAdivina = new ControladorMenuAdivina();
            vBiblio.dispose();
        }
         if(vBiblio.getIniciarGato()== (JButton)ae.getSource()){
          VistaGato gato = new VistaGato();
          gato.setVisible(true);
          vBiblio.dispose();
        }
          if(vBiblio.getIniciarBuscaminas()== (JButton)ae.getSource()){
          VistaBuscaminas busca = new VistaBuscaminas();
          busca.setVisible(true);
          vBiblio.dispose();
        }
          if(vBiblio.getIniciarAhorcado()== (JButton)ae.getSource()){
          ControladorAhorcado cAhorcado = new ControladorAhorcado();
          vBiblio.dispose();
        }
          
    }
}
