
package Vistas;

import Controladores.ControladorBatalla;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import static javafx.scene.paint.Color.color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


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
    
     public JButton getVolver() {
        return volver;
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
    
     public JPanel getjPanel1() {
        return jPanel1;
    }
    
    public JButton getAtaqueC() {
        return ataqueC;
    }

    public JButton getAtaqueL() {
        return ataqueL;
    }

    public JButton getAtaqueM() {
        return ataqueM;
    }

    public JButton getMover() {
        return mover;
    }

    public JButton getPasar() {
        return pasar;
    }

    public JButton getUsarObjeto() {
        return usarObjeto;
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
        jPanel2 = new javax.swing.JPanel();
        mover = new javax.swing.JButton();
        ataqueC = new javax.swing.JButton();
        ataqueL = new javax.swing.JButton();
        ataqueM = new javax.swing.JButton();
        usarObjeto = new javax.swing.JButton();
        pasar = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        mover.setText("Mover");

        ataqueC.setText("Ataque corta distancia");

        ataqueL.setText("Ataque larga distancia");

        ataqueM.setText("Ataque mágico");

        usarObjeto.setText("Utilizar objeto");

        pasar.setText("Pasar turno");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ataqueC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ataqueL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ataqueM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usarObjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pasar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ataqueC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ataqueL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ataqueM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usarObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pasar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        volver.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volver)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volver)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    public void activarTablero(){
        for (int x = 0;x < 25; x++){
            for (int y = 0;y < 25; y++){
                casillas[x][y].setEnabled(true);  
            }
        }
    }
    public void desactivarTablero(){
         for (int x = 0;x < 25; x++){
            for (int y = 0;y < 25; y++){
                casillas[x][y].setEnabled(false);  
            }
        }
    }
   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ataqueC;
    private javax.swing.JButton ataqueL;
    private javax.swing.JButton ataqueM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton mover;
    private javax.swing.JButton pasar;
    private javax.swing.JButton usarObjeto;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

public void agregarListener(ActionListener f){
  
    mover.addActionListener(f);
    ataqueC.addActionListener(f);
    ataqueL.addActionListener(f);
    ataqueM.addActionListener(f);
    usarObjeto.addActionListener(f);
    pasar.addActionListener(f);
    volver.addActionListener(f);
    for (int i=0;i<25;i++) { //por cada fila del tablero
            for (int j=0;j<25;j++) { //por cada elemento de cada fila
                this.casillas[i][j].addActionListener(f); //escuchar elementos(botones)
            }
        } 

    }
}   

