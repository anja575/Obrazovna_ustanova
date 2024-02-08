/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;

/**
 *
 * @author HP ProBook 650 G2
 */
public abstract class OpstaSistemskaOperacija {

    protected abstract void validacija(OpstiDomenskiObjekat odo) throws Exception;

    protected abstract void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception;

    public void izvrsavanje(OpstiDomenskiObjekat odo) throws Exception {
        try {
            validacija(odo);
            izvrsiOperaciju(odo);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }

}
