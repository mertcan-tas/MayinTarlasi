package com.mayintarlasi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;

public class Oyun extends javax.swing.JFrame {

    int ekranGenisligi;
    int ekranYuksekligi;
    int zorluk;
    Map map;
    boolean isClosed = false;
    boolean isNew = false;
    int time;
    public static int mineCount;
    public static boolean isStart = false;

    public Oyun() {
        ekranGenisligi = Toolkit.getDefaultToolkit().getScreenSize().width;
        ekranYuksekligi = Toolkit.getDefaultToolkit().getScreenSize().height;
        initComponents();
        zorluk = 1;
        setNewGame();
    }

    private void setNewGame() {
        
        timeLabel.setText("0");
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                }
                isNew=false;            
                        }
        }).start();
        
        time = 0;
        map = new Map(zorluk);
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        setSize(map.getWidth() + 18, map.getHeight() + 121);
        jPanel2.add(map);
        setLocation((ekranGenisligi - this.getWidth()) / 2, (ekranYuksekligi - this.getHeight()) / 2);

        mineCountLabel.setText("" + mineCount);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                    if (isClosed) {
                        break;
                    }
                    if (map.isBoom) {
                        break;
                    }
                    if (isStart) {
                        time++;
                        timeLabel.setText("" + time);
                    }
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (isNew) {
                        break;
                    }
                }
            }
        }).start();

        new Thread(
                new Runnable() {
            @Override
            public void run() {
                try {

                    while (true) {
                        if (isClosed) {
                            break;
                        }
                        Thread.currentThread().sleep(100);
                        mineCountLabel.setText("" + mineCount);
                        if (map.correctMineCount == map.mayinSayisi) {
                            JOptionPane.showMessageDialog(rootPane, "Tebrikler");
                            isStart = false;
                            break;
                        }
                        if (map.isBoom) {
                            JOptionPane.showMessageDialog(rootPane, "Mayına Bastın!!!");
                            isStart = false;
                            break;
                        }

                    }
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mineCountLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newGame = new javax.swing.JMenuItem();
        beginner = new javax.swing.JMenuItem();
        intermediate = new javax.swing.JMenuItem();
        expert = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFocusable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mineCountLabel.setBackground(new java.awt.Color(0, 0, 0));
        mineCountLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mineCountLabel.setForeground(new java.awt.Color(255, 51, 0));
        mineCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mineCountLabel.setText("000");

        timeLabel.setBackground(new java.awt.Color(0, 0, 0));
        timeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 51, 0));
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("000");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mayintarlasi/sources/gulenyuz.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(mineCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(mineCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jMenu1.setText("Game");

        newGame.setText("New");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        jMenu1.add(newGame);

        beginner.setText("Beginner");
        beginner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginnerActionPerformed(evt);
            }
        });
        jMenu1.add(beginner);

        intermediate.setText("Intermediate");
        intermediate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intermediateActionPerformed(evt);
            }
        });
        jMenu1.add(intermediate);

        expert.setText("Expert");
        expert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expertActionPerformed(evt);
            }
        });
        jMenu1.add(expert);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        isClosed = true;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void expertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expertActionPerformed
        zorluk = 3;
        isNew=true;
        isStart=false;
        setNewGame();
    }//GEN-LAST:event_expertActionPerformed

    private void intermediateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intermediateActionPerformed
        zorluk = 2;
        isNew=true;
        isStart=false;
        setNewGame();
    }//GEN-LAST:event_intermediateActionPerformed

    private void beginnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginnerActionPerformed
        zorluk = 1;
        isNew=true;
        isStart=false;
        setNewGame();
    }//GEN-LAST:event_beginnerActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        isNew=true;
        isStart=false;
        setNewGame();

    }//GEN-LAST:event_newGameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setNewGame();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Oyun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem beginner;
    private javax.swing.JMenuItem expert;
    private javax.swing.JMenuItem intermediate;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mineCountLabel;
    private javax.swing.JMenuItem newGame;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
