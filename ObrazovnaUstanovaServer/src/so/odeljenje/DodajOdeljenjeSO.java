/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.odeljenje;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DBBroker;
import domen.Odeljenje;
import domen.Ucenik;
import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author HP ProBook 650 G2
 */
public class DodajOdeljenjeSO extends OpstaSistemskaOperacija {

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Odeljenje)) {
            throw new Exception("Dati objekat nije instanca klase Odeljenje.");
        }

        Odeljenje odeljenje = (Odeljenje) odo;

        if (odeljenje.getUcenici().size() < 5 || odeljenje.getUcenici().size() > 30) {
            throw new Exception("Broj ucenika u odeljenju mora biti od 5 do 30.");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        PreparedStatement ps = DBBroker.getInstance().insert(odo);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long odeljenjeID = tableKeys.getLong(1);

        Odeljenje odeljenje = (Odeljenje) odo;
        odeljenje.setOdeljenjeID(odeljenjeID);

        for (Ucenik ucenik : odeljenje.getUcenici()) {
            ucenik.setOdeljenje(odeljenje);
            DBBroker.getInstance().insert(ucenik);
        }
    }

}
