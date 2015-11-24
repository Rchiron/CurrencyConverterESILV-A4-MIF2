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
        Currency eur = new Currency("EUR", 1.06514);
        Currency dollars = new Currency("USD", 1);

        addCurrency(eur);
        addCurrency(dollars);
    }

    public List<Currency> getList(){
        return this.currencyList;
    }
}
