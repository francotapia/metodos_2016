/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaBatalla;
import java.awt.Color;
import static java.awt.Color.black;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Maribel
 */
public class ControladorBatalla implements ActionListener {
        
    private VistaBatalla vb;
    
    ControladorBatalla() {
         vb = new VistaBatalla();
         vb.agregarListener(this);
        vb.setVisible(true);
    }
    
    
     
    public void actionPerformed(ActionEvent ae) {
        
        for(int i = 0; i<25; i++){
            for(int j=0; j<25; j++){
                if(vb.getCasillas()[i][j]==(JButton)ae.getSource()){
                    System.out.println("x="+i+",y="+j);
                    vb.marcarPosicion(i, j);
                    
                }
            }
        }   
    }
}