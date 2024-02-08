/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Mesto;
import domen.Odeljenje;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import logika.KontrolerKlijent;
import modeli.ModelTabeleOdeljenje;
import sesija.Sesija;

/**
 *
 * @author HP ProBook 650 G2
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        setLocationRelativeTo(null);
        ModelTabeleOdeljenje model = new ModelTabeleOdeljenje();
        Thread nit = new Thread(model);
        nit.start();
        tblOdeljenja.setModel(model);
        setTitle("Obrazovna ustanova");
        txtUlogovani.setText(Sesija.getInstance().getUlogovani().toString());
        popuniMesta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUlogovani = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOdeljenja = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        txtPretraga = new javax.swing.JTextField();
        btnPrikazi = new javax.swing.JButton();
        cmbMesta = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        pregledSkola = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        odjaviSe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ulogovani korisnik:");

        txtUlogovani.setFont(new java.awt.Font("Viner Hand ITC", 3, 14)); // NOI18N
        txtUlogovani.setText("Ime i prezime");

        tblOdeljenja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblOdeljenja);

        jLabel2.setText("Pretraga odeljenja:");

        btnObrisi.setText("Obriši odeljenje");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni odeljenje");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj odeljenje");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        txtPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPretragaActionPerformed(evt);
            }
        });
        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        btnPrikazi.setText("Prikaži odeljenja za mesto");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });

        cmbMesta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Mesto:");

        jMenu1.setText("Škole");

        pregledSkola.setText("Pregled škola");
        pregledSkola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pregledSkolaActionPerformed(evt);
            }
        });
        jMenu1.add(pregledSkola);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Odjavi se");

        odjaviSe.setText("Odjavi se");
        odjaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odjaviSeActionPerformed(evt);
            }
        });
        jMenu2.add(odjaviSe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnPrikazi, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUlogovani))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnObrisi)
                        .addGap(57, 57, 57)
                        .addComponent(btnIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodaj))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrikazi)
                    .addComponent(cmbMesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tblOdeljenja.getSelectedRow();

        try {
            if (red >= 0) {
                ModelTabeleOdeljenje tabela = (ModelTabeleOdeljenje) tblOdeljenja.getModel();
                Odeljenje odeljenje = tabela.vratiOdeljenje(red);

                KontrolerKlijent.getInstance().obrisiOdeljenje(odeljenje);

                tabela.pronadjiOdeljenja();
                JOptionPane.showMessageDialog(null, "Uspešno ste obrisali odeljenje.", "Obaveštenje", INFORMATION_MESSAGE);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Neuspešno brisanje odeljenja.", "Obaveštenje", INFORMATION_MESSAGE);

            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int red = tblOdeljenja.getSelectedRow();

        if (red >= 0) {
            ModelTabeleOdeljenje tabela = (ModelTabeleOdeljenje) tblOdeljenja.getModel();
            Odeljenje odeljenje = tabela.vratiOdeljenje(red);

            IzmeniOdeljenjeForma of = new IzmeniOdeljenjeForma(this, true, odeljenje);
            of.setVisible(true);

        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        DodajOdeljenjeForma df = new DodajOdeljenjeForma(this, true);
        df.setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void pregledSkolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pregledSkolaActionPerformed
        SkoleForma sf = new SkoleForma(this, true);
        sf.setVisible(true);
    }//GEN-LAST:event_pregledSkolaActionPerformed

    private void odjaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odjaviSeActionPerformed
        this.dispose();
    }//GEN-LAST:event_odjaviSeActionPerformed

    private void txtPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPretragaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPretragaActionPerformed

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        String rec = txtPretraga.getText();
        ((ModelTabeleOdeljenje) tblOdeljenja.getModel()).setParametar(rec);        // TODO add your handling code here:
    }//GEN-LAST:event_txtPretragaKeyReleased

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed
        Mesto mesto = (Mesto) cmbMesta.getSelectedItem();
        OdeljenjaKonkretnogMesta forma = new OdeljenjaKonkretnogMesta(this, true, mesto);
        forma.setVisible(true);
    }//GEN-LAST:event_btnPrikaziActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavnaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JComboBox cmbMesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem odjaviSe;
    private javax.swing.JMenuItem pregledSkola;
    private javax.swing.JTable tblOdeljenja;
    private javax.swing.JTextField txtPretraga;
    private javax.swing.JLabel txtUlogovani;
    // End of variables declaration//GEN-END:variables

    void popuniTabelu() {
        ModelTabeleOdeljenje tabela = (ModelTabeleOdeljenje) tblOdeljenja.getModel();
        tabela.pronadjiOdeljenja();

    }

    private void popuniMesta() {
        try {
            ArrayList<Mesto> mesta = KontrolerKlijent.getInstance().ucitajMesta();

            cmbMesta.removeAllItems();

            for (Mesto mesto : mesta) {
                cmbMesta.addItem(mesto);
            }
        } catch (Exception ex) {
            Logger.getLogger(DodajOdeljenjeForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


}