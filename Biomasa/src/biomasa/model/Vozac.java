/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.model;

/**
 *
 * @author Đorđe
 */
public class Vozac {
    
    private int sifra;
    private String ime;
    private String prezime;
    private String oib;

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }
    
    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }
  
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImePrezime(){
        return this.ime + " " + this.prezime;
    }
    @Override
    public String toString() {
        return this.ime + " " + this.prezime;
    }
    
    
    
}
