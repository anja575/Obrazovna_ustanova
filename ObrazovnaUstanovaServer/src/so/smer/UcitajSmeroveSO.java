/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.smer;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Smer;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP ProBook 650 G2
 */
public class UcitajSmeroveSO extends OpstaSistemskaOperacija {

    private ArrayList<Smer> lista;

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Smer)) {
            throw new Exception("Dati objekat nije instanca klase Smer.");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> smerovi = DBBroker.getInstance().select(odo);
        lista = (ArrayList<Smer>) (ArrayList<?>) smerovi;
    }

    public ArrayList<Smer> getLista() {
        return lista;
    }

}
