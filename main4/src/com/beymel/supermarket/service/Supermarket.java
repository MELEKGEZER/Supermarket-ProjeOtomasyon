package com.beymel.supermarket.service;

public interface Supermarket {
                                        //Dependency Injection
	public int Odeme(String items);//Böylece Supermarket sınıfını BEYMELmarket’in bir implementasyonu olarak kullanabiliriz. 
                                       //Supermarket interface’ini oluşturmamız başka Supermarket implementasyonlarını kullanabilmemizi sağlayacaktır.

}
