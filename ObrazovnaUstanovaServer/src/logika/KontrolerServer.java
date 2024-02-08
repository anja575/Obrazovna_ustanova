/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import java.util.ArrayList;
import domen.Korisnik;
import domen.Mesto;
import domen.Odeljenje;
import domen.Skola;
import domen.Smer;
import domen.Ucenik;
import so.korisnik.PrijavaKorisnikaSO;
import so.mesto.UcitajMestaSO;
import so.odeljenje.DodajOdeljenjeSO;
import so.odeljenje.IzmeniOdeljenjeSO;
import so.odeljenje.ObrisiOdeljenjeSO;
import so.odeljenje.UcitajOdeljenjaSO;
import so.skola.DodajSkoluSO;
import so.skola.IzmeniSkoluSO;
import so.skola.ObrisiSkoluSO;
import so.skola.UcitajSkoleSO;
import so.smer.UcitajSmeroveSO;
import so.ucenik.UcitajUcenikeSO;

/**
 *
 * @author HP ProBook 650 G2
 */
public class KontrolerServer {
    
    private static KontrolerServer instance;

    private KontrolerServer() {
    }

    public static KontrolerServer getInstance() {
        if (instance == null) {
            instance = new KontrolerServer();
        }
        return instance;
    }

    public Korisnik login(Korisnik korisnik) throws Exception {
        PrijavaKorisnikaSO pkso = new PrijavaKorisnikaSO();
        pkso.izvrsavanje(korisnik);
        return pkso.getKorisnik();
    }

    public void dodajOdeljenje(Odeljenje odeljenje) throws Exception {
        (new DodajOdeljenjeSO()).izvrsavanje(odeljenje);
    }

    public void dodajSkolu(Skola skola) throws Exception {
        (new DodajSkoluSO()).izvrsavanje(skola);
    }

    public void obrisiOdeljenje(Odeljenje odeljenje) throws Exception {
        (new ObrisiOdeljenjeSO()).izvrsavanje(odeljenje);
    }

    public void obrisiSkolu(Skola skola) throws Exception {
        (new ObrisiSkoluSO()).izvrsavanje(skola);
    }
 
    public void izmeniOdeljenje(Odeljenje odeljenje) throws Exception {
        (new IzmeniOdeljenjeSO()).izvrsavanje(odeljenje);
    }

    public void izmeniSkolu(Skola skola) throws Exception {
        (new IzmeniSkoluSO()).izvrsavanje(skola);
    }

    public ArrayList<Odeljenje> ucitajOdeljenja() throws Exception {
        UcitajOdeljenjaSO uoso = new UcitajOdeljenjaSO();
        uoso.izvrsavanje(new Odeljenje());
        return uoso.getLista();
    }
   
    public ArrayList<Smer> ucitajSmerove() throws Exception {
        UcitajSmeroveSO usso = new UcitajSmeroveSO();
        usso.izvrsavanje(new Smer());
        return usso.getLista();
    }
    
    public ArrayList<Skola> ucitajSkole() throws Exception {
        UcitajSkoleSO usso = new UcitajSkoleSO();
        usso.izvrsavanje(new Skola());
        return usso.getLista();
    }
    
    public ArrayList<Mesto> ucitajMesta() throws Exception {
        UcitajMestaSO umso = new UcitajMestaSO();
        umso.izvrsavanje(new Mesto());
        return umso.getLista();
    }
    
    public ArrayList<Ucenik> ucitajUcenike(Odeljenje odeljenje) throws Exception {
        UcitajUcenikeSO uuso = new UcitajUcenikeSO();

        Ucenik u = new Ucenik();
        u.setOdeljenje(odeljenje);

        uuso.izvrsavanje(u);
        return uuso.getLista();
    }
    
}
