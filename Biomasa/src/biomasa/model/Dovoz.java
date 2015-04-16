/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Đorđe
 */
public class Dovoz {
    
    private int sifra;
    private Kamion kamion;
    private Date vrijemeistovara;
    private Dobavljac dobavljac;
    private Stovariste stovariste;
    private String sirovina;
    private BigDecimal kolicinat;

    
    public BigDecimal getKolicinat() {
        return kolicinat;
    }

    public void setKolicinat(BigDecimal kolicinat) {
        this.kolicinat = kolicinat;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public Kamion getKamion() {
        return kamion;
    }

    public void setKamion(Kamion kamion) {
        this.kamion = kamion;
    }

    public Date getVrijemeistovara() {
        return vrijemeistovara;
    }

    public void setVrijemeistovara(Date vrijemeistovara) {
        this.vrijemeistovara = vrijemeistovara;
    }

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public Stovariste getStovariste() {
        return stovariste;
    }

    public void setStovariste(Stovariste stovariste) {
        this.stovariste = stovariste;
    }

    public String getSirovina() {
        return sirovina;
    }

    public void setSirovina(String sirovina) {
        this.sirovina = sirovina;
    }



    @Override
    public String toString() {
        return vrijemeistovara + ", " + getStovariste().getNaziv() + ", " 
                + getStovariste().getMjesto() + ": " + getDobavljac().getNaziv() + " ("  
                + getSirovina() + ", " + getKolicinat() + " tona )";
    }
    
    
}
