/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ActividadUsuario.ActividadUsuario;
import Modelos.Usuario;
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
    private Usuario usuario;
    private String principal;
    private String amigo;
    public ControladorPersonajePrincipal(String nombre, String contraseña){
        vPerPrincipal = new VistaPersonajePrincipal();
        vPerPrincipal.agregarListener(this);
        vPerPrincipal.setVisible(true);
        usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setContraseña(contraseña);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (vPerPrincipal.getElegirArquero()  == (JButton)ae.getSource()){ 
            usuario.setPersonajePrincipal("arquero");
            vPerPrincipal.getElegirGuerrero().setEnabled(false);
        }
        
        if (vPerPrincipal.getElegirGuerrero()== (JButton)ae.getSource()){ 
             usuario.setPersonajePrincipal("guerrero");
             vPerPrincipal.getElegirArquero().setEnabled(false);
        }
        
        if (vPerPrincipal.getElegirGuerreroAmigo()  == (JButton)ae.getSource()){ 
            vPerPrincipal.getElegirArqueroAmigo().setEnabled(false);
             usuario.setPersonajeAmigo("guerrero");
        }
        if (vPerPrincipal.getElegirArqueroAmigo()  == (JButton)ae.getSource()){ 
            vPerPrincipal.getElegirGuerreroAmigo().setEnabled(false);
             usuario.setPersonajeAmigo("arquero");
        }
        if(vPerPrincipal.getEjecucion() == (JButton)ae.getSource() ){
             vPerPrincipal.getCivil().setEnabled(false);
             usuario.setMalla("ejecucion");
        }
        if(vPerPrincipal.getCivil() == (JButton)ae.getSource() ){
             vPerPrincipal.getEjecucion().setEnabled(false);
             usuario.setMalla("civil");
        }
        
        if(vPerPrincipal.getJugar() == (JButton)ae.getSource()){
            if(usuario.registrarBD()){
                ControladorLogin cl = new ControladorLogin();
                 vPerPrincipal.dispose();
                vPerPrincipal.mostrarVentana("Usuario creado con exito", "Usuario creado");
               
                
            }
            else{
                vPerPrincipal.mostrarVentana("Usuario existente, intentelo otra vez.", "Error");
                vPerPrincipal.dispose();  
                ControladorRegistro cl = new ControladorRegistro();
            }
        }
   
    
    
    }
}
