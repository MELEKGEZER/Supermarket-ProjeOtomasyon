/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beymel.supermarket;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class dosya {

    public dosya() {
        FileOutputStream fileOutputStream =null;
        try{
            fileOutputStream =new FileOutputStream("beymel.txt");
            String isim ="Deterjan fiyat:20\n"
                    + "Makarna fiyat:50\n"
                    + "Sampuan fiyat:30\n"
                    + "Coca cola fiyat:40\n"
                    + "yag fiyat:130\n"
                    + "pirinc fiyat:50\n"
                    + "cikolata cesitleri  fiyat:10\n"
                    + "meyve cesitleri fiyat:10\n"
                    + "sebze cesitleri fiyat:20\n"
                    + "kraker cesitleri fiyat:5\n"
                    + "bisküvi çesitleri fiyat:12\n"
                    + "meyse suyu fiyat:5\n"
                    + "saç kremi fiyat:55\n";
            byte[] idizi=isim.getBytes();
            fileOutputStream.write(idizi);
            
            
        }catch(Exception e){
            System.out.println("Dosya bulunamadi");
        }finally{
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                 System.out.println("dosya kapatilirken bir hata oluştu");
              
            }
        }
    }
    
}
