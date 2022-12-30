package com.beymel.supermarket.service;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.beymel.supermarket.entites.Alısveris;
import com.beymel.supermarket.entites.Urun;
import com.beymel.supermarket.dao.UrunnDao;


public final class BeyMelmarket implements Supermarket { // interface 

	private UrunnDao urunDao;
	
	public BeyMelmarket(UrunnDao dao) {
		this.urunDao = dao;
	}
	
	
	@Override
	public int Odeme(String oge) { // Alt seviye sınıflardan oluşan nesnelerin/
                                       //sınıfların, ana(üst) sınıfın nesneleri ile yer değiştirdikleri zaman,
                                       //aynı davranışı sergilemesi gerekmektedir. Türetilen sınıflar, 
                                       //türeyen sınıfların tüm özelliklerini kullanabilmelidir.”
		if(null==oge || oge.isEmpty())
			return 0;
		
		oge =oge .replaceAll("\\s", "").toUpperCase();
		Map<Character, Integer> quantities = miktarHesapla(oge);
		int total = hesaplaToplamFiyat(quantities);
		return total;
	}

	
	private int hesaplaToplamFiyat(Map<Character, Integer> quantities) { // veri tabanı kullanmadan map ile öğeleri içeri aktar 
		int sum = 0;
		Iterator<Map.Entry<Character, Integer>> iter = quantities.entrySet().iterator();//anahtarları değerlerle eşleştirme 
		while (iter.hasNext()) {
			Map.Entry<Character, Integer> mapEntry = iter.next();
			sum += hesaplaÖğeTeklifFiyatı(mapEntry.getKey(),
					mapEntry.getValue());
		}
		return sum;
	}

	
	private int hesaplaÖğeTeklifFiyatı(char urunkod, int f) {
		
		Urun item = urunDao.read(urunkod);
		if(item==null)
			throw new IllegalArgumentException(String.format("Urun kodu '%s' gecerli degil", urunkod));
		
		Alısveris deal = item.getDeal();
		int fiyat = item.getPrice();
		
		int satisucreti = (f / deal.getNumberOfItems()) * (fiyat * deal.getForThePriceOf());
		
		int fullPrice = (f % deal.getNumberOfItems()) * fiyat;
		return satisucreti + fullPrice;
	}

	
	private Map<Character, Integer> miktarHesapla(String items) {
		Map<Character, Integer> miktar = new HashMap<Character, Integer>();
		for (char code : items.toCharArray()) {
			Integer currentQuantity = miktar.get(code);
			int quantity = currentQuantity == null ? 1 : currentQuantity + 1;
			miktar.put(code, quantity);
		}
		System.out.print("Urun  miktarlari: ");
		System.out.println(miktar);
		return miktar;
	}
	
	
}
