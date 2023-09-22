/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.agosto2014;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * contiene i bottoni per giocare
 * @author crist
 */
public class Btn extends HBox {
    
    Button nuovaPartita;
    Button stampa;
    Button togliereDadi;
    final String s1 = "Spostamento";
    final String s2 = "Dissolvimento";
    Campo campo;
    
    /**
     * il bottone nuovaPartita crea un nuovo gioco
     * il bottone stampa stampa il valore dei dadi in gioco
     * il bottone togliereDadi toglie i dadi tramite dissolvimento o spostamento
     * @param campo è il campo di gioco
     */
    
    Btn (Campo campo) {
        this.campo=campo;
        nuovaPartita = new Button ("Nuova partita");
        EventHandler<ActionEvent> eventHandlerNew = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuovaPartita();
            }
        };
        nuovaPartita.addEventHandler(ActionEvent.ACTION, eventHandlerNew);
        stampa = new Button ("Stampa");
        EventHandler<ActionEvent> eventHandlerStampa = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                print();
            }
        };
        stampa.addEventHandler(ActionEvent.ACTION, eventHandlerStampa);
        this.getChildren().addAll(nuovaPartita, stampa);
        EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCharacter()) {
                    case "n": case "N":
                        nuovaPartita.fireEvent(new ActionEvent());
                        nuovaPartita.requestFocus();
                        break;
                    case "s": case "S":
                        stampa.fireEvent(new ActionEvent());
                        stampa.requestFocus();
                        break;
                }
            }
        };
        this.addEventHandler(KeyEvent.KEY_TYPED, keyEventHandler);
        togliereDadi = new Button (s1);
        EventHandler<ActionEvent> eventHandlerT = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                togliDadi();
            }
        };
        togliereDadi.addEventHandler(ActionEvent.ACTION, eventHandlerT);
        this.getChildren().add(togliereDadi);
    }
    
    private void togliDadi () {
        if (togliereDadi.getText().compareTo(s1)==0) togliereDadi.setText(s2);
        else togliereDadi.setText(s1);
    }
     
    private void print () {
        String s="";
        for (Dado d : campo.list) {
            s+=d.toString();
            s+=" ";
        }
        Label label = new Label (s);
        Scene scene = new Scene (label, 100, 100);
        Stage stage = new Stage ();
        stage.setScene(scene);
        stage.setTitle("Stampa");
        stage.show();
    }
    
    private void nuovaPartita() {
        campo.svuotaLista();
        campo.cont.reset();
    }
    
}
