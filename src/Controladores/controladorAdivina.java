package Controladores;

import Modelos.AdivinaLaPalabra;
import Vistas.VistaAdivinaPalabra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

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
   VistaAdivinaPalabra vAd; 
   AdivinaLaPalabra Ad;
   private int contadorBoton = 3;
   private Timer t;
   private int tiempo = 26;

    public controladorAdivina(int i){
      
        this.vAd =new VistaAdivinaPalabra();
        this.Ad = new AdivinaLaPalabra();
        this.vAd.ActionListener(this);
        Ad.obtenerPalabra(i); //Se busca inmediatamente una palabra al azar de la lista
        vAd.setVisible(true);
        actualizarTiempo(i);
        
    }
    ///Método que disminuye el tiempo////
    //Entrada: entero
    //Salida: ---
    public void actualizarTiempo(int i){
        t = new Timer(1000,new ActionListener() { //se instancia la clase Timer, donde se indica que el timpo avanzará cada 1 segundo 
            @Override
            public void actionPerformed(ActionEvent ae) { // ActionPerformed del ActionListener de tiempo
                
                if(i == 2||i==3){
                    if(tiempo <= 26){
                        tiempo --;
                        vAd.colorVerdeLabel();
                        vAd.setTiempo(tiempo);
                    }
                    if(tiempo<10){
                       vAd.colorRojoLabel();
                    }
                    if(tiempo < 0){
                        vAd.mostrarVentanaFallo();
                        ControladorBiblioteca bc = new ControladorBiblioteca();
                        t.stop();
                    }
                } 
            }
        });
        t.start();
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {
   
        ////Condicion para volver al menú de inicio
        
        
        if(vAd.getVolverBiblioteca()== (JButton)ae.getSource()){
            ControladorMenuAdivina cMa = new ControladorMenuAdivina();
            vAd.setVisible(false);
            
        }
        
        ////Condiciones que verifican si la palabra ingresada es correcta

        if(Ad.getIntentos() > 0){                                         //Condicion, que comprueba si existen intentos disponibles
            if(vAd.getAceptar() == (JButton)ae.getSource()){
                if(Ad.comparar((vAd.getIngresarTexto()))){                //condición que rectifica si la palabra escrita, es la correcta.
                    vAd.mostrarVentanaVictoria();
                    System.out.println("correcto");
                    t.stop();
                    ControladorBiblioteca bc = new ControladorBiblioteca(); 
                }
                else{
                    int valor = Ad.disminuirIntentos();  //Caso en que al jugador ha fallado
                    vAd.setIntentos(valor);
                    System.out.println("fallaste");
                    t.stop();
                }
            }       
        }
        
        //Si se solicita una pista
        if(vAd.getBtnPista()== (JButton)ae.getSource()){
            Ad.mostrarPista();
            if(contadorBoton == 3){ //Si se ha seleccionado por primera vez el boton
                vAd.setPista(Ad.getPista1()); //Se muestra la primera pista en pantalla
                contadorBoton = 2;
                System.out.println(Ad.getPista1());
            }
            else if(contadorBoton == 2){ //Si se ha seleccionado por segunda vez el botón
                vAd.setPista(Ad.getPista2()); //Se mustra segunda pista en pantalla
                contadorBoton = 1;
                System.out.println(Ad.getPista2());
            }
            else if(contadorBoton == 1){ //Si se ha seleccionado por tercera vez el botón
                vAd.setPista(Ad.getPista3()); //Se muestra tercera pista en pantalla
                contadorBoton = 0;
                System.out.println(Ad.getPista3());
            }
            else if(contadorBoton == 0){ //Si se selecciona por cuarta vez el botón, se vuelve a la primera pista
                vAd.setPista(Ad.getPista1());
                contadorBoton = 2;
                System.out.println(Ad.getPista1());
            }
           
        }
        if(Ad.getIntentos() <= 0){ // Caso en que ya no queden intentos
            vAd.mostrarVentanaFallo();
            ControladorBiblioteca bc = new ControladorBiblioteca();
        }
        
    
    }
}
