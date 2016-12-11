

package Vistas;

import javax.swing.JOptionPane;


public class VistaGato extends javax.swing.JFrame {

    int c1, c2, c3, c4, c5, c6, c7, c8, c9;
    boolean x = false;
    boolean y = false;

    void inicio() {
        c1 = 0;
        c2 = 0;
        c3 = 0;
        c4 = 0;
        c5 = 0;
        c6 = 0;
        c7 = 0;
        c8 = 0;
        c9 = 0;
        b1.setText("");
        b1.setEnabled(true);
        b2.setText("");
        b2.setEnabled(true);
        b3.setText("");
        b3.setEnabled(true);
        b4.setText("");
        b4.setEnabled(true);
        b5.setText("");
        b5.setEnabled(true);
        b6.setText("");
        b6.setEnabled(true);
        b7.setText("");
        b7.setEnabled(true);
        b8.setText("");
        b8.setEnabled(true);
        b9.setText("");
        b9.setEnabled(true);
        x=false;
        y=false;
    }

    void Marcar(int player, int poss) {

        switch (player) {
            case 1:
                switch (poss) {

                    case 1:
                        c1 = 1;
                        b1.setText("O");
                        b1.setEnabled(false);
                        break;
                    case 2:
                        c2 = 1;
                        b2.setText("O");
                        b2.setEnabled(false);
                        break;
                    case 3:
                        c3 = 1;
                        b3.setText("O");
                        b3.setEnabled(false);
                        break;
                    case 4:
                        c4 = 1;
                        b4.setText("O");
                        b4.setEnabled(false);
                        break;
                    case 5:
                        c5 = 1;
                        b5.setText("O");
                        b5.setEnabled(false);
                        break;
                    case 6:
                        c6 = 1;
                        b6.setText("O");
                        b6.setEnabled(false);
                        break;
                    case 7:
                        c7 = 1;
                        b7.setText("O");
                        b7.setEnabled(false);
                        break;
                    case 8:
                        c8 = 1;
                        b8.setText("O");
                        b8.setEnabled(false);
                        break;
                    case 9:
                        c9 = 1;
                        b9.setText("O");
                        b9.setEnabled(false);
                        break;
                }
                break;


            case 2:
                switch (poss) {
                    case 1:
                        c1 = 2;
                        b1.setText("X");
                        b1.setEnabled(false);
                        break;
                    case 2:
                        c2 = 2;
                        b2.setText("X");
                        b2.setEnabled(false);
                        break;
                    case 3:
                        c3 = 2;
                        b3.setText("X");
                        b3.setEnabled(false);
                        break;
                    case 4:
                        c4 = 2;
                        b4.setText("X");
                        b4.setEnabled(false);
                        break;
                    case 5:
                        c5 = 2;
                        b5.setText("X");
                        b5.setEnabled(false);
                        break;
                    case 6:
                        c6 = 2;
                        b6.setText("X");
                        b6.setEnabled(false);
                        break;
                    case 7:
                        c7 = 2;
                        b7.setText("X");
                        b7.setEnabled(false);
                        break;
                    case 8:
                        c8 = 2;
                        b8.setText("X");
                        b8.setEnabled(false);
                        break;
                    case 9:
                        c9 = 2;
                        b9.setText("X");
                        b9.setEnabled(false);
                        break;

                }
                break;

        }
    }

