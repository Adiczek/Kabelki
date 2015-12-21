/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabelki;

import javax.swing.ImageIcon;

/**
 *
 * @author Ardian
 *///id_przew,marka, zdjecie, ilosc, cena


public class Przewod {
    private int id;
    private String Marka;
    private ImageIcon Zdjecie;
    private String Ilosc;
    private String Cena;
    
    
    public void setId(int id) {
        this.id = id;
    }
    public void setMarka(String marka) {
        this.Marka = marka;
    }
    public void setZdjecie(ImageIcon zdjecie) {
        this.Zdjecie = zdjecie;
    }
    public void setIlosc(String ilosc) {
        this.Ilosc = ilosc;
    }
    public void setCena(String cena) {
        this.Cena = cena;
    }
 
    
    public int getId() {
        return id;
    }
    
    public String getMarka() {
        return Marka;
    }
    public ImageIcon getZdjecie() {
        return Zdjecie;
    }
    
    public String getIlosc() {
        return Ilosc;
    }
    public String getCena() {
        return Cena;
    }
  
    public Przewod() { }
    public Przewod(int id, String marka, ImageIcon zdjecie,String ilosc, String cena) {
        this.id = id;
        this.Marka = marka;
        this.Zdjecie = zdjecie;
        this.Ilosc = ilosc;
        this.Cena = cena;

    }
    @Override
    public String toString() {
        
        return "["+id+"] - "+Marka+" "+Zdjecie+" - "+ Ilosc + " - " + Cena;
    }
    
}
