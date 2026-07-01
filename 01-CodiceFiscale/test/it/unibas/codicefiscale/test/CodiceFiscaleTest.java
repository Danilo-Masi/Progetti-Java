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

    // TEST DATI SCORRETTI
    public void testCodiceFiscale2() {
        Persona persona = new Persona("Danilo", "Masi", 1999, "Venosa", Costanti.MASCHIO);
        assertEquals("MSADNL1999M", persona.getCodiceFiscale());
    }
    
    // TEST LANCIA ECCEZZIONE
    public void testCodiceFiscale3() {
        Persona persona = new Persona("XX", "X", 1999, "Venosa", Costanti.MASCHIO);
        persona.getCodiceFiscale();
    }

}
