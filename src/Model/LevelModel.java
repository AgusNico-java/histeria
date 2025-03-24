package Model;

import Observer.Observer;


import java.util.ArrayList;
import java.util.List;

public class LevelModel {
    private List<Observer> observers;

    public  LevelModel(){
        this.observers = new ArrayList<>();

    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
}
