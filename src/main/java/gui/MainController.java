package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Currency;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonExchange;
    @FXML
    private void handleButtonCalcul(){
        try {
            double quantity = Double.valueOf(textFrom.getText());
            String nameFrom = comboFrom.getValue().toString();
            String nameTo = comboTo.getValue().toString();
            double tauxFrom = 0;
            double tauxTo = 0;
            converterList();
            for(int i = 0; i < this.currencyList.size(); i++)
            {
                if(nameFrom == this.currencyList.get(i).getDevise())
                {
                    tauxFrom = this.currencyList.get(i).getTaux();
                }
                if(nameTo == this.currencyList.get(i).getDevise())
                {
                    tauxTo = this.currencyList.get(i).getTaux();
                }
            }
            Currency c1 = new Currency(nameFrom, tauxFrom);
            Currency c2 = new Currency(nameTo, tauxTo);
            double result = c1.calcul(c2, quantity);
            textTo.setText(String.valueOf(result));
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "You need to enter an integers and choose the currency you have and you want");
        }
    }

    @FXML
    private void handleButtonExchange(){
        String nameTmp;
        nameTmp = comboFrom.getValue().toString();
        comboFrom.setValue(comboTo.getValue());
        comboTo.setValue(nameTmp);
    }

    @FXML
    private void handleButtonClose(){
        System.exit(0);
    }
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

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }
}
