package it.unibas.mastermind.test;

import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Operatore;
import org.junit.Assert;
import org.junit.Test;

public class TestOperatore {

    @Test
    public void testCombinazioneCorretta() {
        //Creiamo la combinazione
        Combinazione combinazione = new Combinazione();
        combinazione.setCifraPosizione(1, 0);
        combinazione.setCifraPosizione(2, 1);
        combinazione.setCifraPosizione(3, 2);
        combinazione.setCifraPosizione(4, 3);
        //Verifichiamo la condizione del risulato che ci aspettiamo
        Operatore operatore = new Operatore();
        Assert.assertEquals(1, operatore.contaOccorrenze(1, combinazione));
        Assert.assertEquals(1, operatore.contaOccorrenze(2, combinazione));
        Assert.assertEquals(1, operatore.contaOccorrenze(3, combinazione));
        Assert.assertEquals(1, operatore.contaOccorrenze(4, combinazione));
        Assert.assertEquals(0, operatore.contaOccorrenze(5, combinazione));
        Assert.assertEquals(0, operatore.contaOccorrenze(6, combinazione));
    }

}
