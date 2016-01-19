/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.pl;

/**
 *
 * @author PanRyba.pl
 */
public class Declination {
    private final String mianownik;
    private final String dopelniacz;
    private final String celownik;
    private final String biernik;
    private final String narzednik;
    private final String miejscownik;
    private final String wolacz;
    
    public Declination(String mianownik, String dopelniacz, String celownik, String biernik, String narzednik, String miejscownik, String wolacz) {
        this.mianownik = mianownik;
        this.dopelniacz = dopelniacz;
        this.celownik = celownik;
        this.biernik = biernik;
        this.narzednik = narzednik;
        this.miejscownik = miejscownik;
        this.wolacz = wolacz;
    }

    public String getMianownik() {
        return this.mianownik;
    }
    
    public String getDopelniacz() {
        return this.dopelniacz;
    }
    
    public String getCelownik() {
        return this.celownik;
    }
    
    public String getBiernik() {
        return this.biernik;
    }
    
    public String getNarzednik() {
        return this.narzednik;
    }
    
    public String getMiejscownik() {
        return this.miejscownik;
    }
    
    public String getWolacz() {
        return this.wolacz;
    }    
}
