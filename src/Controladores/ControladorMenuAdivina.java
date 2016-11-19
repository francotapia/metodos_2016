/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaMenuAdivina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorMenuAdivina implements ActionListener {
    VistaMenuAdivina vMa;

    public ControladorMenuAdivina(){
        vMa = new VistaMenuAdivina();
        vMa.agregarListener(this);
        vMa.setVisible(true);
        vMa.invisibleCancelar();
        vMa.desactivarJugar();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //botones de dificultad.
        if(vMa.getFacil() == (JButton)ae.getSource()){
            vMa.desactivarMedio();
            vMa.desactivarDificil();
            vMa.visibleCancelar();
            vMa.activarJugar();
        }
        if(vMa.getMedio() == (JButton)ae.getSource()){
            vMa.desactivarFacil();
            vMa.desactivarDificil();
            vMa.visibleCancelar();
            vMa.activarJugar();
        }
        if(vMa.getDificil() == (JButton)ae.getSource()){
            vMa.desactivarMedio();
            vMa.desactivarFacil();
            vMa.visibleCancelar();
            vMa.activarJugar();
        }
        
        //boton para jugar
        if(vMa.getJugar() == (JButton)ae.getSource()){
            controladorAdivina cA = new controladorAdivina();
            vMa.setVisible(false);
        }
        
        //boton cancelar
        if(vMa.getCancelar() == (JButton)ae.getSource()){
            vMa.activarFacil();
            vMa.activarMedio();
            vMa.activarDificil();
            vMa.desactivarJugar();
            vMa.getCancelar().setVisible(false);
        }
    }
        
}
