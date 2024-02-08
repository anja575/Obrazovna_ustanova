/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Mesto;
import domen.Odeljenje;
import domen.Ucenik;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import logika.KontrolerKlijent;

/**
 *
 * @author HP ProBook 650 G2
 */
public class ModelTabeleOdeljenje extends AbstractTableModel implements Runnable{
    
    ArrayList<Odeljenje> lista;
    String[] kolone = {"Naziv", "Škola", "Smer"};
    private String parametar="";
    //Mesto mesto;
    public ModelTabeleOdeljenje() {
        try {
            lista = KontrolerKlijent.getInstance().vratiOdeljenja();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleOdeljenje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ModelTabeleOdeljenje(Mesto m) {
        ArrayList<Ucenik> ucenici = new ArrayList<>();
        ArrayList<Odeljenje> odeljenja = new ArrayList<>();
        ArrayList<Odeljenje> novaOdeljenja = new ArrayList<>();
        try {
            odeljenja = KontrolerKlijent.getInstance().vratiOdeljenja();
            for (Odeljenje odeljenje : odeljenja) {
                 ucenici = KontrolerKlijent.getInstance().vratiUcenike(odeljenje);
                if(ucenici.get(0).getMesto().getMestoID() == m.getMestoID()){
                    novaOdeljenja.add(odeljenje);
                }
                
            }
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleOdeljenje.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista = novaOdeljenja;
    }
   

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return kolone[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Odeljenje stavkaListe = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return stavkaListe.getNaziv();
            case 1:
                return stavkaListe.getSkola();
            case 2:
                return stavkaListe.getSmer();
            default:
                return "return!";
        }
    }

    public void popuniOdeljenja(ArrayList<Odeljenje> odeljenja) {
        lista = odeljenja;
        fireTableDataChanged();
    }

    public void obrisiOdeljenje(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public Odeljenje vratiOdeljenje(int red) {
        return lista.get(red);
    }

    public void setParametar(String rec) {
        parametar = rec;
        pronadjiOdeljenja();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(3000);
                pronadjiOdeljenja();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ModelTabeleOdeljenje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pronadjiOdeljenja() {
        try {
            lista = KontrolerKlijent.getInstance().vratiOdeljenja();
            if (!parametar.equals("")) {
                ArrayList<Odeljenje> pretrazenaOdeljenja = new ArrayList<>();
                for (Odeljenje o : lista) {
                    if (o.getNaziv().toLowerCase().contains(parametar.toLowerCase())
                            || o.getSkola().getNaziv().toLowerCase().contains(parametar.toLowerCase())) {
                        pretrazenaOdeljenja.add(o);
                    }
                }
                lista = pretrazenaOdeljenja;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
