package Controladores;

import Modelos.AdivinaLaPalabra;
import Vistas.VistaAdivinaPalabra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author franco
 */
public class controladorAdivina implements ActionListener{
  private VistaAdivinaPalabra vAd; 
  private AdivinaLaPalabra Ad;
 
  public void setAdivinaPalabra(AdivinaLaPalabra Ad){
        this.Ad = Ad;
    }
    public controladorAdivina(){
      
        this.vAd =new VistaAdivinaPalabra();
        this.Ad = new AdivinaLaPalabra(5);
        this.vAd.ActionListener(this);
        vAd.setVisible(true);
    }
    
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        
        ////Condiciones que desactivan los botones de dificultad:
        
        if(vAd.getFacil()== (JButton)ae.getSource()){
            System.out.println("me desactivé");
            vAd.desactivarMedio();
            vAd.desactivarDificil();
        } 
        if(vAd.getMedio()== (JButton)ae.getSource()){
            System.out.println("me desactivé");
            vAd.desactivarFacil();
            vAd.desactivarDificil();
        }
        if(vAd.getDificil()== (JButton)ae.getSource()){
            System.out.println("me desactivé");
            vAd.desactivarFacil();
            vAd.desactivarMedio();
        }
   
        ////Condicion para volver al menú de inicio
        
        if(vAd.getVolverBiblioteca()== (JButton)ae.getSource()){
            ControladorBiblioteca cBiblio = new ControladorBiblioteca();
            vAd.setVisible(false);
            
        }
        
        ////Condiciones que verifican si la palabra ingresada es correcta
   
        if(Ad.getIntentos() > 0){                                         //Condicion, que comprueba si existen intentos disponibles
            if(vAd.getAceptar() == (JButton)ae.getSource()){
                if(Ad.comparar((vAd.getIngresarTexto()))){                //condición que rectifica si la palabra escrita, es la correcta.
                    vAd.mostrarVentanaVictoria();
                    ControladorBiblioteca cBiblio = new ControladorBiblioteca();
                    System.out.println("correcto");
                }
                else{
                    int valor = Ad.disminuirIntentos(Ad.getIntentos());  //Caso en que al jugador ha fallado
                    vAd.setIntentos(valor);
                    System.out.println("fallaste");
                }
            }       
        }
        if(Ad.getIntentos() <= 0){                                       // Caso en que ya no queden intentos
            vAd.mostrarVentanaFallo();
        }
    
    }
}
