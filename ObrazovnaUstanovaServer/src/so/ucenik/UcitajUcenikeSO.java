/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.ucenik;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Ucenik;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP ProBook 650 G2
 */
public class UcitajUcenikeSO extends OpstaSistemskaOperacija {

    private ArrayList<Ucenik> lista;

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Ucenik)) {
            throw new Exception("Dati objekat nije instanca klase Ucenik.");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> ucenici = DBBroker.getInstance().select(odo);
        lista = (ArrayList<Ucenik>) (ArrayList<?>) ucenici;
    }

    public ArrayList<Ucenik> getLista() {
        return lista;
    }
}
