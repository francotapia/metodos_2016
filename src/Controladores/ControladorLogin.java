/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ActividadUsuario.ActividadUsuario;
import Modelos.Usuario;

/**
 *
 * @author Maribel
 */
public class ControladorLogin  implements ActionListener{ //implementando interfaz ActionListener
 // comunicacion entre controlador y vista
 VistaLogin vLog;
 ControladorMenuPrincipal cMenuP;
 Usuario usuario;
 ControladorRegistro cReg;
 
    public ControladorLogin(){
     vLog = new VistaLogin();
     usuario = new Usuario();
     vLog.agregarListener(this);
     vLog.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //Condicion que verifica si se ha presionado el botón registrar
        if(vLog.getRegistrar() == (JButton)ae.getSource()){
            ActividadUsuario.actividadUsuario("Usuario se registra");
            cReg = new ControladorRegistro();
            vLog.setVisible(false);
        }
        
        //Condición que verifica si el usuario se ha logeado
        if(vLog.getIngresar() == (JButton)ae.getSource()){
            ActividadUsuario.actividadUsuario("Usuario se logea");
            cMenuP = new ControladorMenuPrincipal();
            vLog.dispose();
             }
    }
 
}
