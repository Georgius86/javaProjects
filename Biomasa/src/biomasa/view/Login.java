/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.view;

import biomasa.model.Operater;
import java.awt.event.KeyEvent;

/**
 *
 * @author Đorđe
 */
public class Login extends javax.swing.JFrame {
    
    private biomasa.controller.ObradaLogin obrada;

    /**
     * Creates new form Operateri
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        
        obrada = new biomasa.controller.ObradaLogin();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        korisnik = new javax.swing.JTextField();
        autoriziraj = new javax.swing.JButton();
        poruka = new javax.swing.JLabel();
        lozinka = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(51, 153, 0));
        setMinimumSize(new java.awt.Dimension(370, 210));
        setPreferredSize(new java.awt.Dimension(370, 210));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setText("Korisnik:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(22, 34, 60, 14);

        jLabel5.setText("Lozinka:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(22, 72, 60, 14);

        korisnik.setText("ddordevic");
        korisnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                korisnikKeyPressed(evt);
            }
        });
        getContentPane().add(korisnik);
        korisnik.setBounds(90, 30, 127, 20);

        autoriziraj.setBackground(new java.awt.Color(255, 102, 0));
        autoriziraj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        autoriziraj.setForeground(new java.awt.Color(255, 255, 255));
        autoriziraj.setText("Pokreni");
        autoriziraj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        autoriziraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorizirajActionPerformed(evt);
            }
        });
        getContentPane().add(autoriziraj);
        autoriziraj.setBounds(90, 130, 120, 36);

        poruka.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(poruka);
        poruka.setBounds(20, 100, 200, 20);

        lozinka.setText("ddd");
        lozinka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lozinkaKeyPressed(evt);
            }
        });
        getContentPane().add(lozinka);
        lozinka.setBounds(90, 70, 127, 20);

        jLabel1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BIOMASA.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 30, 100, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void autorizirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorizirajActionPerformed
        
        poruka.setText("");
        if(korisnik.getText().trim().isEmpty()){
            poruka.setText("Obavezan unos korisnika!");
            korisnik.requestFocus();
            return;
        }
        
        if(new String(lozinka.getPassword()).trim().isEmpty()){
            poruka.setText("Obavezan unos lozinke!");
            lozinka.requestFocus();
            return;
        }
        
        Operater o = obrada.autoriziraj(korisnik.getText().trim(), new String(lozinka.getPassword()).trim());
        
        if(o==null){
            poruka.setText("Netočna kombinacija!");
            return;
            
        }
        
        new Izbornik().setVisible(true);
        dispose();
    }//GEN-LAST:event_autorizirajActionPerformed

    private void korisnikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_korisnikKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            autorizirajActionPerformed(null);
        }
    }//GEN-LAST:event_korisnikKeyPressed

    private void lozinkaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lozinkaKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            autorizirajActionPerformed(null);
        }
    }//GEN-LAST:event_lozinkaKeyPressed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autoriziraj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField korisnik;
    private javax.swing.JPasswordField lozinka;
    private javax.swing.JLabel poruka;
    // End of variables declaration//GEN-END:variables
}
