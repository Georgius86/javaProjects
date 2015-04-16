/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.controller;


import biomasa.model.Kamion;
import biomasa.model.Prijevoznik;
import biomasa.model.Vozac;
import biomasa.utility.Baza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Đorđe
 */
public class ObradaKamioni {
    
     private PreparedStatement command;
    
    public List<Kamion> uzmi (String uvjet){
        
        List<Kamion> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement(" select  "
                    + " a.sifra as sifraKamiona, "
                    + " a.registracija, " 
                    + " a.nosivost, "  
                    + " b.sifra as sifraPrijevoznika, "
                    + " b.naziv, "
                    + " b.mjesto, "
                    + " b.oib as oibPrijevoznika, "
                    + " c.sifra as sifraVozaca, "
                    + " c.ime, "
                    + " c.prezime, "
                    + " c.oib as oibVozaca "                 
                    + " from kamioni a  "
                    + " inner join prijevoznici b on a.prijevoznik=b.sifra "
                    + " inner join vozaci c on a.vozac=c.sifra "
                    + " where b.naziv like ? ");
            command.setString(1, "%" + uvjet + "%");          
            ResultSet rs =command.executeQuery();
            Kamion k;
            Prijevoznik p;
            Vozac v;
            while(rs.next()){
                
                k = new Kamion();
                k.setSifra(rs.getInt("sifraKamiona"));                
                k.setRegistracija(rs.getString("registracija"));
                k.setNosivost(rs.getInt("nosivost"));
               
                p = new Prijevoznik();
                p.setSifra(rs.getInt("sifraPrijevoznika"));
                p.setNaziv(rs.getString("naziv"));
                p.setMjesto(rs.getString("mjesto"));
                p.setOib(rs.getString("oibPrijevoznika"));
                
                k.setPrijevoznik(p);
                
                v = new Vozac();
                v.setSifra(rs.getInt("sifraVozaca"));
                v.setIme(rs.getString("ime"));
                v.setPrezime(rs.getString("prezime"));
                v.setOib(rs.getString("oibVozaca"));
                
                k.setVozac(v);
                
                l.add(k);
            }
            
        } catch (Exception e) {
            Logger.getLogger(ObradaKamioni.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
     public boolean provjeraRegistracija(String registracija){
        
        try {
            
            command = Baza.getLink().prepareStatement("select sifra from kamioni where registracija like ?");
            command.setString(1, registracija);
            ResultSet rs = command.executeQuery();
            return !rs.next();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaKamioni.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
     
    public Kamion dodaj (Kamion k){
        
     try {
             command = Baza.getLink().prepareStatement("insert into kamioni (registracija,prijevoznik,"
                     + "vozac,nosivost) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             command.setString(1, k.getRegistracija());
             command.setInt(2, k.getPrijevoznik().getSifra());
             command.setInt(3, k.getVozac().getSifra());
             command.setInt(4, k.getNosivost());         
             command.executeUpdate();          
              ResultSet rs = command.getGeneratedKeys();
                rs.next();
                k.setSifra(rs.getInt(1));

         } catch (Exception e) {
              Logger.getLogger(ObradaKamioni.class.getName()).log(Level.SEVERE, null, e);
         } 
         return k;
    }
    
     public boolean promijeni(Kamion k){
         boolean vrati=false;
         try {
             
                  command = Baza.getLink().prepareStatement("update kamioni set registracija=?,"
                          + "prijevoznik=?,vozac=?,nosivost=? where sifra=?");
             command.setInt(5, k.getSifra());
             command.setString(1, k.getRegistracija());
             command.setInt(2, k.getPrijevoznik().getSifra());
             command.setInt(3, k.getVozac().getSifra());
             command.setInt(4, k.getNosivost());                                       
             
             if(command.executeUpdate()==1){
                 vrati=true;
             }
             

         } catch (Exception e) {
              Logger.getLogger(ObradaKamioni.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         
         return vrati;
     }
     
      public boolean obrisi(Kamion k){
          boolean vrati=false;
         try {
                  command = Baza.getLink().prepareStatement("delete from kamioni "
                          + " where sifra=?");
             command.setInt(1, k.getSifra()); 
             if(command.executeUpdate()==1){
                 vrati=true;
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaKamioni.class.getName()).log(Level.SEVERE, null, e);
         } 
         return vrati;
     }
  
}
