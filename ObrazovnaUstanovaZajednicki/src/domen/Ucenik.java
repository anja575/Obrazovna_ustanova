/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author HP ProBook 650 G2
 */
public class Ucenik extends OpstiDomenskiObjekat {

    private Odeljenje odeljenje;
    private long ucenikID;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String ulica;
    private String broj;
    private Mesto mesto;

    public Ucenik() {
    }

    public Ucenik(Odeljenje odeljenje, long ucenikID, String ime, String prezime, Date datumRodjenja, String ulica, String broj, Mesto mesto) {
        this.odeljenje = odeljenje;
        this.ucenikID = ucenikID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }
    
    public long getUcenikID() {
        return ucenikID;
    }

    public void setUcenikID(long ucenikID) {
        this.ucenikID = ucenikID;
    }
    
    public Odeljenje getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(Odeljenje odeljenje) {
        this.odeljenje = odeljenje;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getUlica() {
        return ulica;
    }
    
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }
 
    @Override
    public String nazivTabele() {
        return " ucenik ";
    }

    @Override
    public String alijas() {
        return " u ";
    }

    @Override
    public String join() {
        return " JOIN MESTO M ON (M.MESTOID = U.MESTOID) "
                + "JOIN ODELJENJE O ON (U.ODELJENJEID = O.ODELJENJEID) "
                + "JOIN SMER SM ON (SM.SMERID = O.SMERID) "
                + "JOIN SKOLA SK ON (SK.SKOLAID = O.SKOLAID) "
                + "JOIN KORISNIK K ON (K.KORISNIKID = O.KORISNIKID)";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("ImeKorisnika"),
                    rs.getString("PrezimeKorisnika"), rs.getString("Username"), rs.getString("Password"));

            Smer smer = new Smer(rs.getLong("SmerID"), rs.getString("NazivSmera"));

            Skola skola = new Skola(rs.getLong("SkolaID"), rs.getString("NazivSkole"),
                    rs.getString("Adresa"));

            Odeljenje o = new Odeljenje(rs.getLong("OdeljenjeID"), rs.getString("NazivOdeljenja"), skola, smer, k, null);

            Mesto m = new Mesto(rs.getLong("MestoID"), rs.getString("NazivMesta"),
                    rs.getString("PostanskiBroj"));

            Ucenik u = new Ucenik(o, rs.getLong("UcenikID"), rs.getString("ImeUcenika"), rs.getString("PrezimeUcenika"),
                    rs.getDate("DatumRodjenja"), rs.getString("Ulica"), rs.getString("Broj"), m);

            lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (OdeljenjeID, UcenikID, ImeUcenika, PrezimeUcenika, DatumRodjenja, Ulica, Broj, MestoID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " OdeljenjeID = " + odeljenje.getOdeljenjeID();
    }

    @Override
    public String vrednostiZaInsert() {
        return "" + odeljenje.getOdeljenjeID() + ", " + ucenikID + 
                ", '" + ime + "', '" + prezime + "', '" 
                + new java.sql.Date(datumRodjenja.getTime())
                + "', '" + ulica + "', '" + broj + "', " + mesto.getMestoID() + "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " ImeUcenika = '" + ime + "', PrezimeUcenika = '" + prezime + "', DatumRodjenja = '" + new java.sql.Date(datumRodjenja.getTime()) + "', Ulica = '"
                + ulica + "', Broj = '" + broj + "', MestoID = '" + mesto.getMestoID() + "' ";
    }

    @Override
    public String uslov() {
        return " WHERE O.ODELJENJEID = " + odeljenje.getOdeljenjeID() + " ORDER BY U.UCENIKID";
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
