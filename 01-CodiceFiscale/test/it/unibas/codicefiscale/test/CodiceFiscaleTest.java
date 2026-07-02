package it.unibas.codicefiscale.test;

import it.unibas.codicefiscale.modello.Costanti;
import it.unibas.codicefiscale.modello.Persona;
import junit.framework.TestCase;

public class CodiceFiscaleTest extends TestCase {

    public CodiceFiscaleTest(String testName) {
        super(testName);
    }

    // TEST CORRETTO
    public void testCodiceFiscale1() {
        Persona persona = new Persona("Danilo", "Masi", 1999, "Venosa", Costanti.MASCHIO);
        assertEquals("DANMAS1999M", persona.getCodiceFiscale());
    }

    // TEST CORRETTO
    public void testCodiceFiscale2() {
        Persona persona = new Persona("Luigi", "Bisceglia", 1967, "Canosa", Costanti.MASCHIO);
        assertEquals("LUIBIS1967M", persona.getCodiceFiscale());
    }

    // TEST LANCIA ECCEZZIONE
    public void testCodiceFiscale3() {
        Persona persona = new Persona("XX", "X", 1999, "Venosa", Costanti.FEMMINA);
        try {
            persona.getCodiceFiscale();
            fail("Il codice fiscale non doveva poter essere calcolato");
        } catch (IllegalArgumentException iae) {
        }
    }

}
