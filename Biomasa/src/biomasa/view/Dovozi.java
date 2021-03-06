/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomasa.view;

import biomasa.controller.ObradaDobavljaci;
import biomasa.controller.ObradaDovozi;
import biomasa.controller.ObradaKamioni;
import biomasa.controller.ObradaStovarista;
import biomasa.model.Dobavljac;
import biomasa.model.Dovoz;
import biomasa.model.Kamion;
import biomasa.model.Stovariste;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.*;
import java.util.Locale;
import org.freixas.jcalendar.*;

/**
 *
 * @author Đorđe
 */
public class Dovozi extends javax.swing.JInternalFrame {

    
    private ObradaDovozi obrada;
    private Dovoz odabrano;
    //private Calendar cf;
    /**
     * Creates new form Dovozi
     */
    public Dovozi() {
        initComponents();
        obrada=new ObradaDovozi();
        lista.setModel(new DefaultListModel<Dovoz>());
       setTitle("Istovari po danu: ");
       
       ObradaKamioni ok = new ObradaKamioni();
        List<Kamion> lk = ok.uzmi("");
        DefaultComboBoxModel<Kamion> mk = new DefaultComboBoxModel<>();
        for (Kamion l : lk) {
            mk.addElement(l);
        }
        
        kamion.setModel(mk);
        
        ObradaStovarista os = new ObradaStovarista();
        List<Stovariste> ls = os.uzmi("");
        DefaultComboBoxModel<Stovariste> ms = new DefaultComboBoxModel<>();
        for (Stovariste l : ls) {
            ms.addElement(l);
        }
        
        stovariste.setModel(ms);
        uvjetStovariste.setModel(ms);
        
        ObradaDobavljaci odob = new ObradaDobavljaci();
        List<Dobavljac> ldob = odob.uzmi("");
        DefaultComboBoxModel<Dobavljac> mdob = new DefaultComboBoxModel<>();
        for (Dobavljac l : ldob) {
            mdob.addElement(l);
        }
        
        dobavljac.setModel(mdob);
        
        //JCalendar
        //http://flib.sourceforge.net/JCalendar/doc/tutorial.html
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uvjetStovariste = new javax.swing.JComboBox();
        akcijaPovratak = new javax.swing.JButton();
        uvjetSirovina = new javax.swing.JTextField();
        akcijaTrazi = new javax.swing.JButton();
        uvjetDatum = new org.freixas.jcalendar.JCalendarCombo(
            Calendar.getInstance(Locale.UK),
            Locale.UK,
            JCalendar.DISPLAY_DATE,
            true);
        traziDatum = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        kamion = new javax.swing.JComboBox();
        dobavljac = new javax.swing.JComboBox();
        stovariste = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        akcijaDodaj = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sirovina = new javax.swing.JTextField();
        akcijaObrisi = new javax.swing.JButton();
        akcijaPromijeni = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        vrijemeIstovara = new org.freixas.jcalendar.JCalendarCombo(
            Calendar.getInstance(Locale.UK),
            Locale.UK,
            JCalendar.DISPLAY_DATE | JCalendar.DISPLAY_TIME,
            true);
        kolicinat = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 153, 0));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel2.setBackground(new java.awt.Color(51, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Sirovina:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Stovarište:");

        akcijaPovratak.setBackground(new java.awt.Color(255, 102, 0));
        akcijaPovratak.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaPovratak.setForeground(new java.awt.Color(255, 255, 255));
        akcijaPovratak.setText("Povratak");
        akcijaPovratak.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaPovratak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaPovratakActionPerformed(evt);
            }
        });

        akcijaTrazi.setBackground(new java.awt.Color(255, 102, 0));
        akcijaTrazi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaTrazi.setForeground(new java.awt.Color(255, 255, 255));
        akcijaTrazi.setText("Traži");
        akcijaTrazi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaTraziActionPerformed(evt);
            }
        });

        traziDatum.setBackground(new java.awt.Color(51, 153, 0));
        traziDatum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        traziDatum.setText("Traži datum:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(akcijaTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(traziDatum)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(uvjetDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(uvjetStovariste, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(uvjetSirovina, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(akcijaPovratak, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(akcijaTrazi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(akcijaPovratak, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(traziDatum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uvjetStovariste)
                            .addComponent(uvjetDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uvjetSirovina))))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        akcijaDodaj.setBackground(new java.awt.Color(255, 102, 0));
        akcijaDodaj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaDodaj.setForeground(new java.awt.Color(255, 255, 255));
        akcijaDodaj.setText("Dodaj");
        akcijaDodaj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaDodajActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Stovarište:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Dobavljač:");

        akcijaObrisi.setBackground(new java.awt.Color(255, 102, 0));
        akcijaObrisi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaObrisi.setForeground(new java.awt.Color(255, 255, 255));
        akcijaObrisi.setText("Obriši");
        akcijaObrisi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaObrisiActionPerformed(evt);
            }
        });

        akcijaPromijeni.setBackground(new java.awt.Color(255, 102, 0));
        akcijaPromijeni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaPromijeni.setForeground(new java.awt.Color(255, 255, 255));
        akcijaPromijeni.setText("Promijeni");
        akcijaPromijeni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaPromijeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaPromijeniActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sirovina:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Količina(t):");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Kamion:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Vrijeme:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addComponent(dobavljac, 0, 280, Short.MAX_VALUE)
                                        .addComponent(kamion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(sirovina, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(kolicinat))))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(241, 241, 241)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stovariste, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(vrijemeIstovara, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 76, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(akcijaPromijeni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(akcijaObrisi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(akcijaDodaj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(akcijaPromijeni, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(akcijaObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dobavljac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stovariste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kamion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vrijemeIstovara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kolicinat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sirovina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(akcijaDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void akcijaPovratakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaPovratakActionPerformed
       
        dispose();
        
    }//GEN-LAST:event_akcijaPovratakActionPerformed

    private void akcijaTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaTraziActionPerformed
        
        cistiPolja();
       
       
        if(traziDatum.isSelected()){
           //  System.out.println( uvjetDatum.getCalendar().getTime());
          
            List<Dovoz> entiteti = obrada.uzmiPoDatumu(uvjetDatum.getCalendar());
        
        DefaultListModel <Dovoz> m = new DefaultListModel<>();
        for (Dovoz dovoz : entiteti){
            
            m.addElement(dovoz);
        }
        lista.setModel(m);
        }
        
        if(!traziDatum.isSelected()){
        List<Dovoz> entiteti = obrada.uzmiPoTekstu(uvjetSirovina.getText());
        
        DefaultListModel <Dovoz> m = new DefaultListModel<>();
        for (Dovoz dovoz : entiteti){
            
            m.addElement(dovoz);
        }
        lista.setModel(m);
        }       
        
    }//GEN-LAST:event_akcijaTraziActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        
        reset();
        odabrano = (Dovoz) lista.getSelectedValue();
        if(odabrano==null){
            return;
        }
        sirovina.setText(odabrano.getSirovina());
        
        DefaultComboBoxModel<Stovariste> ms = (DefaultComboBoxModel<Stovariste>) stovariste.getModel();
        for(int i=0;i<ms.getSize();i++){
            if(ms.getElementAt(i).getSifra()==odabrano.getStovariste().getSifra()){
                stovariste.setSelectedIndex(i);
                break;
            }
        }
        
        DefaultComboBoxModel<Dobavljac> mdob = (DefaultComboBoxModel<Dobavljac>) dobavljac.getModel();
        for(int i=0;i<mdob.getSize();i++){
            if(mdob.getElementAt(i).getSifra()==odabrano.getDobavljac().getSifra()){
                dobavljac.setSelectedIndex(i);
                break;
            }
        }
        
          DefaultComboBoxModel<Kamion> mk = (DefaultComboBoxModel<Kamion>) kamion.getModel();
        for(int i=0;i<mk.getSize();i++){
            if(mk.getElementAt(i).getSifra()==odabrano.getKamion().getSifra()){
                kamion.setSelectedIndex(i);
                break;
            }
        }
        
        vrijemeIstovara.setDate(odabrano.getVrijemeistovara());
       
        vrijemeIstovara.repaint();
        
       kolicinat.setText(String.valueOf(odabrano.getKolicinat()));
        
    }//GEN-LAST:event_listaValueChanged

    private void akcijaDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaDodajActionPerformed
       
       reset();
        Dovoz d = new Dovoz();
        /*
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        
                */
       // String pattern = "0,00";
        DecimalFormat decimalFormat = new DecimalFormat();
       // decimalFormat.setParseBigDecimal(true);
        
        if(sirovina.getText().trim().isEmpty()){
           greska(sirovina, "Obavezno unesite teret");
           return;
       }
                
       
        
        d.setSirovina(sirovina.getText().trim());
        
        d.setKamion((Kamion) kamion.getSelectedItem());
        d.setDobavljac((Dobavljac)dobavljac.getSelectedItem());
        d.setStovariste((Stovariste)stovariste.getSelectedItem());
        d.setVrijemeistovara(vrijemeIstovara.getDate());
        
        
        try {
            System.out.println(kolicinat.getText().trim());
            d.setKolicinat(new BigDecimal(kolicinat.getText().trim().replace(",", ".")));
            System.out.println(d.getKolicinat());
        } catch (Exception e) {
            greska(kolicinat, "broj nije dobrog formata");
            return;
        }                             
        
        d=obrada.dodaj(d);
        
      
            DefaultListModel<Dovoz> m =(DefaultListModel<Dovoz>) lista.getModel();
            m.addElement(d); 
        
    }//GEN-LAST:event_akcijaDodajActionPerformed

    private void akcijaPromijeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaPromijeniActionPerformed
       
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "0,00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);
        
        if(odabrano==null){
    return;
}       
        reset();
        
        if(sirovina.getText().trim().isEmpty()){
           greska(sirovina, "Obavezno unesite teret");
           return;
       }
        
        odabrano.setKamion((Kamion) kamion.getSelectedItem());
        odabrano.setDobavljac((Dobavljac) dobavljac.getSelectedItem());
        odabrano.setVrijemeistovara(vrijemeIstovara.getDate());
        odabrano.setSirovina(sirovina.getText().trim());
       
         try {
            odabrano.setKolicinat((BigDecimal) decimalFormat.parse(kolicinat.getText().trim()));
        } catch (Exception e) {
            greska(kolicinat, "broj nije dobrog formata");
            return;
        }      
         
        //promjena u bazi
        if(!obrada.promijeni(odabrano)){
            return;
        }
               
        lista.repaint();
        
    }//GEN-LAST:event_akcijaPromijeniActionPerformed

    private void akcijaObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaObrisiActionPerformed
       
        odabrano = (Dovoz) lista.getSelectedValue();
        if(odabrano==null){
            return;
        }
       if(JOptionPane.showConfirmDialog(getParent(), "Jeste li sigurni da želite obrisati dovoz " + odabrano.getVrijemeistovara()+ ", "+ odabrano.getStovariste().getNaziv() + ", " + odabrano.getStovariste().getMjesto() + ", " 
               + odabrano.getSirovina() + "?","Brisanje kamiona",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
            return;
        }
       
       if(!obrada.obrisi(odabrano)){
           return;
       }
       
       DefaultListModel<Dovoz> m =   (DefaultListModel<Dovoz>) lista.getModel();
       m.removeElement(odabrano);
       lista.repaint();
       cistiPolja();
        
    }//GEN-LAST:event_akcijaObrisiActionPerformed

    
    private void cistiPolja(){
        sirovina.setText("");
        kolicinat.setText("");
        
    }
    
        private void reset() {
       
        for (Component c : this.getContentPane().getComponents()) {
            if (c instanceof JTextField ){
                JComponent jc = (JComponent) c;
                jc.setBackground(Color.white);
                jc.setToolTipText("");
            }
        }
    }
        
         private void greska(JComponent komponenta, String obavijest){
           komponenta.setBackground(Color.yellow);
           komponenta.requestFocus();
           komponenta.setToolTipText(obavijest);
           
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton akcijaDodaj;
    private javax.swing.JButton akcijaObrisi;
    private javax.swing.JButton akcijaPovratak;
    private javax.swing.JButton akcijaPromijeni;
    private javax.swing.JButton akcijaTrazi;
    private javax.swing.JComboBox dobavljac;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox kamion;
    private javax.swing.JTextField kolicinat;
    private javax.swing.JList lista;
    private javax.swing.JTextField sirovina;
    private javax.swing.JComboBox stovariste;
    private javax.swing.JCheckBox traziDatum;
    private org.freixas.jcalendar.JCalendarCombo uvjetDatum;
    private javax.swing.JTextField uvjetSirovina;
    private javax.swing.JComboBox uvjetStovariste;
    private org.freixas.jcalendar.JCalendarCombo vrijemeIstovara;
    // End of variables declaration//GEN-END:variables
}
