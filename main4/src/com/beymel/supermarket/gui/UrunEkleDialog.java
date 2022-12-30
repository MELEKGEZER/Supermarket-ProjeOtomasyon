package com.beymel.supermarket.gui;

import com.beymel.supermarket.entites.Alısveris;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.beymel.supermarket.Main4;
import com.beymel.supermarket.entites.Alısveris;
import com.beymel.supermarket.entites.Urun;
import com.beymel.supermarket.dao.UrunnDao;
import java.awt.Color;



public class UrunEkleDialog {
	
	private UrunnDao dao; //Dependency injection kaba tabir ile bir sınıfın/nesnenin bağımlılıklardan kurtulmasını amaçlayan 
                              //ve o nesneyi olabildiğince bağımsızlaştıran bir programlama tekniği/prensibidir.
	
	public UrunEkleDialog(UrunnDao itemDao){
		this.dao = itemDao;
	}
	
	
	public void showDialog(){
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat; // double gibi sınıfları stringe çevirir 
		decimalFormat.setGroupingUsed(false);
		
        JTextField codeField = new JTextField("E");
        codeField.setDocument(new Karakter());
        codeField.setText("E");
        JTextField nameField = new JTextField(" ");
        JTextField descField = new JTextField("Yeni bir oge ");
        JTextField priceField = new JFormattedTextField(decimalFormat);
        priceField.setText("25");
        JTextField numberOfItemsField = new JFormattedTextField(numberFormat);
        numberOfItemsField.setText("1");
        JTextField forThePriceOfField = new JFormattedTextField(numberFormat);
        forThePriceOfField.setText("1");
        
	        JPanel panel = new JPanel(new GridLayout(0, 1));
	        panel.add(new JLabel("urun kodu:"));
	        panel.add(codeField);
	        panel.add(new JLabel("Isim:"));
	        panel.add(nameField);	        
	        panel.add(new JLabel("Aciklama:"));
	        panel.add(descField);
	        panel.add(new JLabel("Urun:"));
	        panel.add(priceField);	        
	        panel.add(new JLabel(""));
	        panel.add(new JLabel("Firsat Bilgisi:"));
	        panel.add(new JLabel("Oge numarasi:"));
	        panel.add(numberOfItemsField);
	        panel.add(new JLabel("Fiyati icin:"));
	        panel.add(forThePriceOfField);
	        panel.add(new JLabel(""));
                panel.setBackground(Color.PINK);
                System.out.println("Urun eklendii");
	        
	        int result = JOptionPane.showConfirmDialog(null, panel, "ekle/guncelle",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	int numberOfItemsValue = Double.valueOf(numberOfItemsField.getText()).intValue();
	        	int forThePriceOfValue =  Double.valueOf(forThePriceOfField.getText()).intValue();
		        if(codeField.getText().isEmpty() || nameField.getText().isEmpty() || Double.valueOf(priceField.getText())<=0
		        		|| Double.valueOf(numberOfItemsField.getText())<1 || Double.valueOf(forThePriceOfField.getText())<1 ){
		        	JOptionPane.showMessageDialog(null, "Bir veya daha fazla alan geçersizdir, lütfen tekrar deneyin.", "HATA", JOptionPane.ERROR_MESSAGE);
		        }else{
		        	Alısveris d = null;
		        	if(numberOfItemsValue!=forThePriceOfValue)
		        		d = new Alısveris(String.format("%s fiyatı için %s", numberOfItemsValue, forThePriceOfValue),
		        				numberOfItemsValue, forThePriceOfValue);
		        	Urun i = new Urun(codeField.getText().toUpperCase().charAt(0), nameField.getText(), descField.getText(), 
		        			d, Double.valueOf(priceField.getText()).intValue());
		        	dao.create(i);
		        	Main4.getSupermarketPanel().initializeButtons();
		        }
	        } else {
	            System.out.println("Iptal edildi");
	        }
	}
	
	
	private class Karakter extends PlainDocument { // kalitim uygulama 
		private static final long serialVersionUID = 1L;

		@Override
		public void insertString(int offs, String str, AttributeSet a)
				throws BadLocationException {
			if(str != null && (getLength() + str.length() < 2)){
				super.insertString(offs, str, a);
			}
		}
	}
        
}
