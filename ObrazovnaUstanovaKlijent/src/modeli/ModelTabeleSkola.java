/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Skola;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP ProBook 650 G2
 */
public class ModelTabeleSkola extends AbstractTableModel{
    
    ArrayList<Skola> lista;
    String[] kolone = {"Naziv", "Adresa"};

    public ModelTabeleSkola() {
        lista = new ArrayList<>();
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
        Skola stavkaListe = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return stavkaListe.getNaziv();
            case 1:
                return stavkaListe.getAdresa();
            default:
                return "return!";
        }
    }

    public void popuniSkole(ArrayList<Skola> skole) {
        lista = skole;
        fireTableDataChanged();
    }

    public Skola vratiSkolu(int red) {
        return lista.get(red);
    }
    
}
