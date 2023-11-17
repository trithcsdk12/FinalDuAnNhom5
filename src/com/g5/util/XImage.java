/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.util;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;

/**
 *
 * @author anhba
 */
public class XImage {

    public static ImageIcon imageIcon = new ImageIcon(XImage.class.getResource("/com/g5/image/coffee.png"));

    public static Image getAppIcon() {
        return imageIcon.getImage();
    }

    public static void selectImage(String file, JLabel lbl) {
        try {
            //   BufferedImage originalImage = ImageIO.read(new File(file.toString()));
            lbl.setText("");
            ImageIcon icon = new ImageIcon(XImage.class.getResource("/com/g5/image/" + file.trim()));

            Image image = icon.getImage();

            Image scaledImage = image.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            lbl.setIcon(scaledIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectImage2(String file, JLabel lbl, int width, int height) {
        try {
            //   BufferedImage originalImage = ImageIO.read(new File(file.toString()));
            lbl.setText("");
            ImageIcon icon = new ImageIcon(XImage.class.getResource("/com/g5/image/" + file.trim()));

            Image image = icon.getImage();

            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            lbl.setIcon(scaledIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String urlImage(String picture) {
        return XImage.class.getResource("/com/g5/image/") + picture.trim();
    }

    public static void chooseImageMenu(String file, JMenu menu) {
        try {
            //   BufferedImage originalImage = ImageIO.read(new File(file.toString()));

            ImageIcon icon = new ImageIcon(XImage.class.getResource("/com/g5/image/" + file));

            Image image = icon.getImage();

            Image scaledImage = image.getScaledInstance(menu.getWidth() - 20, menu.getHeight() - 10, Image.SCALE_DEFAULT);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            menu.setIcon(scaledIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectImgShowHide(String file, String file2, JLabel lbl) {
        try {
            //   BufferedImage originalImage = ImageIO.read(new File(file.toString()));
            ImageIcon icon = new ImageIcon(XImage.class.getResource("/com/g5/image/" + file));
            ImageIcon icon2 = new ImageIcon(XImage.class.getResource("/com/g5/image/" + file2));
            Image image = icon.getImage();
            Image image2 = icon2.getImage();
            lbl.setText("");

            Image scaledImage = image2.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            lbl.setIcon(scaledIcon);
//            new Thread(new Runnable() {
//                int width = lbl.getWidth();
//                int height = lbl.getHeight();
//                
//                @Override
//                public void run() {
//                    for (int i = width; i > 0; i--) {
//                        try {
//                            Thread.sleep(10);
//                        } catch (Exception e) {
//                        }
//                        Image scaledImage = image.getScaledInstance(i, height, Image.SCALE_DEFAULT);
//                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
//                        lbl.setIcon(scaledIcon);
//                    }
//
//               //     System.out.println("xong");
//
//                    for (int i = 1; i < width; i++) {
//                        try {
//                            Thread.sleep(10);
//                        } catch (Exception e) {
//                        }
//                        Image scaledImage = image2.getScaledInstance(i, height, Image.SCALE_DEFAULT);
//                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
//                        lbl.setIcon(scaledIcon);
//                    }
//                }
//            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
