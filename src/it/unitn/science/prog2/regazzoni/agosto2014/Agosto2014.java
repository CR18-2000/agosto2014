/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.agosto2014;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * classe che funge da main
 * @author crist
 */
public class Agosto2014 extends Application {
    
    /**
     * creo un borderpane
     * al top metto i bottoni
     * al centro il campo verde con i dadi
     * al bottom i bottoni
     * @param primaryStage 
     */
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        Contatori contatori = new Contatori();
        root.setBottom(contatori);
        Campo campo = new Campo(contatori);
        root.setCenter(campo);
        Btn bottoni = new Btn (campo);
        root.setTop(bottoni);
        Scene scene = new Scene(root, 500, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
