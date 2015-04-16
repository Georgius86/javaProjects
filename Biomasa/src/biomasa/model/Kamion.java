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
public class Kamion {
    
    private int sifra;
    private String registracija;
    private Prijevoznik prijevoznik;
    private Vozac vozac;
    private int nosivost;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    
    
    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public Prijevoznik getPrijevoznik() {
        return prijevoznik;
    }

    public void setPrijevoznik(Prijevoznik prijevoznik) {
        this.prijevoznik = prijevoznik;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public int getNosivost() {
        return nosivost;
    }

    public void setNosivost(int nosivost) {
        this.nosivost = nosivost;
    }

    @Override
    public String toString() {
        return getPrijevoznik().getNaziv() + ": " + registracija + ", nosivost: " + nosivost + " tona";
    }
    
    
    
}
