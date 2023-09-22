/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.agosto2014;

import java.util.Random;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * dado estende uno stackpane perchè contiene un quadrato a cui aggiungo i punti
 * @author crist
 */
public class Dado extends StackPane {
    Random random = new Random();
    int valore;
    boolean cambioVal;
    GridPane gp = new GridPane ();
    
    /**
     * crea il dado come quadrato
     * e genera un numero casuale che è il numero del dado
     * l'eventHandler fa generare un nuovo numero casuale
     * per mettere i puntini uso un gridpane con 3 righe e 3 colonne
     */
    
    Dado() {
        cambioVal=false;
        this.setWidth(50);
        this.setHeight(50);
        this.setAlignment(Pos.CENTER);
        Rectangle rect = new Rectangle(50, 50);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        this.getChildren().add(rect);
        valore=random.nextInt(6)+1;
        visualizzaValore();
        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tirareIlDado();
                cambioVal=true;
            }  
        };
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);
        ColumnConstraints cc = new ColumnConstraints ();
        cc.setPercentWidth(100. / 3);
        gp.getColumnConstraints().addAll(cc, cc, cc);
        RowConstraints rc = new RowConstraints ();
        rc.setPercentHeight(100. / 3);
        gp.getRowConstraints().addAll(rc, rc, rc);
        this.getChildren().add(gp);
    }
    
    private void visualizzaValore () {
        Circle c1 = new Circle (5);
        Circle c2 = new Circle (5);
        Circle c3 = new Circle (5);
        Circle c4 = new Circle (5);
        Circle c5 = new Circle (5);
        Circle c6 = new Circle (5);
        switch (valore) {
            case 1:
                gp.getChildren().clear();
                gp.add(c1, 1, 1);
                break;
            case 2:
                gp.getChildren().clear();
                gp.add(c1, 0, 0);
                gp.add(c2, 2, 2);
                break;
            case 3:
                gp.getChildren().clear();
                gp.add(c1, 0, 0);
                gp.add(c2, 1, 1);
                gp.add(c3, 2, 2);
                break;
            case 4:
                gp.getChildren().clear();
                gp.add(c1, 0, 0);
                gp.add(c2, 2, 0);
                gp.add(c3, 0, 2);
                gp.add(c4, 2, 2);
                break;
            case 5:
                gp.getChildren().clear();
                gp.add(c1, 0, 0);
                gp.add(c2, 2, 0);
                gp.add(c3, 0, 2);
                gp.add(c4, 2, 2);
                gp.add(c5, 1, 1);
                break;
            case 6:
                gp.getChildren().clear();
                gp.add(c1, 0, 0);
                gp.add(c2, 2, 0);
                gp.add(c3, 0, 2);
                gp.add(c4, 2, 2);
                gp.add(c5, 0, 1);
                gp.add(c6, 2, 1);
                break;
        }
    }
    
    private void tirareIlDado () {
        valore = random.nextInt(6) + 1;
        visualizzaValore();
    }
    
    public void cambiatoVal () {
        cambioVal=false;
    }
    
    @Override
    public String toString () {
        return Integer.toString(valore);
    }
    
}
