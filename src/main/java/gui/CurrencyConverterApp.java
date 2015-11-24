package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;

import java.io.IOException;

public class CurrencyConverterApp extends Application {
    MainController mainController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainController = new MainController();
        Pane mainPane = FXMLLoader.load(getClass().getResource("CurrencyConverter.fxml"));
        Scene scene = new Scene(mainPane, 1000, 700);

        primaryStage.setTitle("Index Equity MIF2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
