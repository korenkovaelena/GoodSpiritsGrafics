package com.example.calculatorfx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Layer[] layers = readFromFile();
        System.out.println(layers[2].planets[1].tonnels);
    }

    static Layer[] readFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Input.txt"));
        int n = sc.nextInt(); //кол-во уровней планет, разделены *
        Layer[] layers = new Layer[n];
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            Planet[] planets = new Planet[k];
            for (int s = 0; s < k; s++) {
                ArrayList<Tonnel> tonnels = new ArrayList<>();
                for (int v = 0; ; v++) {
                    Tonnel tonnel = new Tonnel();
                    tonnel.from = sc.nextInt();
                    if (tonnel.from != 0) {
                        tonnel.cost = sc.nextInt();
                        tonnel.to =s+1;
                        tonnels.add(tonnel);
                    } else
                        break;
                }
                Planet planet = new Planet(tonnels);
                planets[s] = planet;
            }
            layers[i] = new Layer(planets);
            try {
                sc.nextLine();
                sc.nextLine();
            }
            catch (java.util.NoSuchElementException ex){
                break;
            }
        }
        return layers;
    }

}



