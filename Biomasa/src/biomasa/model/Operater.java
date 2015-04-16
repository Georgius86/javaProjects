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
public class Operater {
    
    public static final String ADMINISTRATOR="administrator";
    public static final String KORISNIK="korisnik";
    
    private int sifra;
    private String korisnik;
    private String lozinkaMD5;
    private String lozinka;
    private String ime;
    private String prezime;
    private String uloga;
   

    public String getUloga() {
        if(uloga==null)
            return Operater.KORISNIK;
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
       
    public String getLozinkaMD5() {
        return lozinkaMD5;
    }

    public void setLozinkaMD5(String lozinkaMD5) {
        this.lozinkaMD5 = lozinkaMD5;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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
