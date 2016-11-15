/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Vistas.VistaBuscaminas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;



/**
 *
 * @author Maribel
 */
public class CasillaBuscaminas extends JButton{
    private int x;                 // Esta es la posicion "x" de la casilla
    private int y;                 // Esta es la posicion "y" de la casilla
    private int contenidoCasilla;  // Esto indica si la casilla contiene un numero, una mina, o en su defecto esta pelada
    //SI CONTIENE MINA SE LE ASIGA UN 0, SI NO CONTIENE MINA SE LE ASIGNA UN 0
    private boolean visibilidad;
    private Color color[];

    public int getContenidoCasilla() {
        return contenidoCasilla;
    }
    
    
// Este el constructor generado por defecto, que inicializa dichos atributos
    public CasillaBuscaminas(int x, int y) {
        this.x = x;
        this.y = y;
        this.visibilidad = false; // esto es porque al principio no debe ser visible la mina
        //esto que viene lo saque papeado de internet, segun lei, es para ajustarle las caracteriscas a las casillas
        //Y va de pana banana
        this.color=new Color[]{Color.BLUE,Color.GREEN,Color.ORANGE,Color.YELLOW,Color.PINK,Color.BLACK};
        this.setBackground(new java.awt.Color(0,240,240));
        this.setMinimumSize(new Dimension(40,40));
          // El fondo de mis casillas es cyan pd: YO AMO EL CYAN <3
              // y seran de letra arial en negrita (papeado)
        this.addActionListener(new java.awt.event.ActionListener() {     // esto lo saque papeado de un ejemplo subido por los profes     
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillabuscaminaActionPerformed(evt) ;
            }
        });
    }

  
  
    public void setContenidoCasilla(int contenidoCasilla) {
        this.contenidoCasilla = contenidoCasilla;
    }
    
    
    //ATENCION! este metodo se invoca cada vez que se hace click en alguna casilla del tablero)
    private void casillabuscaminaActionPerformed(java.awt.event.ActionEvent evt){
        // si la casilla del buscaminas es visible y aun no pierde
        if (!visibilidad&&VistaBuscaminas.ganador==false){
            this.visibilidad= true;  // se le cambia su visilidad a true (se muestra la mina....)
            this.setBackground(new java.awt.Color(240,240,240));
            
            switch(this.contenidoCasilla)   {  //con esto dependiendo de que contenga la casilla
                case 0:  // si se presiona la cuadricula, y esta es del tipo 0 (tiene mina)
                    
                   //con esto hago que todas las casillas que esten en 0 muestre la imagen de un BOOM!!
                    JOptionPane.showMessageDialog(null,"perdiste");   
                    for (int i = 0; i < 10; i++) {  //recorro las 10 filas
                        for (int j = 0; j < 10; j++) {   //recorro las 1o columnas
                           //di alguna de las casilla recorridas presenta una mina, y es del tipo cero
                           //entonces a dicha casilla, se le pone la imagen de una mina
                            if(VistaBuscaminas.casilla[i][j].getContenidoCasilla()==0) //obtengo el valor de contenido casilla, de dicha casilla
                            VistaBuscaminas.casilla[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mina.jpg"))); 
                        }
                    }
                    //ademas luego de activar cada mina, se asigna a la variable ganador el valor de true, esto para que 
                    // !visibilidad sea igual false, y no vuelva a entrar a este cicl
                    VistaBuscaminas.ganador=true; 
                    break;
                    
                   //en el cas
                case 1: // en el caso de que la casilla este adyacente a una mina
                    
                    int cont=0; //se crea un contador
                    this.setBackground(new java.awt.Color(240,240,240)); //se cambia el color a blanco (?)
                    //este metodo lo encontre en internet, sirve para poder contar las minas adyacentes
                    for (int i= -1 ; i<=1;i++){
                        if(x+i>=0 && x+i<10){
                            for (int j=-1; j<=1 ;j++){
                                System.out.println(y+i+" "+y+i+" "+ 10);
                                if(((y+j)>=0 && (y+j)<10) && VistaBuscaminas.casilla[x+i][y+j].getContenidoCasilla()==0){
                                    cont++;  
                                    //contador queda con un valor de 0 a 5, indicando si es que hay una mina adyacente
                                    
                                }
                            }
                        }
                    }
                    this.setText(""+cont); // a "esta" casilla se le asigna el valor de contado
                    break;
                    
                // en el caso que el contenido sea 2 (no tenga nada),     
                default:  //en caso de que no halla una mina
                    System.out.println("casilla sin mina"); //printear "casilla sin mina"
            }
                     
            
        }
        
        
        
        
        
        
        
        
        

    }
}

