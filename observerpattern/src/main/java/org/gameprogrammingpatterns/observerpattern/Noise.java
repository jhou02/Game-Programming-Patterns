package org.gameprogrammingpatterns.observerpattern;

import java.util.Observable;

public class Noise extends Observable{
    private String name;

    public Noise(String name) {
        this.name = name;
    }

    void sound() {

        System.out.println(name + "!");
        setChanged();
        notifyObservers(name);
    }

}