package com.example.calculatorfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class HelloController {


    @FXML
    private AnchorPane anchorPane;


    public void initialize() throws FileNotFoundException {
        Layer[] layers = Main.readFromFile();
        int x = 200;
        int y = 30;
        HashMap<String, Circle> map =new HashMap<>();
        Circle c =new Circle();
        c.setCenterX(x);
        c.setCenterY(y);
        c.setRadius(20);
map.put("0.1", c);
        anchorPane.getChildren().add(c);
        for(int  i = 0; i < layers.length; i++){
            String tonnelFrom;
            int space = 300;
            int sp=100;
            int margin = space/layers[i].planets.length;
                    for (int s = 0; s < layers[i].planets.length; s++) {
                            Circle k = new Circle();
                            k.setCenterX(margin+sp*s);
                            k.setCenterY(y + 70);
                            k.setRadius(20);
                           String key = (String.valueOf(i+1)+"."+String.valueOf(s+1));
                            map.put(key,k);
                            anchorPane.getChildren().add(k);
                            for (int j = 0; j < layers[i].planets[s].tonnels.size(); j++){
                                tonnelFrom = i+"."+String.valueOf(layers[i].planets[s].tonnels.get(j).from);
                                Line l = new Line();
                    l.setStartX(map.get(tonnelFrom).getCenterX());
                    l.setStartY(map.get(tonnelFrom).getCenterY());
                    l.setEndX(margin+sp*s);
                    l.setEndY(y + 70);
                    anchorPane.getChildren().add(l);
                            }
                }
                    y=y+70;
            }
        }

}