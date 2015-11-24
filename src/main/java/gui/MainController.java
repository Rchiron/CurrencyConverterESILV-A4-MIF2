package gui;

import model.Currency;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public List<Currency> currencyList;

    public MainController(){
        currencyList = new ArrayList<>();
    }

    public void addCurrency(Currency c){
        currencyList.add(c);
    }

    public void converterList(){
        Currency eur = new Currency("EUR - Euro", 1.06472);
        Currency dollars = new Currency("USD - Dollar USA", 1);
        Currency gpb = new Currency("GBP - Livre britannique", 1.50813);
        Currency inr = new Currency("INR - Roupie indienne",0.01508);
        Currency aud = new Currency("AUD - Dollar australien",0.72732);
        Currency cad = new Currency("CAD - Dollar canadien",0.75174);
        Currency zar = new Currency("ZAR - Rand sud-africain", 0.65612);
        Currency jpy = new Currency("JPY - Yen japonais", 0.00816);

        addCurrency(eur);
        addCurrency(dollars);
        addCurrency(gpb);
        addCurrency(inr);
        addCurrency(aud);
        addCurrency(cad);
        addCurrency(zar);
        addCurrency(jpy);
    }

    public List<Currency> getList(){
        return this.currencyList;
    }
}
