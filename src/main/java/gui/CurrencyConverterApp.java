package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Currency;
import sun.applet.Main;

import java.awt.*;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;

public class CurrencyConverterApp extends Application {
    MainController mainController;
    ComboBox<String> ComboFrom;
    ComboBox<String> ComboTo;
    TextArea TextFrom;
    TextField TextTo;
    Button ButtonCalcul;

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainController = new MainController();
        mainController.converterList();
        Pane mainPane = FXMLLoader.load(getClass().getResource("CurrencyConverter.fxml"));
        HBox hbox1 = (HBox) mainPane.getChildren().get(0);
        ComboFrom = (ComboBox<String>) hbox1.getChildren().get(0);
        ComboTo = (ComboBox<String>) hbox1.getChildren().get(2);
        HBox hbox2 = (HBox) mainPane.getChildren().get(4);

        for(Currency elem : mainController.getList())
        {
            ComboFrom.getItems().add(elem.getDevise());
            ComboTo.getItems().add(elem.getDevise());
        }

        Scene scene = new Scene(mainPane, 1000, 700);

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
