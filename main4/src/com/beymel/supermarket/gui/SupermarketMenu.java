package com.beymel.supermarket.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.beymel.supermarket.Main4;


public class SupermarketMenu {

	public static JMenuBar getMenu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("Urun ekle/Guncelle");
                JMenuItem sil = new JMenuItem("Ürün Sil");
		JMenuItem exit = new JMenuItem("Cikis");
		JMenuItem addItem = new JMenuItem("Oge Ekle/Guncelle");

		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });  
                sil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("eklediginiz urunler silindi");
            }
        });  
		
		addItem.addActionListener((ActionEvent e) -> {
                    Main4.showAddItem();
                });
		
		file.add(addItem);
		file.addSeparator();
		file.add(exit);
		file.add(sil);
		
		menuBar.add(file);
		return menuBar;
	}
}
