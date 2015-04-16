/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.controller;


import biomasa.model.Dobavljac;
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
public class ObradaDobavljaci {
    
     private PreparedStatement command;
    
    public List<Dobavljac> uzmi (String uvjet){
        
        List<Dobavljac> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement("select * from dobavljaci where naziv like ?");
            command.setString(1, "%" + uvjet + "%");           
            ResultSet rs =command.executeQuery();
            Dobavljac d;
            while(rs.next()){
                
                d = new Dobavljac();
                d.setSifra(rs.getInt("sifra"));                
                d.setNaziv(rs.getString("naziv"));
                d.setMjesto(rs.getString("mjesto"));
                d.setOib(rs.getString("oib"));
                l.add(d);
            }
        } catch (Exception e) {
            Logger.getLogger(ObradaDobavljaci.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
    //Metoda za provjeru postoji li već dobavljac preko oib-a
    public boolean provjeraOib(String oib){
        
        try {
            
            command = Baza.getLink().prepareStatement("select sifra from dobavljaci where oib like ?");
            command.setString(1, oib);
            ResultSet rs = command.executeQuery();
            return !rs.next();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaDobavljaci.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public boolean provjeraNaziv(String naziv){
        
        try {
            
            command = Baza.getLink().prepareStatement("select sifra from dobavljaci where naziv like ?");
            command.setString(1, naziv);
            ResultSet rs = command.executeQuery();
            return !rs.next();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaDobavljaci.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Dobavljac dodaj (Dobavljac d){
        
     try {
             command = Baza.getLink().prepareStatement("insert into dobavljaci (naziv,mjesto,"
                     + "oib) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
             command.setString(1, d.getNaziv());
             command.setString(2, d.getMjesto());
             command.setString(3, d.getOib());         
             command.executeUpdate();          
              ResultSet rs = command.getGeneratedKeys();
                rs.next();
                d.setSifra(rs.getInt(1));

         } catch (Exception e) {
              Logger.getLogger(ObradaDobavljaci.class.getName()).log(Level.SEVERE, null, e);
         } 
         return d;
    }
    
     public boolean promijeni(Dobavljac d){
         boolean vrati=false;
         try {
             
                  command = Baza.getLink().prepareStatement("update dobavljaci set naziv=?,"
                          + "mjesto=?,"
                     + "oib=? where sifra=?");
             command.setInt(4, d.getSifra());
             command.setString(1, d.getNaziv());
             command.setString(2, d.getMjesto());
             command.setString(3, d.getOib());                                         
             
             if(command.executeUpdate()==1){
                 vrati=true;
             }
             

         } catch (Exception e) {
              Logger.getLogger(ObradaDobavljaci.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         
         return vrati;
     }
     
     public boolean obrisi(Dobavljac d){
          boolean vrati=false;
         try {
                  command = Baza.getLink().prepareStatement("delete from dobavljaci "
                          + " where sifra=?");
             command.setInt(1, d.getSifra()); 
             if(command.executeUpdate()==1){
                 vrati=true;
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaDobavljaci.class.getName()).log(Level.SEVERE, null, e);
         } 
         return vrati;
     }
    
}
