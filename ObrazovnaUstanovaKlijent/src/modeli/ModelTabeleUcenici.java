/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Odeljenje;
import domen.Ucenik;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import logika.KontrolerKlijent;

/**
 *
 * @author HP ProBook 650 G2
 */
public class ModelTabeleUcenici extends AbstractTableModel{
    
    ArrayList<Ucenik> lista;
    String[] kolone = {"Redni broj", "Ime", "Prezime", "Datum rodjenja"};
    private int rb = 0;

    public ModelTabeleUcenici() {
        lista = new ArrayList<>();
    }

    public ModelTabeleUcenici(Odeljenje odeljenje){
        try {
            lista = KontrolerKlijent.getInstance().vratiUcenike(odeljenje);
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleUcenici.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        Ucenik stavkaListe = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch (columnIndex) {
            case 0:
                return stavkaListe.getUcenikID();
            case 1:
                return stavkaListe.getIme();
            case 2:
                return stavkaListe.getPrezime();
            case 3:
                return sdf.format(stavkaListe.getDatumRodjenja());
            default:
                return "return!";
        }
    }

    public void dodajUcenika(Ucenik ucenik) {
        rb = lista.size();
        ucenik.setUcenikID(++rb);
        lista.add(ucenik);
        fireTableDataChanged();
    }

    public void obrisiUcenika(int red) {
        lista.remove(red);
        
        rb=0;
        for (Ucenik ucenik : lista) {
            ucenik.setUcenikID(++rb);  
        }
        fireTableDataChanged();
    }

    public ArrayList<Ucenik> vratiUcenike() {
        return lista;
    }

    public void popuniUcenike(ArrayList<Ucenik> ucenici) {
        lista = ucenici;
        fireTableDataChanged();
    }
    
    
    

    
}
