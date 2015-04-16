/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.controller;

import biomasa.model.Stovariste;
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
public class ObradaStovarista {
    
     private PreparedStatement command;
    
    public List<Stovariste> uzmi (String uvjet){
        
        List<Stovariste> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement("select * from stovarista where naziv like ? or adresa like ? or mjesto like ?");
            command.setString(1, "%" + uvjet + "%");
            command.setString(2, "%" + uvjet + "%");
            command.setString(3, "%" + uvjet + "%");
            ResultSet rs =command.executeQuery();
            Stovariste s;
            while(rs.next()){
                
                s = new Stovariste();
                s.setSifra(rs.getInt("sifra"));
                s.setNaziv(rs.getString("naziv"));
                s.setAdresa(rs.getString("adresa"));
                s.setMjesto(rs.getString("mjesto"));
                s.setPovrsina(rs.getBigDecimal("povrsina"));
           
                l.add(s);
            }
        } catch (Exception e) {
            Logger.getLogger(ObradaPrijevoznici.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
    //Metoda za provjeru postoji li već oib prijevoznika
    
     public boolean provjeraNaziv(String naziv){
        
        try {
            
            command = Baza.getLink().prepareStatement("select sifra from stovarista where naziv like ?");
            command.setString(1, naziv);
            ResultSet rs = command.executeQuery();
            return !rs.next();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaStovarista.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Stovariste dodaj (Stovariste s){
        
     try {
             command = Baza.getLink().prepareStatement("insert into stovarista (naziv,adresa,mjesto,"
                     + "povrsina) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             command.setString(1, s.getNaziv());
             command.setString(2, s.getAdresa());
             command.setString(3, s.getMjesto());
             command.setBigDecimal(4, s.getPovrsina());         
             command.executeUpdate();          
              ResultSet rs = command.getGeneratedKeys();
                rs.next();
                s.setSifra(rs.getInt(1));

         } catch (Exception e) {
              Logger.getLogger(ObradaStovarista.class.getName()).log(Level.SEVERE, null, e);
         } 
         return s;
    }
    
     public boolean promijeni(Stovariste s){
         boolean vrati=false;
         try {
             
                  command = Baza.getLink().prepareStatement("update stovarista set naziv=?, adresa=?,"
                          + "mjesto=?,"
                     + "povrsina=? where sifra=?");
             command.setInt(1, s.getSifra());
             command.setString(2, s.getNaziv());
             command.setString(3, s.getAdresa());
             command.setString(4, s.getMjesto());
             command.setBigDecimal(5, s.getPovrsina());                                         
             
             if(command.executeUpdate()==1){
                 vrati=true;
             }
             

         } catch (Exception e) {
              Logger.getLogger(ObradaStovarista.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         
         return vrati;
     }
     
     public boolean obrisi(Stovariste s){
          boolean vrati=false;
         try {
                  command = Baza.getLink().prepareStatement("delete from stovarista "
                          + " where sifra=?");
             command.setInt(1, s.getSifra()); 
             if(command.executeUpdate()==1){
                 vrati=true;
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaStovarista.class.getName()).log(Level.SEVERE, null, e);
         } 
         return vrati;
     }
    
}
