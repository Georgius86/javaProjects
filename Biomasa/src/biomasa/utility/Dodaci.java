/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.utility;

import biomasa.model.Operater;

/**
 *
 * @author Đorđe
 */
public class Dodaci {
    
     private static Operater operater;
     
    
    public static final String FORMAT_DATUM_VRIJEME="dd.MM.YYYY. HH:mm:ss";

    public static Operater getOperater() {
        return operater;
    }

    public static void setOperater(Operater o) {
        operater = o;
    }
      
     
    
}
