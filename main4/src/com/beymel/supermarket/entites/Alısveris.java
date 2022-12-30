package com.beymel.supermarket.entites;


public class Alısveris {//Bir sınıf (nesne) yalnızca bir amaç uğruna değiştirilebilir, o amaçta o sınıfa yüklenen sorumluluktur, 
            //yani bir sınıfın yapması gereken yalnızca bir işi olması gerekir.
           

	private String isim;
	private int urunNumarasi;
	private int Fiyat;
	
	public Alısveris(String isim, int urunNumarasi, int Fiyat) {
		super();
		this.isim = isim;
		this.urunNumarasi = urunNumarasi;
		this.Fiyat = Fiyat;
	}

	public String getName() {
		return isim;
	}

	public void setName(String isim) {
		this.isim = isim;
	}

	public int getNumberOfItems() {
		return urunNumarasi;
	}

	public void setNumberOfItems(int urunNumarasi) {
		this.urunNumarasi = urunNumarasi;
	}

	public int getForThePriceOf() {
		return Fiyat;
	}

	public void setForThePriceOf(int Fiyat) {
		this.Fiyat = Fiyat;
	}
}
