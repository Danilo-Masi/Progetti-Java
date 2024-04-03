package it.unibas.mastermind.test;

import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Operatore;
import it.unibas.mastermind.modello.Risposta;
import org.junit.Assert;
import org.junit.Test;

public class TestOperatore {

    private Operatore operatore = new Operatore();

    @Test
    public void testContaOccorrenze() {
        //Creiamo la combinazione
        Combinazione combinazione = new Combinazione(1, 2, 3, 4);
        //Verifichiamo la condizione del risulato che ci aspettiamo
        Assert.assertEquals(1, operatore.contaOccorrenze(1, combinazione));
        Assert.assertEquals(1, operatore.contaOccorrenze(2, combinazione));
        Assert.assertEquals(1, operatore.contaOccorrenze(3, combinazione));
        Assert.assertEquals(1, operatore.contaOccorrenze(4, combinazione));
        Assert.assertEquals(0, operatore.contaOccorrenze(5, combinazione));
        Assert.assertEquals(0, operatore.contaOccorrenze(6, combinazione));
    }

    @Test
    public void testGenerazioneCombinazione() {
        for (int i = 0; i < 100; i++) {
            Combinazione combinazioneCasuale = operatore.generaCombinazione();
            Assert.assertTrue(operatore.verificaCorrettezza(combinazioneCasuale));
        }
    }

    @Test
    public void testCombinazioneCorretta() {
        Assert.assertTrue(operatore.verificaCorrettezza(new Combinazione(1, 2, 3, 4)));
        Assert.assertTrue(operatore.verificaCorrettezza(new Combinazione(4, 3, 2, 1)));
        Assert.assertTrue(operatore.verificaCorrettezza(new Combinazione(1, 2, 3, 5)));
    }

    @Test
    public void testCombinazioneScorretta() {
        Assert.assertFalse(operatore.verificaCorrettezza(new Combinazione(1, 1, 3, 4)));
        Assert.assertFalse(operatore.verificaCorrettezza(new Combinazione(4, 3, 2, 4)));
        try {
            Combinazione combinazione = new Combinazione(1, 2, 5, 7);
            Assert.fail();
        } catch (IllegalArgumentException ex) {

        }
    }

    @Test
    public void testTentativo1() {
        Combinazione combinazioneNascosta = new Combinazione(1, 2, 3, 4);
        Combinazione combinazioneTentativo = new Combinazione(5, 6, 1, 2);
        Risposta risposta = operatore.valutaTentaivo(combinazioneNascosta, combinazioneTentativo);
        Assert.assertEquals("Pallini neri", 0, risposta.getPalliniNeri());
        Assert.assertEquals("Pallini bianchi", 2, risposta.getPalliniBianchi());
    }

}
