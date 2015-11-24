package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Currency;
import sun.applet.Main;

import java.io.IOException;

public class CurrencyConverterApp extends Application {
    MainController mainController;
    ComboBox<String> ComboFrom;
    ComboBox<String> ComboTo;

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainController = new MainController();
        Pane mainPane = FXMLLoader.load(getClass().getResource("CurrencyConverter.fxml"));
        HBox hbox = (HBox) mainPane.getChildren().get(0);
        ComboFrom = (ComboBox<String>) hbox.getChildren().get(0);
        ComboTo = (ComboBox<String>) hbox.getChildren().get(2);

        ComboFrom.getItems().add("EUR");
        ComboTo.getItems().add("USD");

        Scene scene = new Scene(mainPane, 1000, 700);

        primaryStage.setTitle("Index Equity MIF2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
