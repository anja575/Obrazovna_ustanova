/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP ProBook 650 G2
 */
public class Skola extends OpstiDomenskiObjekat {

    private long skolaID;
    private String naziv;
    private String adresa;

    public Skola() {
    }

    public Skola(long skolaID, String naziv, String adresa) {
        this.skolaID = skolaID;
        this.naziv = naziv;
        this.adresa = adresa;
    }
    
    public long getSkolaID() {
        return skolaID;
    }

    public void setSkolaID(long skolaID) {
        this.skolaID = skolaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String nazivTabele() {
        return " skola ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Skola s = new Skola(rs.getLong("SkolaID"), rs.getString("NazivSkole"),
                    rs.getString("Adresa"));

            lista.add(s);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivSkole, Adresa) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " SkolaID = " + skolaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + naziv + "', '" + adresa + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " NazivSkole = '" + naziv + "', Adresa = '" + adresa + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String toString() {
        return naziv;
    }

}
