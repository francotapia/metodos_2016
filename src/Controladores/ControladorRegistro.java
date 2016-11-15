/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ActividadUsuario.ActividadUsuario;
import Vistas.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorRegistro implements ActionListener{
    VistaRegistro vReg;
    
    public ControladorRegistro(){
        vReg = new VistaRegistro();
        vReg.agregarListener(this);
        vReg.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vReg.getBotonRegistrar()== (JButton)ae.getSource()){
            ControladorPersonajePrincipal cRolReg = new ControladorPersonajePrincipal();
            vReg.dispose();
        }
        if(vReg.getSalir1()== (JButton)ae.getSource() ){
            vReg.dispose();
        }
        if(vReg.getAtras()== (JButton)ae.getSource() ){
            ControladorLogin cl = new ControladorLogin();
            vReg.dispose();
        }
        
        
     
    }
    
}
