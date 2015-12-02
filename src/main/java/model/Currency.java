package model;

import java.util.ArrayList;
import java.util.List;

public class Currency {
    private String devise;
    private double taux;

    public Currency(String devise, double taux){
        this.devise = devise;
        this.taux = taux;
    }

    public String getDevise(){
        return this.devise;
    }

    public double getTaux(){
        return this.taux;
    }

    public double calcul(Currency to, double qty){
        return qty * this.taux / to.taux;
    }
}
