
package com.beymel.supermarket.gui;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import javax.swing.ImageIcon;


import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GirisGui extends JDialog {
    public GirisGui(){
        initDialog();   
    }
    private void initDialog(){
    add(initPanel());
    setTitle("Giriş");
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setResizable(false);
    setVisible(true);
    }
    private JPanel initPanel(){
        JPanel anaPanel=new JPanel(new GridLayout(3, 2, 5, 5));
        
        JLabel kullaniciAdiLabel= new JLabel("Kullanıcı Adı");
        JTextField kullaniciAdiField= new JTextField(10);
        JLabel parolaLabel= new JLabel("Parola");
        JPasswordField parolaField= new  JPasswordField(10);
        JButton girisButton= new JButton("Giriş");
        JButton iptalButton= new JButton("İptal");
        
        girisButton.addActionListener((ActionEvent args0) -> {
             
             System.out.println("Markete giris yapildi Hosgeldiniz");
             
           
        });
        iptalButton.addActionListener((ActionEvent args0) -> {
             
             System.out.println("Giris yapilamadi tekrar bekleriz");
             
           
        });
        
        anaPanel.add(kullaniciAdiLabel);
        anaPanel.add(kullaniciAdiField);
        anaPanel.add(parolaLabel);
        anaPanel.add(parolaField);
        anaPanel.add(girisButton);
        anaPanel.add(iptalButton);
       
        girisButton.setBackground(Color.MAGENTA);
        iptalButton.setBackground(Color.CYAN);

        return anaPanel;
        
    }
    
    
}
