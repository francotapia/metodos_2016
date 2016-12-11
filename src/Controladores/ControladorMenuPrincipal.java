/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ActividadUsuario.ActividadUsuario;
import Vistas.VistaMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorMenuPrincipal implements ActionListener {
    
   VistaMenuPrincipal vMenuP;
   ControladorBiblioteca cBiblio;
    
    public ControladorMenuPrincipal(){
        vMenuP = new VistaMenuPrincipal();
        vMenuP.ActionListener(this);
        vMenuP.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vMenuP.getBotonBatalla() == (JButton)ae.getSource()){
            ControladorPreBatalla cB = new ControladorPreBatalla();
            ActividadUsuario.actividadUsuario("Usuario ingresa a una batalla");
            vMenuP.setVisible(false);
        }            
       if(vMenuP.getBotonBiblioteca() == (JButton)ae.getSource()){
            ControladorBiblioteca cBiblio = new ControladorBiblioteca();
            ActividadUsuario.actividadUsuario("Usuario ingresa a la Biblioteca central");
            vMenuP.setVisible(false);
        }
        
       if(vMenuP.getBotonForo() == (JButton)ae.getSource()){
           ControladorForo cForo = new ControladorForo();
           ActividadUsuario.actividadUsuario("Usuario ingresa al Foro griego");
           vMenuP.setVisible(false);
       }
    }
    
}
