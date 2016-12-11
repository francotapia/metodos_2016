/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ActividadUsuario.ActividadUsuario;
import Modelos.Usuario;
import Vistas.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorRegistro implements ActionListener{
    VistaRegistro vReg;
    Usuario usuario;
    
    public ControladorRegistro(){
        usuario=new Usuario();
        vReg = new VistaRegistro();
        vReg.agregarListener(this);
        vReg.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vReg.getBotonRegistrar()== (JButton)ae.getSource()){
            if(vReg.getNombreUsuario().equals("") || vReg.getContraseña().equals("") || vReg.getRepContraseña().equals("")){
                vReg.mostrarVentana("Por favor ingrese un nombre de usuario, contraseña y repeticion de contraseña","Campos vacios");
            }
            else{
                if(usuario.verificarSintaxis(vReg.getNombreUsuario()) && usuario.verificarSintaxis(vReg.getContraseña())){
                    if(vReg.getNombreUsuario().length()<4 || vReg.getContraseña().length()<4){
                        vReg.mostrarVentana("El nombre de usuario y contraseña deben tener al menos 4 caracteres de largo", "Largo insuficiente");
                    }
                    else{
                        if (usuario.getListaUsuarios().contains(vReg.getNombreUsuario())) {
                            vReg.mostrarVentana("El nombre de usuario ya existe.", "Usuario existente");
                        } 
                        else {
                            if (vReg.getContraseña().equals(vReg.getRepContraseña())) {       
                                ActividadUsuario.actividadUsuario("Usuario se registra con el nombre  "+ vReg.getNombreUsuario() + "y contraseña "+ vReg.getContraseña() );
                                ControladorPersonajePrincipal cRolReg = new ControladorPersonajePrincipal(vReg.getNombreUsuario(),vReg.getContraseña());
                                vReg.dispose();
                               
                            }
                            else{
                                vReg.mostrarVentana("Las contraseñas no coinciden.", "Contraseñas no coinciden");
                            }
                        }
                    }
                }
                else{
                    vReg.mostrarVentana("El nombre de usuario o contraseña solo deben poseer caracteres alfanumericos", "Error");
                }
            }
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

