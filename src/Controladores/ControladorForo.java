/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Arquero;
import Modelos.Guerrero;
import Modelos.Mago;
import Modelos.Ninja;
import Modelos.Personaje;
import Modelos.Usuario;
import Vistas.VistaForoGriego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author franco
 */
public class ControladorForo implements ActionListener{

    private VistaForoGriego vForo;
    private ArrayList<Personaje> profesores;
    private ArrayList<Personaje> ayudantes;
    private ArrayList<Personaje> alumnos;
    
    Personaje p1= new Mago("juan");
    Personaje p2= new Guerrero("pedro");
    Personaje p3=new Arquero("diego");
    Personaje p4=new Ninja("fabian");
    Personaje p5= new Guerrero("benjamin");
    
    
    
    public ControladorForo(){
        vForo = new VistaForoGriego();
        vForo.agregarListener(this);
        vForo.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vForo.getBotonAtras() == (JButton)ae.getSource()){
            ControladorMenuPrincipal cp = new ControladorMenuPrincipal();
            vForo.dispose();
        }
    }
    //le doy la posicion y una lista a revisar, y me devuelbe el personaje de dicha posicion
    public Personaje revisarListaContrato(int posicion, ArrayList<Personaje> listaContrato){
        Personaje elegido=listaContrato.get(posicion+1);
        listaContrato.remove(elegido); //NOTA AL CONTRATAR A DICHO PERSONAJE QUIERO ELIMINARLO DE LA LISTA VISIBLE A USUARIO
        
        return elegido;
        
    }
    // contratarPersonaje
    //se le entrega el costo de dicho personaje, un personaje a contratar y el usuario que lo contrata
    //toma un personaje, y el costo que este tiene, si el usuario tiene suficiente dinero, cae en el otro
    // if, y ademas tiene menos de 6 personajes en su lista, le permitira comprarlo
    //si no tiene el dinero, o no cuenta con espacio en su equipo, no lo contrata.
    public boolean contratarPersonaje(int costo, Personaje personaje,Usuario usuario){
        int dineroUsuario=usuario.getDinero();
        ArrayList<Personaje> EquipoUsuario=usuario.getEquipo();
        
        if (dineroUsuario>=costo){
            int NuevoDineroUsuario=dineroUsuario-costo;
            usuario.setDinero(NuevoDineroUsuario);
            if (EquipoUsuario.size()<6){
                EquipoUsuario.add(personaje);
                return true;
            }
            else{
                return false;
            }
        }
        return false;
        
    }
    
}
