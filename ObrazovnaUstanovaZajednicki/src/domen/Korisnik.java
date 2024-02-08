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
public class Korisnik extends OpstiDomenskiObjekat{

    private long korisnikID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(long korisnikID, String ime, String prezime, String username, String password) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(long korisnikID) {
        this.korisnikID = korisnikID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String nazivTabele() {
        return " korisnik ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("ImeKorisnika"),
                    rs.getString("PrezimeKorisnika"), rs.getString("Username"), rs.getString("Password"));

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ImeKorisnika, PrezimeKorisnika, Username, Password) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KorisnikID = " + korisnikID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', " + "'" + username + "', '" + password + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " ImeKorisnika = '" + ime + "', PrezimeKorisnika = '" + prezime + "', " + "Username = '" + username + "', Password = '"
                + password + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
