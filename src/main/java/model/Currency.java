package model;

import java.util.ArrayList;
import java.util.List;

public class Currency {
    public String devise;
    public double taux;
    public List<Currency> currencyList;

    public Currency(String devise, double taux){
        this.devise = devise;
        this.taux = taux;
        currencyList = new ArrayList<>();
    }

    public  Currency(int choice){
        currencyList = new ArrayList<>();
        if(choice == 1){
            converterList();
        }
    }
    public String getDevise(){
        return this.devise;
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
