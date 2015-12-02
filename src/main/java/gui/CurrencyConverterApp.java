package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Currency;

import java.io.IOException;

//Cette classe constitue la View
//Elle a pour but d'afficher ce que l'utilisateur voit
//Elle ne fait en outre aucun calcul
public class CurrencyConverterApp extends Application {
    MainController mainController;
    ComboBox<String> ComboFrom;
    ComboBox<String> ComboTo;

    @Override
    public void start(Stage primaryStage) throws IOException{
        mainController = new MainController();
        mainController.converterList();
        //On charge notre interface graphique qui a été effectué avec Scene Builder
        Pane mainPane = FXMLLoader.load(getClass().getResource("CurrencyConverter.fxml"));
        HBox hbox1 = (HBox) mainPane.getChildren().get(0);
        ComboFrom = (ComboBox<String>) hbox1.getChildren().get(0);
        ComboTo = (ComboBox<String>) hbox1.getChildren().get(2);

        //On insère dans nos ComboBox tout les éléments de la liste currencyList qui contient toute nos devises
        for(Currency elem : mainController.getList())
        {
            ComboFrom.getItems().add(elem.getDevise());
            ComboTo.getItems().add(elem.getDevise());
        }

        Scene scene = new Scene(mainPane);

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
