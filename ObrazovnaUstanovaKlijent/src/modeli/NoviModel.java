/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Odeljenje;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP ProBook 650 G2
 */
public class NoviModel extends AbstractTableModel{
    
    ArrayList<Odeljenje> lista;
    String[] kolone =  {"Naziv", "Škola", "Smer"};

    public NoviModel() {
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

    
}
