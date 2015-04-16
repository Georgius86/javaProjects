/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.controller;

import biomasa.model.Operater;
import java.sql.PreparedStatement;
import biomasa.utility.Baza;
import biomasa.utility.Dodaci;
import java.sql.ResultSet;

/**
 *
 * @author Đorđe
 */
public class ObradaLogin {
    
    
    private PreparedStatement command;
    
    public Operater autoriziraj(String korisnik, String lozinka){
        Operater o = null;
        
        try {
            command=Baza.getLink().prepareStatement("select * from operateri where binary korisnik=? and lozinka=md5(?)");
            command.setString(1, korisnik);
            command.setString(2, lozinka);
            ResultSet rs = command.executeQuery();
            
            while(rs.next()){
                o = new Operater();
                
                o.setSifra(rs.getInt("sifra"));
                o.setKorisnik(rs.getString("korisnik"));
                o.setLozinkaMD5(rs.getString("lozinka"));
                o.setIme(rs.getString("ime"));
                o.setPrezime(rs.getString("prezime"));
                
                try {
                     o.setUloga(rs.getString("uloga"));
                    
                 } catch (Exception e) {
                     o.setUloga(Operater.KORISNIK);
                 }
                
            }
                    
        } catch (Exception e) {
        }
        if(o!=null){
                Dodaci.setOperater(o);
            }
        return o;
    }
    
}
