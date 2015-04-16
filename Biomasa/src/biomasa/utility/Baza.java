/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Đorđe
 */
public class Baza {
    
    private static Connection link;
    
    public static Connection getLink(){
        if(link==null){
            System.out.println("Spajam se na bazu");
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                link=DriverManager.getConnection("jdbc:mysql://localhost/ams?"
              + "user=edunova&password=edunova&useUnicode=yes&characterEncoding=utf8");
                
            } catch (ClassNotFoundException | SQLException e) {
                Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        try {
            if(link.isClosed()){
                link=null;
                getLink();
            }
        } catch (SQLException e) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return link;
    }
    
}
