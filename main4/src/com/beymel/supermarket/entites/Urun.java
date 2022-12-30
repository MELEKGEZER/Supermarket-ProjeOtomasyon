package com.beymel.supermarket.entites;

public class Urun {

	private char code;
	private String name;
	private String description;
	private Alısveris deal;
	private int price;

	public Urun(char code, String name, String description, Alısveris deal, int price) {//Single responsibility prensibi sınıflarımızın iyi tanımlanmış tek bir sorumluluğu olması gerektiğini anlatmaktadır. 
            //Bir sınıf (nesne) yalnızca bir amaç uğruna değiştirilebilir, o amaçta o sınıfa yüklenen sorumluluktur, 
            //yani bir sınıfın yapması gereken yalnızca bir işi olması gerekir.
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.deal = deal;
		this.price = price;
	}

	
	public char getCode() {
		return code;
	}

	
	public void setCode(char code) {
		this.code = code;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {// tanımlamalar 
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Alısveris getDeal() {
		return deal;
	}

	
	public void setDeal(Alısveris deal) {
		this.deal = deal;
	}

	
	public int getPrice() {
		return price;
	}

	
	public void setPrice(int price) {
		this.price = price;
	}


}
