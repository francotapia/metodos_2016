/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.CasillaBuscaminas;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Maribel
 */
public class VistaBuscaminas extends javax.swing.JFrame {
    
    public static CasillaBuscaminas casilla[][];  // con esto estoy creando una matriz de tipo CasillaBuscaminas
    public static boolean ganador= false;

    /**
     * Creates new form VistaBuscaminas
     */
    public VistaBuscaminas() {        // este es el constructor de vista buscaminas
        initComponents();
        cargar();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        tablero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        numeroMinas = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablero.setLayout(new java.awt.GridLayout(10, 10));

        inicio.setText("Comienza!");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        jLabel1.setText("Minas!");

        numeroMinas.setModel(new javax.swing.SpinnerNumberModel(10, 10, 10, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(inicio)
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroMinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inicio)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numeroMinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(241, 241, 241)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(241, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addGap(37, 37, 37)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//esto es para que que cuando se haga click en el boton inicio, ocurra el metodo cargar
    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
      int d=4;  // cuando haga clik en el boton de inicio mi idea es generar el tablero, pero bueno, no se me ha ocurrido
    }//GEN-LAST:event_inicioActionPerformed
    
    /**
     * @param args the command line arguments
     */

    
    public void cargar(){        // cuando el juego carga el buscaminas...
        int filas=10;   // estas son las filas que tendra mi tablero  (las que indica el usuario)
        int columnas=10;//estas otras son las columnas que tendra mi tablero
        int minas=10;    //estas son las minas que tendra mi tablero
        this.casilla= new CasillaBuscaminas[filas][columnas];   //creo las casillas de filas y columnas.
        int minasx[]=generarAleatorios(minas, filas);  //arreglo de minas
        int minasy[]=generarAleatorios(minas, columnas); //arreglo de minas
      
            
          
       //CON ESTOS 2 CICLOS DE FOR, CREO MI TABLERO DE CASILLAS     
       for (int i=0;i<filas; i++){   //recorro mis filas....
         for(int j=0;j<columnas;j++){ //recorro mis  columnas...
            //instancio una casilla de 10*10, con el constructor CasillaBuscaminas
            this.casilla[i][j]=new CasillaBuscaminas(i,j);  //creo una nueva casilla de cordenada i, j 
            this.casilla[i][j].setContenidoCasilla(numeroAleatorio());      // y a esta casilla le asigno un numero 2 (no hay mina)
            tablero.add(this.casilla [i][j]);              //Luego añado esta casilla al tablero.
           }
       
      }
        for(int i=0; i<minas; i++){
            this.casilla[minasx[i]][minasy[i]].setContenidoCasilla(0);
        }
        JOptionPane.showMessageDialog(null, "filas="+filas +"  columnas="+columnas+"  minas="+minas);  // esta wea la puse para ver si capturaba lo que tengo en mi panel
        
    }
    
    //no me acuerdo que hace esto, en algun momento hare la traza
public int numeroAleatorio(){
    Random rd=new Random();
    int numero=(int)(rd.nextDouble()*2);
    return numero+1;
}
//    ESTE METODO GENERA UN ARREGLO DE NUMEROS SIN REPETICIONES, ES UNA COMBINACION DE MI CODIGO, MAS TUTORIALES EN YUTU
public int[] generarAleatorios (int cantidad,int auxiliar){
     Random rd= new Random(); //con esto creo los numero al azar
     int b[]=new int[cantidad]; //con esto guardo los numeros al azar
     int contador=0;  //variable que da las posiciones a dichos numeros
     boolean v; //con esta verifico si el numero ya fue generado
     boolean cero=false; //esta variable es para que se genere el cero
     //CABE DESTACAR QUE PARA MI LOS "0" INDICAN QUE HAY MINA


     //este while esta para que los numeros no se repitan   
     //(lo utilizare ya que en una casilla no pueden haber dos minas
     while(contador<cantidad){
           int numero=(int)(rd.nextDouble() * auxiliar);
           v=true;   // esto me indica si el numero ya fue generado
           for (int i=0; i<cantidad;i++)  {
                if (numero==b[i])  //con esto veridico si el numero ya fue cread
                {v=false;}  //entonces v, tendra el valor de false
           }
           if (!cero&&numero==1) {cero=true;numero=0;}  //asigno a esa posicion un 0
           if (v){ b[contador]=numero; contador++;}
      }
      return b; //estos son los numero aleatoreaos sin repeticion
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JSpinner numeroMinas;
    private javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables
}