    boolean ganador(int player) {

        boolean gana = false;

        switch (player) {

            case 1:
                if (c1 == 1 && c2 == 1 && c3 == 1) {
                    gana = true;
                }
                if (c4 == 1 && c5 == 1 && c6 == 1) {
                    gana = true;
                }
                if (c7 == 1 && c8 == 1 && c9 == 1) {
                    gana = true;
                }
                if (c1 == 1 && c4 == 1 && c7 == 1) {
                    gana = true;
                }
                if (c2 == 1 && c5 == 1 && c8 == 1) {
                    gana = true;
                }
                if (c3 == 1 && c6 == 1 && c9 == 1) {
                    gana = true;
                }
                if (c1 == 1 && c5 == 1 && c9 == 1) {
                    gana = true;
                }
                if (c3 == 1 && c5 == 1 && c7 == 1) {
                    gana = true;
                }
                break;

            case 2:
                if (c1 == 2 && c2 == 2 && c3 == 2) {
                    gana = true;
                }
                if (c4 == 2 && c5 == 2 && c6 == 2) {
                    gana = true;
                }
                if (c7 == 2 && c8 == 2 && c9 == 2) {
                    gana = true;
                }
                if (c1 == 2 && c4 == 2 && c7 == 2) {
                    gana = true;
                }
                if (c2 == 2 && c5 == 2 && c8 == 2) {
                    gana = true;
                }
                if (c3 == 2 && c6 == 2 && c9 == 2) {
                    gana = true;
                }
                if (c1 == 2 && c5 == 2 && c9 == 2) {
                    gana = true;
                }
                if (c3 == 2 && c5 == 2 && c7 == 2) {
                    gana = true;
                }
                break;


        }
        return gana;
    }

    void bloqueo() {
        //primera fila horizontal
        if (c1 == 2 && c2 == 2 && c3 == 0 && !x) {
            Marcar(1, 3);
            x = true;
        }
        if (c1 == 2 && c2 == 0 && c3 == 2 && !x) {
            Marcar(1, 2);
            x = true;

        }
        if (c1 == 0 && c2 == 2 && c3 == 2 && !x) {
            Marcar(1, 1);
            x = true;
        }

        //segunda fila horizontal
        if (c4 == 2 && c5 == 2 && c6 == 0 && !x) {
            Marcar(1, 6);
            x = true;
        }
        if (c4 == 2 && c5 == 0 && c6 == 2 && !x) {
            Marcar(1, 5);
            x = true;
        }
        if (c4 == 0 && c5 == 2 && c6 == 2 && !x) {
            Marcar(1, 4);
            x = true;
        }
        //tercera fila horizontal
        if (c7 == 2 && c8 == 2 && c9 == 0 && !x) {
            Marcar(1, 9);
            x = true;
        }
        if (c7 == 2 && c8 == 0 && c9 == 2 && !x) {
            Marcar(1, 8);
            x = true;
        }
        if (c7 == 0 && c8 == 2 && c9 == 2 && !x) {
            Marcar(1, 7);
            x = true;
        }
        //primera vertical
        if (c1 == 2 && c4 == 2 && c7 == 0 && !x) {
            Marcar(1, 7);
            x = true;
        }
        if (c1 == 2 && c4 == 0 && c7 == 2 && !x) {
            Marcar(1, 4);
            x = true;
        }
        if (c1 == 0 && c4 == 2 && c7 == 2 && !x) {
            Marcar(1, 1);
            x = true;
        }
        //segunda vertical
        if (c2 == 2 && c5 == 2 && c8 == 0 && !x) {
            Marcar(1, 8);
            x = true;
        }
        if (c2 == 2 && c5 == 0 && c8 == 2 && !x) {
            Marcar(1, 5);
            x = true;
        }
        if (c2 == 0 && c5 == 2 && c8 == 2 && !x) {
            Marcar(1, 2);
            x = true;
        }
        //tercera vertical
        if (c3 == 2 && c6 == 2 && c9 == 0 && !x) {
            Marcar(1, 9);
            x = true;
        }
        if (c3 == 2 && c6 == 0 && c9 == 2 && !x) {
            Marcar(1, 6);
            x = true;
        }
        if (c3 == 0 && c6 == 2 && c9 == 2 && !x) {
            Marcar(1, 3);
            x = true;
        }
        //primera diagonal
        if (c1 == 2 && c5 == 2 && c9 == 0 && !x) {
            Marcar(1, 9);
            x = true;
        }
        if (c1 == 2 && c5 == 0 && c9 == 2 && !x) {
            Marcar(1, 5);
            x = true;
        }
        if (c1 == 0 && c5 == 2 && c9 == 2 && !x) {
            Marcar(1, 1);
            x = true;
        }
        
        if (c3 == 2 && c5 == 2 && c7 == 0 && !x) {
            Marcar(1, 7);
            x = true;
        }
        if (c3 == 2 && c5 == 0 && c7 == 2 && !x) {
            Marcar(1, 5);
            x = true;
        }
        if (c3 == 0 && c5 == 2 && c7 == 2 && !x) {
            Marcar(1, 3);
            x = true;

        }


    }

