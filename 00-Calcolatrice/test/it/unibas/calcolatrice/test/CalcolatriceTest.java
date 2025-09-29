package it.unibas.calcolatrice.test;

import it.unibas.calcolatrice.Calcolatrice;
import junit.framework.TestCase;

public class CalcolatriceTest extends TestCase {
    
    private Calcolatrice calcolatrice;
    
    @Override
    public void setUp() {
        this.calcolatrice = new Calcolatrice();
    }
    
    //TODO Aggiungere nuovi test
    public void testSomma() {
        calcolatrice.somma(1.0, 2.0);
        assertEquals(3.0, calcolatrice.getRisultato());
    }
    
}
