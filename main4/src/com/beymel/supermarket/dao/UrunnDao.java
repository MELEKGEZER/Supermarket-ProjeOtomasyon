package com.beymel.supermarket.dao;

import java.util.List;

import com.beymel.supermarket.entites.Urun;


public interface UrunnDao {

	
	public Urun create(Urun item);
	
	
	
	public Urun read(char code);
	
	
	public Urun update(Urun item);
	
	
	public boolean delete(char code);
	
	
	public boolean delete(Urun item);
	
	
	public List<Urun> readAll();

}
