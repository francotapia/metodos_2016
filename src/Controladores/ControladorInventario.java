/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorInventario implements ActionListener {
    
    private VistaInventario vInventario;
    
    public ControladorInventario(){
        vInventario = new VistaInventario();
        vInventario.agregarListener(this);
        vInventario.setVisible(true);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vInventario.getBotonAtras() == (JButton)ae.getSource()){
            vInventario.setVisible(false);
            ControladorMenuPrincipal cmp = new ControladorMenuPrincipal();
            
        }
    }
    
}
