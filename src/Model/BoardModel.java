package Model;

import Observer.Observer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardModel {
    private Cell[][] grid;
    private int columns = 5;
    private int gridSize = 1024 ;//TODO: TAMAÑO VENTANA DEL FORM???
    private Color[] possibleColors = {Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.CYAN, Color.ORANGE};
    private List<Observer> observers;


    public BoardModel(int columns) {
        observers = new ArrayList<Observer>();
        grid = new Cell[columns][columns];
        this.columns = columns;
        int buttonSize = gridSize/columns;

        //TODO: REVISAR COMO CALCULAR EL TAMAÑANO EN BASE AL TAMAÑA DE LA GRILLA
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(i, j, buttonSize);
            }
        }
    }

    //TODO: EL OBSERVADOR PASA LA CELDA CLICKEADA > SE COMPARA ARRIBA, ABAJO,DER E IZQ
    public Boolean compare(Cell cell){
        //ACTUALIZA CELDA

        //
        return  false;

    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}
