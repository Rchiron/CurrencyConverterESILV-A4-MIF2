package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Currency;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

//Cette classe constitue le Controller
//Elle effectue la coordiantion entre la View et le Model
//Elle effectue notamment les calculs
public class MainController implements Initializable{
    private List<Currency> currencyList;

    @FXML
    private TextField textFrom;
    @FXML
    private TextField textTo;
    @FXML
    private ComboBox<String> comboFrom;
    @FXML
    private ComboBox<String> comboTo;
    //Méthode qui s'active lorsqu'on active le boutton Convert
    @FXML
    private void handleButtonCalcul(){
        //On effectue un try catch au cas où l'utilisateur ne remplisse pas correctement l'ensemble des données
        try {
            //On stock dans quantity la quantité qu'a inscrite l'utilisateur
            double quantity = Double.valueOf(textFrom.getText());
            //On stcok dans nameFrom et nameTo les noms des deux devises choisient par l'utilisateur
            String nameFrom = comboFrom.getValue();
            String nameTo = comboTo.getValue();
            //On crée et initialise nos deux taux
            double tauxFrom = 0;
            double tauxTo = 0;
            //converList doit être appelé car sinon la liste est vide
            converterList();
            for(int i = 0; i < this.currencyList.size(); i++)
            {
                if(nameFrom == this.currencyList.get(i).getDevise())
                {
                    //Si le nom de la devise est identique on instancie alors tauxFrom
                    tauxFrom = this.currencyList.get(i).getTaux();
                }
                if(nameTo == this.currencyList.get(i).getDevise())
                {
                    //Si le nom de la devise est identique on instancie alors tauxTo
                    tauxTo = this.currencyList.get(i).getTaux();
                }
            }
            //On crée alors nos deux Currency pour ensuite appeler la méthode de calcul
            Currency c1 = new Currency(nameFrom, tauxFrom);
            Currency c2 = new Currency(nameTo, tauxTo);
            double result = c1.calcul(c2, quantity);
            //On injecte le résultat dans textTo
            textTo.setText(String.valueOf(result));
        }
        catch(NumberFormatException ex){
            //Si on rentre dans le catch on renvoit un message d'erreur
            JOptionPane.showMessageDialog(null, "You need to enter an integer on the textfield FROM and choose the currency you have and you want");
        }
    }

    //Méthode qui s'active quand l(utilisateur appuie sur le boutton d'échange des devises
    @FXML
    private void handleButtonExchange(){
        //On crée une variable temporelle de stockage
        String nameTmp;
        nameTmp = comboFrom.getValue();
        //On échange les deux devises
        comboFrom.setValue(comboTo.getValue());
        comboTo.setValue(nameTmp);
    }

    //Méthode qui s'acive quand l'utilisateur appuie sur le boutton Close
    @FXML
    private void handleButtonClose(){
        System.exit(0);
    }

    //Constructeur du controller
    public MainController(){
        currencyList = new ArrayList<>();
    }

    //Méthode qui ajoute une devise dans la liste des devises
    public void addCurrency(Currency c){
        currencyList.add(c);
    }

    //Méthode qui crée la liste de deivse
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

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }
}
