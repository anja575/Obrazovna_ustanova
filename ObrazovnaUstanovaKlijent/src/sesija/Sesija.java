/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesija;

import domen.Korisnik;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author HP ProBook 650 G2
 */
public class Sesija {
    
    private static Sesija instance;
    private Socket socket;
    private Korisnik ulogovani;
    
    private Sesija() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(Korisnik ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Korisnik getUlogovani() {
        return ulogovani;
    }
    
}
