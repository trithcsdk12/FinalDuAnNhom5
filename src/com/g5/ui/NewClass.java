/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g5.ui;

/**
 *
 * @author anhba
 */
public class NewClass {
    public static void main(String[] args) {
        System.out.println(urlImage("a.png"));
    }
        public static String urlImage(String picture) {
        return NewClass.class.getResource("/com/g5/image/") + picture.trim();
    }
}
