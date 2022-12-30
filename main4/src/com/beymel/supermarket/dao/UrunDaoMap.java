package com.beymel.supermarket.dao;

import com.beymel.supermarket.entites.Alısveris;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beymel.supermarket.entites.Alısveris;
import com.beymel.supermarket.entites.Urun;


public class UrunDaoMap implements UrunnDao{
	private Map<Character, Urun> localMap;
	
	public UrunDaoMap(){
		localMap = new HashMap<Character, Urun>(); // ürün ekleme 
		localMap.put('A', new Urun('A', "Deterjan", "Bu oge 'A'", new Alısveris(null,1,1), 20));
		localMap.put('B',new Urun('B', "Makarna", "Bu oge  'B'", new Alısveris("5 fiyati icin 3",5,3), 50));
		localMap.put('C', new Urun('C', "Sampuan", "Bu oge 'C'", new Alısveris(null,1,1), 30));
                localMap.put('D', new Urun('D', "Coca Cola", "Bu oge 'D'", new Alısveris(null,1,1), 40));
		localMap.put('E',new Urun('E', "Yag", "Bu oge  'E'", new Alısveris("5 fiyati icin 3",5,3), 130));
		localMap.put('F', new Urun('F', "Pirinc", "Bu oge 'F'", new Alısveris(null,1,1), 50));
                localMap.put('G', new Urun('G', "El kremi", "Bu oge 'G'", new Alısveris(null,1,1), 30));
                localMap.put('H', new Urun('H', "Çikolata Çeşitleri", "Bu oge 'H'", new Alısveris(null,1,1), 10));
                localMap.put('I', new Urun('I', "Meyve Cesitleri", "Bu oge 'I'", new Alısveris(null,1,1), 10));
                localMap.put('J', new Urun('J', "Sebze Cesitleri", "Bu oge 'J'", new Alısveris(null,1,1), 5));
                localMap.put('K', new Urun('K', "Kraker cesitleri", "Bu oge 'K'", new Alısveris(null,1,1), 5));
                localMap.put('L', new Urun('L', "Bisküvi cesitleri", "Bu oge 'L'", new Alısveris(null,1,1), 5));
                localMap.put('M', new Urun('M', "Meyve Suyu", "Bu oge 'M'", new Alısveris(null,1,1), 5));
               
                
	}

	@Override                       //LSP
	public Urun create(Urun item) { // Türeyen sınıf yani alt sınıflar ana(üst) sınıfın tüm özelliklerini ve metotlarını 
                                        //aynı işlevi gösterecek şekilde kullanabilme ve kendine ait yeni özellikler barındırabilmelidir.
		localMap.put(item.getCode(), item);
		return item;
	}

	@Override
	public Urun read(char code) {
		return localMap.get(code);
	}

	@Override
	public Urun update(Urun item) {
		localMap.put(item.getCode(), item);
		return item;
	}

	@Override
	public boolean delete(char code) {
		Urun deleted = localMap.remove(code);
		return deleted != null ? true : false;
	}

	@Override
	public boolean delete(Urun item) {
		Urun deleted = localMap.remove(item.getCode());
		return deleted != null ? true : false;
	}

	@Override
	public List<Urun> readAll() {
		return new ArrayList<Urun>(localMap.values());
	}
}
