/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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
    
    public ControladorMenuPrincipal(){
        vMenuP = new VistaMenuPrincipal();
        vMenuP.ActionListener(this);
        vMenuP.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vMenuP.getBotonBatalla() == (JButton)ae.getSource()){
            ControladorBatalla cB = new ControladorBatalla();
            vMenuP.dispose();
        }            
       if(vMenuP.getBotonBiblioteca() == (JButton)ae.getSource()){
            ControladorBiblioteca cBiblio = new ControladorBiblioteca();
            vMenuP.dispose();
        }
        
    }
    
}
