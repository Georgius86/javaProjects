/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.view;

import biomasa.utility.Dodaci;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Đorđe
 */
public class Sat extends Thread {
    
    JLabel datumVrijeme;
    
    public Sat( JLabel datumVrijeme){
        this.datumVrijeme=datumVrijeme;
    }
    
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat(Dodaci.FORMAT_DATUM_VRIJEME);
                while (true) {
                    try {
                        datumVrijeme.setText(df.format(new Date()));
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Izbornik.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
}
