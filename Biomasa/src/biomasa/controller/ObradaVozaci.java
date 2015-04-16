/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.controller;


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
public class ObradaVozaci {
    
    private PreparedStatement command;
    
    public List<Vozac> uzmi (String uvjet){
        
        List<Vozac> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement("select * from vozaci where ime like ? or prezime like ?");
            command.setString(1, "%" + uvjet + "%");
            command.setString(2, "%" + uvjet + "%");
            ResultSet rs =command.executeQuery();
            Vozac v;
            while(rs.next()){
                
                v = new Vozac();
                v.setSifra(rs.getInt("sifra"));                
                v.setIme(rs.getString("ime"));
                v.setPrezime(rs.getString("prezime"));
                v.setOib(rs.getString("oib"));
                l.add(v);
            }
        } catch (Exception e) {
            Logger.getLogger(ObradaVozaci.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
    //Metoda za provjeru postoji li već vozač preko oib-a
    public boolean provjeraOib(String oib){
        
        try {
            
            command = Baza.getLink().prepareStatement("select sifra from vozaci where oib like ?");
            command.setString(1, oib);
            ResultSet rs = command.executeQuery();
            return !rs.next();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaVozaci.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Vozac dodaj (Vozac v){
        
     try {
             command = Baza.getLink().prepareStatement("insert into vozaci (ime,prezime,"
                     + "oib) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
             command.setString(1, v.getIme());
             command.setString(2, v.getPrezime());
             command.setString(3, v.getOib());          
             command.executeUpdate();          
              ResultSet rs = command.getGeneratedKeys();
                rs.next();
                v.setSifra(rs.getInt(1));

         } catch (Exception e) {
              Logger.getLogger(ObradaVozaci.class.getName()).log(Level.SEVERE, null, e);
         } 
         return v;
    }
    
     public boolean promijeni(Vozac v){
         boolean vrati=false;
         try {
            
             command = Baza.getLink().prepareStatement("update vozaci set ime=?,"
                     + "prezime=?,oib=? where sifra=?");
             command.setString(1, v.getIme());             
             command.setString(2, v.getPrezime());
             command.setString(3, v.getOib());
             command.setInt(4, v.getSifra());    
             
             
             if(command.executeUpdate()==1){
                 vrati=true;
             }
             

         } catch (Exception e) {
              Logger.getLogger(ObradaVozaci.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         
         return vrati;
     }
     
     public boolean obrisi(Vozac v){
          boolean vrati=false;
         try {
             command = Baza.getLink().prepareStatement("delete from vozaci "
                          + " where sifra=?");
             command.setInt(1, v.getSifra()); 
             if(command.executeUpdate()==1){
                 vrati=true;
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaVozaci.class.getName()).log(Level.SEVERE, null, e);
         } 
         return vrati;
     }

    List<Vozac> uzmiVozaceOdPrijevoznika(Prijevoznik l1) {
         List<Vozac> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement("select * from vozaci where prijevoznik=?");
            command.setInt(1,l1.getSifra());
            ResultSet rs =command.executeQuery();
            Vozac v;
            while(rs.next()){
                
                v = new Vozac();
                v.setSifra(rs.getInt("sifra"));                
                v.setIme(rs.getString("ime"));
                v.setPrezime(rs.getString("prezime"));
                v.setOib(rs.getString("oib"));
                l.add(v);
            }
        } catch (Exception e) {
            Logger.getLogger(ObradaVozaci.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
}
    

