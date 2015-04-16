/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.model;

import java.math.BigDecimal;

/**
 *
 * @author Đorđe
 */
public class Stovariste {
    
    private int sifra;
    private String naziv;
    private String adresa;
    private String mjesto;
    private BigDecimal povrsina;

    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(BigDecimal povrsina) {
        this.povrsina = povrsina;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMjesto() {
        return mjesto;
    }

    public void setMjesto(String mjesto) {
        this.mjesto = mjesto;
    }

   

    @Override
    public String toString() {
        return this.naziv + ", " + this.adresa + ", " + this.mjesto;
    }
    
    
    
}
