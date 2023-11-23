/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g5.component;

import com.g5.util.XImage;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author anhba
 */
public class Info extends javax.swing.JPanel {

    private float alpha;

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    /**
     * Creates new form Bottom
     */
    public Info() {
        initComponents();
        setOpaque(false);
          setBackground(new Color(65, 152, 216));
        setInfo();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(5, 5, getWidth() - 15, getHeight() - 10, 20, 20);
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    public void setInfo() {
        txtName.setText("Tên: Anhbao5cm");
        txtRole.setText("Chức vụ: Nhân viên");
       

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();
        txtName1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setText("Tên");

        txtRole.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRole.setForeground(new java.awt.Color(255, 255, 255));
        txtRole.setText("Chức vụ:");

        txtName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName1.setForeground(new java.awt.Color(255, 255, 255));
        txtName1.setText("Mã NV:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName)
                    .addComponent(txtName1)
                    .addComponent(txtRole))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRole)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtName1;
    private javax.swing.JLabel txtRole;
    // End of variables declaration//GEN-END:variables
}
