/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaAsignaturasPlanComun;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorPlanComun implements ActionListener{
    
    private VistaAsignaturasPlanComun vComun;
    
    public ControladorPlanComun(){
        vComun = new VistaAsignaturasPlanComun();
        vComun.setVisible(true);
        vComun.agregarListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vComun.getBotonCalculo1() == (JButton)ae.getSource()){
            vComun.setVisible(false);
            ControladorPreBatalla preBatalla = new ControladorPreBatalla();
        }
    }
    
}
