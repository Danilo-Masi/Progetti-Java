package it.unibas.codicefiscale.test;

import it.unibas.codicefiscale.modello.Costanti;
import it.unibas.codicefiscale.modello.Persona;
import junit.framework.TestCase;

public class CodiceFiscaleTest extends TestCase {
    
    public CodiceFiscaleTest(String testName) {
        super(testName);
    }
    
    public void testCodiceFiscale1() {
        Persona persona = new Persona("Danilo", "Masi", 1999, Costanti.MASCHIO, "Lavello");
        assertEquals("DANMAS1999M", persona.getCodiceFiscale());
    }
    
    public void testCodiceFiscale2() {
        Persona persona = new Persona("Maria", "Incoronata", 1912, Costanti.FEMMINA, "Siracusa");
        assertEquals("MARINC1912F", persona.getCodiceFiscale());
    }
    
    public void testCodiceFiscaleScorretto1() {
        Persona persona = new Persona("XX", "YY", 1945, Costanti.MASCHIO, "Milano");
        try {
            persona.getCodiceFiscale();
            fail("Il codice fiscale non doveva poter essere calcolato");
        } catch (IllegalArgumentException e) {
        }
    }
    
}
