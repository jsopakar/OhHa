/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.*;

/**
 *
 * @author jsopakar
 */
public class TekstiKL {

    public TekstiKL() {
        
    }
    
    public void testipeli() {
        
        System.out.println("Testipeli:");
        System.out.println("Luodaan kenttä:");
        
        Pelitaso peli = new Pelitaso();
        
        tulostaRuudukko(peli.getRuudukko());
        
        
    }
    
    private void tulostaRuudukko(Peliruudukko ruudukko) {
        int koko = ruudukko.kerroKoko();
        
        for (int i=0; i<koko; i++) {
            for (int j=0; j<koko; j++) {
                
                System.out.print(ruudukko.palautaRuutu(i, j).kerroTyyppi());
            }
            System.out.println("");
        }

    }
    
}
