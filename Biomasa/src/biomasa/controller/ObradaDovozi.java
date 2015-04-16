/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.controller;

import biomasa.model.Dobavljac;
import biomasa.model.Dovoz;
import biomasa.model.Kamion;
import biomasa.model.Prijevoznik;
import biomasa.model.Stovariste;
import biomasa.model.Vozac;
import biomasa.utility.Baza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Đorđe
 */
public class ObradaDovozi {
    
    private PreparedStatement command;
    
    public List<Dovoz> uzmiPoTekstu (String uvjet){
        
        List<Dovoz> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement(" select  "
                    + " a.sifra as sifraDovoza, "
                    + " a.vrijemeistovara, " 
                    + " a.sirovina, "
                    + " a.kolicinat, " 
                    + " b.sifra as sifraKamiona, "
                    + " b.registracija, "
                    + " b.nosivost, "
                    + " c.sifra as sifraPrijevoznika, "
                    + " c.naziv as nazivPrijevoznika, "
                    + " c.mjesto as mjestoPrijevoznika, "
                    + " c.oib as oibPrijevoznika, "                     
                    + " d.sifra as sifraVozaca, "
                    + " d.ime, "
                    + " d.prezime, "
                    + " d.oib as oibVozaca, "                    
                    + " e.sifra as sifraDobavljaca, "
                    + " e.naziv as nazivDobavljaca, "
                    + " e.mjesto as mjestoDobavljaca, "
                    + " e.oib as oibDobavljaca, "                     
                    + " f.sifra as sifraStovarista, "
                    + " f.naziv as nazivStovarista, "
                    + " f.adresa, "
                    + " f.mjesto as mjestoStovarista, "
                    + " f.povrsina"          
                    + " from dovozi a  "
                    + " inner join kamioni b on a.kamion=b.sifra "
                    + " inner join prijevoznici c on b.prijevoznik=c.sifra "
                    + " inner join vozaci d on b.vozac=d.sifra "
                    + " inner join dobavljaci e on a.dobavljac=e.sifra "
                    + " inner join stovarista f on a.stovariste=f.sifra "
                    + " where a.sirovina like ? ");
            command.setString(1, "%" + uvjet + "%");          
            ResultSet rs =command.executeQuery();
            Dovoz d;
            Kamion k;
            Prijevoznik p;
            Vozac v;
            Dobavljac dob;
            Stovariste s;
            while(rs.next()){
                
                d = new Dovoz();
                d.setSifra(rs.getInt("sifraDovoza"));                
                 try {
                     d.setVrijemeistovara(new Date(rs.getTimestamp("vrijemeistovara").getTime()));
                } catch (Exception e) {
                    d.setVrijemeistovara(null);
                }
                d.setSirovina(rs.getString("sirovina"));
                d.setKolicinat(rs.getBigDecimal("kolicinat"));
                
                k = new Kamion();
                k.setSifra(rs.getInt("sifraKamiona"));                
                k.setRegistracija(rs.getString("registracija"));
                k.setNosivost(rs.getInt("nosivost"));
                
                d.setKamion(k);
               
                p = new Prijevoznik();
                p.setSifra(rs.getInt("sifraPrijevoznika"));
                p.setNaziv(rs.getString("nazivPrijevoznika"));
                p.setMjesto(rs.getString("mjestoPrijevoznika"));
                p.setOib(rs.getString("oibPrijevoznika"));
                
                k.setPrijevoznik(p);
                
                v = new Vozac();
                v.setSifra(rs.getInt("sifraVozaca"));
                v.setIme(rs.getString("ime"));
                v.setPrezime(rs.getString("prezime"));
                v.setOib(rs.getString("oibVozaca"));
                
                k.setVozac(v);
                
                dob = new Dobavljac();
                dob.setSifra(rs.getInt("sifraDobavljaca"));
                dob.setNaziv(rs.getString("nazivDobavljaca"));
                dob.setMjesto(rs.getString("mjestoDobavljaca"));
                dob.setOib(rs.getString("oibDobavljaca"));
                
                d.setDobavljac(dob);
                                             
                s = new Stovariste();
                s.setSifra(rs.getInt("sifraStovarista"));
                s.setNaziv(rs.getString("nazivStovarista"));
                s.setAdresa(rs.getString("adresa"));
                s.setMjesto(rs.getString("mjestoStovarista"));
                s.setPovrsina(rs.getBigDecimal("povrsina"));
                
                d.setStovariste(s);
                
                l.add(d);
            }
            
        } catch (Exception e) {
            Logger.getLogger(ObradaDovozi.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
    
    
    
    public List<Dovoz> uzmiPoDatumu (Calendar datum){
        
        List<Dovoz> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement(" select  "
                    + " a.sifra as sifraDovoza, "
                    + " a.vrijemeistovara, " 
                    + " a.sirovina, "
                    + " a.kolicinat, " 
                    + " b.sifra as sifraKamiona, "
                    + " b.registracija, "
                    + " b.nosivost, "
                    + " c.sifra as sifraPrijevoznika, "
                    + " c.naziv as nazivPrijevoznika, "
                    + " c.mjesto as mjestoPrijevoznika, "
                    + " c.oib as oibPrijevoznika, "                     
                    + " d.sifra as sifraVozaca, "
                    + " d.ime, "
                    + " d.prezime, "
                    + " d.oib as oibVozaca, "                    
                    + " e.sifra as sifraDobavljaca, "
                    + " e.naziv as nazivDobavljaca, "
                    + " e.mjesto as mjestoDobavljaca, "
                    + " e.oib as oibDobavljaca, "                     
                    + " f.sifra as sifraStovarista, "
                    + " f.naziv as nazivStovarista, "
                    + " f.adresa, "
                    + " f.mjesto as mjestoStovarista, "
                    + " f.povrsina"
                   
                    + " from dovozi a  "
                    + " inner join kamioni b on a.kamion=b.sifra "
                    + " inner join prijevoznici c on b.prijevoznik=c.sifra "
                    + " inner join vozaci d on b.vozac=d.sifra "
                    + " inner join dobavljaci e on a.dobavljac=e.sifra "
                    + " inner join stovarista f on a.stovariste=f.sifra "
                    + " where year(a.vrijemeistovara)=? and "
                    + " month(a.vrijemeistovara)=? and"
                    + " day(a.vrijemeistovara)=? ");
            System.out.println(datum.getTime());
            System.out.println(datum.get(Calendar.MONTH));
            command.setInt(1, datum.get(Calendar.YEAR));          
            command.setInt(2, datum.get(Calendar.MONTH)+1);          
            command.setInt(3, datum.get(Calendar.DAY_OF_MONTH));          
            
            ResultSet rs =command.executeQuery();
            Dovoz d;
            Kamion k;
            Prijevoznik p;
            Vozac v;
            Dobavljac dob;
            Stovariste s;
            while(rs.next()){
                
                d = new Dovoz();
                d.setSifra(rs.getInt("sifraDovoza"));                
                 try {
                     System.out.println(rs.getTimestamp("vrijemeistovara").getTime());
                     d.setVrijemeistovara(new Date(rs.getTimestamp("vrijemeistovara").getTime()));
                    // System.out.println(d.getVrijemeistovara());
                } catch (Exception e) {
                    d.setVrijemeistovara(null);
                }
                d.setSirovina(rs.getString("sirovina"));
                d.setKolicinat(rs.getBigDecimal("kolicinat"));
                
                k = new Kamion();
                k.setSifra(rs.getInt("sifraKamiona"));                
                k.setRegistracija(rs.getString("registracija"));
                k.setNosivost(rs.getInt("nosivost"));
                
                d.setKamion(k);
               
                p = new Prijevoznik();
                p.setSifra(rs.getInt("sifraPrijevoznika"));
                p.setNaziv(rs.getString("nazivPrijevoznika"));
                p.setMjesto(rs.getString("mjestoPrijevoznika"));
                p.setOib(rs.getString("oibPrijevoznika"));
                
                k.setPrijevoznik(p);
                
                v = new Vozac();
                v.setSifra(rs.getInt("sifraVozaca"));
                v.setIme(rs.getString("ime"));
                v.setPrezime(rs.getString("prezime"));
                v.setOib(rs.getString("oibVozaca"));
                
                k.setVozac(v);
                
                dob = new Dobavljac();
                dob.setSifra(rs.getInt("sifraDobavljaca"));
                dob.setNaziv(rs.getString("nazivDobavljaca"));
                dob.setMjesto(rs.getString("mjestoDobavljaca"));
                dob.setOib(rs.getString("oibDobavljaca"));
                
                d.setDobavljac(dob);
                                             
                s = new Stovariste();
                s.setSifra(rs.getInt("sifraStovarista"));
                s.setNaziv(rs.getString("nazivStovarista"));
                s.setAdresa(rs.getString("adresa"));
                s.setMjesto(rs.getString("mjestoStovarista"));
                s.setPovrsina(rs.getBigDecimal("povrsina"));
                
                d.setStovariste(s);
                
                l.add(d);
            }
            
        } catch (Exception e) {
            Logger.getLogger(ObradaDovozi.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
    public Dovoz dodaj (Dovoz d){
        
     try {
             command = Baza.getLink().prepareStatement("insert into dovozi (kamion,vrijemeistovara,"
                     + "dobavljac,stovariste,sirovina,kolicinat) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             command.setInt(1, d.getKamion().getSifra());
             command.setDate(2, new java.sql.Date(d.getVrijemeistovara().getTime()));
             command.setInt(3, d.getDobavljac().getSifra());
             command.setInt(4, d.getStovariste().getSifra());         
             command.setString(5, d.getSirovina());
             command.setBigDecimal(6, d.getKolicinat());
             command.executeUpdate();          
              ResultSet rs = command.getGeneratedKeys();
                rs.next();
                d.setSifra(rs.getInt(1));

         } catch (Exception e) {
              Logger.getLogger(ObradaDovozi.class.getName()).log(Level.SEVERE, null, e);
         } 
         return d;
    }
    
    public boolean promijeni(Dovoz d){
         boolean vrati=false;
         try {
             
                  command = Baza.getLink().prepareStatement("update dovozi set kamion=?,"
                          + "vrijemeistovara=?,dobavljac=?,stovariste=?,sirovina=?,kolicinat=? where sifra=?");
             command.setInt(7, d.getSifra());
             command.setInt(1, d.getKamion().getSifra());
             command.setDate(2, new java.sql.Date(d.getVrijemeistovara().getTime()));
             command.setInt(3, d.getDobavljac().getSifra());
             command.setInt(4, d.getStovariste().getSifra());         
             command.setString(5, d.getSirovina());
             command.setBigDecimal(6, d.getKolicinat());                                       
             
             if(command.executeUpdate()==1){
                 vrati=true;
             }
             

         } catch (Exception e) {
              Logger.getLogger(ObradaDovozi.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         
         return vrati;
     }
    
     public boolean obrisi(Dovoz d){
          boolean vrati=false;
         try {
                  command = Baza.getLink().prepareStatement("delete from dovozi "
                          + " where sifra=?");
             command.setInt(1, d.getSifra()); 
             if(command.executeUpdate()==1){
                 vrati=true;
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaDovozi.class.getName()).log(Level.SEVERE, null, e);
         } 
         return vrati;
     }

}
