/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Korisnik;
import domen.Odeljenje;
import domen.Skola;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import konstante.Operacije;
import konstante.Status;
import logika.KontrolerServer;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author HP ProBook 650 G2
 */
public class ObradaKlijentskihZahteva extends Thread {

    private Socket s;

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                KlijentskiZahtev kz = (KlijentskiZahtev) in.readObject();
                ServerskiOdgovor so = vratiOdgovor(kz);
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                out.writeObject(so);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ServerskiOdgovor vratiOdgovor(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor(null, null, Status.Uspesno);

        try {
            switch (kz.getOperacija()) {
                case Operacije.LOGIN:
                    Korisnik korisnik = (Korisnik) kz.getParametar();
                    Korisnik k = KontrolerServer.getInstance().login(korisnik);
                    so.setOdgovor(k);
                    break;
                case Operacije.VRATI_SKOLE:
                    so.setOdgovor(KontrolerServer.getInstance().ucitajSkole());
                    break;
                case Operacije.VRATI_SMEROVE:
                    so.setOdgovor(KontrolerServer.getInstance().ucitajSmerove());
                    break;
                case Operacije.VRATI_MESTA:
                    so.setOdgovor(KontrolerServer.getInstance().ucitajMesta());
                    break;
                case Operacije.DODAJ_ODELJENJE:
                    KontrolerServer.getInstance().dodajOdeljenje((Odeljenje) kz.getParametar());
                    break;
                case Operacije.VRATI_ODELJENJA:
                    so.setOdgovor(KontrolerServer.getInstance().ucitajOdeljenja());
                    break;
                case Operacije.OBRISI_ODELJENJE:
                    KontrolerServer.getInstance().obrisiOdeljenje((Odeljenje) kz.getParametar());
                    break;
                case Operacije.VRATI_UCENIKE:
                    so.setOdgovor(KontrolerServer.getInstance().ucitajUcenike((Odeljenje) kz.getParametar()));
                    break;
                case Operacije.IZMENI_ODELJENJE:
                    KontrolerServer.getInstance().izmeniOdeljenje((Odeljenje) kz.getParametar());
                    break;
                case Operacije.OBRISI_SKOLU:
                    KontrolerServer.getInstance().obrisiSkolu((Skola) kz.getParametar());
                    break;
                case Operacije.IZMENI_SKOLU:
                    KontrolerServer.getInstance().izmeniSkolu((Skola) kz.getParametar());
                    break;
                case Operacije.DODAJ_SKOLU:
                    KontrolerServer.getInstance().dodajSkolu((Skola) kz.getParametar());
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            so.setStatus(Status.Neuspesno);
            so.setException(e);
        }
        return so;
    }

}
