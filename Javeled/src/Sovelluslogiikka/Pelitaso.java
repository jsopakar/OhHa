/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author jsopakar
 */

/* Luokkarunko pelitasolle, joka tulee sisältämään yhden Peliruudukon,
 * ja muut kyseiseen tasoon liittyvät tiedot, kuten vuoromäärän, pistelaskun,
 * ja tiedon siitä milloin taso on läpäisty.
 */
public class Pelitaso {
    
    private int tempTestikoko = 6;
    
    private Peliruudukko ruudukko;
    
    public Pelitaso() {
        
        ruudukko = new Peliruudukko(tempTestikoko);
        ruudukko.taytaRuudukko();
    }
    
    public Peliruudukko getRuudukko() {
        return this.ruudukko;
    }
       
}