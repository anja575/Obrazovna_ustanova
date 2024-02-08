/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domen.Korisnik;
import domen.Mesto;
import domen.Odeljenje;
import domen.Skola;
import domen.Smer;
import domen.Ucenik;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import konstante.Operacije;
import konstante.Status;
import transfer.KlijentskiZahtev;
import sesija.Sesija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author HP ProBook 650 G2
 */
public class KontrolerKlijent {
    
    private static KontrolerKlijent instance;

    private KontrolerKlijent() {
    }

    public static KontrolerKlijent getInstance() {
        if (instance == null) {
            instance = new KontrolerKlijent();
        }
        return instance;
    }
    
    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(operacija, parametar);

        ObjectOutputStream out = new ObjectOutputStream(Sesija.getInstance().getSocket().getOutputStream());
        out.writeObject(kz);

        ObjectInputStream in = new ObjectInputStream(Sesija.getInstance().getSocket().getInputStream());
        ServerskiOdgovor so = (ServerskiOdgovor) in.readObject();

        if (so.getStatus().equals(Status.Neuspesno)) {
            throw so.getException();
        } else {
            return so.getOdgovor();
        }
    }
    
    public Korisnik login(Korisnik korisnik) throws Exception {
        return (Korisnik) posaljiZahtev(Operacije.LOGIN, korisnik);
    }
    
    public ArrayList<Skola> ucitajSkole() throws Exception {
        return (ArrayList<Skola>) posaljiZahtev(Operacije.VRATI_SKOLE, null);
    }

    public ArrayList<Smer> ucitajSmerove() throws Exception {
        return (ArrayList<Smer>) posaljiZahtev(Operacije.VRATI_SMEROVE, null);
    }

    public ArrayList<Mesto> ucitajMesta() throws Exception {
        return (ArrayList<Mesto>) posaljiZahtev(Operacije.VRATI_MESTA, null);
    }

    public void dodajOdeljenje(Odeljenje odeljenje) throws Exception {
        posaljiZahtev(Operacije.DODAJ_ODELJENJE, odeljenje);
    }

    public ArrayList<Odeljenje> vratiOdeljenja() throws Exception {
        return (ArrayList<Odeljenje>) posaljiZahtev(Operacije.VRATI_ODELJENJA, null);
    }

    public void obrisiOdeljenje(Odeljenje odeljenje) throws Exception {
        posaljiZahtev(Operacije.OBRISI_ODELJENJE, odeljenje);
    }

    public ArrayList<Ucenik> vratiUcenike(Odeljenje odeljenje) throws Exception {
        return (ArrayList<Ucenik>) posaljiZahtev(Operacije.VRATI_UCENIKE, odeljenje);
    }

    public void izmeniOdeljenje(Odeljenje odeljenje) throws Exception {
        posaljiZahtev(Operacije.IZMENI_ODELJENJE, odeljenje);
    }

    public ArrayList<Skola> vratiSkole() throws Exception {
        return (ArrayList<Skola>) posaljiZahtev(Operacije.VRATI_SKOLE, null);
    }

    public void obrisiSkolu(Skola skola) throws Exception {
        posaljiZahtev(Operacije.OBRISI_SKOLU, skola);
    }

    public void izmeniSkolu(Skola skola) throws Exception {
        posaljiZahtev(Operacije.IZMENI_SKOLU, skola);
    }

    public void dodajSkolu(Skola skola) throws Exception {
        posaljiZahtev(Operacije.DODAJ_SKOLU, skola);
    }
    
}
