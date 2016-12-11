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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            cReg = new ControladorRegistro();
            vLog.setVisible(false);
        }
        
        //Condición que verifica si el usuario se ha logeado
        
        if(vLog.getIngresar() == (JButton)ae.getSource()){
             if(vLog.getNombreUsuario().equals("")|| vLog.getContraseñaUsuario().equals("")){
                vLog.mostrarVentanaVacio();
            }
            
            else{
            try {
                if(usuario.usuarioExistente(vLog.getNombreUsuario())){ //verificar si el nombre de usuario no existe
                    if(usuario.contraseñaExistente(vLog.getContraseñaUsuario())){
                    ActividadUsuario.actividadUsuario("Usuario se logea");
                    cMenuP = new ControladorMenuPrincipal();
                    vLog.dispose();
                    }
                    else{
                        vLog.mostrarVentanaContraseña();
                    }
                }
                else{
                    vLog.mostrarVentanaUsuario();
                }
              
              
            } catch (SQLException ex) {
                vLog.mostrarVentanaUsuario();
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       }
        
        
           if(vLog.getInvitado() == (JButton)ae.getSource()){
                cMenuP = new ControladorMenuPrincipal();
                vLog.dispose();
                }    
              }
         
            
                
    }

