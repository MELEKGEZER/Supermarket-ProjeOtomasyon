/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beymel.supermarket.gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SupermarketFrame extends JFrame {

    private Object image;
    private ImageIcon imageIcon;
    private JLabel fotografEtiketi;
    public Image getImage() {
        if(this.image==null)
        {
            this.image=getImageIcon().getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        }
        return (Image) image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
     public ImageIcon getImageIcon() {
        if(this.imageIcon==null)
        {
            this.imageIcon=new ImageIcon("/market.jpeg");
        }
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public JLabel getFotografEtiketi() {
        if(this.fotografEtiketi==null)
        {
            this.fotografEtiketi=new JLabel(new ImageIcon(getImage()));
            this.fotografEtiketi.setBounds(0,0,500,500);
        }
        return fotografEtiketi;
    }

    public void setFotografEtiketi(JLabel fotografEtiketi) {
        this.fotografEtiketi = fotografEtiketi;
    
}
}
