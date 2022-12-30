
package com.beymel.supermarket;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.beymel.supermarket.dao.UrunDaoMap;
import com.beymel.supermarket.gui.UrunEkleDialog;
import com.beymel.supermarket.gui.GirisGui;
import com.beymel.supermarket.gui.SupermarketMenu;
import com.beymel.supermarket.gui.SupermarketPanel;
import com.beymel.supermarket.service.BeyMelmarket;
import com.beymel.supermarket.dao.UrunnDao;
import java.awt.Color;


public class Main4 {

	private static JFrame  frame;
	private static JPanel content;
	private static SupermarketPanel supermarketPanel;
	private static UrunEkleDialog itemDialog;
	private static UrunnDao dao = new UrunDaoMap();// POLYMORPHİSM 

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main4().run();
			}
		});
	}
       
	
	
	private void run(){
		frame = new JFrame("BEYMEL Market");
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		
		content = new JPanel();// polymorphism
		content.setLayout(new CardLayout());
		
		supermarketPanel = new SupermarketPanel(new BeyMelmarket(dao), dao);
		content.add(supermarketPanel);
		itemDialog = new UrunEkleDialog(dao);
                
		
		frame.setJMenuBar(SupermarketMenu.getMenu());
		frame.setContentPane(content);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(800, 500);
                frame.setLocation(100, 200);
                supermarketPanel.setBackground(Color.magenta);
                
               
                 new GirisGui();
                 new dosya();
            
                
                
	}
	
	public static void showAddItem(){
		itemDialog.showDialog();
	}

	
	public static SupermarketPanel getSupermarketPanel() {
		return supermarketPanel;
	}
	
	
	public static JFrame getFrame(){
		return frame;
	}	
	
	
	public static void setFrame(JFrame frame_){
		frame = frame_;
	}

   

    
}