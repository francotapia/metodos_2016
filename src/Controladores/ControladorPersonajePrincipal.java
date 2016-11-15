/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ActividadUsuario.ActividadUsuario;
import Vistas.VistaPersonajePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorPersonajePrincipal implements ActionListener {
    
    VistaPersonajePrincipal vPerPrincipal;
    
    public ControladorPersonajePrincipal(){
        vPerPrincipal = new VistaPersonajePrincipal();
        vPerPrincipal.agregarListener(this);
        vPerPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (vPerPrincipal.getElegirArquero()  == (JButton)ae.getSource()){ 
            ControladorBatalla cB = new ControladorBatalla();
            vPerPrincipal.dispose();
        }
        
        if (vPerPrincipal.getElegirGuerrero()== (JButton)ae.getSource()){ 
            ControladorBatalla cB = new ControladorBatalla();
            vPerPrincipal.dispose();
        }
        
        if (vPerPrincipal.getElegirNinja()  == (JButton)ae.getSource()){ 
            ControladorBatalla cB = new ControladorBatalla();
            vPerPrincipal.dispose();
        }
        if (vPerPrincipal.getElegirMago()  == (JButton)ae.getSource()){ 
            ControladorLogin cLog = new ControladorLogin();
            ActividadUsuario.actividadUsuario("Usuario se registra");
            vPerPrincipal.dispose();
        }
   
    
    
    }
}
