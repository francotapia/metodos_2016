
package Vistas;

import Controladores.ControladorBatalla;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import static javafx.scene.paint.Color.color;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author franco
 */
public class VistaBatalla extends javax.swing.JFrame {

    /**
     * Creates new form VistaBatalla
     */
    private JButton[][] casillas;
    
    public VistaBatalla() {
       initComponents();
       generarBotones();
        
    }
    
    public JButton[][] generarBotones(){
        this.casillas = new JButton [25][25];
        JFrame v = new JFrame();
        jPanel1.setLayout(new GridLayout(25,25));
        for (int x = 0;x < 25; x++){
            for (int y = 0;y < 25; y++){
                casillas[x][y] = new JButton();
                jPanel1.add(casillas[x][y]);
            }
                 
        }
        return casillas;
    }

    public JButton[][] getCasillas(){
        return this.casillas;
    }
    public void setCasillas(JButton[][] casillas) {
        this.casillas = casillas;
    }



public void marcarPosicion(int i, int j){
    this.casillas[i][j].setBackground(Color.blue);
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

public void agregarListener(ActionListener f){
    for (int i=0;i<25;i++) { //por cada fila del tablero
            for (int j=0;j<25;j++) { //por cada elemento de cada fila
                this.casillas[i][j].addActionListener(f); //escuchar elementos(botones)
            }
        } 

    }
}   

