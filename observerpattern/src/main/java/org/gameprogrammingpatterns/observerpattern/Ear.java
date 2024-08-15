package org.gameprogrammingpatterns.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class Ear implements Observer {
    private String name;
    public int numObserved = 0;

    public Ear(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object sound) {
        numObserved++;
        System.out.println(name + " heard " + sound);
    }
}