/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author franco
 */
public class VistaAdivinaPalabra extends javax.swing.JFrame {

    /**
     * Creates new form VistaAdivinaPalabra
     */
    public VistaAdivinaPalabra() {
        initComponents();
 
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        ingresarTexto = new javax.swing.JTextField();
        facil = new javax.swing.JButton();
        medio = new javax.swing.JButton();
        dificil = new javax.swing.JButton();
        pista = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        volverBiblioteca = new javax.swing.JButton();
        intentos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        titulo.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        titulo.setText("Adivina la palabra");
        titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ingresarTexto.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        ingresarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarTextoActionPerformed(evt);
            }
        });

        facil.setText("Facil");

        medio.setText("Medio");

        dificil.setText("Dificil");

        aceptar.setText("Aceptar");

        volverBiblioteca.setText("Volver");

        intentos.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        intentos.setText("5");

        jLabel1.setText("Intentos disponibles:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(facil, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(medio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo)
                            .addComponent(dificil, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volverBiblioteca))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pista, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                                .addComponent(ingresarTexto)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(intentos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(pista, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingresarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(intentos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(aceptar)
                .addGap(144, 144, 144)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facil)
                    .addComponent(medio)
                    .addComponent(dificil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volverBiblioteca)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresarTextoActionPerformed

    
    //////////Métodos get y set de cada botón///////////////////////
    
    //Botón aceptar:
    
    public JButton getAceptar() {
        return aceptar;
    }

    public void setAceptar(JButton aceptar) {
        this.aceptar = aceptar;
    }
    
    //Botón volver al menú anterior:

    public JButton getVolverBiblioteca() {
        return volverBiblioteca;
    }

    public void setVolverBiblioteca(JButton volverBiblioteca) {
        this.volverBiblioteca = volverBiblioteca;
    }
    
    //TexField ingresar texto:
    
     public String getIngresarTexto() {
            String res = ingresarTexto.getText();
            return res;
    }

    public void setIngresarTexto(JTextField ingresarTexto) {
        this.ingresarTexto = ingresarTexto;
    }
    
    //JLabel cantidad de intentos disponibles.
    
    public JLabel getIntentos() {
             return intentos;
    }
    public void setIntentos(int valor) {
       this.intentos.setText(Integer.toString(valor));
      
    //Ventana emergente, que muestra que el usuario ha perdido.
    }
    public void mostrarVentanaFallo(){
        this.dispose();
        JOptionPane.showMessageDialog(null, "Se te han acabado los intentos."
        + " Vuelve a jugar o selecciona un nuevo minijuego",   "Perdiste",
        JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Ventana emergente, que muestra que el usuario ha ganado.
    public void mostrarVentanaVictoria(){
        this.dispose();
        JOptionPane.showMessageDialog(null, "Has ganado."
        + " Puedes elegir un nuevo mini juego o volver al menú anterior",   "Perdiste",
        JOptionPane.INFORMATION_MESSAGE);
    }
 
    
    ////////ActionListener de cada botón mostrado en pantalla/////////////
    
    public void ActionListener(ActionListener f){
         this.aceptar.addActionListener(f);
         this.volverBiblioteca.addActionListener(f);
    }

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton dificil;
    private javax.swing.JButton facil;
    private javax.swing.JTextField ingresarTexto;
    private javax.swing.JLabel intentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton medio;
    private javax.swing.JLabel pista;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton volverBiblioteca;
    // End of variables declaration//GEN-END:variables

    

  



   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
}
