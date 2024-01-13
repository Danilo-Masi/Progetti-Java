package it.unibas.codicefiscale.test;

import it.unibas.codicefiscale.modello.Costanti;
import it.unibas.codicefiscale.modello.Persona;
import junit.framework.TestCase;

public class CodiceFIscaleTest extends TestCase {

    public CodiceFIscaleTest(String testName) {
        super(testName);
    }

    public void testCodiceFiscale1() {
        Persona persona = new Persona("Danilo", "Masi", 1999, Costanti.MASCHIO, "Lavello");
        assertEquals("DANMAS1999M", persona.getCodiceFiscale());
    }

    public void testCodiceFiscale2() {
        Persona persona = new Persona("Gino", "Masi", 1990, Costanti.MASCHIO, "Lavello");
        assertEquals("GINMAS1990M", persona.getCodiceFiscale());
    }

    public void testCodiceFiscaleScorretto() {
        Persona persona = new Persona("XX", "XX", 1990, Costanti.FEMMINA, "Lavello");
        try {
            persona.getCodiceFiscale();
            fail("Il codice fiscale non doveva poter essere calcolato");
        } catch (IllegalArgumentException e) {
        }

    }

}
