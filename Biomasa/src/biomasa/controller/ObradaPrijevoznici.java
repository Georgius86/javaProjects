/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.controller;

import biomasa.model.Prijevoznik;
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
public class ObradaPrijevoznici {
    
    private PreparedStatement command;
    
    public List<Prijevoznik> uzmi (String uvjet){
        
        List<Prijevoznik> l = new ArrayList<>();
        
        try {
            
            command = Baza.getLink().prepareStatement("select * from prijevoznici where naziv like ? or mjesto like ?");
            command.setString(1, "%" + uvjet + "%");
            command.setString(2, "%" + uvjet + "%");
            ResultSet rs =command.executeQuery();
            Prijevoznik p;
            while(rs.next()){
                
                p = new Prijevoznik();
                p.setSifra(rs.getInt("sifra"));
                p.setNaziv(rs.getString("naziv"));
                p.setMjesto(rs.getString("mjesto"));
                p.setOib(rs.getString("oib"));
           
                //za svakog prijevoznika dohvatiti vozače kao đšto ja radim dohvaćanje polaznika grupe
                
                
                l.add(p);
                
                
                
            }
            ObradaVozaci ov = new ObradaVozaci();
            for (Prijevoznik l1 : l) {
                l1.setVozaci(ov.uzmiVozaceOdPrijevoznika(l1));
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(ObradaPrijevoznici.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return l;
    }
    
    //Metoda za provjeru postoji li već oib prijevoznika
    public boolean provjeraOib(String oib){
        
        try {
            
            command = Baza.getLink().prepareStatement("select sifra from prijevoznici where oib like ?");
            command.setString(1, oib);
            ResultSet rs = command.executeQuery();
            return !rs.next();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaPrijevoznici.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
     public boolean provjeraNaziv(String naziv){
        
        try {
            
            command = Baza.getLink().prepareStatement("select sifra from prijevoznici where naziv like ?");
            command.setString(1, naziv);
            ResultSet rs = command.executeQuery();
            return !rs.next();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaPrijevoznici.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Prijevoznik dodaj (Prijevoznik p){
        
     try {
             command = Baza.getLink().prepareStatement("insert into prijevoznici (naziv,mjesto,"
                     + "oib) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
             command.setString(1, p.getNaziv());
             command.setString(2, p.getMjesto());
             command.setString(3, p.getOib());         
             command.executeUpdate();          
              ResultSet rs = command.getGeneratedKeys();
                rs.next();
                p.setSifra(rs.getInt(1));

         } catch (Exception e) {
              Logger.getLogger(ObradaPrijevoznici.class.getName()).log(Level.SEVERE, null, e);
         } 
         return p;
    }
    
     public boolean promijeni(Prijevoznik p){
         boolean vrati=false;
         try {
             
                  command = Baza.getLink().prepareStatement("update prijevoznici set naziv=?,"
                          + "mjesto=?,"
                     + "oib=? where sifra=?");
             command.setInt(4, p.getSifra());
             command.setString(1, p.getNaziv());
             command.setString(2, p.getMjesto());
             command.setString(3, p.getOib());                                         
             
             if(command.executeUpdate()==1){
                 vrati=true;
             }
             

         } catch (Exception e) {
              Logger.getLogger(ObradaPrijevoznici.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         
         return vrati;
     }
     
     public boolean obrisi(Prijevoznik o){
          boolean vrati=false;
         try {
                  command = Baza.getLink().prepareStatement("delete from prijevoznici "
                          + " where sifra=?");
             command.setInt(1, o.getSifra()); 
             if(command.executeUpdate()==1){
                 vrati=true;
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaPrijevoznici.class.getName()).log(Level.SEVERE, null, e);
         } 
         return vrati;
     }
    
}
