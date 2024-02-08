/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.skola;

import java.util.ArrayList;
import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Skola;

import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP ProBook 650 G2
 */
public class UcitajSkoleSO extends OpstaSistemskaOperacija {

    private ArrayList<Skola> lista;

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Skola)) {
            throw new Exception("Dati objekat nije instanca klase Skola.");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> skole = DBBroker.getInstance().select(odo);
        lista = (ArrayList<Skola>) (ArrayList<?>) skole;
    }

    public ArrayList<Skola> getLista() {
        return lista;
    }

}
