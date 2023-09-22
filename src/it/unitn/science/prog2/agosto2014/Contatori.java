/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.agosto2014;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * contatori di punti e di totale sul campo
 * @author crist
 */
public class Contatori extends HBox{
    
    Text tot;
    int totale;
    Text punteggio;
    int punti;
    
    /**
     * setto il totale a 0 e il punteggio a 30
     */
    
    Contatori () {
        Label label1 = new Label ("TOTALE:  ");
        tot = new Text ();
        totale=0;
        tot.setText(Integer.toString(totale));
        Label label2 = new Label ("     PUNTEGGIO:  ");
        punteggio = new Text();
        punti=30;
        punteggio.setText(Integer.toString(punti));
        this.getChildren().addAll(label1, tot, label2, punteggio);
        this.setAlignment(Pos.CENTER);
    }
    
    /**
     * aggiorna il totale dei dadi sul banco
     * @param tot 
     */
    
    public void aggiornaTotale (int tot) {
        totale=tot;
        update();
    }
    
    private void update() {
        vittoria();
        tot.setText(Integer.toString(totale));
        punteggio.setText(Integer.toString(punti));
    }
    
    /**
     * ogni volta che viene premuto un dado e cambiato il suo valore il 
     * punteggio diminuisce di 1
     */
    
    public void aggiornaPuntiDadi () {
        punti--;
        update();
    }
    
    /**
     * ogni volta che viene premuto il campo ma non i dadi il
     * punteggio diminuisce di 3
     */
    
    public void aggiornaPuntiVerde () {
        punti-=3;
        update();
    }
    
    private void vittoria () {
        if (totale == 15) {
            Label label = new Label ("VITTORIA - hai ottenuto " + punti + "punti");
            Scene scene = new Scene (label, 300, 100);
            Stage stage = new Stage ();
            stage.setTitle("Vittoria");
            stage.setScene(scene);
            stage.show();
        }
    }
    
    /**
     * resetta i punti a 30 e il totale a 0 e lo aggiorna
     */
    
    public void reset () {
        punti = 30;
        totale = 0;
        update();
    }
    
}
