package model;

//Cette classe constitue notre Model
//Cette classe effectue notamment les calculs dont nous aurons besoins
//Cette classe ne connait pas notamment l'existance de la View
public class Currency {
    //Une devise est constituée d'un nom et d'un taux
    //Variables
    private String devise;
    private double taux;

    //Constructeur
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

    //Méthode de calcul d'une devise dans une autre
    public double calcul(Currency to, double qty){
        return qty * this.taux / to.taux;
    }
}
