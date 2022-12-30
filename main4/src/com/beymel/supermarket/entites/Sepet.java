package com.beymel.supermarket.entites;

import java.util.ArrayList;
import java.util.List;


public class Sepet {
	List<Character> urunkodu; //Bir sınıf (nesne) yalnızca bir amaç uğruna değiştirilebilir, o amaçta o sınıfa yüklenen sorumluluktur, 
            //yani bir sınıfın yapması gereken yalnızca bir işi olması gerekir.

	public Sepet() {
		urunkodu = new ArrayList<Character>(); // polymorphsim 
	}

	public void urunEkle(Character item) {
		urunkodu.add(item);
	}

	public void OgeSil(Character item) {
		urunkodu.remove(item);
	}

	public void SepetiSil() {
		urunkodu.clear();
	}
	
	public int Boyut(){
		return urunkodu.size();
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Character c : urunkodu) {
			builder.append(c);
		}
		return builder.toString();
	}
}
