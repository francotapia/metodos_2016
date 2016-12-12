
package Vistas;

import Controladores.ControladorBatalla;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import static javafx.scene.paint.Color.color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
       setLocationRelativeTo(null);
        
    }
    
     public JButton getVolver() {
        return volver;
    }
    
    public boolean generarBotones(){
        this.casillas = new JButton [25][25];
        JFrame v = new JFrame();
        panelEscenario.setLayout(new GridLayout(25,25));
        for (int x = 0;x < 25; x++){
            for (int y = 0;y < 25; y++){
                casillas[x][y] = new JButton();
                panelEscenario.add(casillas[x][y]);
            }
                 
        }
      return true;
    }
    
     public JPanel getjPanel1() {
        return panelEscenario;
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

    public void pintarAlturas(int i, int j,int altura){
    Color cafe0=new Color(232,195,158);
    Color cafe1=new Color(193, 154, 107);
    Color cafe2=new Color(186, 124, 69);
    Color cafe3=new Color(150, 113, 23);
    Color cafe4=new Color(89,46,11);
    Color cafe5=new Color(63,34,18);
        if(altura  == 0 ){
            casillas[i][j].setBackground(cafe0);
        }
        if(altura  == 1 ){
            casillas[i][j].setBackground(cafe1);
        }
        if(altura == 2){
            casillas[i][j].setBackground(cafe2);
        }
        if(altura == 3){
            casillas[i][j].setBackground(cafe3);
        }
        if(altura == 4){
            casillas[i][j].setBackground(cafe4);
        }
        if(altura == 5){
            casillas[i][j].setBackground(cafe5);
        }
        
    }

    public void marcarRio(int i, int j){
        this.casillas[i][j].setBackground(Color.blue);
    }
    
    public void marcarPosicion(int i,int j){
        this.casillas[i][j].setBackground(Color.green);
    }
    public void marcarCpu(int i, int j){
        this.casillas[i][j].setBackground(Color.red);
    }
    
    public void desmarcarPosicion(int i,int j){
        this.casillas[i][j].setBackground(null);
    }
    
    public void activarBotonAtaqueCorto(){
        ataqueC.setEnabled(true);
    }
    public void desactivarBotonAtaqueCorto(){
        ataqueC.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEscenario = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mover = new javax.swing.JButton();
        ataqueC = new javax.swing.JButton();
        ataqueL = new javax.swing.JButton();
        ataqueM = new javax.swing.JButton();
        usarObjeto = new javax.swing.JButton();
        pasar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        accionesUsuario = new javax.swing.JLabel();
        personaje1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelEscenario.setLayout(new java.awt.GridLayout(1, 0));

        mover.setText("Mover");

        ataqueC.setText("Ataque corta distancia");

        ataqueL.setText("Ataque larga distancia");

        ataqueM.setText("Ataque mágico");

        usarObjeto.setText("Utilizar objeto");

        pasar.setText("Finalizar turno");

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

        javax.swing.GroupLayout personaje1Layout = new javax.swing.GroupLayout(personaje1);
        personaje1.setLayout(personaje1Layout);
        personaje1Layout.setHorizontalGroup(
            personaje1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        personaje1Layout.setVerticalGroup(
            personaje1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEscenario, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(volver, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(accionesUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 204, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(personaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(volver)
                        .addComponent(panelEscenario, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(accionesUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(personaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
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

    public JPanel getPanelEscenario() {
        return panelEscenario;
    }

    public JLabel getAccionesUsuario() {
        return accionesUsuario;
    }

    public void setAccionesUsuario(String accionesUsuario) {
        this.accionesUsuario.setText(accionesUsuario);
    }
   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accionesUsuario;
    private javax.swing.JButton ataqueC;
    private javax.swing.JButton ataqueL;
    private javax.swing.JButton ataqueM;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton mover;
    private javax.swing.JPanel panelEscenario;
    private javax.swing.JButton pasar;
    private javax.swing.JPanel personaje1;
    private javax.swing.JButton usarObjeto;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

public void agregarListener(MouseListener f){
    
    panelEscenario.addMouseListener(f);
    mover.addMouseListener(f);
    ataqueC.addMouseListener(f);
    ataqueL.addMouseListener(f);
    ataqueM.addMouseListener(f);
    usarObjeto.addMouseListener(f);
    pasar.addMouseListener(f);
    volver.addMouseListener(f);
    for (int i=0;i<25;i++) { //por cada fila del tablero
            for (int j=0;j<25;j++) { //por cada elemento de cada fila
                this.casillas[i][j].addMouseListener(f); //escuchar elementos(botones)
            }
        } 

    }
}   