    //pegar la funcion de bloqueo y cambiarle los "2" por "1" en las condiciones
    void ganarCPU() {
        //

        if (c1 == 1 && c2 == 1 && c3 == 0 && !x) {
            Marcar(1, 3);

            x= true;
        }
        if (c1 == 1 && c2 == 0 && c3 == 1 && !x) {
            Marcar(1, 2);
            x = true;

        }
        if (c1 == 0 && c2 == 1 && c3 == 1 && !x) {
            Marcar(1, 1);
            x = true;
        }

        //segunda fila horizontal
        if (c4 == 1 && c5 == 1 && c6 == 0 && !x) {
            Marcar(1, 6);
            x = true;
        }
        if (c4 == 1 && c5 == 0 && c6 == 1 && !x) {
            Marcar(1, 5);
            x = true;
        }
        if (c4 == 0 && c5 == 1 && c6 == 1 && !x) {
            Marcar(1, 4);
            x = true;
        }
        //tercera fila horizontal
        if (c7 == 1 && c8 == 1 && c9 == 0 && !x) {
            Marcar(1, 9);
            x = true;
        }
        if (c7 == 1 && c8 == 0 && c9 == 1 && !x) {
            Marcar(1, 8);
            x = true;
        }
        if (c7 == 0 && c8 == 1 && c9 == 1 && !x) {
            Marcar(1, 7);
            x = true;
        }
        //primera vertical
        if (c1 == 1 && c4 == 1 && c7 == 0 && !x) {
            Marcar(1, 7);
            x = true;
        }
        if (c1 == 1 && c4 == 0 && c7 == 1 && !x) {
            Marcar(1, 4);
            x = true;
        }
        if (c1 == 0 && c4 == 1 && c7 == 1 && !x) {
            Marcar(1, 1);
            x = true;
        }
        //segunda vertical
        if (c2 == 1 && c5 == 1 && c8 == 0 && !x) {
            Marcar(1, 8);
            x = true;
        }
        if (c2 == 1 && c5 == 0 && c8 == 1 && !x) {
            Marcar(1, 5);
            x = true;
        }
        if (c2 == 0 && c5 == 1 && c8 == 1 && !x) {
            Marcar(1, 2);
            x = true;
        }
        //tercera vertical
        if (c3 == 1 && c6 == 1 && c9 == 0 && !x) {
            Marcar(1, 9);
            x= true;
        }
        if (c3 == 1 && c6 == 0 && c9 == 1 && !x) {
            Marcar(1, 6);
            x = true;
        }
        if (c3 == 0 && c6 == 1 && c9 == 1 && !x) {
            Marcar(1, 3);

            x = true;
        }
        //primera diagonal
        if (c1 == 1 && c5 == 1 && c9 == 0 && !x) {
            Marcar(1, 9);
            x = true;
        }
        if (c1 == 1 && c5 == 0 && c9 == 1 && !x) {
            Marcar(1, 5);
            x= true;
        }
        if (c1 == 0 && c5 == 1 && c9 == 1 && !x) {
            Marcar(1, 1);
            x = true;
        }
        //segunda diagonal
        if (c3 == 1 && c5 == 1 && c7 == 0 && !x) {
            Marcar(1, 7);
            x = true;
        }
        if (c3 == 1 && c5 == 0 && c7 == 1 && !x) {
            Marcar(1, 5);
            x = true;
        }
        if (c3 == 0 && c5 == 1 && c7 == 1 && !x) {
            Marcar(1, 3);
            x= true;
        }


    }

    void marcaCentro() {

        if (c5 == 0 && !x) {
            Marcar(1, 5);
            x = true;
        }

    }

