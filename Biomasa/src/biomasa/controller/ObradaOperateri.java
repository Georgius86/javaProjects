/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.controller;

import biomasa.model.Operater;
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
public class ObradaOperateri {
    
    private PreparedStatement command;
    
    public List<Operater> uzmi (String uvjet){
        
        List<Operater> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement("select * from operateri where ime like ? or prezime like ?");
            command.setString(1, "%" + uvjet + "%");
            command.setString(2, "%" + uvjet + "%");
            ResultSet rs =command.executeQuery();
            Operater o;
            while(rs.next()){
                
                o = new Operater();
                o.setSifra(rs.getInt("sifra"));
                o.setKorisnik(rs.getString("korisnik"));
                o.setLozinkaMD5(rs.getString("lozinka"));
                o.setIme(rs.getString("ime"));
                o.setPrezime(rs.getString("prezime"));
                l.add(o);
            }
        } catch (Exception e) {
            Logger.getLogger(ObradaOperateri.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
    //Metoda za provjeru postoji li već korisničko ime
    public boolean provjeraKorisnika(String korisnik){
        
        try {
            
            command = Baza.getLink().prepareStatement("select sifra from operateri where korisnik like ?");
            command.setString(1, korisnik);
            ResultSet rs = command.executeQuery();
            return !rs.next();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaOperateri.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Operater dodaj (Operater o){
        
     try {
             command = Baza.getLink().prepareStatement("insert into operateri (korisnik,lozinka,"
                     + "ime,prezime) values (?,md5(?),?,?)", Statement.RETURN_GENERATED_KEYS);
             command.setString(1, o.getKorisnik());
             command.setString(2, o.getLozinka());
             command.setString(3, o.getIme());
             command.setString(4, o.getPrezime());  
             command.executeUpdate();          
              ResultSet rs = command.getGeneratedKeys();
                rs.next();
                o.setSifra(rs.getInt(1));

         } catch (Exception e) {
              Logger.getLogger(ObradaOperateri.class.getName()).log(Level.SEVERE, null, e);
         } 
         return o;
    }
    
     public boolean promijeni(Operater o){
         boolean vrati=false;
         try {
             if(o.getLozinka().length()>0){
                  command = Baza.getLink().prepareStatement("update operateri set korisnik=?,"
                          + "lozinka=md5(?),"
                     + "ime=?,prezime=? where sifra=?");
             command.setString(1, o.getKorisnik());
             command.setString(2, o.getLozinka());
             command.setString(3, o.getIme());
             command.setString(4, o.getPrezime());  
             command.setInt(5, o.getSifra()); 
                   
             }else{
             command = Baza.getLink().prepareStatement("update operateri set korisnik=?,"
                     + "ime=?,prezime=? where sifra=?");
             command.setString(1, o.getKorisnik());
             command.setString(2, o.getIme());
             command.setString(3, o.getPrezime());  
             command.setInt(4, o.getSifra());    
             }
             
             if(command.executeUpdate()==1){
                 vrati=true;
             }
             

         } catch (Exception e) {
              Logger.getLogger(ObradaOperateri.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         
         return vrati;
     }
     
     public boolean obrisi(Operater o){
          boolean vrati=false;
         try {
                  command = Baza.getLink().prepareStatement("delete from operateri "
                          + " where sifra=?");
             command.setInt(1, o.getSifra()); 
             if(command.executeUpdate()==1){
                 vrati=true;
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaOperateri.class.getName()).log(Level.SEVERE, null, e);
         } 
         return vrati;
     }
    
}
