package com.g5.util;


import java.awt.Component;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anhba
 */
public class Message {

    public static void Alert(Component comp, String text) {
        JOptionPane.showMessageDialog(comp, text, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

}
