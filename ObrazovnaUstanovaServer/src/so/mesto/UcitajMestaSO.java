/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.mesto;

import java.util.ArrayList;
import db.DBBroker;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP ProBook 650 G2
 */
public class UcitajMestaSO extends OpstaSistemskaOperacija {

    private ArrayList<Mesto> lista;

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Mesto)) {
            throw new Exception("Dati objekat nije instanca klase Mesto.");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> mesta = DBBroker.getInstance().select(odo);
        lista = (ArrayList<Mesto>) (ArrayList<?>) mesta;
    }

    public ArrayList<Mesto> getLista() {
        return lista;
    }
    
}
