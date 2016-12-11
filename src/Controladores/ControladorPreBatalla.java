/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Batalla;
import Modelos.Personaje;
import Modelos.Usuario;
import Vistas.VistaPreBatalla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Benxamin
 */
public class ControladorPreBatalla implements ListSelectionListener, ActionListener {
    VistaPreBatalla vpb;
    Batalla batalla;
    Usuario usuario;
    
    //Se deberia obtener el equipo del usuario y obtener de cada personaje en la lista el nombre (String) en un arraylist.
    //Por ahora se utilizara una lista predefinida.
    ArrayList<Personaje> listaDisponibles = new ArrayList<>();
    ArrayList<Personaje> listaSeleccionados = new ArrayList<>();
    
    public void actualizarListaDisponibles(){
        //Cuando se seleccione un personaje hay que quitarlo de la lista de disponibles, para eso se vuelve a crear.
        listaDisponibles.clear();
        for(Personaje p : usuario.getEquipo()){
            if (listaSeleccionados.contains(p)){
        } 
            else {
                listaDisponibles.add(p);
            }
        
        }
    }
    
    public ArrayList<String> obtenerStringNombres(ArrayList<Personaje> lista){
        ArrayList<String> nombres = new ArrayList<>();
        for(Personaje p : lista){
            nombres.add(p.getNombrePersonaje());
        }
        return nombres;
    }
    
    public ControladorPreBatalla(){
        batalla = new Batalla();
        vpb = new VistaPreBatalla();
        usuario = new Usuario();
        actualizarListaDisponibles();
        vpb.añadirListenerLista(this);
        vpb.añadirListenerBotones(this);
        vpb.actualizarListaDisponibles(obtenerStringNombres(listaDisponibles));
        vpb.actualizarListaSeleccionados(obtenerStringNombres(listaSeleccionados));
        vpb.setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        ControladorPreBatalla cpb = new ControladorPreBatalla();
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if (!lse.getValueIsAdjusting()) {
            //PONER RESTRICCION PARA QUE ESTO SOLO PERTENESCA A LA LISTA DISPONIBLES, SINO DA ERROR.
            // IF(es la jlist) o BORRAR SELECCION
            String seleccion = vpb.obtenerSeleccionPersonajesDisponibles();
            Personaje personajeSeleccionado = usuario.identificarPersonaje(seleccion);
            //Setear el texto del label de la informacion a algun valor obtenido de algun dato de la lista.
//            vpb.setLabelAtaque("Ataque: " + personajeSeleccionado.getPuntosAtaqueCortos());
//            vpb.setLabelDefensa("Defensa: " + personajeSeleccionado.getPuntoDefensa());
//            vpb.setLabelVida("Vida: " + personajeSeleccionado.getPuntosVida());
//            vpb.setLabelNivel("Nivel: " + personajeSeleccionado.getNivel());
//            vpb.borrarSeleccionDisponibles();
                  //label.setText(listaPersonajesDisponibles.getSelectedValue().toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vpb.getBotonAgregar() == (JButton)e.getSource()){
            if(listaSeleccionados.size()<6){
                String seleccion=vpb.obtenerSeleccionPersonajesDisponibles();
                
                //Sacar el personaje de la lista de disponibles y agregarlo a la lista de seleccionados.
                Personaje personajeSeleccionado = usuario.identificarPersonaje(seleccion);
                batalla.solicitarPersonajesBatalla(listaDisponibles, listaSeleccionados, personajeSeleccionado);
                //Actualizar las listas.
                vpb.actualizarListaSeleccionados(obtenerStringNombres(listaSeleccionados));
                actualizarListaDisponibles();
                
                vpb.actualizarListaDisponibles(obtenerStringNombres(listaDisponibles));
                //vpb.borrarSeleccionDisponibles();
                System.out.println("Personajes disponibles:");  
                for(String s : obtenerStringNombres(listaDisponibles)){
                                      
                    System.out.println(s);
                }
                System.out.println("===========");
                System.out.println("Personajes seleccionados:");
                for(String s : obtenerStringNombres(listaSeleccionados)){
                    
                    System.out.println(s);
                }
                System.out.println("===========");
            }
            else{
                vpb.mostrarVentana("Ya seleccionaste el maximo de personajes","Alerta");
            }
            vpb.seleccionarIndice(0);
        }
        
        if(vpb.getBotonQuitar()==(JButton)e.getSource()){
            String seleccion = vpb.obtenerSeleccionPersonajesSeleccionados();
            Personaje personajeSeleccionado = usuario.identificarPersonaje(seleccion);
            batalla.quitarPersonajesBatalla(listaDisponibles, listaSeleccionados, personajeSeleccionado);
            actualizarListaDisponibles();
            listaDisponibles.add(personajeSeleccionado);
            this.listaSeleccionados.remove(personajeSeleccionado);
            vpb.actualizarListaDisponibles(obtenerStringNombres(listaDisponibles));
            vpb.actualizarListaSeleccionados(obtenerStringNombres(listaSeleccionados));
            System.out.println("Personajes disponibles:");  
                for(String s : obtenerStringNombres(listaDisponibles)){
                                      
                    System.out.println(s);
                }
                System.out.println("===========");
                System.out.println("Personajes seleccionados:");
                for(String s : obtenerStringNombres(listaSeleccionados)){
                    
                    System.out.println(s);
                }
                System.out.println("===========");
                
            vpb.seleccionarIndice(0);
        }
        
        if(vpb.getBotonObtenerInformacion()==(JButton)e.getSource()){  
            String seleccion = vpb.obtenerSeleccionPersonajesDisponibles();
            Personaje personajeSeleccionado = usuario.identificarPersonaje(seleccion);
            vpb.setLabelAtaque("Ataque: " + personajeSeleccionado.getPuntosAtaqueCortos());
            vpb.setLabelDefensa("Defensa: " + personajeSeleccionado.getPuntoDefensa());
            vpb.setLabelVida("Vida: " + personajeSeleccionado.getPuntosVida());
            vpb.setLabelNivel("Nivel: " + personajeSeleccionado.getNivel());
        }
        if(vpb.getBotonIniciarBatalla() == (JButton)e.getSource()){ 
            ControladorBatalla cb = new ControladorBatalla();
            vpb.dispose();
        }
            
    }
}