    void recorrerMatriz() {
        if (c1 == 0 && !x) {
            Marcar(1, 1);
            x = true;
        }
        if (c2 == 0 && !x) {
            Marcar(1, 2);
            x = true;
            System.out.println("2");
        }
        if (c3 == 0 && !x) {
            Marcar(1, 3);
            x = true;
            System.out.println("3");
        }
        if (c4 == 0 && !x) {
            Marcar(1, 4);
            x = true;
        }
        if (c5 == 0 && !x) {
            Marcar(1, 5);
            x = true;
        }
        if (c6 == 0 && !x) {
            Marcar(1, 6);
            x = true;
        }
        if (c7 == 0 && !x) {
            Marcar(1, 7);
            x = true;
        }
        if (c8 == 0 && !x) {
            Marcar(1, 8);
            x = true;
        }
        if (c9 == 0 && !x) {
            Marcar(1, 9);
            x = true;
        }

    }

   void bloqueoTotal(){
            if(c4==2&&c5==1&&c9==2&&c7==0&&!x){
                Marcar(1,7);
                x=true;
            }
            if(c1==2&&c5==1&&c9==2&&c8==0&& !x){
                Marcar(1,8);
                x=true;
            }
            if(c3==2&&c5==1&&c7==2&&c4==0&& !x){
                Marcar(1,4);
                x=true;
            }
            if(c3==2&&c5==1&&c8==2&&c6==0&&!x){
                Marcar(1,6);
                x=true;
            }
            if(c1==2&&c5==1&&c8==2&&c7==0&&!x){
                Marcar(1,7);
                x=true;
            }

   }

    void cpu() {
        //MARCA QUE NO HAY MARCAS DE LA CPU, X SE VUELVE TRUE CUANDO LA CPU MARCA
        x = false;
        y = false;
        boolean gano =ganador(2);

       
        if (gano) {
            JOptionPane.showMessageDialog(null, "felicidades, ganaste", "<3", JOptionPane.PLAIN_MESSAGE);
            inicio();
            y = true;
            
        }


        //esta funcion comprueba si puede ganar
        if (!x && !y) {
            System.out.println("ganandocpu");
            ganarCPU();
        }

        //intenta bloquear los tiros del ususario en caso de uqe se pueda

        if (!x && !y) {
            bloqueo();
            System.out.println("bloqueo");
        }

        //tira en el centro en caso de que este vacio
        if (!x && !y) {
            marcaCentro();
        }

        if(!x && !y){
            bloqueoTotal();
        }

        //si no puedo hacer nada de lo anterior

        if (!x && !x && c3 == 0) {
            Marcar(1, 3);
            x=true;
        }
        //funcion  de comprobacion de casillas vacias

        if (!x && !y) {
            recorrerMatriz();
        }


//comprueba si CPU gano
        if (x && !y) {
            gano = ganador(1);
            if (gano) {
                JOptionPane.showMessageDialog(null, "DERROTA", "GG :C", JOptionPane.PLAIN_MESSAGE);
                inicio();
                y = true;
            }

        }

        if(c1!=0&&c2!=0&&c3!=0&&c4!=0&&c5!=0&&c6!=0&&c7!=0&&c8!=0&&c9!=0){
            JOptionPane.showMessageDialog(null, "Empate", ":s", JOptionPane.PLAIN_MESSAGE);
            inicio();
        }

    }


    public VistaGato() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GATO");

        b2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b9.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        Marcar(2, 7);
        cpu();
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        Marcar(2, 8);
        cpu();
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        Marcar(2, 9);
        cpu();
    }//GEN-LAST:event_b9ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        Marcar(2, 4);
        cpu();
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        Marcar(2, 5);
        cpu();
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        Marcar(2, 6);
        cpu();
    }//GEN-LAST:event_b6ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        Marcar(2, 3);
        cpu();
    }//GEN-LAST:event_b3ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        Marcar(2, 1);
        cpu();
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        Marcar(2, 2);
        cpu();
    }//GEN-LAST:event_b2ActionPerformed

 
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}