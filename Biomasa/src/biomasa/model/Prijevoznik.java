/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.model;

import java.util.List;

/**
 *
 * @author Đorđe
 */
public class Prijevoznik {
    
    private int sifra;
    private String naziv;
    private String mjesto;
    private String oib;
    private List<Vozac> vozaci;

    public List<Vozac> getVozaci() {
        return vozaci;
    }

    public void setVozaci(List<Vozac> vozaci) {
        this.vozaci = vozaci;
    }
    
    

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMjesto() {
        return mjesto;
    }

    public void setMjesto(String mjesto) {
        this.mjesto = mjesto;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

     
     
    @Override
    public String toString() {
        return this.naziv + ", " + this.mjesto;
    }
    
    
    
}
