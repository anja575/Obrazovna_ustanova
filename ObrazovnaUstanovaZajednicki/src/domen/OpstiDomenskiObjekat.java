/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP ProBook 650 G2
 */
public abstract class OpstiDomenskiObjekat implements Serializable{
    
    public abstract String nazivTabele();

    public abstract String alijas();
   
    public abstract String join();
    
    public abstract ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException;
  
    public abstract String koloneZaInsert();
    
    public abstract String vrednostZaPrimarniKljuc();
    
    public abstract String vrednostiZaInsert();
    
    public abstract String vrednostiZaUpdate();
    
    public abstract String uslov();
    
}
