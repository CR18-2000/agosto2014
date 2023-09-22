/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.agosto2014;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

/**
 * campo da gioco che contiene i dadi
 * @author crist
 */
public class Campo extends TilePane {

    ArrayList<Dado> list = new ArrayList<>();
    Dado d;
    Contatori cont;
    
    /**
     * l'eventHandler fa aggiungere i dadi se non ho premuto su uno di loro per cambiare il valore
     * l'arraylist memorizza i dadi aggiunti per non farne aggiungere 
     * più di 5
     * @param contatori contatore del gioco
     */

    Campo(Contatori contatori) {
        cont = contatori;
        this.setStyle("-fx-background-color: green;");
        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean canAdd = true;
                for (Dado d : list) {
                    if (d.cambioVal) {
                        canAdd = false;
                        d.cambiatoVal();
                        cont.aggiornaPuntiDadi();
                    }
                }
                if (canAdd) {
                    aggiungiDadi();
                    cont.aggiornaPuntiVerde();
                }
                totalePresente();
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);

    }

    private void aggiungiDadi() {
        if (list.size() < 5) {
            d = new Dado();
            list.add(d);
            this.getChildren().add(d);
        }
    }

    private void totalePresente() {
        int tot = 0;
        for (Dado d : list) {
            tot += d.valore;
        }
        cont.aggiornaTotale(tot);
    }
    
    /**
     * toglie tutti gli elementi dalla lista e elimina tutti gli elementi 
     * presenti nel tilepane
     */
    
    public void svuotaLista() {
        this.getChildren().clear();
        list.removeAll(list);
    }

}
