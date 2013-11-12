/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Peliruudukko;
import java.awt.Point;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jsopakar
 */
public class PeliruudukkoTest {
    
    Peliruudukko ruudukko;
    
    public PeliruudukkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruudukko = new Peliruudukko(6);
        ruudukko.taytaEsimerkkiruudukko();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void hello() {}
    
    @Test
    // Koetesti
    public void ruudukonEkanRuudunArvoOikein() {
        int ekaArvo = ruudukko.palautaRuutu(0, 0).kerroTyyppi();
        
        assertEquals(1, ekaArvo);
        
    } 
    
    @Test
    // TODO: muokattava paremmaksi vielä...
    public void onnistuukoRuutujenVaihto() {
        int arvo1 = ruudukko.palautaRuutu(2, 1).kerroTyyppi();
        int arvo2 = ruudukko.palautaRuutu(2, 2).kerroTyyppi();
        ruudukko.vaihdaRuudut(2, 1, 2, 2);
        int uusi1 = ruudukko.palautaRuutu(2, 1).kerroTyyppi();
        int uusi2 = ruudukko.palautaRuutu(2, 2).kerroTyyppi();
        
        assertEquals(arvo1, uusi2);
        assertEquals(arvo2, uusi1);
        
    }
    
    @Test
    public void toimiikoSamanTyypinRuudunSiirtojenEsto() {
        boolean onnistuiko = ruudukko.siirtoMahdollinen(0, 0, 0, 1);
        assertEquals(false, onnistuiko);
    }
    
    @Test
    public void toimiikoYksittaisenRuudunTarkastelu() {
        int samojenMaara = ruudukko.kasitteleRuutu(2, 2);
        assertEquals(1, samojenMaara);
    }
    
    @Test
    public void toimiikoKolmenRuudunTarkastelu() {
        int samojenMaara = ruudukko.kasitteleRuutu(1, 3);
        assertEquals(3, samojenMaara);
    }
    
    @Test
    //taulukon raja-arvoja varten
    public void toimiikoEnsimmaisenJaViimaisenTarkastelu() {
        int samojenMaaraEka = ruudukko.kasitteleRuutu(0, 0);
        assertEquals(2, samojenMaaraEka);
        int samojenMaaraViimainen = ruudukko.kasitteleRuutu(5, 5);
        assertEquals(1, samojenMaaraViimainen);
    }
    
    @Test
    public void toimiikoYhdenRuudunPoisto() {
        ArrayList<Point> poistettavat = new ArrayList<Point>();
        poistettavat.add(new Point(2, 3));
        ruudukko.poistaRuudut(poistettavat);
        int poistetunTyyppi = ruudukko.palautaRuutu(2, 3).kerroTyyppi();
        assertEquals(0, poistetunTyyppi);
    }
    
    public void toimiikoUseanRuudunPoisto() {
        ArrayList<Point> poistettavat = new ArrayList<Point>();
        poistettavat.add(new Point(0, 0));
        poistettavat.add(new Point(3, 2));
        poistettavat.add(new Point(5, 5));
        ruudukko.poistaRuudut(poistettavat);
        int[] oikea = {0,0,0};
        int[] poistetut = new int[3];
        poistetut[0] = ruudukko.palautaRuutu(0, 0).kerroTyyppi();
        poistetut[1] = ruudukko.palautaRuutu(3, 3).kerroTyyppi();
        poistetut[2] = ruudukko.palautaRuutu(5, 5).kerroTyyppi();
        assertArrayEquals(oikea, poistetut);
    }
    
}