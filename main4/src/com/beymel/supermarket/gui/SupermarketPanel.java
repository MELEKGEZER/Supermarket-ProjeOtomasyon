package com.beymel.supermarket.gui;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.beymel.supermarket.Main4;

import com.beymel.supermarket.entites.Sepet;
import com.beymel.supermarket.entites.Alısveris;
import com.beymel.supermarket.entites.Urun;
import com.beymel.supermarket.service.Supermarket;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import com.beymel.supermarket.dao.UrunnDao;




public class SupermarketPanel extends JPanel { //jpanelden kalıtım 

	private static final long serialVersionUID = 1L;
	
	private Sepet sepet;
	private Supermarket supermarket;
	private UrunnDao itemDao;
	private JLabel cartLabel;
	private JPanel itemPanel;
	
	public SupermarketPanel(Supermarket supermarket_, UrunnDao dao_) {
		this.supermarket = supermarket_;
		this.itemDao = dao_;
		init();
	}

	
	public void init(){
		this.removeAll();
		this.setLayout(null);
		sepet = new Sepet();
               

		JLabel addLabel = new JLabel("ürünler:");
		addLabel.setBounds(100, 0, 75, 20);
                addLabel.setBackground(Color.pink);
		add(addLabel);

		initializeButtons();
		
              
		
		cartLabel = new JLabel(sepet.Boyut() + "sepetiniz");
		cartLabel.setBounds(10, 355, 150, 20);
                
		add(cartLabel);

	
		JButton checkoutButton = new JButton("Ödeme Noktasi");
                Image img1 =new ImageIcon(SupermarketPanel.class.getResource("/kasa.png")).getImage();
                checkoutButton.setIcon(new ImageIcon(img1));
               
               
		checkoutButton.addActionListener((ActionEvent e) -> {
                    checkOut(true);
                });
		checkoutButton.setBounds(10, 375, 200, 50);
		add(checkoutButton);
		
	}

	
        @SuppressWarnings("Bos ifade")
	public void initializeButtons() {
		if(null!=itemPanel)
			remove(itemPanel);
		
		itemPanel = new JPanel();
		itemPanel.setLayout(new FlowLayout());
		List<Urun> allItems = itemDao.readAll();
		
                Image img2 =new ImageIcon(SupermarketPanel.class.getResource("/market.jpeg")).getImage();
               
		
		Collections.sort(allItems, new Comparator<Urun>() { //Collectionlar 
			@Override
			public int compare(Urun o1, Urun o2) { // iki öğeyi karşılaştır ona göre değişimini yap 
				Character c1 = o1.getCode();
				Character c2 = o2.getCode();
				return c1.compareTo(c2);
			}
		});
		
		for(final Urun item : allItems){
			JButton addButton = new JButton(item.getName());
			Alısveris deal = item.getDeal();
			String dealName = deal == null ? "" : "<br>" + deal.getName();
			
			addButton.setToolTipText("<html>"+item.getDescription()+"<br>Fiyat: ₺"+item.getPrice()+ dealName+"</html>"); // öğe fiyatını ekrana yazdır 
			
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sepet.urunEkle(item.getCode());
					cartLabel.setText(sepet.Boyut()+ " sepetinizdeki ürün sayisi"); // sepette olan ürün kodlarını yaz
                                        
				}
			});
	
			addButton.setSize(new Dimension(100, 10));
			itemPanel.add(addButton);
		}
                    
               
		
		itemPanel.setBounds(100, 30, 500, 300);
                itemPanel.setBackground(Color.cyan);
		add(itemPanel);
              
		Main4.getFrame().setVisible(true);
               
	}

	
	public boolean checkOut(boolean showMessage) {
		if(null==sepet){
			sepet = new Sepet();
		}
		
		int total = 0;
		boolean success = false;
		String stringOfItems = sepet.toString();
		if (stringOfItems.isEmpty()) {
			if(showMessage) {
                            JOptionPane.showMessageDialog(Main4.getFrame(), "Sepetiniz Bos","Dikkat", JOptionPane.WARNING_MESSAGE);
                        }
		} else {
			total = supermarket.Odeme(stringOfItems);
			sepet.SepetiSil();
			cartLabel.setText(sepet.Boyut()+ "sepetinizdeki urunler ");
			success = true;
			if(showMessage)
				JOptionPane.showMessageDialog(Main4.getFrame(),
						String.format("<html>Satin alinan urunler: %s<br><br>toplamda :₺ %s</html>"
								,stringOfItems, total), "Toplam",JOptionPane.INFORMATION_MESSAGE);
		}
		return success;
	}
	
		public void setCart(Sepet cart){
		this.sepet = sepet;
	}

}
