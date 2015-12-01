package model;


import junit.framework.Assert;
import org.junit.Test;

public class CurrencyTest {
    @Test
    public void testCalcul() throws Exception {
        Currency c1 = new Currency("eur", 1.06340);
        Currency c2 = new Currency("usd", 1);
        Assert.assertEquals(1.06340, c1.calcul(c2, 1));
    }
}
