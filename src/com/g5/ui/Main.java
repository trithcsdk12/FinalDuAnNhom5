/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g5.ui;

import com.g5.component.Menu;
import com.g5.event.EventMenuSelected;
import com.g5.form.HoaDonJPanel;
import com.g5.form.NhanVienJPanel;
import com.g5.form.TrangChuJPanel;
import com.g5.model.Model_Menu;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author anhba
 */
public class Main extends javax.swing.JFrame {

    private Menu menu = new Menu();
    private JPanel main = new JPanel();
    private MigLayout layout;
    private Animator animator;
    private boolean menuShow;

    public Main() {
        this.setUndecorated(true);
        initComponents();

        init();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void init() {
        //setSize(1000, 800);
        setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        
        
        layout = new MigLayout("fill", "0[]3[]0", "0[fill]0"); // layout cua form chinh "giản cách bên trái[]giản cách ở giữ[] giản cách bên phải
        panelBody.setLayout(layout); // set layout cho form chinh

        main.setOpaque(false);
        main.setLayout(new BorderLayout());
        menu.addEventButtonMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        menu.addEventButtonLogout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.setEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    showForm(new TrangChuJPanel());
                }
                if (index == 1) {
                    showForm(new NhanVienJPanel());
                }
                if (index == 2) {
                    showForm(new HoaDonJPanel());
                }
                if (index == 3) {
                    
                }
                if (index == 4) {
                    //   showForm(new Form5());
                }
            }
        });

        menu.addMenu(new Model_Menu("Trang chủ", new ImageIcon(Main.class.getResource("/com/g5/image/Home_2.png"))));
        menu.addMenu(new Model_Menu("Nhân viên", new ImageIcon(Main.class.getResource("/com/g5/image/Person_1.png"))));
        menu.addMenu(new Model_Menu("Hóa đơn", new ImageIcon(Main.class.getResource("/com/g5/image/Bill.png"))));
        menu.addMenu(new Model_Menu("Sản phẩm", new ImageIcon(Main.class.getResource("/com/g5/image/Box.png"))));
        menu.addMenu(new Model_Menu("Thống kê", new ImageIcon(Main.class.getResource("/com/g5/image/Combo_Chart.png"))));

        panelBody.add(menu, "w 62!");
        panelBody.add(main, "w 100%");

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuShow) {
                    width = 62 + (150 * (1f - fraction));
                    menu.setAlpha(1f - fraction);
                } else {
                    width = 62 + (150 * fraction);
                    menu.setAlpha(fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                panelBody.revalidate();
            }

            @Override
            public void end() {
                if(menu.getWidth() > 63){
                menuShow = true;
                return;
                }
                if(menu.getWidth() < 63){
                menuShow = false;
                return;
                }
                
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
      //  menu.initMoving(Main.this);
        showForm(new TrangChuJPanel());
    }

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBody;
    // End of variables declaration//GEN-END:variables
}
